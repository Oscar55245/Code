
package Sistema;

/**
 * @author CesarJ
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo5estados.Proceso;

public class E_Bloqueo extends Hilo_estado {
	
        public E_Bloqueo(Controlador_proc Conpr, Impresor im){
            super(Conpr);
            this.im=im;
        }
    
	public void run() {
		Proceso p;
                System.out.println("Un hilo Bloqueado a sido creado");
		while(true) {
			if(Fila_Procesos()){
				synchronized(this) {
                                    try {
                                        wait();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(E_Bloqueo.class.getName()).log(Level.SEVERE, null, ex);
                                    }
				}
			} else {
				p = Quitar_Procesos();
                                imprimir_bloqueo(p.getArchivo());
                            try {
                                sleep(p.getTiempoB());
                                Conpr.Terminado(p);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(E_Bloqueo.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
			}
		}
	}
}
