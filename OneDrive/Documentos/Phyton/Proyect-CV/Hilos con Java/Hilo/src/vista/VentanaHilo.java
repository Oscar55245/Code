
package vista;

import controlador.HiloControlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Impresor;


public final class VentanaHilo extends JFrame implements Impresor{

   public static javax.swing.JTextField texto;
   public static ArrayList <JButton> boton;
   public static ArrayList <JTextArea> txtArea;
   public static JPanel p2 = new JPanel();
   public static JPanel p3 = new JPanel();
   public static JButton bot = new JButton();
   //Hilo hilo;
   private HiloControlador hiloControlador, hiloControlador2;
    public VentanaHilo(){
         super("Hilos");
         boton = new ArrayList<JButton>();
         txtArea = new ArrayList<JTextArea>();
         setVisible(true);
         setSize(300,100);
         p2.setBackground(Color.PINK);
         p3.setBackground(Color.yellow);
         //Action1();
         texto = new JTextField();
         setLayout(new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.weightx = 0.5;
         c.fill = GridBagConstraints.HORIZONTAL;
         c.gridx = 0;
         c.gridy = 0;
         add(texto, c);
         c.fill = GridBagConstraints.HORIZONTAL;
         c.ipady = 150;     
         c.weightx = 0.0;
         c.gridwidth = 3;
         c.gridx = 0;
         c.gridy = 1;
         add(p2,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 100;      
        c.weighty = 0.0;  
        c.anchor = GridBagConstraints.CENTER; 
        c.gridx = 0;       
        c.gridwidth =2; 
        c.gridy = 2;       
        add(p3, c);
        Botones();
        Action1();
        Action2();
        setSize(400, 400); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearAreasTexto(2);
        
      
    }
    public void Action1(){
      JButton bt = boton.get(0);
      bt.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent ae) {
        int N = 2;
        crearAreasTexto(N);
     }
     });  

    }
    public void Action2(){
      JButton bt = boton.get(1);
      bt.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent ae) {
      hiloControlador.supender();
   //  hiloControlador2.supender();
      
     }
     });  

    }
    public void Botones(){
        p3.setLayout(new GridLayout(0,1,1,10));
        for (int i = 0; i < 2; i++) {  
            String labelBoton = "Boton:"+(i+1);
            if(i==1){labelBoton="PAUSAR | INICIAR";}
            JButton bot = new JButton(labelBoton);
            bot.setMinimumSize(new Dimension(20,20));
            boton.add(bot);
            p3.add(bot);
        }
    }
    public void crearAreasTexto (int numero){
     p2.setLayout(new GridLayout(1,2,25,10));
     for (int i = 0; i < numero; i++) {  
         String labelBoton = "txt"+(i+1);
         JTextArea txt = new JTextArea(labelBoton);
          txtArea.add(txt);
      p2.add(txt, BorderLayout.AFTER_LAST_LINE); 
      p2.updateUI();
     }
    }   
   // VentanaHilo ventanaHilo = new VentanaHilo();

    public static void main(String[] args) {
      VentanaHilo ventanaHilo=new VentanaHilo();
      HiloControlador  hiloControlador = new HiloControlador(1000, ventanaHilo,"Hilo 1");
      HiloControlador  hiloControlador2 = new HiloControlador(1000, ventanaHilo,"Hilo 2");
      ventanaHilo.setHiloControlador(hiloControlador, hiloControlador2);
      ventanaHilo.setVisible(true);
      hiloControlador.start();
      hiloControlador2.start();
    }

    @Override
        public void imprimirContador(int contador,int contador2, String nombre) {
            if (nombre.equals("Hilo 1")) {
            txtArea.get(0).setText(String.valueOf(contador)+" "+ nombre);
        }
            if (nombre.equals("Hilo 2")) {
            txtArea.get(1).setText(String.valueOf(contador2)+" "+ nombre);
        }
        
          //  nombre.compareTo(nombre)
    }

   private void setHiloControlador(HiloControlador hiloControlador , HiloControlador hiloControlador2 ) {
        this.hiloControlador = hiloControlador;
        this.hiloControlador2 = hiloControlador2;                
   }

  //  @Override
    public void imprimirContador2(int contador) {
        txtArea.get(1).setText(String.valueOf(contador)+"\n");
    }

}