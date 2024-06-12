
package modelo5estados;

import java.util.ArrayList;

/**
 *
 * @author CesarJ
 */
public class Proceso {
    
    private String Archivo;
    private int LapsoE;
    private int TiempoE;
    private int TiempoB;
    private int TiempoIn;
    private int TiempoLt;
    
    ArrayList<Instruccion>instruccion;

    public void LProceso(String Archivo, int LapsoE, int TiempoE, int TiempoB, int TiempoIn, int TiempoLt, ArrayList<Instruccion> instruccion) {
        this.Archivo = Archivo;
        this.LapsoE = LapsoE;
        this.TiempoE = TiempoE;
        this.TiempoB = TiempoB;
        this.TiempoIn = TiempoIn;
        this.TiempoIn = TiempoLt;
        this.instruccion = instruccion;
    }

    public String getArchivo() {
        return Archivo;
    }

    public void setArchivo(String Archivo) {
        this.Archivo = Archivo;
    }

    public int getLapsoE() {
        return LapsoE;
    }

    public void setLapsoE(int LapsoE) {
        this.LapsoE = LapsoE;
    }

    public int getTiempoE() {
        return TiempoE;
    }

    public void setTiempoE(int TiempoE) {
        this.TiempoE = TiempoE;
    }

    public int getTiempoB() {
        return TiempoB;
    }

    public void setTiempoB(int TiempoB) {
        this.TiempoB = TiempoB;
    }

    public int getTiempoIn() {
        return TiempoIn;
    }

    public void setTiempoIn(int TiempoIn) {
        this.TiempoIn = TiempoIn;
    }

    public ArrayList<Instruccion> getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(ArrayList<Instruccion> instruccion) {
        this.instruccion = instruccion;
    }

    public int getTiempoLt() {
        return TiempoLt;
    }

    public void setTiempoLt(int TiempoLt) {
        this.TiempoLt = TiempoLt;
    }
    
    
}
