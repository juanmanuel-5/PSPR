//package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Formulario que permite realizar peticiones a un servidor para procesar
 * cadenas de texto y obtener el número de ocurrencias de cada vocal.
 * @author 
 */
public class ClienteA extends javax.swing.JFrame {

  // Dirección del servidor
  static final String HOST = "localhost";
  static final int Puerto = 1800;

  // Establecer una conexión con el servidor
  Socket sCliente;

  /**
   * Constructor de la ventana cliente
   */
  public ClienteA() {
    initComponents();

    // Configurar aspecto inicial
    this.setTitle("PSP03-01: Comunicaciones en Red (Procesar Vocales)");

    this.setLocationRelativeTo(null); // Centrada
    this.setResizable(false); // No cambia de tamaño
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  //@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    jPanel1 = new javax.swing.JPanel();
    lblTexto = new javax.swing.JLabel();
    txtTexto = new javax.swing.JTextField();
    btnProcesarTexto = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    btnGenerarCadenas = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtLog = new javax.swing.JTextArea();
    spnNumCadenas = new javax.swing.JSpinner();
    lblNumCadenas = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(
      javax.swing.BorderFactory.createTitledBorder("Procesar Vocales")
    );

    lblTexto.setText("Texto");

    btnProcesarTexto.setText("Procesar Texto");
    btnProcesarTexto.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnProcesarTextoActionPerformed(evt);
        }
      }
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
      jPanel1
    );
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          jPanel1Layout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(
                      btnProcesarTexto,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      163,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(lblTexto)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(
                      txtTexto,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      556,
                      Short.MAX_VALUE
                    )
                )
            )
            .addContainerGap()
        )
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTexto)
                .addComponent(
                  txtTexto,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(btnProcesarTexto)
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );

    jPanel2.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        "Generación Automática de Cadenas"
      )
    );

    btnGenerarCadenas.setText("Generar Cadenas");
    btnGenerarCadenas.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnGenerarCadenasActionPerformed(evt);
        }
      }
    );

    txtLog.setColumns(20);
    txtLog.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
    txtLog.setRows(5);
    jScrollPane1.setViewportView(txtLog);

    spnNumCadenas.setModel(new javax.swing.SpinnerNumberModel(5, 1, 20, 1));

    lblNumCadenas.setText("Nº Cadenas (máx 20)");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
      jPanel2
    );
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel2Layout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
              jPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
                .addGroup(
                  jPanel2Layout
                    .createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblNumCadenas)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(
                      spnNumCadenas,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      56,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(18, 18, 18)
                    .addComponent(
                      btnGenerarCadenas,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      163,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
            )
            .addContainerGap()
        )
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel2Layout
            .createSequentialGroup()
            .addGroup(
              jPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnGenerarCadenas)
                .addComponent(
                  spnNumCadenas,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(lblNumCadenas)
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(
              jScrollPane1,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              197,
              Short.MAX_VALUE
            )
            .addContainerGap()
        )
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          layout
            .createSequentialGroup()
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(10, 10, 10)
        )
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jPanel2,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
            .addContainerGap()
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(18, 18, 18)
            .addComponent(
              jPanel2,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
            .addContainerGap()
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  /**
   * Gestiona el evento asociado al botón con el que se solicita al servidor el
   * procesamiento de la cadena de texto que el usuario ha indicado.
   * @param evt Parámetros del evento.
   */
  private void btnProcesarTextoActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnProcesarTextoActionPerformed //GEN-HEADEREND:event_btnProcesarTextoActionPerformed
    try {
      // Validar que el usuario ha indicado una cadena de texto
      if (txtTexto.getText().isEmpty()) throw new Exception(
        "No se ha indicado el texto a procesar."
      );

      // Establecer una conexión con el servidor
      sCliente = new Socket(HOST, Puerto);

      // Definir un flujo de salida para enviar información al servidor
      DataOutputStream flujo_salida = new DataOutputStream(
        sCliente.getOutputStream()
      );

      // Enviar la información al servidor
      flujo_salida.writeUTF(txtTexto.getText());

      // Definir un flujo de entrada para leer la información devuelta por el servidor
      DataInputStream flujo_entrada = new DataInputStream(
        sCliente.getInputStream()
      );

      String mensaje = "Frecuencia de las Vocales: " + flujo_entrada.readUTF();

      // Mostrar la información recibida
      JOptionPane.showMessageDialog(
        this,
        mensaje,
        "Aviso",
        JOptionPane.INFORMATION_MESSAGE
      );
    } catch (IOException e) {
      JOptionPane.showMessageDialog(
        this,
        "No existe conexión con el servidor '" + HOST + ":" + Puerto + "'.",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        this,
        e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    } finally {
      if (sCliente != null) {
        try {
          // Cerrar la conexión con el servidor
          sCliente.close();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
          );
        }
      }
    }
  } //GEN-LAST:event_btnProcesarTextoActionPerformed

  /**
   * Gestiona el evento asociado al botón con el que se solicita al servidor el
   * procesamiento de una serie de cadenas de texto generadas aleatoriamente.
   * @param evt Parámetros del evento.
   */
  private void btnGenerarCadenasActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_btnGenerarCadenasActionPerformed //GEN-HEADEREND:event_btnGenerarCadenasActionPerformed
    int numCadenas; // Número de cadenas a generar
    String cadenaTexto; // Cadena de texto generada
    String mensaje; // Mensaje a mostrar

    try {
      txtLog.setText(
        "a e i o u " +
        "\t" +
        "Cadena de Texto\n" +
        "--------- " +
        "\t" +
        "-------------------------------------------"
      );

      // Número de cadenas a generar
      numCadenas = (int) spnNumCadenas.getValue();

      // Generar y procesar el número de cadenas indicado por el usuario
      for (int x = 0; x < numCadenas; x++) {
        // Generar una cadena de texto aleatoria
        cadenaTexto = generarCadena();

        // Establecer una conexión con el servidor
        sCliente = new Socket(HOST, Puerto);

        // Definir un flujo de salida para enviar información al servidor
        DataOutputStream flujo_salida = new DataOutputStream(
          sCliente.getOutputStream()
        );

        // Enviar la información al servidor
        flujo_salida.writeUTF(cadenaTexto);

        // Definir un flujo de entrada para leer la información devuelta por el servidor
        DataInputStream flujo_entrada = new DataInputStream(
          sCliente.getInputStream()
        );

        mensaje = flujo_entrada.readUTF() + "\t" + cadenaTexto;

        txtLog.setText(txtLog.getText() + "\n" + mensaje);
      }
    } catch (IOException e) {
      JOptionPane.showMessageDialog(
        this,
        "No existe conexión con el servidor '" + HOST + ":" + Puerto + "'.",
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        this,
        e.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    } finally {
      if (sCliente != null) {
        try {
          // Cerrar la conexión con el servidor
          sCliente.close();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
          );
        }
      }
    }
  } //GEN-LAST:event_btnGenerarCadenasActionPerformed

  /**
   * Genera una cadena de texto con una longitud aleatoria entre 1 y 30
   * @return Cadena de texto
   */
  private static String generarCadena() {
    // Se genera un número aleatorio entre 0-29, y se le suma 1.
    int longCadena = (new Random().nextInt(30)) + 1;

    // Inicializar la nueva cadena
    String cadena = "";

    // Generar el número de letras que indique la longitud de la cadena
    for (int i = 0; i < longCadena; i++) {
      // Añadir a la cadena una nueva letra.
      cadena += generarLetra();
    }

    return cadena;
  }

  /**
   * Genera de forma aleatoria un carácter del alfabeto, en mayúscula o minúscula.
   * @return Carácter del alfabeto
   */
  private static char generarLetra() {
    int randomNum; // Número aleatorio, para obtener el código ASCII
    int codASCII; // Código ASCII del carácter a generar
    char letra;

    // En la tabla ASCII estándar hay 26 letras minúsculas y 26 mayúsculas.
    // Tenemos 52 opciones posibles. Se generará un número entre 0-51.
    randomNum = new Random().nextInt(52);

    // Los primeros 26 números, corresponderán a las mayúsculas,
    // con caracteres ASCII entre el 65-90, así que le sumaremos 65.
    if (randomNum < 26) {
      codASCII = randomNum + 65;
    } else {
      // Los siguientes números (26 al 51), corresponderán a las minúsculas,
      // con caracteres ASCII entre el 97-122, así que le sumaremos 71.
      codASCII = randomNum + 71;
    }

    // La letra será la correspondiente al código ASCII que se ha calculado,
    // para ello basta con hacer un casting.
    letra = (char) codASCII;

    return letra;
  }

  /**
   * Inicio de la aplicación cliente
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger
        .getLogger(ClienteA.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(ClienteA.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(ClienteA.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(ClienteA.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new ClienteA().setVisible(true);
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnGenerarCadenas;
  private javax.swing.JButton btnProcesarTexto;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblNumCadenas;
  private javax.swing.JLabel lblTexto;
  private javax.swing.JSpinner spnNumCadenas;
  private javax.swing.JTextArea txtLog;
  private javax.swing.JTextField txtTexto;
  // End of variables declaration//GEN-END:variables
}
