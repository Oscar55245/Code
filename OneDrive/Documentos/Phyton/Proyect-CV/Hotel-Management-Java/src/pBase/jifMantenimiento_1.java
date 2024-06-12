package pBase;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;
import static pBase.JDRESER.ItmHabitacion;
import static pBase.jffPrincipal.reservacion;
import proyecto.DAOHabitacion;
import proyecto.DAOTickets;
import proyecto.Habitacion;
import proyecto.No_Habi;
import proyecto.Tickets;

public class jifMantenimiento_1 extends javax.swing.JInternalFrame {

    private Tickets tickets;
    private final DAOTickets dao = new DAOTickets();
    private List<Tickets> adlist;

    private final DAOHabitacion daoH = new DAOHabitacion();
    public static Date dato2 = new Date();
    Date  salida =null;
    private Habitacion habitacion;

    public static ArrayList<No_Habi> lis;
    int ha=0;
    public static String reservar;
    public static ArrayList<Habitacion> list;

    public jifMantenimiento_1() {
        initComponents();
        list = daoH.busquedapornombre("");
        for (Habitacion habitacion1 : list) {
            jchabitacion.addItem(String.valueOf(habitacion1.getNoH()));

        }
        adlist = dao.list();
        ModelTickets modelo = new ModelTickets((ArrayList<Tickets>) adlist);
        Limpieza.setModel(modelo);
        Limpieza.getColumnModel().getColumn(6).setCellRenderer(new PintrCasilla());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Limpieza = new javax.swing.JTable();
        folioL = new javax.swing.JTextField();
        tipoL = new javax.swing.JTextField();
        empleadoL = new javax.swing.JTextField();
        descripcionL = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        estadoL = new javax.swing.JComboBox<>();
        solucionL = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        agregarL = new javax.swing.JLabel();
        listarL = new javax.swing.JLabel();
        actualizarL = new javax.swing.JLabel();
        jchabitacion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Mantenimiento");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Limpieza.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Limpieza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Limpieza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimpiezaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Limpieza);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1080, 450));

        folioL.setEditable(false);
        folioL.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        folioL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                folioLKeyTyped(evt);
            }
        });
        getContentPane().add(folioL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 40));

        tipoL.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tipoL.setEnabled(false);
        tipoL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipoLKeyTyped(evt);
            }
        });
        getContentPane().add(tipoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 174, 40));

        empleadoL.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        empleadoL.setEnabled(false);
        empleadoL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empleadoLKeyTyped(evt);
            }
        });
        getContentPane().add(empleadoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 174, 40));

        descripcionL.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        descripcionL.setEnabled(false);
        descripcionL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionLKeyTyped(evt);
            }
        });
        getContentPane().add(descripcionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 480, 40));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("NO_FOLIO");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("TIPO");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("DESCRIPCION");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("F_SOLUCION ");
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 160, 40));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("ESTADO");
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("EMPLEADO");
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Buscar  :");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("HABITACION");
        getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtbuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 350, 40));

        estadoL.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        estadoL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTADO", "PENDIENTE", "COMPLETADO", "EN CURSO" }));
        getContentPane().add(estadoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 480, 40));

        solucionL.setEnabled(false);
        solucionL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                solucionLFocusLost(evt);
            }
        });
        getContentPane().add(solucionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 80, 210, 40));

        agregarL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        agregarL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarLMouseClicked(evt);
            }
        });

        listarL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listas.png"))); // NOI18N
        listarL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarLMouseClicked(evt);
            }
        });

        actualizarL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        actualizarL.setEnabled(false);
        actualizarL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actualizarL)
                .addGap(18, 18, 18)
                .addComponent(listarL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agregarL)
                .addGap(52, 52, 52))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarL)
                    .addComponent(listarL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        jchabitacion.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jchabitacion.setEnabled(false);
        getContentPane().add(jchabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 174, 41));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul Grande.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -4, -1, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar() {
        folioL.setText("");
        descripcionL.setText("");
        tipoL.setText("");
        estadoL.setSelectedIndex(0);
        jchabitacion.setSelectedIndex(0);
        solucionL.setDate(null);

    }
    public void BloquearR() {
        folioL.setEnabled(false);
        descripcionL.setEnabled(true);
        tipoL.setEnabled(true);
        empleadoL.setEnabled(false);
        estadoL.setEnabled(true);
        jchabitacion.setEnabled(true);
        solucionL.setEnabled(false);
        agregarL.setEnabled(true);
        actualizarL.setEnabled(true);
        
    }
    public void BloquearE() {
        folioL.setEnabled(false);
        descripcionL.setEnabled(false);
        tipoL.setEnabled(false);
        empleadoL.setEnabled(false);
        estadoL.setEnabled(true);
        jchabitacion.setEnabled(false);
        solucionL.setEnabled(false);
        Date d = new Date();
        solucionL.setDate(d);
        agregarL.setEnabled(false);
        actualizarL.setEnabled(true);
    }

    private void folioLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_folioLKeyTyped
        char c01 = evt.getKeyChar();
        if (!(Character.isDigit(c01) || (c01 == KeyEvent.VK_BACK_SPACE) || (c01 == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_folioLKeyTyped

    private void tipoLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoLKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }

    }//GEN-LAST:event_tipoLKeyTyped

    private void descripcionLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionLKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar) || Character.isDigit(keyChar) || (Character.isSpace(keyChar)))) {
            evt.consume();
            getToolkit().beep();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_descripcionLKeyTyped

    private void empleadoLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empleadoLKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_empleadoLKeyTyped

    private void solucionLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_solucionLFocusLost
        if (solucionL.getDate() != null) {
            Date dato1 = solucionL.getDate();
            Date date3 = new Date();

            int ingresado = solucionL.getDate().getYear();
            int hoy = date3.getYear();
            int permitido = (hoy - ingresado);
            if (permitido >= 18) {
            } else if (permitido >= 1 || permitido <= 17) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "Tienes que ser mayor de edad para poder trabar aquí");
            } else if (dato1.after(date3)) {
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "No se pueden registrar fechas futuras");
            }
        } else if (solucionL.getDate() == null) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "*La fecha esta vacia.");
        }
    }//GEN-LAST:event_solucionLFocusLost

    private void agregarLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarLMouseClicked
        if (agregarL.isEnabled() == false) {
          JOptionPane.showMessageDialog(null, "Revisa la accion");
        } else {
            if (tipoL.getText().equals("") || descripcionL.getText().equals("") ||
         jchabitacion.getSelectedItem().equals("") || estadoL.getSelectedItem().equals("ESTADO") ) {
          JOptionPane.showMessageDialog(null, "Campos vacios");
            } else {
                 ha = Integer.parseInt(jchabitacion.getSelectedItem().toString());
                System.out.println(ha);
                habitacion = daoH.get(ha);
                 tickets = new Tickets();
                descarga();
                String resultado = dao.Insertar(tickets);
                System.out.println(habitacion.getEstatus());
                JOptionPane.showMessageDialog(null, resultado);
                if (!(habitacion.getEstatus().equals("OCUPADO"))) {
                  String res = Arrays.toString(estadoL.getSelectedObjects());
                System.out.println(res);
                limpiar();
                switch (res) {
                    case "[ESTADO]":
                        JOptionPane.showMessageDialog(null, "Elige un estado");
                        break;
                    case "[PENDIENTE]":
                        reservar = "MANTENIMIENTO";
                        reservacion.colores(String.valueOf(ha),reservar);
                        habitacion.setEstatus(reservar);
                        daoH.Estado(habitacion);
                        break;
                    case "[COMPLETADO]":
                        reservar = "ACTIVO";
                        reservacion.colores(String.valueOf(ha),reservar);
                        habitacion.setEstatus(reservar);
                        daoH.Estado(habitacion);
                        break;
                }}
               
                }
            
                ItmHabitacion.removeAllItems();
                lis = daoH.No_habitacion();
                for (No_Habi habitacion1 : lis) {
                    ItmHabitacion.addItem(String.valueOf(habitacion1.getHabitacionNO()));
                    System.out.println(habitacion1.getHabitacionNO());
            }
        adlist = dao.list();
        ModelTickets modelo = new ModelTickets((ArrayList<Tickets>) adlist);
        Limpieza.setModel(modelo);
        Limpieza.getColumnModel().getColumn(6).setCellRenderer(new PintrCasilla());
        }
    }//GEN-LAST:event_agregarLMouseClicked

    private void listarLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarLMouseClicked
        adlist = dao.list();
        ModelTickets modelo = new ModelTickets((ArrayList<Tickets>) adlist);
        Limpieza.setModel(modelo);
        Limpieza.getColumnModel().getColumn(6).setCellRenderer(new PintrCasilla());
    }//GEN-LAST:event_listarLMouseClicked

    private void actualizarLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarLMouseClicked
     
        if (actualizarL.isEnabled() == false||empleadoL.getText().equals("")||tipoL.getText().equals("") || descripcionL.getText().equals("") || jchabitacion.getSelectedItem().equals("") || estadoL.getSelectedItem().equals("ESTADO")) {
            JOptionPane.showMessageDialog(null, "Revisa la accion ");
        } else {
            ha = Integer.parseInt(jchabitacion.getSelectedItem().toString());
                System.out.println(ha);
                habitacion = daoH.get(ha);
                
               descarga2();
               String resultado = dao.update(tickets);
               JOptionPane.showMessageDialog(null, resultado);
                if (!(habitacion.getEstatus().equals("OCUPADO"))) {
                  String res = Arrays.toString(estadoL.getSelectedObjects());
                System.out.println(res);
                limpiar();
                switch (res) {
                    case "[ESTADO]":
                        JOptionPane.showMessageDialog(null, "Elige un estado");
                        break;
                    case "[PENDIENTE]":
                        reservar = "MANTENIMIENTO";
                        reservacion.colores(String.valueOf(ha),reservar);
                        habitacion.setEstatus(reservar);
                        daoH.Estado(habitacion);
                        break;
                    case "[COMPLETADO]":
                        reservar = "ACTIVO";
                        reservacion.colores(String.valueOf(ha),reservar);
                        habitacion.setEstatus(reservar);
                        daoH.Estado(habitacion);
                        break;
                }
                }
            adlist = dao.list();
            ModelTickets modelo = new ModelTickets((ArrayList<Tickets>) adlist);
            Limpieza.setModel(modelo);
            Limpieza.getColumnModel().getColumn(6).setCellRenderer(new PintrCasilla());
            actualizarL.setEnabled(false);
            agregarL.setEnabled(true);
            limpiar();
        }
    }//GEN-LAST:event_actualizarLMouseClicked

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
   adlist = dao.busquedapornombre(txtbuscar.getText());
        ModelTickets modelo = new ModelTickets((ArrayList<Tickets>) adlist);
        Limpieza.setModel(modelo);
        Limpieza.getColumnModel().getColumn(6).setCellRenderer(new PintrCasilla());
        Limpieza.repaint();   
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
 agregarL.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void LimpiezaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiezaMouseClicked
        try {
            tickets = adlist.get(Limpieza.getSelectedRow());
        folioL.setText(String.valueOf(tickets.getNo_Folio()));
        tickets = dao.get(Integer.parseInt(folioL.getText()));
        if (tickets == null) {
            JOptionPane.showMessageDialog(this, "No fue encontrado.");
        } else {
            actualizarL.setEnabled(true);
            agregarL.setEnabled(false);
            if (empleadoL.getText().isEmpty()) {
                carga();
            }else{carga3();}
        }
        } catch (Exception e) {
            System.out.println("error");
        }
        
    }//GEN-LAST:event_LimpiezaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Limpieza;
    private javax.swing.JLabel actualizarL;
    private javax.swing.JLabel agregarL;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField descripcionL;
    public javax.swing.JTextField empleadoL;
    private javax.swing.JComboBox<String> estadoL;
    private javax.swing.JTextField folioL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jchabitacion;
    private javax.swing.JLabel listarL;
    private com.toedter.calendar.JDateChooser solucionL;
    private javax.swing.JTextField tipoL;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    public void carga() {
        folioL.setText(String.valueOf(tickets.getNo_Folio()));
        tipoL.setText(tickets.getTipo());
        descripcionL.setText(tickets.getDescripcion());
        empleadoL.setText(tickets.getEmpleado());
        jchabitacion.setSelectedItem(tickets.getHabitacion());
        estadoL.setSelectedItem(tickets.getStatus());
        solucionL.setDate(tickets.getResolucion());
    }
    public void carga3() {
        folioL.setText(String.valueOf(tickets.getNo_Folio()));
        tipoL.setText(tickets.getTipo());
        descripcionL.setText(tickets.getDescripcion());
        empleadoL.setText(Login.em);
        jchabitacion.setSelectedItem(tickets.getHabitacion());
        estadoL.setSelectedItem(tickets.getStatus());
        solucionL.setDate(tickets.getResolucion());
    }
    public void descarga() {
        Date da = new Date();
        java.sql.Date sqlda= new java.sql.Date(da.getTime()), sqldate =  new java.sql.Date(da.getTime());
        if (solucionL.getDate()!=null) {
        java.util.Date d = solucionL.getDate();
        sqldate = new java.sql.Date(d.getTime());
        Date dato = solucionL.getDate();   
        }
        tickets.setTipo(tipoL.getText());
        tickets.setDescripcion(descripcionL.getText());
        tickets.setEmision(sqlda);
        tickets.setHabitacion(jchabitacion.getSelectedItem().toString());
        tickets.setEmpleado(empleadoL.getText());
        tickets.setStatus(estadoL.getSelectedItem().toString());
        tickets.setResolucion(sqldate);
    }
    public void descarga2() {
        Date da = new Date();
        java.sql.Date sqlda= new java.sql.Date(da.getTime());
        tickets.setTipo(tipoL.getText());
        tickets.setDescripcion(descripcionL.getText());
        tickets.setHabitacion(jchabitacion.getSelectedItem().toString());
        tickets.setEmpleado(empleadoL.getText());
        tickets.setStatus(estadoL.getSelectedItem().toString());
        tickets.setResolucion(sqlda);
    }

}
