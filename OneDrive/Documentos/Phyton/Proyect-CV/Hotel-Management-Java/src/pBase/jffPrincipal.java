package pBase;

import java.awt.*;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class jffPrincipal extends javax.swing.JFrame {
    private static final jifEmpleado altaEmpleado = new jifEmpleado();
    public static JIrecepcion reservacion = new JIrecepcion();
    private static final jifMantenimiento_1 mantenimiento = new jifMantenimiento_1();
    private static final jifHabitacion altaHabitacion = new jifHabitacion();
    private static final jifCliente altaCliente = new jifCliente();
    private static final Login login = new Login();
    public jffPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        altaEmpleado.setVisible(false);
        reservacion.setVisible(false);
        mantenimiento.setVisible(false);
        altaHabitacion.setVisible(false);
        altaCliente.setVisible(false);
        Escritorio.add(altaEmpleado);
        Escritorio.add(reservacion);
        Escritorio.add(mantenimiento);
        Escritorio.add(altaHabitacion);
        Escritorio.add(altaCliente);
        
    }
    public Image getIconImage() {
        
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/hotel.png"));
        return retValue;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jToolBar2 = new javax.swing.JToolBar();
        btnEmpleado = new javax.swing.JButton();
        Lempleado = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCliente = new javax.swing.JButton();
        Lcliente = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnHabitacion = new javax.swing.JButton();
        Lhabitacion = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnReservacion = new javax.swing.JButton();
        Lrecepcion = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnMantenimiento = new javax.swing.JButton();
        Lmantenimiento = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        Salir = new javax.swing.JLabel();
        lblUsuario5 = new javax.swing.JLabel();
        Escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOTEL");
        setIconImage(getIconImage());
        setUndecorated(true);

        jToolBar2.setBackground(new java.awt.Color(0, 0, 204));
        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setToolTipText("");
        jToolBar2.setEnabled(false);
        jToolBar2.setFocusable(false);

        btnEmpleado.setBackground(new java.awt.Color(0, 0, 204));
        btnEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Empleado.png"))); // NOI18N
        btnEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleado.setFocusable(false);
        btnEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmpleadoMouseExited(evt);
            }
        });
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEmpleado);

        Lempleado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lempleado.setForeground(new java.awt.Color(51, 51, 51));
        Lempleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lempleado.setText("Empleado");
        jToolBar2.add(Lempleado);
        jToolBar2.add(jSeparator2);

        btnCliente.setBackground(new java.awt.Color(0, 0, 204));
        btnCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente.png"))); // NOI18N
        btnCliente.setContentAreaFilled(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setFocusable(false);
        btnCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
        });
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jToolBar2.add(btnCliente);

        Lcliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lcliente.setForeground(new java.awt.Color(51, 51, 51));
        Lcliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lcliente.setText("Cliente");
        jToolBar2.add(Lcliente);
        jToolBar2.add(jSeparator3);

        btnHabitacion.setBackground(new java.awt.Color(0, 0, 204));
        btnHabitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitacion.png"))); // NOI18N
        btnHabitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHabitacion.setFocusable(false);
        btnHabitacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHabitacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHabitacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHabitacionMouseExited(evt);
            }
        });
        btnHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabitacionActionPerformed(evt);
            }
        });
        jToolBar2.add(btnHabitacion);

        Lhabitacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lhabitacion.setForeground(new java.awt.Color(51, 51, 51));
        Lhabitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lhabitacion.setText("Habitacion");
        jToolBar2.add(Lhabitacion);
        jToolBar2.add(jSeparator4);

        btnReservacion.setBackground(new java.awt.Color(0, 0, 204));
        btnReservacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recepcion.png"))); // NOI18N
        btnReservacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservacion.setFocusable(false);
        btnReservacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReservacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReservacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReservacionMouseExited(evt);
            }
        });
        btnReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservacionActionPerformed(evt);
            }
        });
        jToolBar2.add(btnReservacion);

        Lrecepcion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lrecepcion.setForeground(new java.awt.Color(51, 51, 51));
        Lrecepcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lrecepcion.setText("Recepcion");
        jToolBar2.add(Lrecepcion);
        jToolBar2.add(jSeparator5);

        btnMantenimiento.setBackground(new java.awt.Color(0, 0, 204));
        btnMantenimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mante.png"))); // NOI18N
        btnMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMantenimiento.setFocusable(false);
        btnMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMantenimientoMouseExited(evt);
            }
        });
        btnMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMantenimiento);

        Lmantenimiento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lmantenimiento.setForeground(new java.awt.Color(51, 51, 51));
        Lmantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lmantenimiento.setText("Mantenimiento");
        jToolBar2.add(Lmantenimiento);
        jToolBar2.add(jSeparator6);

        Salir.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jToolBar2.add(Salir);

        lblUsuario5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario5.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario5.setText("Salir");
        jToolBar2.add(lblUsuario5);

        Escritorio.setBackground(new java.awt.Color(255, 255, 255));
        Escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bienvenido.jpg"))); // NOI18N
        Escritorio.add(jLabel1);
        jLabel1.setBounds(0, 0, 1250, 870);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        altaEmpleado.setVisible(true);
        reservacion.setVisible(false);
        mantenimiento.setVisible(false);
        altaHabitacion.setVisible(false);
        altaCliente.setVisible(false);
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        altaEmpleado.setVisible(false);
        reservacion.setVisible(false);
        mantenimiento.setVisible(false);
        altaHabitacion.setVisible(false);
        altaCliente.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabitacionActionPerformed
        altaEmpleado.setVisible(false);
        reservacion.setVisible(false);
        mantenimiento.setVisible(false);
        altaHabitacion.setVisible(true);
        altaCliente.setVisible(false);
    }//GEN-LAST:event_btnHabitacionActionPerformed

    private void btnReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionActionPerformed
        altaEmpleado.setVisible(false);
        reservacion.setVisible(true);
        mantenimiento.setVisible(false);
        altaHabitacion.setVisible(false);
        altaCliente.setVisible(false);
        try {
        reservacion.Imagenes();
        } catch (IOException ex) {
            Logger.getLogger(jffPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReservacionActionPerformed

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int respuesta = JOptionPane.showConfirmDialog(this, "Deseas Salir?");
        if (respuesta == 0) {
            login.setVisible(true);
            this.hide(); }
    }//GEN-LAST:event_SalirMouseClicked

    private void btnMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoActionPerformed
     altaEmpleado.setVisible(false);
     reservacion.setVisible(false);
     mantenimiento.setVisible(true);
     mantenimiento.empleadoL.setText(Login.em);
        System.out.println(Login.puesto);
        switch (Login.puesto) {
            case "Recepcion":
                mantenimiento.BloquearR();
                break;
            case "Mantenimiento":
                mantenimiento.BloquearE();
                break;
            case "Limpieza":
                mantenimiento.BloquearE();
                break;
            default:
                break;
        }
     altaHabitacion.setVisible(false);
     altaCliente.setVisible(false);
    }//GEN-LAST:event_btnMantenimientoActionPerformed

    private void btnEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMouseEntered
        btnEmpleado.setFont(new Font("Arial Black", Font.BOLD, 20));
    }//GEN-LAST:event_btnEmpleadoMouseEntered

    private void btnEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadoMouseExited
        btnEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
    }//GEN-LAST:event_btnEmpleadoMouseExited

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        btnCliente.setFont(new Font("Arial Black", Font.BOLD, 20));
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnHabitacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHabitacionMouseEntered
        btnHabitacion.setFont(new Font("Arial Black", Font.BOLD, 20));
    }//GEN-LAST:event_btnHabitacionMouseEntered

    private void btnHabitacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHabitacionMouseExited
        btnHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
    }//GEN-LAST:event_btnHabitacionMouseExited

    private void btnReservacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservacionMouseEntered
        btnReservacion.setFont(new Font("Arial Black", Font.BOLD, 20));
    }//GEN-LAST:event_btnReservacionMouseEntered

    private void btnReservacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservacionMouseExited
        btnReservacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
    }//GEN-LAST:event_btnReservacionMouseExited

    private void btnMantenimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseEntered
        btnMantenimiento.setFont(new Font("Arial Black", Font.BOLD, 20));
    }//GEN-LAST:event_btnMantenimientoMouseEntered

    private void btnMantenimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenimientoMouseExited
        btnMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
    }//GEN-LAST:event_btnMantenimientoMouseExited
 public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jffPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jffPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jffPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jffPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jffPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    public static javax.swing.JLabel Lcliente;
    public static javax.swing.JLabel Lempleado;
    public static javax.swing.JLabel Lhabitacion;
    private javax.swing.JLabel Lmantenimiento;
    public static javax.swing.JLabel Lrecepcion;
    private javax.swing.JLabel Salir;
    public static javax.swing.JButton btnCliente;
    public static javax.swing.JButton btnEmpleado;
    public static javax.swing.JButton btnHabitacion;
    public static javax.swing.JButton btnMantenimiento;
    public static javax.swing.JButton btnReservacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblUsuario5;
    // End of variables declaration//GEN-END:variables
}
