
package Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Impresor;

public class EstadoTerminado extends EstadoHilo {
     Impresor impresor;
      public EstadoTerminado(PlanificadorProcesos planificador,Impresor impresor) {
         super(planificador);
         this.impresor = impresor;
     }
	public void run() {
            while(true) {
                
			if(listaProcesosEmpty()){
				synchronized(this) {
                                    try {
                                        wait();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(EstadoInicio.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
			} else {
                            proceso p = extraerProceso();
                            impresor.imprimirTerminado(p.getnombre());
                            Lapso.finLapso=false;
                        }
            }
        }
}
