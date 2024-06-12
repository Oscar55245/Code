package modelo;

import java.io.File;


public class Proceso implements Cloneable {
	public static final String DELIMITADOR_INSTRUCCIONES = "|";
	private int pid;
	private File proceso;
	private int tiempoEjecucion;
	private int lapsoEjecucion;
	private int tiempoInicio;
	private int tiempoBloqueo;
	private String razonBloqueo;
	
		
	public Proceso(File proceso) {
		this.proceso = proceso;
	}
	
	public void establecerId(int id) {
		this.pid = id;
	}
	
	public int obtenerId() {
		return pid;
	}
	
	public String obtenerImagen() {
		return proceso.getName();
	}
	
	public void establecerTiempoEjecucion(int tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	
	public void establecerLapsoEjecucion(int lapsoEjecucion) {
		this.lapsoEjecucion = lapsoEjecucion;
	}
	public void establecerTiempoInicio(int tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}
	public void establecerTiempoBloqueo(int tiempoBloqueo) {
		this.tiempoBloqueo = tiempoBloqueo;
	}

	public int obtenerTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public int obtenerLapsoEjecucion() {
		return lapsoEjecucion;
	}

	public int obtenerTiempoInicio() {
		return tiempoInicio;
	}

	public int obtenerTiempoBloqueo() {
		return tiempoBloqueo;
	}
	public File obtenerInstrucciones() {
		return proceso;
	}

	public String obtenerRazonBloqueo() {
		return razonBloqueo;
	}

	public void establecerRazonBloqueo(String mensaje) {
		this.razonBloqueo = mensaje;
		
	}
	
	@Override
	public String toString() {
		return pid+DELIMITADOR_INSTRUCCIONES+obtenerImagen();
	}
	
	@Override
	public Object clone(){
		Object clon;
		try {
			clon = super.clone();
		} catch (CloneNotSupportedException e) {
			clon = null;
		}
		return clon;
	}
}
