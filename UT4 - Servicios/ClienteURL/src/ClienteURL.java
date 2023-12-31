/**
 * Cliente que obtiene un recurso web cuya URL ha sido indicada por el usuario.
 */
public class ClienteURL extends javax.swing.JFrame {

  /**
   * Constructor de la ventana
   */
  public ClienteURL() {
    //inicia los componentes de diseño
    initComponents();

    // Configurar aspecto inicial
    this.setTitle("Cliente Análisis URL");
    this.setLocationRelativeTo(null); // Centrada
    this.setResizable(false); // No cambia de tamaño

    txtLog.setEditable(false);

    // Valor que se muestra por defecto para la URL
    txtUrl.setText(
      "https://www.maeva.es/repositorio/lecturas/inicio-sin-limites.pdf"
    );
    //http://www.juntadeandalucia.es/boja/boletines/2012/38/d/updf/d1.pdf");
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
    btnProcesar = new javax.swing.JButton();
    txtUrl = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtLog = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        null,
        "Escribe una URL",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new java.awt.Font("Tahoma", 0, 11),
        new java.awt.Color(51, 153, 255)
      )
    ); // NOI18N

    btnProcesar.setText("Procesar");
    btnProcesar.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnProcesarActionPerformed(evt);
        }
      }
    );

    txtUrl.setText(
      "https://www.maeva.es/repositorio/lecturas/inicio-sin-limites.pdf"
    );
    //http://www.juntadeandalucia.es/boja/boletines/2012/38/d/updf/d1.pdf");
    txtUrl.setToolTipText("");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
      jPanel1
    );
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(409, 409, 409)
            .addComponent(btnProcesar)
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(txtUrl)
            .addContainerGap()
        )
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          jPanel1Layout
            .createSequentialGroup()
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
            .addComponent(
              txtUrl,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addComponent(btnProcesar)
            .addGap(7, 7, 7)
        )
    );

    jLabel1.setText("Acceso a la URL indicada");

    jPanel3.setBorder(
      javax.swing.BorderFactory.createTitledBorder(
        null,
        "Log",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new java.awt.Font("Tahoma", 0, 11),
        new java.awt.Color(51, 102, 255)
      )
    ); // NOI18N

    txtLog.setColumns(20);
    txtLog.setRows(5);
    jScrollPane1.setViewportView(txtLog);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
      jPanel3
    );
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel3Layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1)
            .addContainerGap()
        )
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel3Layout
            .createSequentialGroup()
            .addComponent(
              jScrollPane1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              197,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(0, 9, Short.MAX_VALUE)
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
            .addContainerGap()
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(
                  jPanel3,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  Short.MAX_VALUE
                )
                .addComponent(
                  jPanel1,
                  javax.swing.GroupLayout.Alignment.LEADING,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  Short.MAX_VALUE
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.LEADING,
                  layout
                    .createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)
                )
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
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jPanel3,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap()
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  /**
   * Método asociado al botón Procesar, que crea un nuevo hilo para el
   * procesamiento de la lógica de la aplicación.
   * Como en cualquier aplicación de ventana, la realización de una tarea
   * que acapara recursos (como la descarga de un fichero o página de Internet)
   * debe colocarse en un hilo independiente para que la ventana no se bloquee.
   * @param evt
   */
  private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnProcesarActionPerformed
    // Hilo para la descarga de un recurso url
    HiloPrincipal hiloBoton = new HiloPrincipal(txtUrl.getText(), txtLog);
    hiloBoton.start();
  } //GEN-LAST:event_btnProcesarActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /*
     * Set the Nimbus look and feel
     */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the
     * default look and feel. For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
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
        .getLogger(ClienteURL.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(ClienteURL.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(ClienteURL.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(ClienteURL.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /*
     * Create and display the form
     */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          new ClienteURL().setVisible(true);
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnProcesar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea txtLog;
  private javax.swing.JTextField txtUrl;
  // End of variables declaration//GEN-END:variables

}
