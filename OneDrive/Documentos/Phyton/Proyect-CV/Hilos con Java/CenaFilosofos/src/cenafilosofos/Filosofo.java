
package cenafilosofos;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Filosofo extends Thread  {
    private static  long TIEMPO_MAX_ESPERA=1000;
    private int tenedorDerecho;
    private int tenedorIzquierdo;
    private Mesa mesa;
    
    public Filosofo(String name, int idFilosofo, Mesa mesa) throws InterruptedException{
      super(name);
      this.mesa=mesa;
      int totalTenedores=5;
      int derecho;
      tenedorIzquierdo=idFilosofo;
      tenedorDerecho=(idFilosofo+1)%totalTenedores;
    }
    public void run(){
       while(true){
           try {
               pensar();
               mesa.ocuparTenedor(tenedorIzquierdo, tenedorDerecho);
               comer();
               System.out.println(getName()+"Dejo de comer");
               mesa.desocuparTenedor(tenedorIzquierdo, tenedorDerecho);
           } catch (InterruptedException ex) {
               Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
    
    }
    private void comer() throws InterruptedException{
        System.out.println(getName()+"-------Estoy comiendo con tenedor iz"+tenedorIzquierdo+"y dr"+tenedorDerecho);
        esperar();
    }
    public void pensar() throws InterruptedException{
          System.out.println(getName()+"-------Estoy pensando");
          esperar();
    }
    public void esperar() throws InterruptedException{
        sleep(TIEMPO_MAX_ESPERA*5);
    }
    
}
