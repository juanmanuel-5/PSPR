/**
 * Lanza varias instancias de la aplicación ´Cadenas´.
 * El usuario tiene que indicar el número de instancias (menos de 10) y el número de cadenas a generar en todas ellas.
 * @author AUTOR
 * @version 1.0
 */
public class Generador {

  /**
   * Implementa la funcionalidad principal de la clase.
   * @param args Argumentos de línea de comandos: Número de instancias (menos de 10), y número de cadenas a generar.
   */
  public static void main(String[] args) {
    int numProcesos; // Número de procesos a generar
    //int numCadenas; // Cantidad de cadenas a generar
    //Process nuevoProceso; // Proceso a generar, para poder referirse a él desde cualquier punto del programa.

    try {
      // Comprobar que se han indicado los dos parámetros, nº procesos y nº de cadenas a generar.
      // Deben ser valores positivos, y el nº de procesos será menor de 10.
      if (args.length != 2) throw new Exception(
        "Parámetros incorrectos: Se debe indicar el número de procesos y el número de cadenas a generar."
      );

      // Comprobar si alguno de los caracteres del primer parámetro no es numérico
      for (int i = 0; i < args[0].length(); i++) {
        if (!Character.isDigit(args[0].charAt(i))) throw new Exception(
          "El número de procesos debe ser un valor numérico entre 1 y 9."
        );
      }

      // El número de procesos indicado es un valor numérico positivo
      numProcesos = Integer.parseInt(args[0]);

      // Comprobar que el número de procesos no sea mayor de 9.
      if (numProcesos > 9) throw new Exception(
        "El número de procesos debe ser un valor numérico entre 1 y 9."
      );

      // Comprobar si alguno de los caracteres del segundo parámetro no es numérico
      for (int i = 0; i < args[1].length(); i++) {
        if (!Character.isDigit(args[1].charAt(i))) throw new Exception(
          "El número de cadenas a generar debe ser un valor numérico positivo."
        );
      }

      // El número de cadenas a generar es un valor correcto
      //numCadenas = Integer.parseInt(args[1]);

      // Crear el número de procesos que se haya indicado como parámetro.
      for (int i = 0; i < numProcesos; i++) {
        String[] comando = {
          "cmd",
          "/c",
          "start",
          "cmd",
          "/K",
          "java",
          "-jar",
          "Cadenas.jar",
          args[1]
        };
        //nuevoProceso =
        Runtime.getRuntime().exec(comando);
      }
    } catch (SecurityException ex) {
      System.out.println(
        "Ha ocurrido un error de Seguridad.\n" + ex.getMessage()
      );
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
