package sistema.estados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import modelo.HiloEstado;
import modelo.Proceso;

public class EstadoEjecucion extends HiloEstado {

	public void run() {
		Proceso p;
		int tiempoEjecucion;
		while(true) {
			if(colaProcesosVacia()){
				synchronized(this) {
					notify();
				}
			} else {
				p = desencolarProceso();
				imprimirMensaje("Procesos actual "+"\n"+p);
				tiempoEjecucion = 0;
				while(tiempoEjecucion < p.obtenerLapsoEjecucion()) {
					ejecutarPrograma(p);
					tiempoEjecucion++;
				}
				manejadorProcesos.terminar(p);
			}
		}
	}



	private void ejecutarPrograma(Proceso p) {
		String s;
		String mensaje;
		BufferedReader in = null;
		int contadorInstrucciones, idx;
		try {
			in=new BufferedReader(new FileReader(p.obtenerInstrucciones()));
			s = in.readLine();
			while(s!=null){
				idx=s.indexOf(Proceso.DELIMITADOR_INSTRUCCIONES);
				if(idx == -1){
					idx = s.length();
				}
				mensaje = s.substring(0, idx);
				if(esBloqueable(mensaje)) {
					p.establecerRazonBloqueo(mensaje);
					manejadorProcesos.bloquear(p);
					
				} else {
					contadorInstrucciones = Integer.valueOf(s.substring(mensaje.length()+1));
					for(int i = 0; i<contadorInstrucciones; i++) {
						imprimirMensaje(mensaje);
						sleep(SEGUNDO*p.obtenerTiempoEjecucion());
					}
				}
				s=in.readLine();
			}
			in.close();
		} catch (IOException | InterruptedException e) {
			imprimirMensaje(e.getMessage());
		}
	}



	private boolean esBloqueable(String mensaje) {
		boolean bloquearProceso;
		switch(mensaje) {
		case EstadoBloqueado.BLOQUEO_ENVIO:
		case EstadoBloqueado.BLOQUEO_ESCRITURA:
		case EstadoBloqueado.BLOQUEO_LECTURA:
		case EstadoBloqueado.BLOQUEO_RECEPCION:
			bloquearProceso = true;
			break;
		default:
			bloquearProceso = false;
		}
		return bloquearProceso;
	}
}
