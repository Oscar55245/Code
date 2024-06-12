package pBase;

import java.awt.*;
import javax.swing.JOptionPane;
import proyecto.DAOEmpleado;
import proyecto.Empleado;

public class Login extends javax.swing.JFrame {

    private Empleado empleado;
    private final DAOEmpleado dao = new DAOEmpleado();
    public static String em="",puesto="";
    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/hotel.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio = new javax.swing.JPanel();
        etqNombre = new javax.swing.JLabel();
        etqPassword = new javax.swing.JLabel();
        bienvenido = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        Salir = new javax.swing.JLabel();
        lblImgusuario = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 255));
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(550, 620));

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));
        pnlInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        pnlInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etqNombre.setBackground(new java.awt.Color(255, 204, 51));
        etqNombre.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        etqNombre.setForeground(new java.awt.Color(255, 255, 255));
        etqNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqNombre.setText("Usuario:");
        pnlInicio.add(etqNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 110, -1));

        etqPassword.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        etqPassword.setForeground(new java.awt.Color(255, 255, 255));
        etqPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etqPassword.setText("Contraseña:");
        pnlInicio.add(etqPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        bienvenido.setFont(new java.awt.Font("Tahoma", 3, 60)); // NOI18N
        bienvenido.setForeground(new java.awt.Color(255, 255, 255));
        bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenido.setText("¡ Bienvenido !");
        pnlInicio.add(bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 520, 70));

        btnEntrar.setBackground(new java.awt.Color(0, 102, 255));
        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        pnlInicio.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 110, 40));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar_1.png"))); // NOI18N
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        pnlInicio.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 60, -1));

        lblImgusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        pnlInicio.add(lblImgusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 260, 290));

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        txtUser.setForeground(new java.awt.Color(153, 153, 153));
        txtUser.setText(" Ingrese su Usuario");
        txtUser.setBorder(null);
        txtUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserMousePressed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        pnlInicio.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 430, 40));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setText("********");
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        pnlInicio.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 430, 40));

        lblFondo.setBackground(new java.awt.Color(255, 255, 255));
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul.png"))); // NOI18N
        pnlInicio.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        jifEmpleado  e  =  new jifEmpleado();
        String usu="" ,pass = "";
        usu=txtUser.getText();
        pass=txtPassword.getText();
        empleado = dao.login(usu,pass);
        if (empleado == null) {
            JOptionPane.showMessageDialog(this, "*Algunos de los campos no coincide.");
        } else {
            puesto =  empleado.getPuesto();
            System.out.println(puesto);
            switch (empleado.getPuesto()) {
                case "Administrador":
                    this.dispose();
                    jffPrincipal.main(null);
                    jffPrincipal.btnEmpleado.setVisible(true);
                    jffPrincipal.Lempleado.setVisible(true);
                    jffPrincipal.btnHabitacion.setVisible(true);
                    jffPrincipal.btnReservacion.setVisible(true);
                    jffPrincipal.btnCliente.setVisible(true);
                    jffPrincipal.Lcliente.setVisible(true);
                    jffPrincipal.Lrecepcion.setVisible(true);
                    jffPrincipal.Lhabitacion.setVisible(true);
                    break;
                case "Recepcion":
                    {
                        jffPrincipal x = new jffPrincipal();
                        jffPrincipal.btnEmpleado.setVisible(false);
                        jffPrincipal.Lempleado.setVisible(false);
                        jffPrincipal.btnHabitacion.setVisible(true);
                        jffPrincipal.btnReservacion.setVisible(true);
                        jffPrincipal.btnCliente.setVisible(true);
                        jffPrincipal.Lcliente.setVisible(true);
                        jffPrincipal.Lrecepcion.setVisible(true);
                        jffPrincipal.Lhabitacion.setVisible(true);
                        x.show();
                        this.dispose();
                        break;
                    }
                case "Limpieza":
                    {
                        em=empleado.getNombre();
                        jffPrincipal x = new jffPrincipal();
                        jffPrincipal.btnEmpleado.setVisible(false);
                        jffPrincipal.btnHabitacion.setVisible(false);
                        jffPrincipal.btnReservacion.setVisible(false);
                        jffPrincipal.btnCliente.setVisible(false);
                        jffPrincipal.Lempleado.setVisible(false);
                        jffPrincipal.Lcliente.setVisible(false);
                        jffPrincipal.Lrecepcion.setVisible(false);
                        jffPrincipal.Lhabitacion.setVisible(false);
                        
                        x.show();
                        this.dispose();
                        break;
                    }
                case "Mantenimiento":
                    {
                        em=empleado.getNombre();
                        jffPrincipal x = new jffPrincipal();
                        jffPrincipal.btnEmpleado.setVisible(false);
                        jffPrincipal.btnHabitacion.setVisible(false);
                        jffPrincipal.btnReservacion.setVisible(false);
                        jffPrincipal.btnCliente.setVisible(false);
                        jffPrincipal.Lempleado.setVisible(false);
                        jffPrincipal.Lcliente.setVisible(false);
                        jffPrincipal.Lrecepcion.setVisible(false);
                        jffPrincipal.Lhabitacion.setVisible(false);
                        x.show();
                        this.dispose();
                        break;
                    }
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        btnEntrar.setBackground(new Color(0, 153, 255));
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        btnEntrar.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_btnEntrarMouseExited

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar) || Character.isDigit(keyChar))) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMousePressed
        if (txtUser.getText().equals(" Ingrese su Usuario")) {
            txtUser.setText("");
            txtUser.setForeground(Color.black);
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            txtPassword.setText("********");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUserMousePressed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar) || Character.isDigit(keyChar))) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
        if (txtUser.getText().isEmpty()) {
            txtUser.setText(" Ingrese su Usuario");
            txtUser.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqPassword;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblImgusuario;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
