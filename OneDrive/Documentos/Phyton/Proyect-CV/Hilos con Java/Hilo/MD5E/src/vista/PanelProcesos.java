package vista;

import java.awt.GridLayout;
import java.awt.Panel;

import modelo.HiloEstado;
import sistema.BloqueControlProcesos.ManejadorProcesos;
import sistema.estados.EstadoBloqueado;
import sistema.estados.EstadoEjecucion;
import sistema.estados.EstadoInicio;
import sistema.estados.EstadoListo;
import sistema.estados.EstadoTerminado;

public class PanelProcesos extends Panel{
	private static final long serialVersionUID = 1L;
	private static final int MAX_ESTADOS = 5;
	private ManejadorProcesos manejadorProcesos;
	
	public PanelProcesos() {
		setLayout(new GridLayout(2, 4));
		manejadorProcesos = new ManejadorProcesos(agregarEstados());
        add(new FrameAltaProceso(manejadorProcesos));
	}


	private HiloEstado[] agregarEstados() {
		FrameEstado[] estados= new FrameEstado[MAX_ESTADOS];
		String[] nombreEstados = new String[MAX_ESTADOS];
		HiloEstado[] hilos = new HiloEstado[MAX_ESTADOS];
		
		nombreEstados[HiloEstado.ESTADO_INICIO] = "Inicio";
		nombreEstados[HiloEstado.ESTADO_LISTO] = "Listo";
		nombreEstados[HiloEstado.ESTADO_EJECUCION] = "Ejecucion";
		nombreEstados[HiloEstado.ESTADO_TERMINADO] = "Terminado";
		nombreEstados[HiloEstado.ESTADO_BLOQUEADO] = "Bloqueado";
		
		hilos[HiloEstado.ESTADO_INICIO] = new EstadoInicio();
		hilos[HiloEstado.ESTADO_LISTO] = new EstadoListo();
		hilos[HiloEstado.ESTADO_EJECUCION] = new EstadoEjecucion();
		hilos[HiloEstado.ESTADO_TERMINADO] = new EstadoTerminado();
		hilos[HiloEstado.ESTADO_BLOQUEADO] = new EstadoBloqueado();
        
        for (int i = 0; i<MAX_ESTADOS; i++) {
        	estados[i] = new FrameEstado(nombreEstados[i]);
        	hilos[i].establecerImpresor(estados[i]);
			estados[i].establecerHilo(hilos[i]);
			hilos[i].start();
			add(estados[i]);
        }
        return hilos;
	}
}
