//package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que implementa el servidor que permite obtener el fichero indicado
 * por el usuario, u obtener la lista de archivos de texto del directorio actual.
 * @author José Carlos García Bermúdez
 */
public class ServidorB {

  static final int Puerto = 1900;

  /**
   * Constructor de la clase servidor
   */
  public ServidorB() {
    String nombreFichero; // Nombre del fichero a procesar
    String linea; // Línea de texto leída del fichero
    StringBuilder textoRetorno; // Texto que será devuelto al cliente
    BufferedReader br; // Buffer de lectura
    int nCli = 0; // Número de clientes procesados

    try {
      // Iniciar la escucha del servidor en el puerto indicado
      ServerSocket skServidor = new ServerSocket(Puerto);

      // Mostrar mensaje por consola
      System.out.println("Escucho el Puerto " + Puerto);

      // El servidor estará permanentemente en escucha
      while (true) {
        nCli++;

        // Inicializar el StringBuilder con el texto que será devuelto
        textoRetorno = new StringBuilder(500);

        // Esperar a que se conecte un cliente (se crea un nuevo socket para el cliente)
        Socket sCliente = skServidor.accept();

        System.out.println("Nº de Peticiones Atendidas: " + nCli);

        // Definir un flujo de entrada para leer la información enviada por el cliente
        DataInputStream flujo_entrada = new DataInputStream(
          sCliente.getInputStream()
        );

        // Obtener el texto de la petición que se ha realizado
        nombreFichero = flujo_entrada.readUTF();

        // Si se ha recibido un texto, será el nombre de un fichero
        // En caso contrario (texto vacío), se quiere obtener una lista de ficheros de texto
        if (nombreFichero.length() > 0) {
          // Comprobar si existe un fichero con el nombre recibido
          File miFile = new File(nombreFichero);

          // Si no existe el fichero
          if (!miFile.exists()) {
            // Texto que será devuelto al cliente
            textoRetorno.append("No ha sido posible realizar la operación.\n");
            textoRetorno
              .append("No existe el fichero '")
              .append(nombreFichero)
              .append("'.");
          } else {
            // El fichero existe. Leer su contenido

            br = new BufferedReader(new FileReader(nombreFichero));

            // Procesar cada una de las líneas
            while ((linea = br.readLine()) != null) {
              // No añadir un salto de línea al añadir la primera línea
              if (textoRetorno.length() > 0) textoRetorno.append("\n");

              textoRetorno.append(linea);
            }

            // Cerrar el fichero
            br.close();
          }
        } else {
          // Se quiere obtener una lista de ficheros de texto

          // Directorio actual
          File dirActual = new File(".");

          FilenameFilter textFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
              String lowercaseName = name.toLowerCase();

              if (
                lowercaseName.endsWith(".txt")
              ) return true; else return false;
            }
          };

          // Obtener la lista de ficheros que cumplen con el filtro .txt
          File[] listaFicheros = dirActual.listFiles(textFilter);

          // Si la lista de ficheros está vacía
          if (listaFicheros.length == 0) {
            textoRetorno.append(
              "No hay ningún fichero con la extensión '.txt'"
            );
          } else {
            // La lista de ficheros no está vacía.

            textoRetorno.append("Ficheros con la extensión '.txt'\n");

            // Procesar cada uno de los ficheros de la lista
            for (File fichero : listaFicheros) {
              // Añadir el nombre del fichero (con un salto de línea antes).
              textoRetorno.append("\n");
              textoRetorno.append(fichero.getName());
            }
          }
        }

        // Definir un flujo de salida para enviar información al cliente
        DataOutputStream flujo_salida = new DataOutputStream(
          sCliente.getOutputStream()
        );

        // Enviar la información al cliente
        flujo_salida.writeUTF(textoRetorno.toString());

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
   * Inicio de la aplicación servidor
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String[] args) {
    ServidorB servidor = new ServidorB();
  }
}
