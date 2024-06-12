
package cenafilosofos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {
    private boolean[] tenedores;
    public void CrearTenedores(int tenedores){
      this.tenedores= new boolean[tenedores];
        for (int i = 0; i < this.tenedores.length; i++) {
            System.out.println(this.tenedores[i]);
        }
    }
    public synchronized void ocuparTenedor(int tenedorIzquierdo, int tenedorDerecho){
        while(this.tenedores[tenedorIzquierdo]||this.tenedores[tenedorDerecho]) {
         try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.tenedores[tenedorIzquierdo]=true;
        this.tenedores[tenedorDerecho]=true;
           
    }
   public synchronized void desocuparTenedor(int tenedorIzquierdo, int tenedorDerecho){
           this.tenedores[tenedorIzquierdo]=false;
           this.tenedores[tenedorDerecho]=false;
           notify();
   }
   
}
