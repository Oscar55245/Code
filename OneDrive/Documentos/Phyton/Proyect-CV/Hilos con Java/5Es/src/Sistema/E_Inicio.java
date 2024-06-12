

package Sistema;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo5estados.Proceso;

/**
 * @author CesarJ
 */
public class E_Inicio extends Hilo_estado {
        Impresor impresor;
	public E_Inicio(Controlador_proc Conpr, Impresor im){
            super(Conpr);
           this.im=im;
        }
	public void run() {
		Proceso p;
                System.out.println("Un hilo de Ejecucion a sido creado");
		while(true) {
			if(Fila_Procesos()){
				synchronized(this) {
                                    try {
                                        wait();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(E_Inicio.class.getName()).log(Level.SEVERE, null, ex);
                                    }
				}
			} else {
				p = Quitar_Procesos();
                                imprimir_inicio(p.getArchivo());
                            try {
                                sleep(p.getTiempoIn());
                                Conpr.Listo(p);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(E_Inicio.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
	}
}
