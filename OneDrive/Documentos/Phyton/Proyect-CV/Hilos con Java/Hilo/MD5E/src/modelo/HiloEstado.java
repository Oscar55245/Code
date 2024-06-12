package modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import sistema.BloqueControlProcesos.ManejadorProcesos;

public abstract class HiloEstado extends Thread {
	public static final long SEGUNDO = 1000;
	public static final int ESTADO_INICIO = 0;
	public static final int ESTADO_LISTO = 1;
	public static final int ESTADO_EJECUCION = 2;
	public static final int ESTADO_TERMINADO = 3;
	public static final int ESTADO_BLOQUEADO = 4;

	private Impresor impresor;
	private Queue<Proceso> cola;
	public ManejadorProcesos manejadorProcesos;

	
	public HiloEstado() {
		cola = new LinkedList<Proceso>();
	}

	public void verProcesosEncolados() {
		Iterator<Proceso> i = cola.iterator();
		String s = "";
		while(i.hasNext()) {
			s+=i.next();
		}
		imprimirMensaje(s);
	}
	
	
	public void pausar(long tiempo) {
		try {
			synchronized(this) {
				wait(SEGUNDO*tiempo);
			}
		} catch (InterruptedException e) {
			imprimirMensaje(e.getMessage());
		}
	}

	
	public Proceso desencolarProceso() {
		return cola.poll();
	}
	
	public boolean colaProcesosVacia() {
		return cola.isEmpty();
	}
	
	public boolean agregarProceso(Proceso p) {
		return cola.add(p);
	}
	
	
	public void establecerManProcesos(ManejadorProcesos manejadorProcesos) {
		this.manejadorProcesos = manejadorProcesos;
	}
	
	public void establecerImpresor(Impresor impresor) {
		this.impresor = impresor;
	}
	
	public void imprimirMensaje(String s) {
		impresor.imprimirln(s+"\n");
	}
}
