package sistema.BloqueControlProcesos;

import java.io.File;
import java.util.ArrayList;

import modelo.HiloEstado;
import modelo.Proceso;

public class ManejadorProcesos {
	private String DIRECTORIO_PROCESOS = "ejecutables";
	
	private ArrayList<Proceso> listaEjecutables;
	private int pid;
	private HiloEstado[] estados;

	public ManejadorProcesos(HiloEstado[] estados) {
		listaEjecutables = new ArrayList<>();
		File[] directorio = new File(DIRECTORIO_PROCESOS).listFiles();
		if(directorio!=null){
			for(File f:directorio){
				listaEjecutables.add(new Proceso(f));
			}
		}

		pid = 1;
		this.estados = estados;
		for(HiloEstado f:estados) {
			f.establecerManProcesos(this);
		}
	}

	public ArrayList<Proceso> listarProcesosDisponibles() {
		return listaEjecutables;
	}

	public void iniciar(Proceso p, int tiemEjecucion,int lapsoEjecucion,
			int tiemInicio, int tiemBloqueo) {
		p.establecerId(pid++);
		p.establecerTiempoEjecucion(tiemEjecucion);
		p.establecerLapsoEjecucion(lapsoEjecucion);
		p.establecerTiempoInicio(tiemInicio);
		p.establecerTiempoBloqueo(tiemBloqueo);
		estados[HiloEstado.ESTADO_INICIO].agregarProceso(p);
	}

	public void listar(Proceso p) {
		estados[HiloEstado.ESTADO_LISTO].agregarProceso(p);
	}

	public void ejecutar(Proceso p) {
		estados[HiloEstado.ESTADO_EJECUCION].agregarProceso(p);
		
	}

	public void bloquear(Proceso p) {
		estados[HiloEstado.ESTADO_BLOQUEADO].agregarProceso(p);
	}

	public void terminar(Proceso p) {
		estados[HiloEstado.ESTADO_TERMINADO].agregarProceso(p);	
	}
}
