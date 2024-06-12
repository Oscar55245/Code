
package pBase;
import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static pBase.JDRESER.componen;
import static pBase.JDRESER.component;
import proyecto.DAOHabitacion;
import proyecto.DAOReservacion;
import proyecto.Habitacion;
import proyecto.Reservacion;

public final class JIrecepcion extends javax.swing.JInternalFrame {
    
  public static DAOReservacion re = new DAOReservacion();
    public static ArrayList<Reservacion> list;
    public static Reservacion reservacion;
    public static ArrayList <JButton> boton;
    private Habitacion habitacion;
    private final DAOHabitacion dao = new DAOHabitacion();
    private ArrayList<Habitacion> lista; 
    public static  JButton bot;
    public static int res,ac,man,in,columna=3,fila=2;
    public static boolean bandera=true;
    public static JDRESER mmm = new JDRESER(null, true);
    
 public JIrecepcion() {
 initComponents();
 botones();
 action();
 }
 
 private void extras(JButton bt) throws IOException{
     try {
          if (bt.getBackground()==RED) {
         list = re.busquedaO(Integer.parseInt(bt.getText()),"ACTIVO"); 
         reservacion = list.get(0);
         descrip.setText("HABITACION RESERVADA\n"+"Nombre del cliente :"+reservacion.getNombre()+"\n"+
                         "Numero de Habitacion"+reservacion.getHabitacion()+"\n"+
                         "CUENTA  $"+reservacion.getCosto());
     }else if(bt.getBackground()==GREEN) {
    habitacion = dao.get(Integer.parseInt(bt.getText()));
   descrip.setText("Descripcion de Habitacion  NO° :"+habitacion.getNoH()+" \n"+
           "PISO :"+habitacion.getPISO()+"\n"+
           "CUARTOS    : "+ habitacion.getCUARTOS()+"\n"+
           "TIPO :"+habitacion.getTipo()+"\n"+
           "COSTO   : "+ habitacion.getCosto()+"\n"+
           "BAÑO       : "+ habitacion.getBAÑOS()+"\n"+
           "CAMAS      : "+habitacion.getCAMAS()+"\n"+
           "TELEVISORES: "+ habitacion.getTV()+"\n"+
           "AIRE ACONDICIONADO: "+habitacion.getAC()+"\n");
         System.out.println(habitacion.getFoto());
         File file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\"+habitacion.getFoto());
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIcon mgIco = new ImageIcon(bufferedImage);
            Image imgcalada = mgIco.getImage().getScaledInstance( cuarto.getWidth(),
            cuarto.getHeight(), Image.SCALE_SMOOTH);
            Icon iconscalado = new ImageIcon(imgcalada);
            cuarto.setIcon(iconscalado);
            cuarto.setVisible(true);
     } else if(bt.getBackground()==Color.YELLOW) {
         descrip.setText("EN MANTENIMIENTO");
         cuarto.setVisible(false);
         cuarto.setIcon(null);
     }
     } catch (Exception e) {
         System.out.println("Error");
     }
    
 }
 public void mouseE(JButton bt){
      bt.addMouseListener( new MouseAdapter() {
        public void mouseEntered(MouseEvent event){ 
            try {
                extras(bt);
            } catch (IOException ex) {
                Logger.getLogger(JIrecepcion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
      descrip.setText("");
      cuarto.setIcon(null);
   }
      } );
 }
 public void action(){
   for (int i = 0; i < boton.size(); i++) {
       JButton bt = boton.get(i);
       bt.addActionListener(new ActionListener() {
     @Override
     @SuppressWarnings("empty-statement")
     public void actionPerformed(ActionEvent ae) {
   if (bt.getBackground()==GREEN){
JDRESER.ItmHabitacion.setSelectedItem(bt.getText());
 System.out.println(JDRESER.dia);
 JDRESER.estadoA ="ACTIVO";
 mmm.Item(bt);
 mmm.limpiar();
 mmm.desbloquear();
 mmm.FechasBD(Integer.parseInt(bt.getText()));
 JDRESER.habiN = Integer.parseInt(bt.getText());
 JDRESER.estadoR="LIBRE";
 mmm.show();
 
// JDRESER.SS.CUENTA.setText("");
 for (int i = 0; i < component.length; i++) { componen[i].setBackground(null);}
}
 if (bt.getBackground()==RED) {
            list = re.busquedaO(Integer.parseInt(bt.getText()),"ACTIVO"); 
            reservacion = list.get(0);
            mmm.carga2(reservacion.getFolio());
            JDRESER.COMPLETO=reservacion.getCosto();
            JDRESER.ItmHabitacion.setSelectedItem(bt.getText());
            mmm.Item(bt);
            JDRESER.estadoA ="OCUPADO";
            JDRESER.estadoR=reservacion.getEstatus();
            mmm.bloquear();
            mmm.FechasBD(Integer.parseInt(bt.getText()));;
            JDRESER.habiN = Integer.parseInt(bt.getText());
            JDRESER.ItmHabitacion.setSelectedItem(bt.getText());
            mmm.show();
 for (int i = 0; i < component.length; i++) { componen[i].setBackground(null);}
 System.out.println(JDRESER.dia);
           
  }   /// COLOR ROJO 
  if (bt.getBackground()==Color.YELLOW) {
            descrip.setText("Mantenimiento");
  }/// COLOR AMARILLO 
 
     }
     });  
     }
 }
  public void botones(){
   boton = new ArrayList<>();
 lista = dao.list();
 for (Habitacion habitacion1 : lista) {
 String labelBoton = String.valueOf(habitacion1.getNoH());
 bot = new JButton(labelBoton);
 bot.setBackground(Color.BLUE);
 mouseE(bot);
        if (habitacion1.getEstatus().equals("OCUPADO")) {
               bot.setBackground(Color.RED);
                boton.add(bot); 
          this.PANEL.add(bot);
            }
              if (habitacion1.getEstatus().equals("ACTIVO")) {
                bot.setBackground(Color.GREEN);
                 boton.add(bot); 
                 
          this.PANEL.add(bot);
            }
              if (habitacion1.getEstatus().equals("MANTENIMIENTO")) {
                bot.setBackground(Color.YELLOW);
                 boton.add(bot); 
                 
          this.PANEL.add(bot);
            }
              if (habitacion1.getEstatus().equals("RESERVADO")) {
                bot.setBackground(Color.ORANGE);
                 boton.add(bot); 
                 
          this.PANEL.add(bot);
            }
             
        }
  PANEL.setLayout(new GridLayout(fila,columna,25,10));
  

  }

public void Imagenes() throws IOException{
    final int defaultButtonWidth = 119;
    final int defaultButtonHeight = 268;
    for (int i = 0; i < boton.size(); i++) {
        JButton bt = boton.get(i);
        ImageIcon mgIco = null;        
        //C:\Users\aylem\Desktop\ProyectoModularI\Imagene
        if (boton.get(i).getBackground().equals(GREEN)) {
            File file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\Puerta.PNG");
            BufferedImage bufferedImage = ImageIO.read(file);
            mgIco = new ImageIcon((bufferedImage));
        }
        else if (boton.get(i).getBackground().equals(RED)) {
            File file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\PuertaO.PNG");
            BufferedImage bufferedImage = ImageIO.read(file);
            mgIco = new ImageIcon((bufferedImage));
        }
        else if (boton.get(i).getBackground().equals(Color.YELLOW)) {
            File file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\PuertaM.PNG");
            BufferedImage bufferedImage = ImageIO.read(file);
            mgIco = new ImageIcon((bufferedImage));
        }
        else if (boton.get(i).getBackground().equals(Color.ORANGE)) {
            File file = new File("C:\\Users\\aylem\\Desktop\\ProyectoModularI\\Imagenes\\PuertaR.PNG");
            BufferedImage bufferedImage = ImageIO.read(file);
            mgIco = new ImageIcon((bufferedImage));
        }
        if(mgIco != null){
            Image imgcalada = mgIco.getImage().getScaledInstance(defaultButtonWidth,
            defaultButtonHeight, Image.SCALE_SMOOTH);
            Icon iconscalado = new ImageIcon(imgcalada);
            bt.setIcon(iconscalado);
        }
    }
}
  public void colores(String x, String status){
 System.out.println("x="+x+"  --- status = "+status);
 mmm.hide();
 for (int i = 0; i < boton.size(); i++) {
            if (boton.get(i).getText().equals(x)) {
             JButton bt = boton.get(i);
              if (status.equals("OCUPADO")) {
                  bt.setBackground(Color.RED);
              }
              if (status.equals("ACTIVO")) {
                bt.setBackground(Color.GREEN);
            }
              if (status.equals("MANTENIMIENTO")) {
                bt.setBackground(Color.YELLOW);
            }
              if (status.equals("INACTIVO")) {
                bt.setBackground(Color.BLUE);
            }   
            
            }
  }
  }
  public void contador (){
      
     disponibles.setText("DISPONIBLES = "+ac);
     ocupados.setText("OCUPADOS = "+res);
      ac=0;
      res=0;
      man=0;
      in=0;
  lista = dao.list();
  for (Habitacion habitacion1 : lista) {
        if (habitacion1.getEstatus().equals("RESERVADO")) {
          res++;
      }
        if (habitacion1.getEstatus().equals("MANTENIMIENTO")) {
          man++;
      }
        if (habitacion1.getEstatus().equals("ACTIVO")) {
          ac++;
      }
        if (habitacion1.getEstatus().equals("INACTIVO")) {
          in++;
      }
        }
      System.out.println(lista.size()+"");
      System.out.println(res);
      System.out.println(ac);
      System.out.println(man);
      System.out.println(in);
     disponibles.setText("DISPONIBLES = "+ac);
     ocupados.setText("OCUPADOS = "+res);
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descrip = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PANEL = new javax.swing.JPanel();
        disponibles = new javax.swing.JButton();
        vendidos = new javax.swing.JButton();
        ocupados = new javax.swing.JButton();
        Fondo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Recepcion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 340, 176));

        cuarto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cuarto.setFocusable(false);
        jPanel2.add(cuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 290, 150));

        descrip.setEditable(false);
        descrip.setBackground(new java.awt.Color(0, 0, 0));
        descrip.setColumns(20);
        descrip.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        descrip.setForeground(new java.awt.Color(255, 255, 255));
        descrip.setLineWrap(true);
        descrip.setRows(5);
        descrip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane2.setViewportView(descrip);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 290, 200));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul Empleado.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 610));

        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        PANEL.setBackground(new java.awt.Color(204, 204, 255));
        PANEL.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 204), new java.awt.Color(255, 153, 255)));
        PANEL.setLayout(new java.awt.GridLayout(2, 4, 10, 15));
        jScrollPane1.setViewportView(PANEL);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 77, 720, 553));

        disponibles.setBackground(new java.awt.Color(0, 255, 0));
        disponibles.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        disponibles.setForeground(new java.awt.Color(255, 255, 255));
        disponibles.setText("DISPONIBLES");
        disponibles.setToolTipText("");
        disponibles.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 255)));
        disponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disponiblesActionPerformed(evt);
            }
        });
        jPanel1.add(disponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 240, 60));

        vendidos.setBackground(new java.awt.Color(0, 0, 255));
        vendidos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vendidos.setForeground(new java.awt.Color(255, 255, 255));
        vendidos.setText("Todos");
        vendidos.setToolTipText("");
        vendidos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 255)));
        vendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendidosActionPerformed(evt);
            }
        });
        jPanel1.add(vendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 270, 60));

        ocupados.setBackground(new java.awt.Color(255, 0, 0));
        ocupados.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ocupados.setForeground(new java.awt.Color(255, 255, 255));
        ocupados.setText("OCUPADOS");
        ocupados.setToolTipText("");
        ocupados.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 255)));
        ocupados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocupadosActionPerformed(evt);
            }
        });
        jPanel1.add(ocupados, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 210, 60));

        Fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul Grande.png"))); // NOI18N
        jPanel1.add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -10, 1420, 730));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAzul.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1536, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ocupadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocupadosActionPerformed
   PANEL.removeAll();
  PANEL.setLayout(new GridLayout(4,5,25,10));
        for (int i = 0; i < boton.size(); i++) {
            if (boton.get(i).getBackground()==RED) {
                boton.get(i).setPreferredSize(new Dimension(119, 268));
                this.PANEL.add(boton.get(i));
            }
        }
                PANEL.updateUI();
    }//GEN-LAST:event_ocupadosActionPerformed
public void BTaction(JButton botton){      
      botton.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent ae) {
 if (botton.getBackground()==RED) {
            list = re.busquedaO(Integer.parseInt(botton.getText()),"ACTIVO"); 
             reservacion = list.get(0);
            mmm.carga2(reservacion.getFolio());
            JDRESER.COMPLETO=reservacion.getCosto();
            mmm.bloquear();
            mmm.show();
  }
 if (botton.getBackground()==Color.YELLOW) {
            list = re.busquedaO(Integer.parseInt(botton.getText()),"RESERVADO"); 
             reservacion = list.get(0);
            mmm.carga2(reservacion.getFolio());
            JDRESER.COMPLETO=reservacion.getCosto();
            mmm.bloquear();
            mmm.show();
  }
 else if(botton.getBackground()==GREEN)  {
// mmm.limpiar();
 mmm.desbloquear();
 mmm.show();
 }
     }
     });  
     
 }
    private void disponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disponiblesActionPerformed
   PANEL.removeAll();
   PANEL.updateUI();
   
  PANEL.setLayout(new GridLayout(fila,columna,25,10));
    for (int i = 0; i < boton.size(); i++) {
            if (boton.get(i).getBackground()==GREEN) {
                this.PANEL.add(boton.get(i));
            }
        }
    }//GEN-LAST:event_disponiblesActionPerformed

    private void vendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendidosActionPerformed
PANEL.removeAll();
PANEL.updateUI();
PANEL.setLayout(new GridLayout(fila,columna,25,10));
for (int i = 0; i < boton.size(); i++) {
                this.PANEL.add(boton.get(i));
            
        }
    }//GEN-LAST:event_vendidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo1;
    private javax.swing.JPanel PANEL;
    private final javax.swing.JLabel cuarto = new javax.swing.JLabel();
    private javax.swing.JTextArea descrip;
    private javax.swing.JButton disponibles;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton ocupados;
    private javax.swing.JButton vendidos;
    // End of variables declaration//GEN-END:variables
}
