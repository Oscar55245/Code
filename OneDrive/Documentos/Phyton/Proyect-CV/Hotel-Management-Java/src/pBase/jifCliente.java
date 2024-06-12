package pBase;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import proyecto.Cliente;
import proyecto.DAOCliente;

public class jifCliente extends javax.swing.JInternalFrame {

    boolean nombre, Apaterno, Amaterno, dn, email, opcemail, fecha = false;
    private Cliente cliente;    
    private final DAOCliente dao = new DAOCliente();
    private ArrayList<Cliente> lista;
    private final jdCliente cli = new jdCliente(null, true);
    public jifCliente() {
        initComponents();
        lista = dao.list();
        ModelCliente modelo = new ModelCliente(lista);
        tabla.setModel(modelo);
        tabla.repaint();
        ErrorAMaterno.setVisible(false);
        ErrorAPaterno.setVisible(false);
        ErrorDN.setVisible(false);
        ErrorEmail.setVisible(false);
        ErrorID.setVisible(false);
        ErrorName.setVisible(false);
        ErrorOpcEmail.setVisible(false);
        ErrorFecha.setVisible(false);
        btnCancelar.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RESEE = new javax.swing.JPanel();
        tcorre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        agregar = new javax.swing.JLabel();
        listar = new javax.swing.JLabel();
        actualizar = new javax.swing.JLabel();
        buscar = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jcFecha = new com.toedter.calendar.JDateChooser();
        ErrorID = new javax.swing.JLabel();
        ErrorName = new javax.swing.JLabel();
        ErrorAPaterno = new javax.swing.JLabel();
        ErrorAMaterno = new javax.swing.JLabel();
        ErrorDN = new javax.swing.JLabel();
        ErrorEmail = new javax.swing.JLabel();
        ErrorOpcEmail = new javax.swing.JLabel();
        cbEmail = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        ErrorFecha = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setTitle("ALTA DE CLIENTE");
        setMinimumSize(new java.awt.Dimension(1217, 785));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1217, 785));

        RESEE.setBackground(new java.awt.Color(0, 51, 153));
        RESEE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RESEE.setMinimumSize(new java.awt.Dimension(1217, 785));
        RESEE.setPreferredSize(new java.awt.Dimension(1217, 785));
        RESEE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        RESEE.add(tcorre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        tabla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        RESEE.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 1130, 380));

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarMouseEntered(evt);
            }
        });

        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listas.png"))); // NOI18N
        listar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarMouseClicked(evt);
            }
        });

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        actualizar.setEnabled(false);
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
        });

        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar)
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar)
                    .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RESEE.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("ID");
        RESEE.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Nombre");
        RESEE.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Ap.Paterno");
        RESEE.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 140, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Ap.Materno");
        RESEE.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Buscar");
        RESEE.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 100, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Fech.Nacimiento");
        RESEE.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Correo");
        RESEE.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 100, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Teléfono");
        RESEE.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 150, -1));

        jcFecha.setEnabled(false);
        jcFecha.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jcFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcFechaFocusLost(evt);
            }
        });
        RESEE.add(jcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 300, 30));

        ErrorID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorID.setForeground(new java.awt.Color(255, 51, 51));
        ErrorID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorID.setText("ErrorID");
        RESEE.add(ErrorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 150, 30));

        ErrorName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorName.setForeground(new java.awt.Color(255, 51, 51));
        ErrorName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorName.setText("NameError");
        RESEE.add(ErrorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, -1));

        ErrorAPaterno.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorAPaterno.setForeground(new java.awt.Color(255, 51, 51));
        ErrorAPaterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorAPaterno.setText("APaternoError");
        RESEE.add(ErrorAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 220, -1));

        ErrorAMaterno.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorAMaterno.setForeground(new java.awt.Color(255, 51, 51));
        ErrorAMaterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorAMaterno.setText("AMaternoError");
        RESEE.add(ErrorAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 220, -1));

        ErrorDN.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorDN.setForeground(new java.awt.Color(255, 51, 51));
        ErrorDN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorDN.setText("ErrorTelefono");
        RESEE.add(ErrorDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 220, -1));

        ErrorEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorEmail.setForeground(new java.awt.Color(255, 51, 51));
        ErrorEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorEmail.setText("ErrorEmail");
        RESEE.add(ErrorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 300, -1));

        ErrorOpcEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorOpcEmail.setForeground(new java.awt.Color(255, 51, 51));
        ErrorOpcEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorOpcEmail.setText("ErrorOpcEmail");
        RESEE.add(ErrorOpcEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 240, -1));

        cbEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        cbEmail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "opc de correo", "@gmail.com", "@hotmail.com", "@icloud.com", "@outlook.com", "@outlook.com.es" }));
        cbEmail.setEnabled(false);
        cbEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbEmailFocusLost(evt);
            }
        });
        RESEE.add(cbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, 300, 30));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        RESEE.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 312, 300, 30));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtID.setFocusCycleRoot(true);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        RESEE.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 140, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setEnabled(false);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        RESEE.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 300, -1));

        txtPaterno.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPaterno.setEnabled(false);
        txtPaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPaternoFocusLost(evt);
            }
        });
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        RESEE.add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 300, -1));

        txtMaterno.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaterno.setEnabled(false);
        txtMaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaternoFocusLost(evt);
            }
        });
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });
        RESEE.add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 300, 30));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono.setEnabled(false);
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        RESEE.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 300, 30));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setEnabled(false);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        RESEE.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 300, -1));

        ErrorFecha.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorFecha.setForeground(new java.awt.Color(255, 51, 51));
        ErrorFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ErrorFecha.setText("ErrorFecha");
        RESEE.add(ErrorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 80, 120, -1));

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
        RESEE.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 160, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul Grande.png"))); // NOI18N
        RESEE.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 760));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RESEE, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RESEE, javax.swing.GroupLayout.PREFERRED_SIZE, 753, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void habilitados() {
        txtMaterno.setEnabled(true);
        txtNombre.setEnabled(true);
        txtPaterno.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        cbEmail.setEnabled(true);
        jcFecha.setEnabled(true);
        btnCancelar.setVisible(true);
    }
    public void deshabilitados() {
        txtMaterno.setEnabled(false);
        txtNombre.setEnabled(false);
        txtPaterno.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        cbEmail.setEnabled(false);
        jcFecha.setEnabled(false);
        btnCancelar.setVisible(false);
    }
    public void perderFocus() {
        txtNombreFocusLost(null);
        txtPaternoFocusLost(null);
        txtMaternoFocusLost(null);
        txtTelefonoFocusLost(null);
        txtEmailFocusLost(null);
        cbEmailFocusLost(null);
        jcFechaFocusLost(null);
    }
    public void eliminarErrores() {
        ErrorAMaterno.setVisible(false);
        ErrorAPaterno.setVisible(false);
        ErrorDN.setVisible(false);
        ErrorEmail.setVisible(false);
        ErrorID.setVisible(false);
        ErrorName.setVisible(false);
        ErrorOpcEmail.setVisible(false);
        ErrorFecha.setVisible(false);
    }
    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
       // cli.show();
        
    }//GEN-LAST:event_buscarMouseClicked

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        if (actualizar.isEnabled() == true) {
            descarga();
            String resultado = dao.update(cliente);
            JOptionPane.showMessageDialog(this, "Actualizado con Exito!");
            limpiar();
            actualizar.setEnabled(false);
            agregar.setEnabled(true);
            txtID.setEnabled(true);
            deshabilitados();
             lista = dao.list();
        ModelCliente modelo = new ModelCliente(lista);
        tabla.setModel(modelo);
        tabla.repaint();
        } else if ((actualizar.isEnabled() == false)) {
            JOptionPane.showMessageDialog(this, "No disponible.");
        }
    }//GEN-LAST:event_actualizarMouseClicked

    private void listarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarMouseClicked
        lista = dao.list();
        ModelCliente modelo = new ModelCliente(lista);
        tabla.setModel(modelo);
        tabla.repaint();
    }//GEN-LAST:event_listarMouseClicked

    private void agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseEntered
        if (txtNombre.isEnabled() == true) {
            perderFocus();
        }
    }//GEN-LAST:event_agregarMouseEntered

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked
        
            if (agregar.isEnabled() == true) {
                habilitados();
                txtID.setEnabled(false);
                if (nombre == true&&Apaterno == true&&Amaterno == true&&
                     dn == true&&email == true && opcemail == true&&fecha == true&&txtEmail.getText().length() <= 10&&txtEmail.getText().length() >= 5 ) {
                     cliente = new Cliente();
                                            descarga();
                                            String resultado = dao.Insertar(cliente);
                                            JOptionPane.showMessageDialog(this, resultado);
                                            limpiar();
                                            deshabilitados();
                                            txtID.setEnabled(true);
                                             lista = dao.list();
                                             ModelCliente modelo = new ModelCliente(lista);
                                             tabla.setModel(modelo);
                                              tabla.repaint();
                                        }
                                    
            } else if (agregar.isEnabled() == false) {
                JOptionPane.showMessageDialog(this, "*Existe algun error en los datos solicitados.");
            }
       
    }//GEN-LAST:event_agregarMouseClicked

    private void cbEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbEmailFocusLost
        if (cbEmail.getSelectedIndex() != 0) {
            opcemail = true;
            ErrorOpcEmail.setVisible(false);
        } else {
            ErrorOpcEmail.setText("*No Valido.");
            ErrorOpcEmail.setVisible(true);
            opcemail = false;
        }
    }//GEN-LAST:event_cbEmailFocusLost

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar))) {
            ErrorID.setText("*Solo números.");
            ErrorID.setVisible(true);
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtIDKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        txtNombre.setForeground(Color.BLACK);

        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar))) {
            ErrorName.setText("*Solo Letras.");
            ErrorName.setVisible(true);
            evt.consume();
            getToolkit().beep();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        txtPaterno.setForeground(Color.BLACK);

        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar))) {
            ErrorAPaterno.setText("*Solo Letras.");
            ErrorAPaterno.setVisible(true);
            evt.consume();
            getToolkit().beep();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
        txtMaterno.setForeground(Color.BLACK);

        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar))) {
            ErrorAMaterno.setText("*Solo Letras.");
            ErrorAMaterno.setVisible(true);
            evt.consume();
            getToolkit().beep();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtMaternoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar))) {
            ErrorDN.setText("*Solo números.");
            ErrorDN.setVisible(true);
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        txtEmail.setForeground(Color.BLACK);
        String s1 = String.valueOf(evt.getKeyChar());
        final char keyChar = evt.getKeyChar();
        if (s1.matches("[@]") || !(Character.isLetter(keyChar) || Character.isDigit(keyChar) || s1.matches("[._-]"))) {
            evt.consume();
            getToolkit().beep();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void jcFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcFechaFocusLost
        if (txtNombre.isEnabled() == true) {
            if (jcFecha.getDate() != null) {
                Date dato1 = jcFecha.getDate();
                Date dato2 = new Date();

                int ingresado = dato1.getYear();
                int hoy = dato2.getYear();
                int permitido = (hoy - ingresado);

                if (permitido >= 18) {
                    fecha = true;
                    ErrorFecha.setVisible(false);
                } else if (permitido >= 1 || permitido <= 17) {
                    getToolkit().beep();
                    ErrorFecha.setText("Fecha no valida.");
                    ErrorFecha.setVisible(true);
                    JOptionPane.showMessageDialog(this, "Tienes que ser mayor de edad para poder registrate.");
                    fecha = false;
                } else if (dato1.after(dato2)) {
                    getToolkit().beep();
                    ErrorFecha.setText("Fecha no valida.");
                    ErrorFecha.setVisible(true);
                    JOptionPane.showMessageDialog(this, "No se pueden registrar fechas futuras");
                    fecha = false;
                }
            } else if (jcFecha.getDate() == null) {
                getToolkit().beep();
                ErrorFecha.setText("*Campo vacio.");
                ErrorFecha.setVisible(true);
                //JOptionPane.showMessageDialog(this, "*La fecha esta vacia.");
                fecha = false;
            }
        }
    }//GEN-LAST:event_jcFechaFocusLost

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (txtNombre.getText().length() > 2) {
            nombre = true;
            ErrorName.setVisible(false);
        } else if (txtNombre.getText().isEmpty()) {
            ErrorName.setText("*El Campo esta vacio");
            nombre = false;
            ErrorName.setVisible(true);
        } else {
            ErrorName.setText("*No Valido.");
            nombre = false;
            ErrorName.setVisible(true);
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtPaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaternoFocusLost
        if (txtPaterno.getText().length() > 3) {
            Apaterno = true;
            ErrorAPaterno.setVisible(false);
        } else if (txtPaterno.getText().isEmpty()) {
            ErrorAPaterno.setText("*El campo esta vacio.");
            ErrorAPaterno.setVisible(true);
            Apaterno = false;
        } else {
            ErrorAPaterno.setText("*No Valido.");
            ErrorAPaterno.setVisible(true);
            Apaterno = false;
        }
    }//GEN-LAST:event_txtPaternoFocusLost

    private void txtMaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaternoFocusLost
        if (txtMaterno.getText().length() > 3) {
            Amaterno = true;
            ErrorAMaterno.setVisible(false);
        } else if (txtMaterno.getText().isEmpty()) {
            ErrorAMaterno.setText("*El campo esta vacio.");
            ErrorAMaterno.setVisible(true);
            Amaterno = false;
        } else {
            ErrorAMaterno.setText("*No Valido.");
            ErrorAMaterno.setVisible(true);
            Amaterno = false;
        }
    }//GEN-LAST:event_txtMaternoFocusLost

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        if (txtTelefono.getText().length() > 9 && txtTelefono.getText().length() < 14) {
            dn = true;
            ErrorDN.setVisible(false);
        } else if (txtTelefono.getText().isEmpty()) {
            ErrorDN.setText("*El campo esta vacio.");
            ErrorDN.setVisible(true);
            dn = false;
        } else {
            ErrorDN.setText("*No Valido.");
            ErrorDN.setVisible(true);
            dn = false;
        }
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().length() >= 6) {
            email = true;
            ErrorEmail.setVisible(false);
        } else if (txtEmail.getText().isEmpty()) {
            ErrorEmail.setText("*El campo esta vacio");
            ErrorEmail.setVisible(true);
            email = false;
        } else {
            ErrorEmail.setText("*Mínimo de 6 Caracteres.");
            ErrorEmail.setVisible(true);
            email = false;
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        deshabilitados();
        limpiar();
        eliminarErrores();
        actualizar.setEnabled(false);
        agregar.setEnabled(true);
        txtID.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        System.out.println(tabla.getSelectedRow());
        cliente = lista.get(tabla.getSelectedRow());
        txtID.setText(String.valueOf(cliente.getID_Cliente()));
        cliente = dao.get(Integer.parseInt(txtID.getText()));
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "No fue encontrado");
        } else {
            habilitados();
            carga();
            agregar.setEnabled(false);
            actualizar.setEnabled(true);
        } 
    }//GEN-LAST:event_tablaMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        lista = dao.busquedapornombre(txtBuscar.getText());
        ModelCliente modelo = new ModelCliente(lista);
        tabla.setModel(modelo);
        tabla.repaint(); 
    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorAMaterno;
    private javax.swing.JLabel ErrorAPaterno;
    private javax.swing.JLabel ErrorDN;
    private javax.swing.JLabel ErrorEmail;
    private javax.swing.JLabel ErrorFecha;
    private javax.swing.JLabel ErrorID;
    private javax.swing.JLabel ErrorName;
    private javax.swing.JLabel ErrorOpcEmail;
    private javax.swing.JPanel RESEE;
    private javax.swing.JLabel actualizar;
    private javax.swing.JLabel agregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel buscar;
    private javax.swing.JComboBox<String> cbEmail;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcFecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel listar;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel tcorre;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void carga() {
        txtNombre.setText(cliente.getNombre().trim());
        txtPaterno.setText(cliente.getPaterno());
        txtMaterno.setText(cliente.getMaterno());
        txtTelefono.setText(cliente.getTelefono());
        jcFecha.setDate(cliente.getNacimiento());
        txtEmail.setText(cliente.getEmail());
        txtID.setText(String.valueOf(cliente.getID_Cliente()));
        cbEmail.setSelectedItem(cliente.getOpcEmail());
    }

    public void descarga() {
        java.util.Date d = jcFecha.getDate();
        if (d == null) {
            System.out.println("No hay Fecha.");
        } else {
            java.sql.Date sqldate = new java.sql.Date(d.getTime());
            cliente.setNombre(txtNombre.getText());
            cliente.setPaterno(txtPaterno.getText());
            cliente.setMaterno(txtMaterno.getText());
            cliente.setTelefono(txtTelefono.getText());
            cliente.setNacimiento(sqldate);
            cliente.setEmail(txtEmail.getText());
            cliente.setOpcEmail(cbEmail.getSelectedItem().toString());
        }
    }

    private void limpiar() {
        txtID.setText("");
        txtNombre.setText("");
        txtMaterno.setText("");
        txtPaterno.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        cbEmail.setSelectedIndex(0);
        jcFecha.setDate(null);
    }
}
