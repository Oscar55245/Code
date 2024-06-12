package Controlador;
import model.Impresor;

public class PlanificadorProcesos {
    private EstadoHilo[] estados;
    private final static int MAX_ESTADOS = 5;
    private final int ESTADOS_INICIO = 0; 
    private final int ESTADOS_LISTO = 1; 
    private final int ESTADOS_EJECUTAR = 2; 
    private final int ESTADOS_BLOQUEO = 3; 
    private final int ESTADOS_TERMINADO = 4;
    public static Lapso lapso;
    public PlanificadorProcesos(Impresor impresor) {
        lapso = new Lapso();
        estados = new EstadoHilo[] {
            new EstadoInicio(this,impresor),
            new EstadoListo(this,impresor),
            new EstadoEjecutar(this,impresor),
            new EstadoBloqueo(this, impresor),
            new EstadoTerminado(this, impresor),
            
        };
        for(int i = 0; i<MAX_ESTADOS; i++) {
            estados[i].start();
        }
    }
    public void IniciarLapso(int lap){
        lapso.getLapso(lap);
        lapso.start();
    
    };
    public void  agregarInicio(proceso p) {
        EstadoHilo estado = estados[ESTADOS_INICIO];
        estado.agregarProceso(p);
        notificar(estado);
    }
    public void agregarListo(proceso p) {
        EstadoHilo estado = estados[ESTADOS_LISTO];
        estado.agregarProceso(p);
        notificar(estado);
    }
    public void agregarEjecutar(proceso p) {
        EstadoHilo estado = estados[ESTADOS_EJECUTAR];
        estado.agregarProceso(p);
        notificar(estado);
    }
    public void agregarBloqueo(proceso p) {
        EstadoHilo estado = estados[ESTADOS_BLOQUEO];
        estado.agregarProceso(p);
        notificar(estado);
       
    }
    public void agregarTerminar(proceso p) {
        EstadoHilo estado = estados[ESTADOS_TERMINADO];
        estado.agregarProceso(p);
        notificar(estado);
    }
    
    public void notificar(EstadoHilo estado){
     synchronized (estado) {
            estado.notify();
     }}}
