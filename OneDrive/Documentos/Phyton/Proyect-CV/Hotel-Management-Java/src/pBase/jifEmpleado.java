package pBase;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyecto.DAOEmpleado;
import proyecto.Empleado;

// @author Danny
public class jifEmpleado extends javax.swing.JInternalFrame {

    boolean name, Apaterno, Amaterno, curp, domicilio, dn, sexo, fecha, correo, opcEmail, estado, contra, recontra, foto,
            iguales;
    private Empleado empleado;
    private final DAOEmpleado dao = new DAOEmpleado();
    private ArrayList<Empleado> lista;
    private final jdEmpleado emp = new jdEmpleado(null, true);
    public Icon imagen1;
    public  String  Ecrip="",puestos="";
    public String[] rutas = new String[4];
    public String[] nombres = new String[4];
    public String[] peso = new String[4];
    public int rand = 0;
    public String random = "";

   
    
    public jifEmpleado() {
        initComponents();
        ErrorAMaterno.setVisible(false);
        ErrorAPaterno.setVisible(false);
        ErrorCurp.setVisible(false);
        ErrorDN.setVisible(false);
        ErrorDireccion.setVisible(false);
        ErrorEmail.setVisible(false);
        ErrorFecha.setVisible(false);
        ErrorID.setVisible(false);
        ErrorName.setVisible(false);
        ErrorOpcEmail.setVisible(false);
        ErrorPassword.setVisible(false);
        ErrorPuesto.setVisible(false);
        ErrorREPassword.setVisible(false);
        ErrorSexo.setVisible(false);
        ErrorStatus.setVisible(false);
        btnCancelar.setVisible(false);
    }
    public void  encriptacion (String contra){
    String crip = contra;
        char ch []=new char[crip.length()];
        int cr []=new int[crip.length()];
        for (int i = 0; i < crip.length(); i++) {
            ch[i]=crip.charAt(i);
            int ascii = ch[i];
            cr[i] += (int) ch[i]+3;
        }
        crip="";
        for (int i = 0; i < cr.length; i++) {
            crip+=cr[i]+"-";
        }
        String cri  =  crip;
        String[] c = cri.split("-");
        int []   asciiValue = new int [cri.length()];
        char[] convertedChar = new char [cri.length()];
        cri="";
        for (int i = 0; i < c.length; i++) {
            asciiValue[i] = Integer.parseInt(c[i]);
            convertedChar[i] = (char)asciiValue[i];
            cri+=convertedChar[i];
        }
        Ecrip =cri;
    }
    public void desencrip(String crip){
        char ch []=new char[crip.length()];
        int cr []=new int[crip.length()];
        for (int i = 0; i < crip.length(); i++) {
            ch[i]=crip.charAt(i);
            int ascii = ch[i];
            cr[i] += (int) ch[i]-3;
        }
        crip="";
        for (int i = 0; i < cr.length; i++) {
            crip+=cr[i]+"-";
        }
        String cri  =  crip;
        String[] c = cri.split("-");
        int []   asciiValue = new int [cri.length()];
        char[] convertedChar = new char [cri.length()];
        cri="";
        for (int i = 0; i < c.length; i++) {
            asciiValue[i] = Integer.parseInt(c[i]);
            convertedChar[i] = (char)asciiValue[i];
            cri+=convertedChar[i];
        }
        Ecrip=cri;
    }
public void PDF() {
        Paragraph titulo;
        titulo = new Paragraph("Bienvenido");
        Document doc = new Document();
        try {
            PdfWriter.getInstance((com.itextpdf.text.Document) doc, new FileOutputStream("C:/Users/aylem/Desktop/" + empleado.getNombre() + "_" + empleado.getPaterno() + ".pdf"));
            doc.open();
            titulo.setAlignment(1);
            doc.add(titulo);
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Nombre: " + empleado.getNombre()));
            doc.add(new Paragraph("Apellido Paterno: "+ empleado.getPaterno()));
            doc.add(new Paragraph("Apellido Materno: "+ empleado.getMaterno()));
            doc.add(new Paragraph("Teléfono: "+empleado.getTelefono()));
            doc.add(new Paragraph("Puesto: "+empleado.getPuesto()));
            doc.add(new Paragraph("Usuario: "+empleado.getUsuario()));
            doc.add(new Paragraph("Contraseña: "+empleado.getPass()));
            JOptionPane.showMessageDialog(null, "PDF Realizado.", "ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);

        } catch (FileNotFoundException | DocumentException ex) {
            java.util.logging.Logger.getLogger(jifEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }
    public void diaHoy() {
        Date hoy = new Date();
        ingreso.setDate(hoy);
    }

    public void habilitados() {
        txtCurp.setEnabled(true);
        txtDN.setEnabled(true);
        txtDomicilio.setEnabled(true);
        txtEmail.setEnabled(true);
        txtMaterno.setEnabled(true);
        txtNombre.setEnabled(true);
        txtPassword.setEnabled(true);
        txtPaterno.setEnabled(true);
        txtRe_password.setEnabled(true);
        txtUsuario.setEnabled(true);
        cbEmail.setEnabled(true);
        cbSexo.setEnabled(true);
        cbStatus.setEnabled(true);
        nacimiento.setEnabled(true);
        ingreso.setEnabled(true);
        Foto.setEnabled(true);
        btnExaminar.setEnabled(true);
        rbAdmin.setEnabled(true);
        rbLimpieza.setEnabled(true);
        rbMantenimiento.setEnabled(true);
        rbRecepcion.setEnabled(true);
        btnCancelar.setVisible(true);
    }

    public void deshabilitados() {
        txtCurp.setEnabled(false);
        txtDN.setEnabled(false);
        txtDomicilio.setEnabled(false);
        txtEmail.setEnabled(false);
        txtMaterno.setEnabled(false);
        txtNombre.setEnabled(false);
        txtPassword.setEnabled(false);
        txtPaterno.setEnabled(false);
        txtRe_password.setEnabled(false);
        txtUsuario.setEnabled(false);
        cbEmail.setEnabled(false);
        cbSexo.setEnabled(false);
        cbStatus.setEnabled(false);
        nacimiento.setEnabled(false);
        ingreso.setEnabled(false);
        Foto.setEnabled(false);
        btnExaminar.setEnabled(false);
        rbAdmin.setEnabled(false);
        rbLimpieza.setEnabled(false);
        rbMantenimiento.setEnabled(false);
        rbRecepcion.setEnabled(false);
        btnCancelar.setVisible(false);
    }

    public void perderFocus() {
        cbStatusFocusLost(null);
        txtNombreFocusLost(null);
        txtCurpFocusLost(null);
        txtPaternoFocusLost(null);
        txtMaternoFocusLost(null);
        nacimientoFocusLost(null);
        txtDomicilioFocusLost(null);
        txtEmailFocusLost(null);
        cbEmailFocusLost(null);
        txtDNFocusLost(null);
        cbSexoFocusLost(null);
        txtPasswordFocusLost(null);
        txtRe_passwordFocusLost(null);
    }

    public void eliminarErrores() {
        ErrorAMaterno.setVisible(false);
        ErrorAPaterno.setVisible(false);
        ErrorCurp.setVisible(false);
        ErrorDN.setVisible(false);
        ErrorDireccion.setVisible(false);
        ErrorEmail.setVisible(false);
        ErrorFecha.setVisible(false);
        ErrorID.setVisible(false);
        ErrorName.setVisible(false);
        ErrorOpcEmail.setVisible(false);
        ErrorPassword.setVisible(false);
        ErrorPuesto.setVisible(false);
        ErrorREPassword.setVisible(false);
        ErrorSexo.setVisible(false);
        ErrorStatus.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puesto = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jpPrincipal = new javax.swing.JPanel();
        ErrorAMaterno = new javax.swing.JLabel();
        lblCURP = new javax.swing.JLabel();
        lblPaterno = new javax.swing.JLabel();
        lblMaterno = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblRepass = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        ErrorID = new javax.swing.JLabel();
        ErrorAPaterno = new javax.swing.JLabel();
        ErrorCurp = new javax.swing.JLabel();
        ErrorEmail = new javax.swing.JLabel();
        ErrorPassword = new javax.swing.JLabel();
        ErrorREPassword = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblDieccion = new javax.swing.JLabel();
        ErrorDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        ErrorDN = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtCurp = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        rbLimpieza = new javax.swing.JRadioButton();
        rbRecepcion = new javax.swing.JRadioButton();
        rbMantenimiento = new javax.swing.JRadioButton();
        rbAdmin = new javax.swing.JRadioButton();
        txtDomicilio = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDN = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtRe_password = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jpOpciones = new javax.swing.JPanel();
        agregar = new javax.swing.JLabel();
        listar = new javax.swing.JLabel();
        actualizar = new javax.swing.JLabel();
        buscar = new javax.swing.JLabel();
        registro = new javax.swing.JLabel();
        nacimiento = new com.toedter.calendar.JDateChooser();
        cbEmail = new javax.swing.JComboBox<>();
        ErrorName = new javax.swing.JLabel();
        ErrorOpcEmail = new javax.swing.JLabel();
        ErrorSexo = new javax.swing.JLabel();
        Foto = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();
        cbStatus = new javax.swing.JComboBox<>();
        ErrorStatus = new javax.swing.JLabel();
        ErrorFecha = new javax.swing.JLabel();
        ErrorPuesto = new javax.swing.JLabel();
        lblCURP1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        ingreso = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("ALTA DE EMPLEADO");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1324, 893));

        jpPrincipal.setBackground(new java.awt.Color(255, 255, 51));
        jpPrincipal.setEnabled(false);
        jpPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ErrorAMaterno.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorAMaterno.setForeground(new java.awt.Color(255, 51, 51));
        ErrorAMaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorAMaterno.setText("AMaternoError");
        jpPrincipal.add(ErrorAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 710, -1));

        lblCURP.setBackground(new java.awt.Color(255, 255, 255));
        lblCURP.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblCURP.setForeground(new java.awt.Color(255, 255, 255));
        lblCURP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCURP.setText("CURP");
        jpPrincipal.add(lblCURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 160, -1));

        lblPaterno.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblPaterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPaterno.setText("Ap. Paterno");
        jpPrincipal.add(lblPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, 40));

        lblMaterno.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblMaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblMaterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaterno.setText("Ap. Materno");
        jpPrincipal.add(lblMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, -1));

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmail.setText("Email");
        jpPrincipal.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 150, -1));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Usuario");
        jpPrincipal.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 100, -1));

        lblRepass.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblRepass.setForeground(new java.awt.Color(255, 255, 255));
        lblRepass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRepass.setText("Confimación");
        jpPrincipal.add(lblRepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, -1, 30));

        lblPass.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPass.setForeground(new java.awt.Color(255, 255, 255));
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPass.setText("Contraseña");
        jpPrincipal.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 160, 30));

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Nombre(s)");
        jpPrincipal.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, -1));

        ErrorID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorID.setForeground(new java.awt.Color(255, 51, 51));
        ErrorID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorID.setText("ErrorID");
        jpPrincipal.add(ErrorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 280, 30));

        ErrorAPaterno.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorAPaterno.setForeground(new java.awt.Color(255, 51, 51));
        ErrorAPaterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorAPaterno.setText("APaternoError");
        jpPrincipal.add(ErrorAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 710, -1));

        ErrorCurp.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorCurp.setForeground(new java.awt.Color(255, 51, 51));
        ErrorCurp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorCurp.setText("ErrorCurp");
        jpPrincipal.add(ErrorCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 710, -1));

        ErrorEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorEmail.setForeground(new java.awt.Color(255, 51, 51));
        ErrorEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorEmail.setText("ErrorEmail");
        jpPrincipal.add(ErrorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 350, -1));

        ErrorPassword.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorPassword.setForeground(new java.awt.Color(255, 51, 51));
        ErrorPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorPassword.setText("ErrorPassword");
        jpPrincipal.add(ErrorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 710, -1));

        ErrorREPassword.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorREPassword.setForeground(new java.awt.Color(255, 51, 51));
        ErrorREPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorREPassword.setText("ErrorREPassword");
        jpPrincipal.add(ErrorREPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 710, -1));

        lblID.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblID.setText("ID");
        jpPrincipal.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 50, -1));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 160, 30));

        lblDieccion.setBackground(new java.awt.Color(255, 255, 255));
        lblDieccion.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblDieccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDieccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDieccion.setText("Dirección");
        jpPrincipal.add(lblDieccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 160, -1));

        ErrorDireccion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorDireccion.setForeground(new java.awt.Color(255, 51, 51));
        ErrorDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorDireccion.setText("ErrorDireccion");
        jpPrincipal.add(ErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 710, -1));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTelefono.setText("Teléfono");
        jpPrincipal.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 160, -1));

        ErrorDN.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorDN.setForeground(new java.awt.Color(255, 51, 51));
        ErrorDN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorDN.setText("ErrorTelefono");
        jpPrincipal.add(ErrorDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 350, -1));

        cbSexo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo", "Masculino", "Femenino" }));
        cbSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbSexo.setEnabled(false);
        cbSexo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbSexoFocusLost(evt);
            }
        });
        jpPrincipal.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 190, -1));

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
        jpPrincipal.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 520, 30));

        txtCurp.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtCurp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCurp.setEnabled(false);
        txtCurp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCurpFocusLost(evt);
            }
        });
        txtCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurpActionPerformed(evt);
            }
        });
        txtCurp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurpKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 520, -1));

        txtPaterno.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPaterno.setEnabled(false);
        txtPaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPaternoFocusLost(evt);
            }
        });
        txtPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoActionPerformed(evt);
            }
        });
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 211, 520, 30));

        txtMaterno.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaterno.setEnabled(false);
        txtMaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaternoFocusLost(evt);
            }
        });
        txtMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaternoActionPerformed(evt);
            }
        });
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 520, 30));

        rbLimpieza.setBackground(new java.awt.Color(0, 51, 153));
        rbLimpieza.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbLimpieza.setForeground(new java.awt.Color(255, 255, 255));
        rbLimpieza.setText("Limpieza");
        rbLimpieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLimpiezaActionPerformed(evt);
            }
        });
        jpPrincipal.add(rbLimpieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, -1, -1));

        rbRecepcion.setBackground(new java.awt.Color(0, 51, 153));
        rbRecepcion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbRecepcion.setForeground(new java.awt.Color(255, 255, 255));
        rbRecepcion.setText("Recepcion");
        rbRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRecepcionActionPerformed(evt);
            }
        });
        jpPrincipal.add(rbRecepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, -1, -1));

        rbMantenimiento.setBackground(new java.awt.Color(0, 51, 153));
        rbMantenimiento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbMantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        rbMantenimiento.setText("Mantenimiento");
        rbMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMantenimientoActionPerformed(evt);
            }
        });
        jpPrincipal.add(rbMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, -1, -1));

        rbAdmin.setBackground(new java.awt.Color(0, 51, 153));
        rbAdmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbAdmin.setForeground(new java.awt.Color(255, 255, 255));
        rbAdmin.setText("Administrador");
        rbAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdminActionPerformed(evt);
            }
        });
        jpPrincipal.add(rbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, -1, -1));

        txtDomicilio.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtDomicilio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDomicilio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDomicilio.setEnabled(false);
        txtDomicilio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDomicilioFocusLost(evt);
            }
        });
        txtDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDomicilioKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 670, 520, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setEnabled(false);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 270, -1));

        txtDN.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtDN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDN.setEnabled(false);
        txtDN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDNFocusLost(evt);
            }
        });
        txtDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNActionPerformed(evt);
            }
        });
        txtDN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 270, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setEnabled(false);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 520, 30));

        txtRe_password.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtRe_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRe_password.setEnabled(false);
        txtRe_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRe_passwordFocusLost(evt);
            }
        });
        txtRe_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRe_passwordKeyTyped(evt);
            }
        });
        jpPrincipal.add(txtRe_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 520, 30));

        txtUsuario.setEditable(false);
        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtUsuario.setEnabled(false);
        jpPrincipal.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 290, 30));

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarMouseEntered(evt);
            }
        });

        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listas.png"))); // NOI18N
        listar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarMouseClicked(evt);
            }
        });

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actualizar.setEnabled(false);
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
        });

        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contacto.png"))); // NOI18N
        registro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpOpcionesLayout = new javax.swing.GroupLayout(jpOpciones);
        jpOpciones.setLayout(jpOpcionesLayout);
        jpOpcionesLayout.setHorizontalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registro)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jpOpcionesLayout.setVerticalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesLayout.createSequentialGroup()
                .addGroup(jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpOpcionesLayout.createSequentialGroup()
                        .addGroup(jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registro)
                            .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpPrincipal.add(jpOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        nacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 20))); // NOI18N
        nacimiento.setEnabled(false);
        nacimiento.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nacimientoFocusLost(evt);
            }
        });
        nacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nacimientoPropertyChange(evt);
            }
        });
        jpPrincipal.add(nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 300, 80));

        cbEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        cbEmail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- -", "@gmail.com", "@hotmail.com", "@icloud.com", "@outlook.com", "@outlook.com.es" }));
        cbEmail.setEnabled(false);
        cbEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbEmailFocusLost(evt);
            }
        });
        cbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmailActionPerformed(evt);
            }
        });
        jpPrincipal.add(cbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 230, 30));

        ErrorName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorName.setForeground(new java.awt.Color(255, 51, 51));
        ErrorName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorName.setText("NameError");
        jpPrincipal.add(ErrorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 710, -1));

        ErrorOpcEmail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorOpcEmail.setForeground(new java.awt.Color(255, 51, 51));
        ErrorOpcEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorOpcEmail.setText("ErrorOpcEmail");
        jpPrincipal.add(ErrorOpcEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, 240, -1));

        ErrorSexo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorSexo.setForeground(new java.awt.Color(255, 51, 51));
        ErrorSexo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorSexo.setText("ErrorSexo");
        jpPrincipal.add(ErrorSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 230, -1));

        Foto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jpPrincipal.add(Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 160, 130));

        btnExaminar.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        btnExaminar.setText("Examinar");
        btnExaminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExaminar.setEnabled(false);
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });
        jpPrincipal.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, 160, 30));

        cbStatus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estatus", "Activo", "Inactivo (Vacaciones)", "Inactivo (Salud)" }));
        cbStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbStatus.setEnabled(false);
        cbStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbStatusFocusLost(evt);
            }
        });
        jpPrincipal.add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 170, 40));

        ErrorStatus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorStatus.setForeground(new java.awt.Color(255, 51, 51));
        ErrorStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorStatus.setText("ErrorStatus");
        jpPrincipal.add(ErrorStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 80, 210, -1));

        ErrorFecha.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorFecha.setForeground(new java.awt.Color(255, 51, 51));
        ErrorFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorFecha.setText("ErrorFecha");
        jpPrincipal.add(ErrorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 210, -1));

        ErrorPuesto.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ErrorPuesto.setForeground(new java.awt.Color(255, 51, 51));
        ErrorPuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ErrorPuesto.setText("ErrorPuesto");
        jpPrincipal.add(ErrorPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 550, -1));

        lblCURP1.setBackground(new java.awt.Color(255, 255, 255));
        lblCURP1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblCURP1.setForeground(new java.awt.Color(255, 255, 255));
        lblCURP1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCURP1.setText("Puesto");
        jpPrincipal.add(lblCURP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 220, -1));

        tabla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jpPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 480, 430));

        ingreso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingreso:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N
        ingreso.setEnabled(false);
        ingreso.setFocusable(false);
        ingreso.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jpPrincipal.add(ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 260, 80));

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jpPrincipal.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul Empleado.png"))); // NOI18N
        jpPrincipal.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1800, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked
        try {
            if (agregar.isEnabled()== true) {
            habilitados();
            txtID.setEnabled(false);
            txtID.setText("");
            diaHoy();
            if (name == true&&Apaterno == true&&Amaterno == true&&curp == true&&domicilio == true&&dn == true
             &&sexo == true&&fecha == true&&correo == true&&opcEmail == true&&estado == true &&
             contra == true&&recontra == true&&foto == true && iguales ==true&&cbEmail.getSelectedItem()!="- -") {
                                                                                if (!puestos.equals("")) {
                                                                                System.out.println("Hola");
                                                                                System.out.println("puesto: " + puesto);
                                                                                empleado = new Empleado();
                                                                                descarga();
                                                                                System.out.println(empleado);
                                                                                String resultado = dao.Insertar(empleado);
                                                                                JOptionPane.showMessageDialog(this, resultado);
                                                                                limpiar();
                                                                                deshabilitados();
                                                                                txtID.setEnabled(true);
                                                                                diaHoy();
                                                                                PDF();
                                                                            }else{JOptionPane.showMessageDialog(null,"Selecciona un puesto");}
                                                                       
                                                                    }else{JOptionPane.showMessageDialog(null,"Revisa los campos ");}
        } else if (agregar.isEnabled() == false) {
            JOptionPane.showMessageDialog(this, "*Existe algun error en los datos solicitados.");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ocurrio algun error intentelo mas tarde");
        }

        
    }//GEN-LAST:event_agregarMouseClicked

    private void listarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarMouseClicked
        lista = dao.list();
        for (Empleado empleado1 : lista) {
            System.out.println(empleado1);
        }
        ModelEmpleado modelo = new ModelEmpleado(lista);
        tabla.setModel(modelo);
        tabla.repaint();
    }//GEN-LAST:event_listarMouseClicked

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        if (actualizar.isEnabled() == true) {
            descarga();
            String resultado = dao.update(empleado);
            System.out.println(empleado.getUsuario());
            JOptionPane.showMessageDialog(this, "Actualizado con Exito!");
            limpiar();
            actualizar.setEnabled(false);
            agregar.setEnabled(true);
            txtID.setEnabled(true);
            deshabilitados();
        } else if ((actualizar.isEnabled() == false)) {
            JOptionPane.showMessageDialog(this, "No disponible.");
        }
    }//GEN-LAST:event_actualizarMouseClicked

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
       // emp.show();
    }//GEN-LAST:event_buscarMouseClicked

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

    private void txtCurpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurpKeyTyped
        txtNombre.setForeground(Color.BLACK);

        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar) || Character.isDigit(keyChar))) {
            ErrorCurp.setText("*Caracter No Valido.");
            ErrorCurp.setVisible(true);
            evt.consume();
            getToolkit().beep();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtCurpKeyTyped

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

    private void txtDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDomicilioKeyTyped
        txtDomicilio.setForeground(Color.BLACK);

        String s1 = String.valueOf(evt.getKeyChar());
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar) || Character.isDigit(keyChar)
                || Character.isSpaceChar(keyChar) || s1.matches("[#,.-]"))) {
            evt.consume();
            getToolkit().beep();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtDomicilioKeyTyped

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

    private void txtDNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar))) {
            ErrorDN.setText("*Solo números.");
            ErrorDN.setVisible(true);
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtDNKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar))) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtRe_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRe_passwordKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar) || Character.isDigit(keyChar))) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtRe_passwordKeyTyped

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar))) {
            ErrorID.setText("*Solo números.");
            ErrorID.setVisible(true);
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtIDKeyTyped

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (txtNombre.getText().length() > 2) {
            name = true;
            ErrorName.setVisible(false);
        } else if (txtNombre.getText().isEmpty()) {
            ErrorName.setText("*El Campo esta vacio");
            name = false;
            ErrorName.setVisible(true);
        } else {
            ErrorName.setText("*No Valido.");
            name = false;
            ErrorName.setVisible(true);
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtCurpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCurpFocusLost
        if (txtCurp.getText().length() == 18) {
            curp = true;
            ErrorCurp.setVisible(false);
        } else if (txtCurp.getText().isEmpty()) {
            ErrorCurp.setText("*El Campo Esta Vacio");
            ErrorCurp.setVisible(true);
            curp = false;
        } else {
            ErrorCurp.setText("*El CURP tiene que ser de 18 Caracteres");
            ErrorCurp.setVisible(true);
            curp = false;
        }
    }//GEN-LAST:event_txtCurpFocusLost

    private void txtPaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaternoFocusLost
        if (txtPaterno.getText().length() > 3) {
            Apaterno = true;
            ErrorAPaterno.setVisible(false);
            rand = (int) (Math.random() * 1000);
            random = String.valueOf(rand);
            txtUsuario.setText(txtPaterno.getText() + random);
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

    private void txtDomicilioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDomicilioFocusLost
        if (txtDomicilio.getText().length() > 10) {
            domicilio = true;
            ErrorDireccion.setVisible(false);
        } else if (txtDomicilio.getText().isEmpty()) {
            ErrorDireccion.setText("*El campo esta vacio.");
            ErrorDireccion.setVisible(true);
            domicilio = false;
        } else {
            ErrorDireccion.setText("*No Valido.");
            ErrorDireccion.setVisible(true);
            domicilio = false;
        }
    }//GEN-LAST:event_txtDomicilioFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().length() >= 6) {
            correo = true;
            ErrorEmail.setVisible(false);
        } else if (txtEmail.getText().isEmpty()) {
            ErrorEmail.setText("*El campo esta vacio");
            ErrorEmail.setVisible(true);
            correo = false;
        } else {
            ErrorEmail.setText("*Mínimo de 6 Caracteres.");
            ErrorEmail.setVisible(true);
            correo = false;
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtDNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDNFocusLost
        if (txtDN.getText().length() > 9 && txtDN.getText().length() < 14) {
            dn = true;
            ErrorDN.setVisible(false);
        } else if (txtDN.getText().isEmpty()) {
            ErrorDN.setText("*El campo esta vacio.");
            ErrorDN.setVisible(true);
            dn = false;
        } else {
            ErrorDN.setText("*No Valido.");
            ErrorDN.setVisible(true);
            dn = false;
        }
    }//GEN-LAST:event_txtDNFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if (txtPassword.getText().length() >= 8) {
            contra = true;
            ErrorPassword.setVisible(false);
            if ((txtRe_password.getText().equals(txtPassword.getText()))) {
                iguales = true;
            } else {
                iguales = false;
            }
        } else if (txtPassword.getText().isEmpty()) {
            ErrorPassword.setText("*El campo esta vacio");
            ErrorPassword.setVisible(true);
            contra = false;
        } else {
            ErrorPassword.setText("*Mínimo 8 caracteres.");
            ErrorPassword.setVisible(true);
            contra = false;
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtRe_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRe_passwordFocusLost
        if (txtRe_password.getText().length() >= 8) {
            recontra = true;
            ErrorREPassword.setVisible(false);
        } else if (txtRe_password.getText().isEmpty()) {
            ErrorREPassword.setText("*El campo esta vacio");
            ErrorREPassword.setVisible(true);
            recontra = false;
        }

        if ((txtRe_password.getText().equals(txtPassword.getText()))) {
            iguales = true;
            ErrorREPassword.setVisible(false);
        } else {
            ErrorREPassword.setText("*Las contraseñas no son igualesa.");
            ErrorREPassword.setVisible(true);
            iguales = false;
        }
    }//GEN-LAST:event_txtRe_passwordFocusLost

    private void cbEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbEmailFocusLost
        if (cbEmail.getSelectedIndex() != 0) {
            opcEmail = true;
            ErrorOpcEmail.setVisible(false);
        } else {
            ErrorOpcEmail.setText("*No Valido.");
            ErrorOpcEmail.setVisible(true);
            opcEmail = false;
        }
    }//GEN-LAST:event_cbEmailFocusLost

    private void cbSexoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbSexoFocusLost
        if (cbSexo.getSelectedIndex() != 0) {
            sexo = true;
            ErrorSexo.setVisible(false);
            if (cbSexo.getSelectedIndex() == 1) {
                txtUsuario.setText(txtPaterno.getText() + random + "H");
            } else {
                txtUsuario.setText(txtPaterno.getText() + random + "M");
            }
        } else {
            ErrorSexo.setText("*No Valido.");
            ErrorSexo.setVisible(true);
            sexo = false;
        }
    }//GEN-LAST:event_cbSexoFocusLost

    private void agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseEntered
        if (!agregar.isEnabled()) {
           if (txtNombre.isEnabled() == true) {
            perderFocus();
            if (rbAdmin.isSelected() == false && rbLimpieza.isSelected() == false && 
                rbMantenimiento.isSelected() == false && rbRecepcion.isSelected() == false) {
                ErrorPuesto.setText("*Selecciona un puesto..");
                ErrorPuesto.setVisible(true);
            }
        }  
        }
    }//GEN-LAST:event_agregarMouseEntered

    private void cbStatusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbStatusFocusLost
        if (cbStatus.getSelectedIndex() != 0) {
            estado = true;
            ErrorStatus.setVisible(false);
        } else {
            ErrorStatus.setText("*No Valido.");
            ErrorStatus.setVisible(true);
            estado = false;
        }
    }//GEN-LAST:event_cbStatusFocusLost

    private void nacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nacimientoFocusLost
        
    }//GEN-LAST:event_nacimientoFocusLost

    private JFileChooser readFile() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos jpg", "jpg");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (!(returnVal == JFileChooser.APPROVE_OPTION)) {
            JOptionPane.showMessageDialog(null, "Solo puedes seleccionar archivos jpg !");
        } else {
            return chooser;
        }
        return null;
    }

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        try {
        JFileChooser chooser = readFile();
        ImageIcon imagen = new ImageIcon(chooser.getSelectedFile().getPath());
        Foto.setIcon(imagen);

        Image imgEscalada = imagen.getImage().getScaledInstance(Foto.getWidth(),
                Foto.getHeight(), Image.SCALE_SMOOTH);
        imagen1 = new ImageIcon(imgEscalada);
        Foto.setIcon(imagen1);

        rutas[0] = chooser.getSelectedFile().getPath();
        nombres[0] = chooser.getSelectedFile().getName();
        peso[0] = String.valueOf(chooser.getSelectedFile().getTotalSpace());
//        ubicacion.setText(rutas[0]);
//        name.setText(nombres[0]);
//        pesoD_Imagen.setText(peso[0]);
        //pictur++;
        buscar.setEnabled(false);
        Foto.setText(txtPaterno.getText() + ".jpg");
        foto = true;    
        } catch (Exception e) {
            System.out.println("Problema");
        }
        
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroMouseClicked
        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "*Ingresa el ID que deseas buscar.");
            txtID.setEnabled(true);
        } else if (!txtID.getText().isEmpty()) {
            String busqueda = txtID.getText();
            empleado = dao.get(Integer.parseInt(busqueda));
            if (empleado == null) {
                JOptionPane.showMessageDialog(this, "No fue encontrado.");
            } else {
                JOptionPane.showMessageDialog(this, "Si esta Registrado.");
                carga();
                actualizar.setEnabled(true);
                agregar.setEnabled(false);
                txtID.setEnabled(false);
                habilitados();
            }
        }
    }//GEN-LAST:event_registroMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        deshabilitados();
        limpiar();
        eliminarErrores();
        actualizar.setEnabled(false);
        agregar.setEnabled(true);
        txtID.setEnabled(true);
        txtID.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaternoActionPerformed

    }//GEN-LAST:event_txtMaternoActionPerformed

    private void txtCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurpActionPerformed

    private void txtDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNActionPerformed
    
    }//GEN-LAST:event_txtDNActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void cbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmailActionPerformed

    }//GEN-LAST:event_cbEmailActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoActionPerformed

    }//GEN-LAST:event_txtPaternoActionPerformed

    private void rbAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAdminActionPerformed
     if (rbAdmin.isSelected()) {
          
puestos=rbAdmin.getText(); 
rbLimpieza.setSelected(false);
rbRecepcion.setSelected(false);
rbMantenimiento.setSelected(false);
         }else{puestos="";} 
        System.out.println("Puesto"+puestos);
    }//GEN-LAST:event_rbAdminActionPerformed

    private void rbLimpiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLimpiezaActionPerformed
if (rbLimpieza.isSelected()) {
puestos=rbLimpieza.getText(); 
rbAdmin.setSelected(false);
rbRecepcion.setSelected(false);
rbMantenimiento.setSelected(false);
         }else{puestos="";} 
        System.out.println("Puesto"+puestos);        // TODO add your handling code here:
    }//GEN-LAST:event_rbLimpiezaActionPerformed

    private void rbRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRecepcionActionPerformed
if (rbRecepcion.isSelected()) {
puestos=rbRecepcion.getText(); 
rbAdmin.setSelected(false);
rbMantenimiento.setSelected(false);
rbLimpieza.setSelected(false);
         }else{puestos="";} 
        System.out.println("Puesto"+puestos);            // TODO add your handling code here:
    }//GEN-LAST:event_rbRecepcionActionPerformed

    private void rbMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMantenimientoActionPerformed
if (rbMantenimiento.isSelected()) {
puestos=rbMantenimiento.getText(); 
rbAdmin.setSelected(false);
rbRecepcion.setSelected(false);
rbLimpieza.setSelected(false);
         }else{puestos="";} 
        System.out.println("Puesto"+puestos);            // TODO add your handling code here:
    }//GEN-LAST:event_rbMantenimientoActionPerformed

    private void nacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nacimientoPropertyChange
if (txtNombre.isEnabled() == true) {
            if (nacimiento.getDate() != null) {
                Date dato1 = nacimiento.getDate();
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
                    JOptionPane.showMessageDialog(this, "Tienes que ser mayor de edad para poder trabar aquí");
                    fecha = false;
                } else if (dato1.after(dato2)) {
                    getToolkit().beep();
                    ErrorFecha.setText("Fecha no valida.");
                    ErrorFecha.setVisible(true);
                    JOptionPane.showMessageDialog(this, "No se pueden registrar fechas futuras");
                    fecha = false;
                }
            } else if (nacimiento.getDate() == null) {
                getToolkit().beep();
                ErrorFecha.setText("*Campo vacio.");
                ErrorFecha.setVisible(true);
                fecha = false;
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_nacimientoPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorAMaterno;
    private javax.swing.JLabel ErrorAPaterno;
    private javax.swing.JLabel ErrorCurp;
    private javax.swing.JLabel ErrorDN;
    private javax.swing.JLabel ErrorDireccion;
    private javax.swing.JLabel ErrorEmail;
    private javax.swing.JLabel ErrorFecha;
    private javax.swing.JLabel ErrorID;
    private javax.swing.JLabel ErrorName;
    private javax.swing.JLabel ErrorOpcEmail;
    private javax.swing.JLabel ErrorPassword;
    private javax.swing.JLabel ErrorPuesto;
    private javax.swing.JLabel ErrorREPassword;
    private javax.swing.JLabel ErrorSexo;
    private javax.swing.JLabel ErrorStatus;
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel actualizar;
    private javax.swing.JLabel agregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JLabel buscar;
    private javax.swing.JComboBox<String> cbEmail;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbStatus;
    private com.toedter.calendar.JDateChooser ingreso;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpOpciones;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JLabel lblCURP;
    private javax.swing.JLabel lblCURP1;
    private javax.swing.JLabel lblDieccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMaterno;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPaterno;
    private javax.swing.JLabel lblRepass;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel listar;
    private com.toedter.calendar.JDateChooser nacimiento;
    private javax.swing.ButtonGroup puesto;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbLimpieza;
    private javax.swing.JRadioButton rbMantenimiento;
    private javax.swing.JRadioButton rbRecepcion;
    private javax.swing.JLabel registro;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtDN;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JPasswordField txtRe_password;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void carga() { //SE UTILIZA EN BUSCAR
        txtNombre.setText(empleado.getNombre().trim());
        txtPaterno.setText(empleado.getPaterno());
        txtMaterno.setText(empleado.getMaterno());
        txtCurp.setText(empleado.getCurp());
        txtDomicilio.setText(empleado.getDireccion());
        txtDN.setText(empleado.getTelefono());
        cbSexo.setSelectedItem(empleado.getSexo());
        if (empleado.getPuesto().toString().equals(rbRecepcion.getText())) {
            rbRecepcion.setSelected(true);
        } else if (empleado.getPuesto().toString().equals(rbLimpieza.getText())) {
            rbLimpieza.setSelected(true);
        } else if (empleado.getPuesto().toString().equals(rbAdmin.getText())) {
            rbAdmin.setSelected(true);
        } else if (empleado.getPuesto().toString().equals(rbMantenimiento.getText())) {
            rbMantenimiento.setSelected(true);
        }
        ingreso.setDate(empleado.getIngreso());
        txtEmail.setText(empleado.getEmail());
        cbEmail.setSelectedItem(empleado.getOpcEmail());
        cbStatus.setSelectedItem(empleado.getStatus());
        Foto.setText(empleado.getFoto());
        desencrip(empleado.getPass());
        txtPassword.setText(Ecrip);
        txtRe_password.setText(Ecrip);
        desencrip(empleado.getUsuario());
        txtUsuario.setText(Ecrip);
    }

    private void descarga() { // SE UTILIZA EN ACTUALIZAR / AGREGAR
        java.util.Date d = nacimiento.getDate();
        java.util.Date i = ingreso.getDate();
        if (d == null) {
            System.out.println("No hay Fecha.");
        } else {
            java.sql.Date sqldate = new java.sql.Date(d.getTime());
            java.sql.Date sqldate1 = new java.sql.Date(i.getTime());

            empleado.setNombre(txtNombre.getText().trim());
            empleado.setPaterno(txtPaterno.getText());
            empleado.setMaterno(txtMaterno.getText());
            empleado.setCurp(txtCurp.getText());
            empleado.setDireccion(txtDomicilio.getText());
            empleado.setTelefono(txtDN.getText());
            empleado.setSexo(cbSexo.getSelectedItem().toString());
           
            empleado.setPuesto(puestos);
            if (rbAdmin.isSelected()) {
                empleado.setPuesto(rbAdmin.getText());
            } else if (rbRecepcion.isSelected()) {
                empleado.setPuesto(rbRecepcion.getText());
            } else if (rbMantenimiento.isSelected()) {
                empleado.setPuesto(rbMantenimiento.getText());
            } else if (rbLimpieza.isSelected()) {
                empleado.setPuesto(rbLimpieza.getText());
            }
            empleado.setIngreso(sqldate1);
            empleado.setEmail(txtEmail.getText());
            empleado.setOpcEmail(cbEmail.getSelectedItem().toString());
            empleado.setStatus(cbStatus.getSelectedItem().toString());
            empleado.setFoto(Foto.getText());
            encriptacion(txtPassword.getText());
            empleado.setPass(Ecrip);
            empleado.setRepass(Ecrip);
            encriptacion(txtUsuario.getText());
            empleado.setUsuario(Ecrip);
        }
    }

    private void limpiar() {
        rbAdmin.setSelected(false);
        rbLimpieza.setSelected(false);
        rbMantenimiento.setSelected(false);
        rbRecepcion.setSelected(false);
        txtCurp.setText("");
        txtDN.setText("");
        txtDomicilio.setText("");
        txtEmail.setText("");
        txtID.setText("");
        txtMaterno.setText("");
        txtNombre.setText("");
        txtPassword.setText("");
        txtPaterno.setText("");
        txtRe_password.setText("");
        txtUsuario.setText("");
        Foto.setText("");
        nacimiento.setDate(null);
        ingreso.setDate(null);
        puesto.clearSelection();
        cbEmail.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);

    }
}
