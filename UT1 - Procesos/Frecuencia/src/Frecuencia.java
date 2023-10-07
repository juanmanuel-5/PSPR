import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Dado un texto recibido a través de la entrada estándar, obtiene la frecuencia absoluta
 * de cada una de las vocales, es decir, la cantidad de veces que aparece cada vocal.
 * @author AUTOR
 * @version 1.0
 */
public class Frecuencia {

  /**
   * Método principal de la clase, que implementa toda su funcionalidad.
   * @param args Argumentos de línea de comandos (no requiere de ninguno).
   */
  public static void main(String[] args) {
    // Definición de variables
    int[] cont = new int[5]; // Contadores de las vocales. Por defecto se inicializan a cero.
    String lineaTexto = null; // Línea de texto a analizar
    String textoCompleto = ""; // Texto completo de todas las líneas analizadas
    InputStreamReader isr = null; // Stream de lectura
    BufferedReader br = null; // Buffer de lectura

    try {
      // Leer de la entrada estándar del proceso, obteniendo un stream de lectura
      isr = new InputStreamReader(System.in);

      // Utilizar un buffer de lectura sobre el stream anterior, para optimizar los accesos
      br = new BufferedReader(isr);

      // Procesar cada una de las líneas, hasta que una esté vacía
      // (se repetirá mientras no sea nula ni vacía)
      while ((lineaTexto = br.readLine()) != null && !lineaTexto.isEmpty()) {
        // Actualizamos el texto completo, para mostrarlo al final del análisis
        textoCompleto = textoCompleto + lineaTexto + "\n";

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
      }

      // Mostrar el valor de los contadores
      System.out.print("FRECUENCIA VOCALES: ");
      for (int i = 0; i < 5; i++) {
        System.out.print(" " + cont[i]);
      }

      System.out.println("\n");
      System.out.println("TEXTO ANALIZADO: ");
      System.out.println(textoCompleto);
    } catch (IOException ex) {
      System.err.println("Se ha producido un error de E/S.");
      System.err.println(ex.toString());
    } finally {
      // Cerrar los recursos utilizados.

      // Antes de cerrar un recurso hay que comprobar que exista,
      // ya que ha podido producirse un error al crearlo.

      if (br != null) {
        try {
          br.close();
        } catch (IOException ex) {
          System.err.println(
            "Se ha producido un error al cerrar el BufferReader."
          );
          System.err.println(ex.toString());
        }
      }

      if (isr != null) {
        try {
          isr.close();
        } catch (IOException ex) {
          System.err.println(
            "Se ha producido un error al cerrar el InputStreamReader."
          );
          System.err.println(ex.toString());
        }
      }
    }
  }
}
