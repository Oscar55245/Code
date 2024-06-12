package Controlador;

import static java.lang.Thread.sleep;
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
            if (listaProcesosEmpty()||EstadoBloqueo.block==true||Lapso.finLapso==true) {
                detener();
            }else {
                proceso p = extraerProceso();
//               planificador.IniciarLapso(p.getlapsoEjecucion());
                for (int i = 0; i < p.getI_final().size(); i++) {
                    if (i==1&&p.getBloqueo()&&!Lapso.finLapso==true) {
                        planificador.agregarBloqueo(p);
                        p.getI_final().remove(i-1);
                    }else{
                        for (int j=0;j<Integer.parseInt(p.getI_final().get(i).getNumero());j++) {
                               impresor.imprimirContador(p.getI_final().get(i).getImpresion()+" - "+p.getnombre());
                               try {
                                   sleep(p.gettiempoEjecucion());
                               } catch (InterruptedException ex) {
                               }
                           }
                     if (p.getI_final().size()==1){
                         planificador.agregarTerminar(p);
                     }
//                        if (Lapso.finLapso==true) {
//                            planificador.agregarTerminar(p);
//                        }
                    }
                   }
            }
        }
    }
}
