/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pBase;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static pBase.JDRESER.ItmHabitacion;
import static pBase.JDRESER.list;
import static pBase.jffPrincipal.reservacion;
import proyecto.Habitacion;
import proyecto.DAOHabitacion;
import proyecto.No_Habi;

public final class jifHabitacion extends javax.swing.JInternalFrame {
//   
    private Habitacion habitacion;
    private final DAOHabitacion dao = new DAOHabitacion();
    private ArrayList<Habitacion> lista;
    private final jdHabitacion habi = new jdHabitacion(null, true);
    public static String imagenes, piso, extras;

    public jifHabitacion() {
        initComponents();
        lista = dao.list();
        ModelHabitacion modelo = new ModelHabitacion(lista);
        tabla.setModel(modelo);
        tabla.repaint();
        errorTipo.setVisible(false);
        errorCosto.setVisible(false);
        errorHabitacion.setVisible(false);
        errorEstado.setVisible(false);
        errorNumero.setVisible(false);
        actualizar1.setEnabled(false);
        spAC.setValue(0);
        spBaños.setValue(0);
        spPiso.setValue(0);
        spcamas.setValue(0);
        spcuartos.setValue(0);
        sptv.setValue(0);
    }

    public void limpiar() {
        txtPersonas.setText("");
        txtHabitacion.setText("");
        cbTipo.setSelectedItem("TIPO");
        cbEstado.setSelectedItem("ESTADO");
        txtCosto.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtHabitacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtCosto = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        agregar1 = new javax.swing.JLabel();
        listar1 = new javax.swing.JLabel();
        actualizar1 = new javax.swing.JLabel();
        errorTipo = new javax.swing.JLabel();
        lblHabitacion = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtPersonas = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        cbEstado = new javax.swing.JComboBox<>();
        foto = new javax.swing.JButton();
        lblPersonas = new javax.swing.JLabel();
        errorNumero = new javax.swing.JLabel();
        errorHabitacion = new javax.swing.JLabel();
        errorEstado = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        errorCosto = new javax.swing.JLabel();
        spAC = new javax.swing.JSpinner();
        lblPersonas1 = new javax.swing.JLabel();
        lblPersonas2 = new javax.swing.JLabel();
        spcuartos = new javax.swing.JSpinner();
        lblPersonas3 = new javax.swing.JLabel();
        sptv = new javax.swing.JSpinner();
        lblPersonas4 = new javax.swing.JLabel();
        spPiso = new javax.swing.JSpinner();
        lblPersonas8 = new javax.swing.JLabel();
        lblPersonas5 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        spBaños = new javax.swing.JSpinner();
        lblPersonas7 = new javax.swing.JLabel();
        spcamas = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setTitle("REGISTRO DE HABITACIONES");
        setMinimumSize(new java.awt.Dimension(1217, 785));
        setName(""); // NOI18N
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(1217, 785));

        principal.setBackground(new java.awt.Color(0, 102, 153));
        principal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        principal.setMinimumSize(new java.awt.Dimension(1217, 785));
        principal.setPreferredSize(new java.awt.Dimension(1217, 785));
        principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        principal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtHabitacion.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtHabitacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHabitacion.setEnabled(false);
        txtHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHabitacionActionPerformed(evt);
            }
        });
        txtHabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHabitacionKeyTyped(evt);
            }
        });
        principal.add(txtHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 250, 40));

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Piso", "Tipo", "No°", "Estatus", "Id.C"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1160, 400));

        txtCosto.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtCosto.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        principal.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 220, 40));

        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        principal.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 220, 40));

        agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        agregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregar1MouseEntered(evt);
            }
        });

        listar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listas.png"))); // NOI18N
        listar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listar1MouseClicked(evt);
            }
        });

        actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        actualizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actualizar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar1)
                .addGap(74, 74, 74))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar1)
                    .addComponent(listar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        principal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        errorTipo.setBackground(new java.awt.Color(255, 0, 0));
        errorTipo.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        errorTipo.setForeground(new java.awt.Color(255, 0, 0));
        errorTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorTipo.setText("ERROR");
        principal.add(errorTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 190, -1));

        lblHabitacion.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblHabitacion.setForeground(new java.awt.Color(255, 255, 255));
        lblHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHabitacion.setText("NO.HABITACION");
        principal.add(lblHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, -1));

        lblCosto.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(255, 0, 0));
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCosto.setText("COSTO");
        principal.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 100, -1));

        txtPersonas.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPersonas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonasActionPerformed(evt);
            }
        });
        txtPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPersonasKeyTyped(evt);
            }
        });
        principal.add(txtPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 250, 40));

        cbTipo.setBackground(new java.awt.Color(255, 204, 255));
        cbTipo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIPO", "INDIVIDUAL", "DOBLE", "TRIPLE", "SIUTE" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        principal.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, 40));

        cbEstado.setBackground(new java.awt.Color(255, 204, 255));
        cbEstado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTADO", "ACTIVO", "INACTIVO" }));
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });
        principal.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, -1, 40));
        principal.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 120, 220, 140));

        lblPersonas.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas.setText("A.C.");
        principal.add(lblPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        errorNumero.setBackground(new java.awt.Color(255, 0, 0));
        errorNumero.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        errorNumero.setForeground(new java.awt.Color(255, 0, 0));
        errorNumero.setText("ERROR");
        principal.add(errorNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, 40));

        errorHabitacion.setBackground(new java.awt.Color(255, 0, 0));
        errorHabitacion.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        errorHabitacion.setForeground(new java.awt.Color(255, 0, 0));
        errorHabitacion.setText("ERROR");
        principal.add(errorHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 100, 40));

        errorEstado.setBackground(new java.awt.Color(255, 0, 0));
        errorEstado.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        errorEstado.setForeground(new java.awt.Color(255, 0, 0));
        errorEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorEstado.setText("ERROR");
        principal.add(errorEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 160, -1));

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
        principal.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 160, 40));

        errorCosto.setBackground(new java.awt.Color(255, 0, 0));
        errorCosto.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        errorCosto.setForeground(new java.awt.Color(255, 0, 0));
        errorCosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorCosto.setText("ERROR");
        errorCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                errorCostoKeyTyped(evt);
            }
        });
        principal.add(errorCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 130, -1));

        spAC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spAC.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spACStateChanged(evt);
            }
        });
        principal.add(spAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 100, 30));

        lblPersonas1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas1.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas1.setText("NO.PERSONAS");
        principal.add(lblPersonas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, -1));

        lblPersonas2.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas2.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas2.setText("Baños");
        principal.add(lblPersonas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, 40));

        spcuartos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spcuartos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spcuartosStateChanged(evt);
            }
        });
        principal.add(spcuartos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 100, 30));

        lblPersonas3.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas3.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas3.setText("Television");
        principal.add(lblPersonas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        sptv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sptv.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sptvStateChanged(evt);
            }
        });
        principal.add(sptv, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 100, 30));

        lblPersonas4.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas4.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas4.setText("Piso");
        principal.add(lblPersonas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        spPiso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spPiso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spPisoStateChanged(evt);
            }
        });
        principal.add(spPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 100, 30));

        lblPersonas8.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas8.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas8.setText("Dato a buscar");
        principal.add(lblPersonas8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 300, -1, -1));

        lblPersonas5.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas5.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas5.setText("Cuartos");
        principal.add(lblPersonas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        principal.add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 100, 30));

        spBaños.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spBaños.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spBañosStateChanged(evt);
            }
        });
        principal.add(spBaños, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 100, 30));

        lblPersonas7.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPersonas7.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonas7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPersonas7.setText("Camas");
        principal.add(lblPersonas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        spcamas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spcamas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spcamasStateChanged(evt);
            }
        });
        principal.add(spcamas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul Grande.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(945, 822));
        principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 749, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void habilitados() {
//        txtPersonas.setEnabled(true);
//        txtPiso.setEnabled(true);
//        txtStatus.setEnabled(true);
//        txtTipo.setEnabled(true);
    }
    

    public void deshabilitados() {
//        txtPersonas.setEnabled(false);
//        txtPiso.setEnabled(false);
//        txtStatus.setEnabled(false);
//        txtTipo.setEnabled(false);
    }

    public void perderFocus() {
//        txtPersonasFocusLost(null);
//        txtPisoFocusLost(null);
//        txtStatusFocusLost(null);
//        txtTipoFocusLost(null);
    }

    private void txtHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHabitacionActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void agregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar1MouseClicked
            if (agregar1.isEnabled() == true) {
            if (!(cbTipo.getSelectedItem().equals("")  || txtCosto.getText().equals("") || cbEstado.getSelectedItem().equals("ESTADO")
              ||(int)spPiso.getValue()<=0||(int)spcuartos.getValue()<=0||(int)spcamas.getValue()<=0||(int)spBaños.getValue()<=0)) {
                habitacion = new Habitacion();
                descarga();
                String resultado = dao.Insertar(habitacion);
                JOptionPane.showMessageDialog(null, resultado);
                limpiar();
            ItmHabitacion.removeAllItems();
            list = dao.No_habitacion();
            for (No_Habi habitacion1 : list ) {
            ItmHabitacion.addItem(String.valueOf(habitacion1.getHabitacionNO()));
            }
            lista = dao.list();
        ModelHabitacion modelo = new ModelHabitacion(lista);
        tabla.setModel(modelo);
        tabla.repaint();
            } else {JOptionPane.showMessageDialog(null, "Campos vacios"); }
            } else {JOptionPane.showMessageDialog(null, "Limpia los campos");}
    }//GEN-LAST:event_agregar1MouseClicked

    private void agregar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar1MouseEntered


    }//GEN-LAST:event_agregar1MouseEntered

    private void listar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar1MouseClicked
        lista = dao.list();
        ModelHabitacion modelo = new ModelHabitacion(lista);
        tabla.setModel(modelo);
        tabla.repaint();
    }//GEN-LAST:event_listar1MouseClicked

    private void actualizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizar1MouseClicked
        if (actualizar1.isEnabled() == false) {
            JOptionPane.showMessageDialog(null, "revisa la accion");
        } else {
            descarga();
            String resultado = dao.update(habitacion);
            reservacion.colores(String.valueOf(habitacion.getNoH()), habitacion.getEstatus().toString());
            JOptionPane.showMessageDialog(this, resultado);
            limpiar();
            agregar1.setEnabled(true);
            actualizar1.setEnabled(false);
            ItmHabitacion.removeAllItems();
            list = dao.No_habitacion();
            for (No_Habi habitacion1 : list ) {
            ItmHabitacion.addItem(String.valueOf(habitacion1.getHabitacionNO()));
            }
            lista = dao.list();
        ModelHabitacion modelo = new ModelHabitacion(lista);
        tabla.setModel(modelo);
        tabla.repaint();
        }
    }//GEN-LAST:event_actualizar1MouseClicked

    private void txtPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonasActionPerformed

    private void txtPersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonasKeyTyped
        final char keyChar = evt.getKeyChar();
        if ((Character.isLetter(keyChar) || Character.isSpaceChar(keyChar))) {
            evt.consume();
            errorNumero.setVisible(true);
        } else {
            errorNumero.setVisible(false);
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtPersonasKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        final char keyChar = evt.getKeyChar();
        if ((Character.isLetter(keyChar) || Character.isSpaceChar(keyChar))) {
            errorCosto.setVisible(true);
            evt.consume();
        } else {
            errorCosto.setVisible(false);
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        try {
            ImageIcon  mgIco = null;
          BufferedImage bufferedImage = null;
          File file = null;
        if (cbTipo.getSelectedItem().equals("TIPO")) {
            errorTipo.setVisible(true);
        } else {
            errorTipo.setVisible(false);
        }
        if (cbTipo.getSelectedItem().equals("SIUTE")) {
             file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\SUITE.JPG");
             imagenes="SIUTE.JPG";
             txtPersonas.setText("8");
        } else if (cbTipo.getSelectedItem().equals("DOBLE")) {
             file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\DOBLE.JPG");
            imagenes="DOBLE.JPG";
            txtPersonas.setText("4");
        } else if (cbTipo.getSelectedItem().equals("INDIVIDUAL")) {
            file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\Individual.JPG");
            imagenes="INDIVIDUAL.JPG";
            txtPersonas.setText("2");
        } else if (cbTipo.getSelectedItem().equals("TRIPLE")) {
             file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\TRIPLE.JPG");
            imagenes="TRIPLE.JPG";
            txtPersonas.setText("6");
        }
        
        try {
                  bufferedImage = ImageIO.read(file);
              } catch (IOException ex) {
                  Logger.getLogger(jifHabitacion.class.getName()).log(Level.SEVERE, null, ex);
              }
            mgIco = new ImageIcon((bufferedImage));
            Image imgcalada = mgIco.getImage().getScaledInstance(foto.getWidth(),
            foto.getHeight(), Image.SCALE_SMOOTH);
            Icon iconscalado = new ImageIcon(imgcalada);
            foto.setIcon(iconscalado);
        } catch (Exception e) {
            System.out.println("Error ");
        }
        
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed

        if (cbEstado.getSelectedItem().equals("ESTADO")) {
            errorEstado.setVisible(true);
        } else {
            errorEstado.setVisible(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void errorCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_errorCostoKeyTyped


    }//GEN-LAST:event_errorCostoKeyTyped

    private void spBañosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spBañosStateChanged
int valor = (int) spBaños.getValue();
int numeroP =  Integer.parseInt(txtPersonas.getText())/2;
        if (valor < 0|| valor>numeroP) {
            spBaños.setValue(0);
        }
        if (valor>numeroP) {
            JOptionPane.showMessageDialog(null,"Excediste el numero de Baños de la habitacion");
            spBaños.setValue(numeroP);
        }
    }//GEN-LAST:event_spBañosStateChanged

    private void sptvStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sptvStateChanged

        int valor = (int) sptv.getValue();
int numeroP =  Integer.parseInt(txtPersonas.getText())/2;
        if (valor < 0|| valor>numeroP) {
            sptv.setValue(0);
        }
        if (valor>numeroP) {
            JOptionPane.showMessageDialog(null,"Excediste el numero de televisores de la habitacion");
            sptv.setValue(numeroP);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_sptvStateChanged

    private void spcamasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spcamasStateChanged
int valor = (int) spcamas.getValue();
int numeroP =  Integer.parseInt(txtPersonas.getText())/2;
        if (valor < 0|| valor>numeroP) {
            spcamas.setValue(0);
        }
        if (valor>numeroP) {
            JOptionPane.showMessageDialog(null,"Excediste el numero de camas de la habitacion");
            spcamas.setValue(numeroP);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_spcamasStateChanged

    private void spACStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spACStateChanged

int valor = (int) spAC.getValue();
int numeroP =  Integer.parseInt(txtPersonas.getText())/2;
        if (valor < 0|| valor>numeroP) {
            spAC.setValue(0);
        }
        if (valor>numeroP) {
            JOptionPane.showMessageDialog(null,"Excediste el numero de A.C. de la habitacion");
            spAC.setValue(numeroP);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_spACStateChanged

    private void spPisoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spPisoStateChanged
int valor = (int) spPiso.getValue();
        if (valor < 0) {
            spPiso.setValue(0);
        } else if(valor>5)  {
        JOptionPane.showMessageDialog(null, "Excede el numero de pisos ");
        spPiso.setValue(5);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_spPisoStateChanged

    private void spcuartosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spcuartosStateChanged
int valor = (int) spcuartos.getValue();
int numeroP =  Integer.parseInt(txtPersonas.getText())/2;
        if (valor < 0|| valor>numeroP) {
            spcuartos.setValue(0);
        }
        if (valor>numeroP) {
            JOptionPane.showMessageDialog(null,"Excediste el numero de cuartos de la habitacion");
            spcuartos.setValue(numeroP);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_spcuartosStateChanged

    private void txtHabitacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHabitacionKeyTyped
        final char keyChar = evt.getKeyChar();
        if ((Character.isLetter(keyChar) || Character.isSpaceChar(keyChar))) {
            errorHabitacion.setVisible(true);
            evt.consume();
        } else {
            errorHabitacion.setVisible(false);
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        if (txtHabitacion.getText().length() > 2) {
            evt.consume();
            errorHabitacion.setText("Exceso");
        } else {
            errorHabitacion.setVisible(false);
        }
    }//GEN-LAST:event_txtHabitacionKeyTyped

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
       lista = dao.busquedapornombre(txtBuscar.getText());
        ModelHabitacion modelo = new ModelHabitacion(lista);
        tabla.setModel(modelo);
        tabla.repaint();    
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
       habitacion=lista.get(tabla.getSelectedRow());
       txtHabitacion.setText(String.valueOf(habitacion.getNoH()));
        habitacion=dao.get(Integer.parseInt(txtHabitacion.getText()));
        if (habitacion==null){
                JOptionPane.showMessageDialog(this, "No fue encontrado.");
            }else{
            System.out.println(habitacion);
                actualizar1.setEnabled(true);
                carga();
                agregar1.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        deshabilitados();
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualizar1;
    private javax.swing.JLabel agregar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel errorCosto;
    private javax.swing.JLabel errorEstado;
    private javax.swing.JLabel errorHabitacion;
    private javax.swing.JLabel errorNumero;
    private javax.swing.JLabel errorTipo;
    public static javax.swing.JButton foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblPersonas;
    private javax.swing.JLabel lblPersonas1;
    private javax.swing.JLabel lblPersonas2;
    private javax.swing.JLabel lblPersonas3;
    private javax.swing.JLabel lblPersonas4;
    private javax.swing.JLabel lblPersonas5;
    private javax.swing.JLabel lblPersonas7;
    private javax.swing.JLabel lblPersonas8;
    private javax.swing.JLabel listar1;
    private javax.swing.JPanel principal;
    private javax.swing.JSpinner spAC;
    private javax.swing.JSpinner spBaños;
    private javax.swing.JSpinner spPiso;
    private javax.swing.JSpinner spcamas;
    private javax.swing.JSpinner spcuartos;
    private javax.swing.JSpinner sptv;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtPersonas;
    // End of variables declaration//GEN-END:variables
    private void carga() {
        txtHabitacion.setText(String.valueOf(habitacion.getNoH()));
        cbTipo.setSelectedItem(habitacion.getTipo());
        txtPersonas.setText(String.valueOf(habitacion.getCapacidad()));
        cbEstado.setSelectedItem(habitacion.getEstatus());
        txtCosto.setText(String.valueOf(habitacion.getCosto()));
     spPiso.setValue(Integer.parseInt(habitacion.getPISO()));
     spcuartos.setValue(Integer.parseInt(habitacion.getCUARTOS()));
        foto.setText(habitacion.getFoto());
        spcamas.setValue(Integer.parseInt(habitacion.getCAMAS()));
        spBaños.setValue(Integer.parseInt(habitacion.getBAÑOS()));
        spAC.setValue(Integer.parseInt(habitacion.getAC()));
        sptv.setValue(Integer.parseInt(habitacion.getTV()));
    }

    public void descarga() {
        habitacion.setTipo(cbTipo.getSelectedItem().toString());
        habitacion.setCapacidad(Integer.parseInt(txtPersonas.getText()));
        habitacion.setEstatus(cbEstado.getSelectedItem().toString());
        habitacion.setCosto(Integer.parseInt(txtCosto.getText()));
        habitacion.setPISO(spPiso.getValue().toString());
        habitacion.setCUARTOS(spcuartos.getValue().toString());
        habitacion.setFoto(imagenes);
        habitacion.setCAMAS(spcamas.getValue().toString());
        habitacion.setBAÑOS(spBaños.getValue().toString());
        habitacion.setAC(spAC.getValue().toString());
        habitacion.setTV(sptv.getValue().toString());
    }
}
