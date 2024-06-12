
package modelo5estados;

import java.util.ArrayList;
public class definir_proc {
    
    
    public Proceso Obtener_proc(String Archivo, int LapsoE, int TiempoE, int TiempoB, int TiempoIn, int TiempoLt){
        Proceso p = new Proceso();
        p.setArchivo(Archivo);
        p.setTiempoB(TiempoB);
        p.setTiempoE(TiempoE);
        p.setTiempoIn(TiempoIn);
        p.setTiempoLt(TiempoLt);
        return p;
    }
}
