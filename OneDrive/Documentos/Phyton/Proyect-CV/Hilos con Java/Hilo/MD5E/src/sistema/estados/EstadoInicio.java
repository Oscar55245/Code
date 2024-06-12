package sistema.estados;

import modelo.HiloEstado;
import modelo.Proceso;

public class EstadoInicio extends HiloEstado{
	
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
				pausar(p.obtenerTiempoInicio());
				manejadorProcesos.listar(p);
			}
		}
	}

}
