package Controlador;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class EstadoHilo extends Thread {

    public PriorityQueue<proceso> listaProcesos;
    private boolean hilo1Activo;
    public PlanificadorProcesos planificador;

    public EstadoHilo(PlanificadorProcesos planificador) {
        this.planificador = planificador;
        listaProcesos = new PriorityQueue<proceso>();
    }

    public void agregarProceso(proceso p) {
        listaProcesos.add(p);
    }

    public proceso extraerProceso() {
        return listaProcesos.poll();
    }

    public void Remove(proceso p){
       listaProcesos.remove(p);
    }
    public void suspender() {
        hilo1Activo = !hilo1Activo;
    }

    protected boolean listaProcesosEmpty() {
        return listaProcesos.isEmpty();
    }

    protected void detener() {
        synchronized (this) {
            try {
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(EstadoInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
