package Controlador;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Impresor;

public class EstadoEjecutar extends EstadoHilo {

    Impresor impresor;
    int conteoIntruccion=0;

    public EstadoEjecutar(PlanificadorProcesos planificador, Impresor impresor) {
        super(planificador);
        this.impresor = impresor;
    }

    public void run() {
        while (true) {
            if (listaProcesosEmpty()||EstadoBloqueo.block==true) {
                detener();
            }else {
                proceso p = extraerProceso();
                for (int i = 0; i < p.getI_final().size(); i++) {
                    if (i==1&&p.getBloqueo()) {
                        planificador.agregarBloqueo(p);
                        p.getI_final().remove(i-1);
                    }else{
                    for (int j=0;j<Integer.parseInt(p.getI_final().get(i).getNumero());j++) {
                        impresor.imprimirContador(p.getI_final().get(i).getImpresion());
                        try {
                            sleep(p.gettiempoEjecucion());
                        } catch (InterruptedException ex) {
                            
                        }
                    }
                    if (p.getI_final().size()==1) {
                            planificador.agregarTerminar(p);
                        }
                    }
                }
                
            }
        }
    }
}
