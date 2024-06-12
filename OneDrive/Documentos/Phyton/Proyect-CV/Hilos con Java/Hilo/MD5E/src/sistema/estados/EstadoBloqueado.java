package sistema.estados;

import modelo.HiloEstado;
import modelo.Proceso;

public class EstadoBloqueado extends HiloEstado {
	public static final String BLOQUEO_LECTURA = "read";
	public static final String BLOQUEO_ESCRITURA = "write";
	public static final String BLOQUEO_ENVIO = "send";
	public static final String BLOQUEO_RECEPCION = "receive";
	public void run() {
		Proceso p;
		while(true) {
			if(colaProcesosVacia()){
				synchronized(this) {
					notify();
				}
			} else {
				p = desencolarProceso();
				imprimirMensaje("Proceso "+p.obtenerImagen()+" bloqueado por "+
				p.obtenerRazonBloqueo());
				pausar(p.obtenerTiempoBloqueo());
			}
		}
	}
}
