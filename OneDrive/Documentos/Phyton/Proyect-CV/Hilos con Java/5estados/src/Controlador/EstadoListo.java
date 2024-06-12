
package Controlador;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Impresor;

public class EstadoListo extends EstadoHilo {
     Impresor impresor;
      public EstadoListo(PlanificadorProcesos planificador,Impresor impresor) {
         super(planificador);
         this.impresor = impresor;
     }
	public void run() {
            while(true) {
                System.out.println("Hilo listo creado");
			if(listaProcesosEmpty()){
				synchronized(this) {
                                    try {
                                        wait();
                                        System.out.println("Lista vacia");
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(EstadoInicio.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
			} else {
                            proceso p = extraerProceso();
                            impresor.imprimirListo(p.getnombre());
                            try { 
                                synchronized(this) {
                                wait(p.gettiempoInicio());
                                planificador.agregarEjecutar(p);
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(EstadoInicio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
            }
        }
}
