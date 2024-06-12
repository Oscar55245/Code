
package Controlador;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Impresor;

public class EstadoBloqueo extends EstadoHilo {
     Impresor impresor;
     public static boolean block;
      public EstadoBloqueo(PlanificadorProcesos planificador,Impresor impresor) {
         super(planificador);
         this.impresor = impresor;
     }
	public void run() {
            while(true) {
                if(listaProcesosEmpty()){
				detener();
			} else {
                            block=true;
                            proceso p = extraerProceso();
                            impresor.imprimirBloqueado(p.getnombre());
                            try {
                                sleep(p.gettiempoBloqueo());
                                planificador.agregarEjecutar(p);
                                block=false;
                            } catch (InterruptedException ex) {
                                Logger.getLogger(EstadoInicio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
            }
        }
}

