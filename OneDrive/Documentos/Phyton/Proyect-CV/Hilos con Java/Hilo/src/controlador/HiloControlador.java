
package controlador;

import modelo.Impresor;


public class HiloControlador extends Thread  {
     private final Impresor impresor;
     private int tiempoPausa;
     private boolean hilo1Activo;
     private boolean hilo2iActvo;
     private String nombre ;
     public  HiloControlador(int tiempoPausa, Impresor impresor, String nombre){
         super(nombre);
         hilo1Activo = true;
         this.impresor =impresor;
         this.tiempoPausa = tiempoPausa;
         this.nombre = nombre; 
     }@Override
    public void run() {
         int contador=0;
         int contador2=0;
         while(true) {
            if(hilo1Activo) {
                    // this.resume();
                try {   
                    contador++;
                    contador2=contador2+2;
                    impresor.imprimirContador(contador,contador2, nombre);
                    System.out.println(nombre);
                   // impresor.imprimirContador2(contador+2,nombre);
                    Thread.sleep(tiempoPausa);
                    } catch (InterruptedException e) {
                    }
                }else{resume();}
         } 

    }

    public  void supender() {
        hilo1Activo = ! hilo1Activo;
        System.out.println(hilo1Activo);
        System.out.println(Thread.currentThread());
       
    }
}
