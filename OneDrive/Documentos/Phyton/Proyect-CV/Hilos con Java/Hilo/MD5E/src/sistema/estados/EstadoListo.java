package sistema.estados;

import modelo.HiloEstado;
import modelo.Proceso;

public class EstadoListo extends HiloEstado {
	
	private static final long TIEMPO_MINIMO = 1;

	public void run() {
		Proceso p;
		while(true) {
			if(colaProcesosVacia()){
				synchronized(this) {
					notify();
				}
			} else {
				verProcesosEncolados();
				p = desencolarProceso();
				pausar(TIEMPO_MINIMO);
				manejadorProcesos.ejecutar(p);
			}
		}
	}
}
