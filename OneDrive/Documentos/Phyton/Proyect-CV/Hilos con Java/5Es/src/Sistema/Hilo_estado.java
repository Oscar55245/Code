
package Sistema;

/**
 * @author CesarJ
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Sistema.Controlador_proc;
import modelo5estados.Proceso;

public abstract class Hilo_estado extends Thread {
	public static final long SEGUNDO = 1000;
	public static final int ESTADO_INICIO = 0;
	public static final int ESTADO_LISTO = 1;
	public static final int ESTADO_EJECUCION = 2;
	public static final int ESTADO_TERMINADO = 3;
	public static final int ESTADO_BLOQUEADO = 4;
	private Queue<Proceso> fila;
	public Controlador_proc Conpr;
	Impresor im;
        
        public void imprimir_inicio(String archivo){
            im.inicio(archivo);
        }
        public void imprimir_listo(String archivo){
            im.listo(archivo);
        }
        public void imprimir_ejecucion(String archivo){
            im.ejecucion(archivo);
        }
        public void imprimir_bloqueo(String archivo){
            im.bloqueo(archivo);
        }
        public void imprimir_terminado(String archivo){
            im.terminado(archivo);
        }
        public void setimpresor(Impresor im){
            this.im = im;
        }
        
	public Hilo_estado(Controlador_proc Conpr) {
		fila = new LinkedList<Proceso>();
                this.Conpr = Conpr;
	}

	
	public Proceso Quitar_Procesos() {
		return fila.poll();
	}
	
	public boolean Fila_Procesos() {
		return fila.isEmpty();
	}
	
	public boolean agregarProceso(Proceso p) {
		return fila.add(p);
	}
	
}
