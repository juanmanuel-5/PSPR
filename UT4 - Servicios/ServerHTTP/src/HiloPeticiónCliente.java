import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hilo que gestiona cada una de las peticiones realizadas por los clientes
 * @author José Carlos García
 */
public class HiloPeticiónCliente extends Thread {

    private final ServidorWeb serverGUI;
    private final Socket socketCliente;
    int numClie;

    public HiloPeticiónCliente(Socket socketCliente, int numClie, ServidorWeb serverGUI)
    {
        this.socketCliente = socketCliente;
        this.serverGUI = serverGUI;
        this.numClie = numClie;
    }

    @Override
    public void run()
    {
        try
        {
            // Tramita la petición de un cliente
            serverGUI.escribirLog("Petición " + this.numClie + ": Iniciada");
            
            procesaPetición(socketCliente);
            
            // Cierra la conexión entrante
            socketCliente.close();            
            serverGUI.escribirLog("Petición " + this.numClie + ": Finalizada");            
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Procesa la petición recibida
     * @throws IOException
     */
    private void procesaPetición(Socket socketCliente) throws IOException
    {
        //variables locales
        String peticion;
        String html;

        // Flujo de entrada
        InputStreamReader inSR = new InputStreamReader(socketCliente.getInputStream());
        
        // Espacio en memoria para la entrada de peticiones
        BufferedReader bufLeer = new BufferedReader(inSR);

        // Objeto de java.io que permite escribir 'línea a línea' en un flujo de salida
        PrintWriter printWriter = new PrintWriter(socketCliente.getOutputStream(), true);

        // Mensaje petición cliente
        peticion = bufLeer.readLine();
        
        serverGUI.escribirLog("Petición " + this.numClie + ": " + peticion);

        if (peticion != null)
        {
            // Para compactar la petición y facilitar así su análisis,
            // suprimimos todos los espacios en blanco que contenga
            peticion = peticion.replaceAll(" ", "");

            // Si realmente se trata de una petición 'GET'
            // (que es la única que vamos a implementar en nuestro Servidor)
            if (peticion.startsWith("GET"))
            {
                // Extrae la petición (subcadena entre 'GET' y 'HTTP/1.1')
                peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

                // Si la petición está vacía
                if (peticion.length() == 0 || peticion.equals("/"))
                {
                    // Se sirve la página de inicio
                    //html = Paginas.html_index;
                    html = obtenerPagina("www/index.html");
                    printWriter.println(Mensajes.lineaInicial_OK);
                }
                else
                {
                    // Comprobar si en la carpeta 'www' del servidor hay un archivo 
                    // cuyo nombre coincide con el de la petición, y la extension '.html'                    
                    String archivo = "www" + peticion + ".html";

                    // Si existe el archivo
                    if (existePagina(archivo))
                    {
                        // Se sirve la página indicada
                        html = obtenerPagina(archivo);
                        printWriter.println(Mensajes.lineaInicial_OK);
                    }
                    else
                    {
                        // No existe el archivo. Se sirve la página de error.
                        // html = Paginas.html_noEncontrado;
                        html = obtenerPagina("www/error.html");
                        printWriter.println(Mensajes.lineaInicial_NotFound);
                    }
                }

                // Completar el envío al cliente
                printWriter.println(Mensajes.primeraCabecera);
                printWriter.println("Content-Length: " + (html.length() + new Integer(1)));                
                printWriter.println("\n");
                printWriter.println(html);                
            }
        }
    }

    /**
     * Comprueba la existencia o no de un archivo, cuyo nombre se recibe como parámetro.
     * @param nombreFichero Nombre del archivo de texto que se desea obtener.
     * @return  Indicador de la existencia o no del fichero indicado.
     */    
    private static boolean existePagina(String nombreFichero)
    {
        boolean retorno = false;

        try
        {
            // Comprobar si existe un fichero con el nombre recibido
            File miFile = new File(nombreFichero);

            // Si no existe el fichero
            if (miFile.exists())
            {
                retorno = true;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return retorno;
    }
    
    /**
     * Obtiene el contenido de un archivo de texto del directorio actual, cuyo nombre se recibe como parámetro.
     * @param nombreFichero Nombre del archivo de texto que se desea obtener.
     * @return  Contenido del archivo de texto que se ha obtenido.
     */    
    private static String obtenerPagina(String nombreFichero)
    {
        BufferedReader br;          // Buffer de lectura        
        String linea;               // Línea de texto leída del fichero
        StringBuilder textoRetorno = new StringBuilder(500); // Texto que será devuelto

        try
        {
            // Comprobar si existe un fichero con el nombre recibido
            File miFile = new File(nombreFichero);

            // Si no existe el fichero
            if (!miFile.exists())
            {
                // Texto que será devuelto al cliente
                textoRetorno.append("No ha sido posible realizar la operación.\n");
                textoRetorno.append("No existe el fichero '").append(nombreFichero).append("'.");
            }
            else
            {
                // El fichero existe. Leer su contenido

                br = new BufferedReader(new FileReader(nombreFichero));

                // Procesar cada una de las líneas
                while ((linea = br.readLine()) != null)
                {
                    // No añadir un salto de línea al añadir la primera línea
                    if (textoRetorno.length() > 0)
                        textoRetorno.append("\n");

                    textoRetorno.append(linea);
                }

                // Cerrar el fichero
                br.close();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        return textoRetorno.toString();
    }
    
}
