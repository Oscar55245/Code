
package Sistema;

/**
 * @author CesarJ
 */
import java.io.File;
import java.util.ArrayList;
import modelo5estados.Proceso;


public class Controlador_proc {
	private String DIRECTORIO_PROCESOS = "ejecutables";
	
	private ArrayList<Proceso> listaEjecutables;
	private int pid;
	private Hilo_estado[] Lista_estados;
        private int MaxEstados = 5;

        Impresor im;
        
        public void getimpresor(Impresor im){
            this.im = im;
        }
        
        
        public Controlador_proc(Impresor im){
            
            Lista_estados = new Hilo_estado[]{
              new E_Inicio(this,im), new E_Bloqueo(this,im), new E_Ejecucion(this,im), new E_Listo(this,im), new E_Terminado(this,im)  
            };
            
            for (int i = 0; i < MaxEstados; i++) {
                Lista_estados[i].start();
                
            }
            
        }
        
        public void Inicio(Proceso Pr){
            
            Hilo_estado estado = Lista_estados [0];
            estado.agregarProceso(Pr);
            synchronized (estado) {
                estado.notify();
            }
        }
        public void Listo(Proceso Pr){
            Hilo_estado estado = Lista_estados [3];
            estado.agregarProceso(Pr);
            synchronized (estado) {
                estado.notify();
            }
        }
        public void Ejecucion(Proceso Pr){
            Hilo_estado estado = Lista_estados [2];
            estado.agregarProceso(Pr);
            synchronized (estado) {
                estado.notify();
            }
        }
        public void Bloqueo(Proceso Pr){
            Hilo_estado estado = Lista_estados [1];
            estado.agregarProceso(Pr);
            synchronized (estado) {
                estado.notify();
            }
        }
        public void Terminado(Proceso Pr){
            Hilo_estado estado = Lista_estados [4];
            estado.agregarProceso(Pr);
            synchronized (estado) {
                estado.notify();
            }
        }
}


