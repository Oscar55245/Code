
package Sistema;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo5estados.Proceso;

/**
 * @author CesarJ
 */
public class E_Listo extends Hilo_estado {
	
        public E_Listo(Controlador_proc Conpr,Impresor im){
            super(Conpr);
            this.im=im;
        }
    
	public void run() {
		Proceso p;
                System.out.println("Un hilo Listo a sido creado");
		while(true) {
			if(Fila_Procesos()){
				synchronized(this) {
                                    try {
                                        wait();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(E_Listo.class.getName()).log(Level.SEVERE, null, ex);
                                    }
				}
			} else {
				p = Quitar_Procesos();
                                imprimir_listo(p.getArchivo());
                            try {
                                sleep(p.getTiempoLt());
                                Conpr.Ejecucion(p);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(E_Listo.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
	}
}