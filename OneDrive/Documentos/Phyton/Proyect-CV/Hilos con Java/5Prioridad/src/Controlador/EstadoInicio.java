
package Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Impresor;
public class EstadoInicio extends EstadoHilo{
     Impresor impresor;
     private static int id;
     public EstadoInicio(PlanificadorProcesos planificador, Impresor impresor) {
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
                 impresor.imprimirInicio(p.getnombre());
                 try {
                     sleep(p.gettiempoInicio());
                     planificador.agregarListo(p);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(EstadoInicio.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
     }
}

