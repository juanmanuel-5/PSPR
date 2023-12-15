import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import javax.swing.JTextArea;

/**
 * Hilo para obtener el contenido de la URL que ha recibido en su constructor.
 */
class HiloPrincipal extends Thread {

  // Variables locales
  private final String cadenaURL;
  private final JTextArea txtLog;

  /**
   * Constructor
   * @param cadenaURL URL que se desea analizar.
   * @param txtLog    Campo de texto donde se mostrará al usuario los mensajes generados en el hilo.
   */
  public HiloPrincipal(String cadenaURL, JTextArea txtLog) {
    this.cadenaURL = cadenaURL;
    this.txtLog = txtLog;
  }

  /**
   * Implementa la funcionalidad del hilo.
   */
  @Override
  public void run() {
    // Variables locales
    String texto = "";

    try {
      // Crear objeto URL
      URI uri = new URI(cadenaURL);
      URL url = uri.toURL();

      // Obtener una conexión al recurso URL
      URLConnection conexion = url.openConnection();
      conexion.connect();

      // Obtener la información más relevante de la cabecera
      texto = "Encabezados destacados:";

      // Obtener el tipo de contenido
      String contentType = conexion.getContentType();
      texto += "\n    - Content-Type:\t" + contentType;

      // Obtener el tamaño del contenido
      int contentLength = conexion.getContentLength();
      texto += "\n    - Content-Length:\t" + contentLength;

      // Obtener la codificación
      String codificacion = conexion.getContentEncoding();
      texto += "\n    - Content-Encoding:\t" + codificacion;

      // Obtener la fecha de la última modificación
      Date fecha = new Date(conexion.getLastModified());
      texto += "\n    - Last Modified:\t" + fecha;

      // Obtener la fecha de la última modificación
      Date fecha2 = new Date(conexion.getDate());
      texto += "\n    - Date:\t\t" + fecha2;

      // Obtener la fecha de la última modificación
      Date fecha3 = new Date(conexion.getExpiration());
      texto += "\n    - Expires:\t\t" + fecha3;

      // Mostrar la información en el log de la ventana
      this.txtLog.setText(texto);
    } catch (Exception e) {
      // URL incorrecta
      texto = "Debe indicar una URL válida.\n\n";
      texto += "Por ejemplo:\n\t";
      texto += "http://www.diariosur.es/deportes";

      this.txtLog.setText(texto);
    }
  }
}
