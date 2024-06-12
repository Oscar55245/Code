
package Controlador;

import java.util.ArrayList;
import java.util.Objects;


public class proceso {
    
    private int tiempoEjecucion;
    private int tiempoInicio;
    private int lapsoEjecucion;
    private int tiempoBloqueo;
    private int id;
    private String nombre;
    private ArrayList<Instruccion> I_final;
    private boolean  bloqueo;
    public void hiloProceso(ArrayList<Instruccion> I_final,int tiempoEjecucion,int tiempoInicio,int lapsoEjecucion,
    int tiempoBloqueo, int id, String nombre, boolean  bloqueo){
    this.id=id;
    this.lapsoEjecucion=lapsoEjecucion;
    this.tiempoBloqueo=tiempoBloqueo;
    this.tiempoEjecucion=tiempoEjecucion;
    this.tiempoInicio=tiempoInicio;
    this.I_final = I_final;
    this.nombre = nombre;
    this.bloqueo = bloqueo;
    }

    public ArrayList<Instruccion> getI_final() {
        return I_final;
    }

    public void setI_final(ArrayList<Instruccion> I_final) {
        this.I_final = I_final;
    }
    public int gettiempoEjecucion() {
        return tiempoEjecucion;
    }
    public void settiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }
    public void settiempoInicio(int tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }
    public int gettiempoInicio() {
        return tiempoInicio;
    }
    public void settiempoBloqueo(int tiempoBloqueo) {
        this.tiempoBloqueo = tiempoBloqueo;
    }
    public int gettiempoBloqueo() {
        return tiempoBloqueo;
    }
    public void setlapsoEjecucion(int lapsoEjecucion) {
        this.lapsoEjecucion = lapsoEjecucion;
    }
    public int getlapsoEjecucion() {
        return lapsoEjecucion;
    }
    public void setid(int id) {
        this.id= id;
    }
    public int getid() {
        return id;
    
    }
    public void setnombre(String nombre) {
        this.nombre= nombre;
    }
    public String getnombre() {
        return nombre;
    
    }

    public boolean getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.tiempoEjecucion;
        hash = 37 * hash + this.tiempoInicio;
        hash = 37 * hash + this.lapsoEjecucion;
        hash = 37 * hash + this.tiempoBloqueo;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.I_final);
        hash = 37 * hash + (this.bloqueo ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final proceso other = (proceso) obj;
        if (this.tiempoEjecucion != other.tiempoEjecucion) {
            return false;
        }
        if (this.tiempoInicio != other.tiempoInicio) {
            return false;
        }
        if (this.lapsoEjecucion != other.lapsoEjecucion) {
            return false;
        }
        if (this.tiempoBloqueo != other.tiempoBloqueo) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.bloqueo != other.bloqueo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.I_final, other.I_final);
    }

    @Override
    public String toString() {
        return "proceso{" + "tiempoEjecucion=" + tiempoEjecucion + ", tiempoInicio=" + tiempoInicio + ", lapsoEjecucion=" + lapsoEjecucion + ", tiempoBloqueo=" + tiempoBloqueo + ", id=" + id + ", nombre=" + nombre + ", I_final=" + I_final + ", bloqueo=" + bloqueo + '}';
    }

 

    
}
