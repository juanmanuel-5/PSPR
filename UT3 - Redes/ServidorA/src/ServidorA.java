//package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que implementa el servidor que permite procesar cadenas de caracteres
 * para calcular el número de ocurrencias de cada vocal.
 * @author José Carlos García Bermúdez
 */
public final class ServidorA {

  static final int Puerto = 1800;

  /**
   * Constructor de la clase servidor
   */
  public ServidorA() {
    String txtFrecuencia; // Texto con la frecuencia de cada vocal
    int nCli = 0; // Número de clientes procesados

    try {
      // Iniciar la escucha del servidor en el puerto indicado
      ServerSocket skServidor = new ServerSocket(Puerto);

      // Mostrar mensaje por consola
      System.out.println("Escucho el Puerto " + Puerto);

      // El servidor estará permanentemente en escucha
      while (true) {
        nCli++;

        // Esperar a que se conecte un cliente (se crea un nuevo socket para el cliente)
        Socket sCliente = skServidor.accept();

        System.out.println("Nº de Peticiones Atendidas: " + nCli);

        // Definir un flujo de entrada para leer la información enviada por el cliente
        DataInputStream flujo_entrada = new DataInputStream(
          sCliente.getInputStream()
        );

        // Calcular la frecuencia de cada vocal en el texto recibido
        txtFrecuencia = contarVocales(flujo_entrada.readUTF());

        // Definir un flujo de salida para enviar información al cliente
        DataOutputStream flujo_salida = new DataOutputStream(
          sCliente.getOutputStream()
        );

        // Enviar la información al cliente
        flujo_salida.writeUTF(txtFrecuencia);

        // Cerrar la conexión con el cliente
        sCliente.close();
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("El servidor ha finalizado.");
    }
  }

  /**
   * Recorre la cadena de texto recibida como parámetro para calcular el número
   * de ocurrencias de cada vocal.
   * @param lineaTexto    Cadena de texto a procesar
   * @return  Cadena de texto con el número de ocurrencias de cada vocal.
   */
  public String contarVocales(String lineaTexto) {
    // Definición de variables
    int[] cont = new int[5]; // Contadores de las vocales. Por defecto se inicializan a cero.
    String txtFrecuencia = ""; // Texto con la frecuencia de cada vocal

    // Analizar cada uno de los caracteres de la línea
    for (char letra : lineaTexto.toCharArray()) {
      // Se pasa a minúscula, para solo tener que comprobar las minúsculas.
      // Incrementar el contador de la vocal que corresponda
      switch (Character.toLowerCase(letra)) {
        case 'a':
          cont[0]++;
          break;
        case 'e':
          cont[1]++;
          break;
        case 'i':
          cont[2]++;
          break;
        case 'o':
          cont[3]++;
          break;
        case 'u':
          cont[4]++;
          break;
      }
    }

    // Montar una cadena de texto con el valor de los contadores
    for (int i = 0; i < 5; i++) {
      txtFrecuencia = txtFrecuencia + cont[i] + " ";
    }

    return txtFrecuencia;
  }

  /**
   * Inicio de la aplicación servidor
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String[] args) {
    ServidorA servidor = new ServidorA();
  }
}
