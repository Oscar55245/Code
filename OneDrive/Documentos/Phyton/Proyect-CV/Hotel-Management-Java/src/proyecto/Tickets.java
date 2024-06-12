package proyecto;

// @author Danny

import java.util.Date;


public class Tickets {

    private int No_Folio;
    private String Tipo;
    private String Descripcion;
    private Date Emision;
    private String Habitacion;
    private String Empleado;
    private String Status;
    private Date Resolucion;

    public Tickets(int No_Folio, String Tipo, String Descripcion, Date Emision, String Habitacion, String Empleado, String Status, Date Resolucion) {
        this.No_Folio = No_Folio;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Emision = Emision;
        this.Habitacion = Habitacion;
        this.Empleado = Empleado;
        this.Status = Status;
        this.Resolucion = Resolucion;
    }

    public Tickets(){
    }

    public int getNo_Folio() {
        return No_Folio;
    }

    public void setNo_Folio(int No_Folio) {
        this.No_Folio = No_Folio;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getEmision() {
        return Emision;
    }

    public void setEmision(Date Emision) {
        this.Emision = Emision;
    }

    public String getHabitacion() {
        return Habitacion;
    }

    public void setHabitacion(String Habitacion) {
        this.Habitacion = Habitacion;
    }

    public String getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(String Empleado) {
        this.Empleado = Empleado;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getResolucion() {
        return Resolucion;
    }

    public void setResolucion(Date Resolucion) {
        this.Resolucion = Resolucion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.No_Folio;
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
        final Tickets other = (Tickets) obj;
        if (this.No_Folio != other.No_Folio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tickets{" + "No_Folio=" + No_Folio + ", Tipo=" + Tipo + ", Descripcion=" +
                Descripcion + ", Emision=" + Emision + ", Habitacion=" + Habitacion +
                ", Empleado=" + Empleado + ", Status=" + Status + ", Resolucion=" + Resolucion + '}';
    }
    
}
