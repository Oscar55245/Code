package proyecto;

// @author Danny

import java.util.Date;

public class Reservacion {
    private int Folio;
    private int cliente;
    private String Nombre;
    private String estatus;
    private int ocupantes;
    private String Extras;
    private Date FechaE;
    private Date FechaS;
    private String habitacion;
    private int costo;

      public Reservacion () {
      
      }

    public Reservacion(int Folio) {
        this.Folio = Folio;
    }

    public Reservacion(int Folio, int cliente, String Nombre, String estatus, int ocupantes, String Extras, Date FechaE, Date FechaS, String habitacion, int costo) {
        this.Folio = Folio;
        this.cliente = cliente;
        this.Nombre = Nombre;
        this.estatus = estatus;
        this.ocupantes = ocupantes;
        this.Extras = Extras;
        this.FechaE = FechaE;
        this.FechaS = FechaS;
        this.habitacion = habitacion;
        this.costo = costo;
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
    }

    public String getExtras() {
        return Extras;
    }

    public void setExtras(String Extras) {
        this.Extras = Extras;
    }

    public Date getFechaE() {
        return FechaE;
    }

    public void setFechaE(Date FechaE) {
        this.FechaE = FechaE;
    }

    public Date getFechaS() {
        return FechaS;
    }

    public void setFechaS(Date FechaS) {
        this.FechaS = FechaS;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.Folio;
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
        final Reservacion other = (Reservacion) obj;
        if (this.Folio != other.Folio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RESERVACION{" + "Folio=" + Folio + ", cliente=" + cliente + ", Nombre=" + Nombre + ", estatus=" + estatus + ", ocupantes=" + ocupantes + ", Extras=" + Extras + ", FechaE=" + FechaE + ", FechaS=" + FechaS + ", habitacion=" + habitacion + ", Costo=" + costo + '}';
    }
      
    
   

    
}
    

    