import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hilo principal del servidor HTTP que atiende peticiones de tipo 'GET' recibidas por el puerto 8066.
 */
public class HiloPrincipal extends Thread {

    private final ServidorWeb serverGUI;
    private Socket socketCliente;
    int numClie;

    public HiloPrincipal(ServidorWeb serverGUI)
    {
        this.serverGUI = serverGUI;
    }

    @Override
    public void run()
    {
        int puerto = 8066;
        int numCliente = 0;
        HiloPeticiónCliente hilo;

        try
        {
            //Asociamos al servidor el puerto 8066
            ServerSocket socServidor = new ServerSocket(puerto);

            this.serverGUI.escribirLog("Se ha iniciado el servidor en el puerto " + puerto);
            this.serverGUI.escribirLog("En la barra de direcciones del navegador puedes escribir:");
            this.serverGUI.escribirLog("\thttp://localhost:8066\tPágina de bienvenida.");
            this.serverGUI.escribirLog("\thttp://localhost:8066/quijote\tPágina 'quijote.html'.");
            this.serverGUI.escribirLog("\thttp://localhost:8066/pirata\tPágina 'pirata.html'.");
            this.serverGUI.escribirLog("\t... o cualquier otra página que esté disponible en el servidor.");
                
            // Este hilo está en permanente ejecución, a la espera de peticiones
            while(true)
            {
                // Acepta una petición, y le asigna un socket cliente para la respuesta
                socketCliente = socServidor.accept();
                
                // Identificador del cliente que está siendo atendido
                numCliente++;

                // Crea un nuevo hilo para despacharla por el socketCliente que le asignó
                hilo = new HiloPeticiónCliente(socketCliente, numCliente, this.serverGUI);
                hilo.start();
            }
            
            
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }      
    }

}
