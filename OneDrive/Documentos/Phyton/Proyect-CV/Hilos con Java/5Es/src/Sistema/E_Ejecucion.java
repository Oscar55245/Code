
package Sistema;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo5estados.Proceso;
import modelo5estados.leer_archivos;

public class E_Ejecucion extends Hilo_estado {
	leer_archivos leer ;
        public E_Ejecucion(Controlador_proc Conpr,Impresor im){
            super(Conpr);
            this.im=im;
            leer = new leer_archivos();
        }
    
	public void run() {
		Proceso p;
                System.out.println("Un hilo en Ejecucion a sido creado");
		while(true) {
			if(Fila_Procesos()){
				synchronized(this) {
                                    try {
                                        wait();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(E_Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
                                    }
				}
			} else {
				p = Quitar_Procesos();
                                imprimir_ejecucion(p.getArchivo());
                            try {
                                p.setInstruccion( leer.leer(p.getArchivo()));
                                for (int i = 0; i < p.getInstruccion().size(); i++) {
                                    for (int j = 0; j < p.getInstruccion().get(i).getEjecucion(); j++) {
                                        imprimir_ejecucion(p.getInstruccion().get(i).getIntruccion());
                                        sleep(p.getTiempoE());
                                    }
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(E_Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(E_Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                sleep(p.getLapsoE());
                                Conpr.Bloqueo(p);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(E_Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
                        
		}
	}
}
