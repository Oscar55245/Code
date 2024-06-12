package sistema.estados;

import modelo.HiloEstado;
import modelo.Proceso;

public class EstadoTerminado extends HiloEstado {

	public void run() {
		Proceso p;
		while(true) {
			if(colaProcesosVacia()){
				synchronized(this) {
					notify();
				}
			} else {
				p = desencolarProceso();
				imprimirMensaje(p+" terminado");
			}
		}
	}
}
