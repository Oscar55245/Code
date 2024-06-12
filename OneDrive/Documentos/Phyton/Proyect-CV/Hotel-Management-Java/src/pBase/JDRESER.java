
package pBase;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyecto.Cliente;
import proyecto.DAOCliente;
import proyecto.DAOHabitacion;
import proyecto.DAOReservacion;
import proyecto.Habitacion;
import proyecto.No_Habi;
import proyecto.Reservacion;
public class JDRESER extends javax.swing.JDialog {
    public static DAOReservacion re = new DAOReservacion();
    public static ArrayList<Reservacion> lista;
    public static Reservacion reservacion;
    private Habitacion habi;
    private final DAOHabitacion daoh = new DAOHabitacion();
    public static String in = "", na = "", ex = "", num, reservar,NOH,EXTRAS,estadoA,estadoR;
    public static Date dato2 = new Date();
    private final DAOHabitacion dao = new DAOHabitacion();
    private final  JIrecepcion reser = new JIrecepcion();
   public static jdReservacion S = new jdReservacion(null, true); 
    public static ArrayList<No_Habi> list;
    public static ArrayList<Reservacion> listh;
    public static int totalR, actual, cont = 0, cap,COMPLETO=0,habiN,d=0,IDCLIENTE,CF=0;
    public static SERVICIOS SS = new SERVICIOS(null, true);     
    public static Cliente cliente;
    public static Reservacion reservaci;
    public static DAOCliente daoc = new DAOCliente();
    public static ArrayList<Cliente> listac;
    public static Component component[] = {};
    public static Component componen[] = {};
    Boolean fecha  =  false, ocupado = false ;
    int n;
    public static NavigableSet<Integer> dia = new TreeSet<>();
    NavigableSet<Integer> diaR = new TreeSet<>();
    public JDRESER(java.awt.Frame parent, boolean modal)  {
        super(parent, modal);
        initComponents();
        errorNombre.setVisible(false);
        errna.setVisible(false);
        errin.setVisible(false);
        errcliente.setVisible(false);
        errEstado1.setVisible(false);
        errorC.setVisible(false);
        errorHabitacion.setVisible(false);
        list = dao.No_habitacion();
        for (No_Habi habitacion1 : list) {
            ItmHabitacion.addItem(String.valueOf(habitacion1.getHabitacionNO()));
    }    
        RancgoFechas();
    }
    
public void PDF() {
        Paragraph titulo;
        titulo = new Paragraph("Bienvenido");
        Document doc = new Document();
        try {
            PdfWriter.getInstance((com.itextpdf.text.Document) doc, new FileOutputStream("C:/Users/aylem/Desktop/" + reservacion.getFolio() + "_" + reservacion.getHabitacion()+ ".pdf"));
            doc.open();
            titulo.setAlignment(1);
            doc.add(titulo);
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Nombre: " + reservacion.getNombre()));
            doc.add(new Paragraph("Habitacion ocupada: "+ reservacion.getHabitacion()));
            doc.add(new Paragraph("Periodo de fechas: "+ reservacion.getFechaE()+"// "+ reservacion.getFechaS()));
            doc.add(new Paragraph("numero de ocupantes: "+reservacion.getOcupantes()));
            doc.add(new Paragraph("Extras: "+reservacion.getExtras()));
            doc.add(new Paragraph("-----------------------------------------------------------------------------"));
            doc.add(new Paragraph("Total de costo: "+reservacion.getCosto()));
            JOptionPane.showMessageDialog(null, "PDF Realizado.", "ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(jifEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            java.util.logging.Logger.getLogger(jifEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }
private void RancgoFechas(){
Calendar c = Calendar.getInstance();
c.setTime(dato2);
c.add(Calendar.MONTH,2);
Date dat = c.getTime();
 jCalendar1.setMinSelectableDate(dato2);
jCalendar1.setMaxSelectableDate(dat);   
 jCalendar2.setMinSelectableDate(dato2);
jCalendar2.setMaxSelectableDate(dat);   
}
public void Rese(){
Calendar co = Calendar.getInstance();
Calendar c2 = Calendar.getInstance();
c2.setTime(jCalendar2.getDate());
co.setTime(jCalendar1.getDate());
Calendar cal = Calendar.getInstance();
cal.set(Calendar.DAY_OF_MONTH,1);
int offset = cal.get(Calendar.DAY_OF_WEEK);
JPanel jPanel = jCalendar1.getDayChooser().getDayPanel();
component = jPanel.getComponents();
JPanel jPane = jCalendar2.getDayChooser().getDayPanel();
componen = jPane.getComponents();
    System.out.println(co.get(Calendar.DAY_OF_MONTH));
    System.out.println(c2.get(Calendar.DAY_OF_MONTH));
for (int i = 0; i < component.length; i++) { componen[i].setBackground(null);
component[i].setBackground(null);}
 int dayOfMonth = co.get(Calendar.DAY_OF_MONTH)+5;
  component[dayOfMonth + offset].setBackground(Color.BLUE);
 int dayOfMont = c2.get(Calendar.DAY_OF_MONTH)+5;
  component[dayOfMont + offset].setBackground(Color.BLUE);
}
  //////////////////////////////////////////////////////////FECHAS//////////////////////////////////////////////////////////////////////
public void FechasBD(int habi ){
    try {
        dia.clear();
int habitacio  =  habi;
int mes  = 0,mes2=0;
listh = re.busquedaR(habitacio);
Calendar co = Calendar.getInstance();
Calendar c2 = Calendar.getInstance();
c2.setTime(jCalendar2.getDate());
co.setTime(jCalendar1.getDate());
////////////////////////////////////////////////////CALENDARIO SINWG ///////////////////////////////////////////////////
Calendar cal = Calendar.getInstance();
cal.set(Calendar.DAY_OF_MONTH,1);
int offset = cal.get(Calendar.DAY_OF_WEEK);
JPanel jPanel = jCalendar1.getDayChooser().getDayPanel();
component = jPanel.getComponents();
JPanel jPane = jCalendar2.getDayChooser().getDayPanel();
componen = jPane.getComponents();
for (int i = 0; i < component.length; i++) { componen[i].setBackground(null);}
for (int i = 0; i < component.length; i++) { component[i].setBackground(null);}
///////////////////////////////////////GUARDAR FECHAS////////////////////////////////////////////////////////////////////////
System.out.println("lista"+listh.size());
for (int i = 0; i < listh.size(); i++) {
reservaci = listh.get(i);
Date date = reservaci.getFechaS();
Date date2 = reservaci.getFechaE();
long dif  =  date2.getTime()- date.getTime();
TimeUnit unidad = TimeUnit.DAYS;
int dias  =  (int) unidad.convert(dif, TimeUnit.MILLISECONDS);
Calendar ca = Calendar.getInstance();
ca.setTime(date);
Date  dato =  new Date();
dato.setHours(0);
dato.setSeconds(0);
dato.setMinutes(0);
Calendar cI = Calendar.getInstance();
///////////////////////////fecha entrada
Calendar cp = Calendar.getInstance();
cp.setTime(date);
/////////////////////////fecha salida
Calendar ck = Calendar.getInstance();
ck.setTime(date2);
/////////////////////////////fecha actual
Calendar ce = Calendar.getInstance();
ce.setTime(dato);
if (co.get(Calendar.MONTH)==ca.get(Calendar.MONTH)
   &&Integer.parseInt(reservaci.getHabitacion())==habiN&&(dato.before(date)
    ||cI.get(Calendar.DAY_OF_MONTH)==cp.get(Calendar.DAY_OF_MONTH))) {
         for (int x = 0; x < dias+1; x++) {
            mes = ca.get(Calendar.MONTH);
            dia.add(ca.get(Calendar.DAY_OF_MONTH)+x);
    } 
}
    if (date2.after(dato)||(ck.get(Calendar.DAY_OF_MONTH)==ce.get(Calendar.DAY_OF_MONTH)&&ck.get(Calendar.MONTH)==ce.get(Calendar.MONTH))) {
      for (int x = 0; x < dias+1; x++) {
            mes = mes2 = ca.get(Calendar.MONTH);
            dia.add(ca.get(Calendar.DAY_OF_MONTH)+x);
    }   
    }
if (c2.get(Calendar.MONTH)==ca.get(Calendar.MONTH)&&Integer.parseInt(reservaci.getHabitacion())==habiN&&(dato.before(date)
        ||cI.get(Calendar.DAY_OF_MONTH)==cp.get(Calendar.DAY_OF_MONTH))) {
         for (int x = 0; x < dias+1; x++) {
             mes2= ca.get(Calendar.MONTH);
 } 
} else if (reservaci.getEstatus().equals("ACTIVO")&&dato2.before(reservaci.getFechaE())) {
        Calendar cP = Calendar.getInstance();
        ca.setTime(reservaci.getFechaS());
        Calendar cu = Calendar.getInstance();
        cu.setTime(reservaci.getFechaE());
        int diaE =ca.get(Calendar.DAY_OF_MONTH);
        int diaS =cu.get(Calendar.DAY_OF_MONTH);
        for (int j = diaE; j<diaS+1; j++) {
            dia.add(j);
    }
    }
    }
//////////////////////////////////////////////////////////////TERMINO FOR FECHAS//////////////////////////////////////////////////////////

if (mes==co.get(Calendar.MONTH)) {
dia.forEach(new Consumer<Integer>() {
    @Override
    public void accept(Integer element) {
        int dayOfMonth = element+5;
        component[dayOfMonth + offset].setBackground(RED);
    }
});
    }else{
    for (Component component1 : component) {
        component1.setBackground(null);
    }
}

if (mes2==c2.get(Calendar.MONTH)) {
dia.forEach(new Consumer<Integer>() {
    @Override
    public void accept(Integer element) {
        int dayOfMonth = element+5;
        componen[dayOfMonth + offset].setBackground(RED);
    }
});
    }else{for (int i = 0; i < component.length; i++) { componen[i].setBackground(null);}}
    } catch (Exception e) {
        System.out.println("Problema");
    }

    System.out.println("Dias reservados"+dia.toString());
    }  
    
    public void Item(JButton bt){
        jcbEstado.removeAllItems();
     if(bt.getBackground()==RED) {
       jcbEstado.addItem("ACTIVO");
       jcbEstado.addItem("CONCLUIDO");
     }else if(bt.getBackground()==GREEN||bt.getBackground()==Color.ORANGE)  {
     jcbEstado.addItem("ACTIVO");
     jcbEstado.addItem("RESERVADO");
    }
    }
    public void limpiar() {
        nombre.setText("");
        txtcliente.setText("");
        jcbEstado.removeAllItems();
        NUM.setValue(0);
        ex = "";
        in = "";
        na = "";
        ID.setText("");
        txtCosto.setText("");
         if (estadoA.equals("OCUPADO")) {
             jcbEstado.addItem("ESTADO");
             jcbEstado.addItem("RESERVADO");
            } else if (estadoA.equals("ACTIVO")) {
             jcbEstado.addItem("ESTADO");
             jcbEstado.addItem("RESERVADO");
             jcbEstado.addItem("ACTIVO");
            }
            
    }
    public void desbloquear() {
        jcbEstado.setEnabled(true);
        agregar.setEnabled(true);
        actualizar.setEnabled(false);
       jCalendar2.setEnabled(true);
       jCalendar1.setEnabled(true);
       NUM.setEnabled(true);
       RegistrarF.setEnabled(true);
        txtcliente.setEnabled(true);
        
    }
    public void bloquear() {
        jcbEstado.setEnabled(true);
        NUM.setEnabled(false);
       jCalendar2.setEnabled(false);
        jCalendar1.setEnabled(false);
        actualizar.setEnabled(true);
        agregar.setEnabled(false);
        RegistrarF.setEnabled(false);
        txtcliente.setEnabled(false);
        nombre.setEnabled(false);
        eliminar.setEnabled(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RESEE = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tnom = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jlExtras = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        errin = new javax.swing.JLabel();
        errna = new javax.swing.JLabel();
        reservaciones = new javax.swing.JLabel();
        errcliente = new javax.swing.JLabel();
        errorNombre = new javax.swing.JLabel();
        errEstado1 = new javax.swing.JLabel();
        errorC = new javax.swing.JLabel();
        errorHabitacion = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        eliminar = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        actualizar = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        agregar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        salir = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        limpiar = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        ID1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        RegistrarF = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        nombre = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        ItmHabitacion = new javax.swing.JComboBox<>();
        NUM = new javax.swing.JSpinner();
        buscar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ASIGNACION");
        setLocation(new java.awt.Point(450, 50));
        setUndecorated(true);

        RESEE.setBackground(new java.awt.Color(0, 102, 153));
        RESEE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        RESEE.setToolTipText("");
        RESEE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("EXTRAS");
        RESEE.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("RESERVACIONES");
        RESEE.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, -1, -1));

        tnom.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        tnom.setForeground(new java.awt.Color(255, 255, 255));
        tnom.setText("Nombre");
        RESEE.add(tnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Habitacion");
        RESEE.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, -1));

        jlExtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/extras.png"))); // NOI18N
        jlExtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlExtrasMouseClicked(evt);
            }
        });
        RESEE.add(jlExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("TOTAL");
        RESEE.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, -1, -1));

        ID.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));
        RESEE.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 90, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("$");
        RESEE.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Entrada");
        RESEE.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Salida");
        RESEE.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, -1));

        jcbEstado.setBackground(new java.awt.Color(255, 204, 255));
        jcbEstado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTADO", "ACTIVO", "CONCLUIDO", "PENDIENTE" }));
        jcbEstado.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcbEstadoPropertyChange(evt);
            }
        });
        RESEE.add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 240, 40));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Cliente");
        RESEE.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        errin.setBackground(new java.awt.Color(255, 0, 0));
        errin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        errin.setForeground(new java.awt.Color(255, 0, 0));
        errin.setText("ERROR");
        RESEE.add(errin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 160, -1));

        errna.setBackground(new java.awt.Color(255, 0, 0));
        errna.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        errna.setForeground(new java.awt.Color(255, 0, 0));
        errna.setText("ERROR");
        RESEE.add(errna, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 180, -1));

        reservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reservaciones.png"))); // NOI18N
        reservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservacionesMouseClicked(evt);
            }
        });
        RESEE.add(reservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, 100));

        errcliente.setBackground(new java.awt.Color(255, 0, 0));
        errcliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        errcliente.setForeground(new java.awt.Color(255, 0, 0));
        errcliente.setText("ERROR");
        RESEE.add(errcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, -30, -1, -1));

        errorNombre.setBackground(new java.awt.Color(255, 0, 0));
        errorNombre.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        errorNombre.setForeground(new java.awt.Color(255, 0, 0));
        errorNombre.setText("ERROR");
        RESEE.add(errorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, -1, 30));

        errEstado1.setBackground(new java.awt.Color(255, 0, 0));
        errEstado1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        errEstado1.setForeground(new java.awt.Color(255, 0, 0));
        errEstado1.setText("ERROR");
        RESEE.add(errEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 80, 20));

        errorC.setBackground(new java.awt.Color(255, 0, 0));
        errorC.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        errorC.setForeground(new java.awt.Color(255, 0, 0));
        errorC.setText("ERROR");
        RESEE.add(errorC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, 30));

        errorHabitacion.setBackground(new java.awt.Color(255, 0, 0));
        errorHabitacion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        errorHabitacion.setForeground(new java.awt.Color(255, 0, 0));
        errorHabitacion.setText("ERROR");
        RESEE.add(errorHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, -1, 30));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jToolBar1.setRollover(true);

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        eliminar.setEnabled(false);
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });
        jToolBar1.add(eliminar);
        jToolBar1.add(jSeparator4);

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        actualizar.setEnabled(false);
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
        });
        jToolBar1.add(actualizar);
        jToolBar1.add(jSeparator3);

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarMouseEntered(evt);
            }
        });
        jToolBar1.add(agregar);
        jToolBar1.add(jSeparator1);

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir1.png"))); // NOI18N
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        jToolBar1.add(salir);
        jToolBar1.add(jSeparator5);

        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiarMouseClicked(evt);
            }
        });
        jToolBar1.add(limpiar);

        RESEE.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        txtCosto.setEditable(false);
        txtCosto.setBackground(new java.awt.Color(255, 255, 153));
        txtCosto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtCosto.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        RESEE.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 250, 70));

        ID1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        ID1.setForeground(new java.awt.Color(255, 255, 255));
        ID1.setText("ID :");
        RESEE.add(ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));
        RESEE.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Ocupantes");
        RESEE.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        RegistrarF.setBackground(new java.awt.Color(51, 51, 255));
        RegistrarF.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        RegistrarF.setForeground(new java.awt.Color(255, 255, 255));
        RegistrarF.setText("Registrar fechas");
        RegistrarF.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 255)));
        RegistrarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarFActionPerformed(evt);
            }
        });
        RESEE.add(RegistrarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 410, 40));

        jCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51), 5));
        jCalendar1.setForeground(new java.awt.Color(0, 0, 51));
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });
        RESEE.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 330, 250));

        jCalendar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 5, true));
        jCalendar2.setForeground(new java.awt.Color(0, 0, 51));
        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });
        RESEE.add(jCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 360, 250));

        nombre.setEditable(false);
        nombre.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre.setDoubleBuffered(true);
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        RESEE.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 650, 32));

        txtcliente.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtcliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcliente.setDoubleBuffered(true);
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtclienteKeyTyped(evt);
            }
        });
        RESEE.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 130, 32));

        ItmHabitacion.setEnabled(false);
        ItmHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItmHabitacionActionPerformed(evt);
            }
        });
        RESEE.add(ItmHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 650, 32));

        NUM.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        NUM.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                NUMStateChanged(evt);
            }
        });
        RESEE.add(NUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 650, 32));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });
        RESEE.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 40, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul Grande.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        RESEE.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1980, 830));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RESEE, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RESEE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 642, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseEntered
        if (agregar.isEnabled() == false) {
            JOptionPane.showMessageDialog(null, "Revisa la accion");
            }       
    }//GEN-LAST:event_agregarMouseEntered

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked
        if (!(jCalendar1.getDate() == null || jCalendar2.getDate() == null)&&fecha==true) {
            in = jCalendar1.getDate().toString();
            System.out.println(in);
            na = jCalendar2.getDate().toString();
            System.out.println(in);
            if (!(nombre.getText().equals("") || txtcliente.getText().equals("") || NUM.getValue().equals(0) || ItmHabitacion.getSelectedItem().equals("0") || jcbEstado.getSelectedItem().equals("ESTADO"))) {
                reservacion = new Reservacion();
                NOH=ItmHabitacion.getSelectedItem().toString();
                descarga();
                if (jcbEstado.getSelectedItem().equals("ACTIVO")) {
                reservar="OCUPADO";
                }else if(jcbEstado.getSelectedItem().equals("RESERVADO")){
                System.out.println("Estado A"+estadoA);
                reservar=estadoA;
                }
                habi.setEstatus(reservar);
                String res=daoh.Estado(habi);
                System.out.println(res);
                String resultado=re.Insertar(reservacion);
                ItmHabitacion.removeAllItems();
                list = dao.No_habitacion();
                for (No_Habi habitacion1:list) {
                    ItmHabitacion.addItem(String.valueOf(habitacion1.getHabitacionNO()));
                }
                JOptionPane.showMessageDialog(null, resultado);
                limpiar();
                reser.colores(NOH,reservar);
                reser.contador();
            } else {
                JOptionPane.showMessageDialog(null, "Campos vacios");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Ingresa una fecha");
            errin.setVisible(true);
            errna.setVisible(true);
        }try {
            reser.Imagenes();
        } catch (IOException ex) {
            Logger.getLogger(JDRESER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_agregarMouseClicked

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
       if (actualizar.isEnabled()==true) {
             if (!(jCalendar1.getDate()==null)||jCalendar2.getDate()== null) {
                in = jCalendar1.getDate().toString();
                System.out.println(in);
                na = jCalendar2.getDate().toString();
                descarga();
                String res = jcbEstado.getSelectedItem().toString();
                System.out.println("BASE   ---- " + res);
                switch (res) {
                    case "ESTADO":
                    JOptionPane.showMessageDialog(null, "Elige un estado");
                    break;
                    case "ACTIVO":
                    reservar = "OCUPADO";
                    habi.setEstatus(reservar);
                    daoh.Estado(habi);
                    break;
                    case "RESERVADO":
                    reservar =estadoA;;
                    habi.setEstatus(reservar);
                    daoh.Estado(habi);
                    break;
                    case "CANCELADO":
                        if (estadoA.equals("OCUPADO")) {
                    reservar = "ACTIVO";
                    habi.setEstatus(reservar);
                    daoh.Estado(habi);
                        }
                        if (estadoA.equals("RESERVADO")) {
                   
                        }
                    break;
                    case "CONCLUIDO":
                    ocupado = true;
                    reservar = "ACTIVO";
                    habi.setEstatus(reservar);
                    daoh.Estado(habi);
                    break;
                }
                NOH=String.valueOf(ItmHabitacion.getSelectedItem());
                System.out.println(NOH+"---"+reservar);
                String resultado = re.update(reservacion);
                 if (ocupado==true) {
                     PDF();
                     ocupado=false;
                 }
                JDRESER.COMPLETO=0;
                reser.colores(NOH,reservar);
                reser.contador();
                 try {
                     reser.Imagenes();
                 } catch (IOException ex) {
                     Logger.getLogger(JDRESER.class.getName()).log(Level.SEVERE, null, ex);
                 }
                JOptionPane.showMessageDialog(this, resultado);
                ItmHabitacion.removeAllItems();
                list = dao.No_habitacion();
                for (No_Habi habitacion1 : list) {
                    ItmHabitacion.addItem(String.valueOf(habitacion1.getHabitacionNO()));

                }
                limpiar();
                agregar.setEnabled(true);
                actualizar.setEnabled(false);
                eliminar.setEnabled(false);
            } else {
                System.out.println("ingresa una fecha");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifica la accion");
        }
    }//GEN-LAST:event_actualizarMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
    if (eliminar.isEnabled() == false) {
        JOptionPane.showMessageDialog(null, "Busca una reservacion");
    } else {
jcbEstado.removeAllItems();
jcbEstado.addItem("CANCELADO");
num = ItmHabitacion.getSelectedItem().toString();
habi=daoh.get(Integer.parseInt(num));
carga2(IDCLIENTE);
System.out.println(reservacion.getEstatus());
dato2.setHours(0);
dato2.setMinutes(0);
dato2.setSeconds(0);
System.out.println(dato2);
System.out.println(reservacion.getFechaS());
System.out.println(reservacion.getFechaE());
 long di  =reservacion.getFechaS().getTime()-dato2.getTime();
TimeUnit unidad = TimeUnit.DAYS;
long dias  =  unidad.convert(di, TimeUnit.MILLISECONDS)+1;
System.out.println("DIAS FALTANTES "+dias);
/////////////////////////////////////////////////////////////////
long pd  =dato2.getTime()-reservacion.getFechaE().getTime();
TimeUnit unida = TimeUnit.DAYS;
long o  =  unida.convert(pd, TimeUnit.MILLISECONDS);
System.out.println("dias ocupados "+o);
long pk  =reservacion.getFechaS().getTime()-reservacion.getFechaE().getTime();
TimeUnit unidal = TimeUnit.DAYS;
long ol  =  unidal.convert(pk, TimeUnit.MILLISECONDS);
System.out.println("DIAS requeridos"+ol);
int diasR = (int)(ol-o);
System.out.println(diasR);
System.out.println((diasR*habi.getCosto()));
        if (o<=0) {
txtCosto.setText(String.valueOf(0));
        }else{
            System.out.println(habi.getCosto());
     txtCosto.setText(String.valueOf((reservacion.getCosto())-(diasR*habi.getCosto())));   
        }
        }
    }//GEN-LAST:event_eliminarMouseClicked

    private void ItmHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItmHabitacionActionPerformed

        if (ItmHabitacion.getSelectedItem()!=null) {
            num = ItmHabitacion.getSelectedItem().toString();
            habi=daoh.get(Integer.parseInt(num));
            cap =  habi.getCapacidad();
        }
    }//GEN-LAST:event_ItmHabitacionActionPerformed

    private void txtclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyTyped
        final char keyChar = evt.getKeyChar();
        if ((Character.isLetter(keyChar) || Character.isSpaceChar(keyChar)||!(Character.isDigit(keyChar)))) {
            errcliente.setVisible(true);
            evt.consume();
        } else {
            errcliente.setVisible(false);
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_txtclienteKeyTyped

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed

    }//GEN-LAST:event_txtclienteActionPerformed

    private void NUMStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_NUMStateChanged
        int valorn = (int) NUM.getValue();
        if (valorn > cap) {
            JOptionPane.showMessageDialog(null, "Capacidad excedida");
            NUM.setValue(cap);
        }
        if (valorn<0) {
            NUM.setValue(0);
        }
    }//GEN-LAST:event_NUMStateChanged

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        final char keyChar = evt.getKeyChar();
        if (!(Character.isLetter(keyChar)) || Character.isSpaceChar(keyChar)) {
//            errorCliente.setVisible(true);
            evt.consume();
        } else {
//            errorCliente.setVisible(false);
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void RegistrarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarFActionPerformed

num = ItmHabitacion.getSelectedItem().toString();
habi=daoh.get(Integer.parseInt(num));
Calendar ca = Calendar.getInstance();
Calendar co = Calendar.getInstance();
ca.setTime(jCalendar1.getDate());
co.setTime(jCalendar2.getDate());
Date date1 =  jCalendar1.getDate();
Date date2 =  jCalendar2.getDate();
long di  =  date2.getTime()- date1.getTime();
TimeUnit unidad = TimeUnit.DAYS;
long dias  =  unidad.convert(di, TimeUnit.MILLISECONDS);
int gg = habi.getCosto();
boolean dis =  false ; 
d=ca.get(Calendar.DAY_OF_MONTH);
System.out.println("dd"+d);
for (int i = 0; i < dias+1; i++) {
      System.out.println(d+i);
    if (dia.contains(d+i)) {
        dis=true;
        System.out.println(d+i);
    }
}
if (dis==true) {JOptionPane.showMessageDialog(null,"Dia no disponible");}else{
if (jCalendar1.getDate() != null || jCalendar2.getDate() != null){
Date dato1 = jCalendar1.getDate();
Date dato = jCalendar2.getDate();
    System.out.println(dato2);
    dato1.setHours(01);
    dato2.setHours(00);
    dato2.setMinutes(00);
    dato2.setSeconds(00);
    System.out.println(dato1);
    System.out.println(dato);
    System.out.println(dato2);
if (dato1.before(dato2) || dato.before(dato2)||dato.before(dato1)||dato1.getDay()==dato.getDay()&&
    dato1.getMonth()==dato.getMonth() || dato1.getMonth()!=dato.getMonth() ) {
JOptionPane.showMessageDialog(null, "Ingresa una fecha valida");
}else   {
JOptionPane.showMessageDialog(null,"Dias ocupados"+dias+" x costo habitacion :"+gg);
//////////////////////////////////////Costo de reservacion //////////////////////////////////////////////////////
if (CF==0) {
CF = (int)(gg*dias);
COMPLETO=COMPLETO+CF; 
        }else{
COMPLETO=COMPLETO-CF;
CF = (int)(gg*dias);
COMPLETO+=CF; }
txtCosto.setText(String.valueOf(COMPLETO));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
fecha =  true;
        }
        }}
    }//GEN-LAST:event_RegistrarFActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        if (!txtcliente.getText().isEmpty()) {
           cliente = daoc.get(Integer.parseInt(txtcliente.getText()));
        if (cliente == null||cliente.getNombre()==null) {
            JOptionPane.showMessageDialog(this, "No fue encontrado");
            errorC.setVisible(true);
        } else {
         nombre.setText(cliente.getNombre());
         errorC.setVisible(false);
        } 
        }else{JOptionPane.showMessageDialog(null,"Ingresa el folio del cliente");}
    }//GEN-LAST:event_buscarMouseClicked

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        RancgoFechas();
        FechasBD(habiN);
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
       RancgoFechas();
        FechasBD(habiN);   
    }//GEN-LAST:event_jCalendar2PropertyChange

    private void jcbEstadoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcbEstadoPropertyChange
        try {
            String Estado =""+jcbEstado.getSelectedItem().toString()+"3";
        System.out.println(Estado);
        switch (Estado) {
            case "ACTIVO3":
            jcbEstado.setBackground(GREEN);
                break;
            case "CANCELADO3":
            jcbEstado.setBackground(RED);
                break;
            case "RESERVADO3":
            jcbEstado.setBackground(Color.ORANGE);
                break;
            case "CONCLUIDO3":
            jcbEstado.setBackground(Color.RED);
                break;
            case "3":
            jcbEstado.setBackground(Color.GREEN);
                break;
            default:
                jcbEstado.setBackground(GREEN);
        }  
        } catch (Exception e) {
            System.out.println("error");
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadoPropertyChange

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
CF=0;
COMPLETO=0;
this.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_salirMouseClicked

    private void limpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarMouseClicked
  limpiar();
  desbloquear();    
  estadoR="LIBRE";
//  SS.inhabilitar();
  CF=0;
  COMPLETO=0;
    }//GEN-LAST:event_limpiarMouseClicked

    private void jlExtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlExtrasMouseClicked
//        System.out.println("Estado Reservasion "+estadoR);
//        if (estadoR.equals("ACTIVO")) {
//        SS.habilitar();
//        }else{SS.inhabilitar();}
        SS.show();// TODO add your handling code here:
    }//GEN-LAST:event_jlExtrasMouseClicked

    private void reservacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservacionesMouseClicked
        try {
            jdReservacion.txtBuscar.setText(ItmHabitacion.getSelectedItem().toString());
        S.show();
        reservaci = jdReservacion.lista.get(jdReservacion.tablaR.getSelectedRow());
        int H = reservaci.getFolio();
        reservacion = re.get(reservaci.getFolio());
        System.out.println(reservaci);
        if (reservacion == null) {
            JOptionPane.showMessageDialog(this, "No fue encontrado");
        } else {
            desbloquear();
            carga2(H);
            carga();
            Rese();
            jcbEstado.removeAllItems();
            jcbEstado.addItem("RESERVADO");
            jcbEstado.addItem("ACTIVO");
            bloquear();
            jcbEstado.setSelectedItem(reservaci.getEstatus());
            estadoA="RESERVADO";
            estadoR="RESERVADO";
            agregar.setEnabled(false);
            eliminar.setEnabled(true);
            actualizar.setEnabled(true);
            jCalendar1.setEnabled(true);
            jCalendar2.setEnabled(true);
        }    
        } catch (Exception e) {
            System.out.println("Ocurrio algun error");
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_reservacionesMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDRESER dialog = null;
                dialog = new JDRESER(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JLabel ID1;
    public static javax.swing.JComboBox<String> ItmHabitacion;
    public static javax.swing.JSpinner NUM;
    private javax.swing.JPanel RESEE;
    private javax.swing.JButton RegistrarF;
    public static javax.swing.JLabel actualizar;
    public static javax.swing.JLabel agregar;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel eliminar;
    private javax.swing.JLabel errEstado1;
    private javax.swing.JLabel errcliente;
    private javax.swing.JLabel errin;
    private javax.swing.JLabel errna;
    private javax.swing.JLabel errorC;
    private javax.swing.JLabel errorHabitacion;
    private javax.swing.JLabel errorNombre;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JLabel jlExtras;
    private javax.swing.JLabel limpiar;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel reservaciones;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel tnom;
    public static javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtcliente;
    // End of variables declaration//GEN-END:variables

    private void carga() {
        ID.setText(String.valueOf(reservacion.getFolio()));
        nombre.setText(reservacion.getNombre());
        txtcliente.setText("" + reservacion.getCliente());
        jcbEstado.setSelectedItem(reservacion.getEstatus());
        NUM.setValue(reservacion.getOcupantes());
        SERVICIOS.CUENTA.setText(reservacion.getExtras());
        jCalendar1.setDate(reservacion.getFechaE());
        jCalendar2.setDate(reservacion.getFechaS());
        ItmHabitacion.addItem(reservacion.getHabitacion());
        ItmHabitacion.setSelectedItem(reservacion.getHabitacion());
        txtCosto.setText(String.valueOf(reservacion.getCosto()));
        
    }
    
    public void carga2(int x){
        System.out.println(x);
        reservacion = re.get(x);
        IDCLIENTE = reservacion.getFolio();
        System.out.println("Id cliente  "+ IDCLIENTE);
        ID.setText(String.valueOf(reservacion.getFolio()));
        nombre.setText(reservacion.getNombre());
        txtcliente.setText("" + reservacion.getCliente());
        jcbEstado.setSelectedItem(reservacion.getEstatus());
        NUM.setValue(reservacion.getOcupantes());
        SERVICIOS.CUENTA.setText(reservacion.getExtras());
        jCalendar1.setDate(reservacion.getFechaE());
        jCalendar2.setDate(reservacion.getFechaS());
        ItmHabitacion.addItem(reservacion.getHabitacion());
        ItmHabitacion.setSelectedItem(reservacion.getHabitacion());
        txtCosto.setText(String.valueOf(reservacion.getCosto()));
    }
    
    
    private void descarga() {
        java.util.Date d = jCalendar1.getDate();
        java.util.Date i = jCalendar2.getDate();
        java.sql.Date sqldate = new java.sql.Date(d.getTime());
        java.sql.Date sqldate1 = new java.sql.Date(i.getTime());
        reservacion.setNombre(nombre.getText());
        reservacion.setCliente(Integer.parseInt(txtcliente.getText()));
        reservacion.setEstatus(jcbEstado.getSelectedItem().toString());
        reservacion.setOcupantes((int) NUM.getValue());
        reservacion.setExtras(SERVICIOS.CUENTA.getText());
        reservacion.setFechaE(sqldate);
        reservacion.setFechaS(sqldate1);
        reservacion.setHabitacion(ItmHabitacion.getSelectedItem().toString());
        reservacion.setCosto(Integer.parseInt(txtCosto.getText()));
    }
}
