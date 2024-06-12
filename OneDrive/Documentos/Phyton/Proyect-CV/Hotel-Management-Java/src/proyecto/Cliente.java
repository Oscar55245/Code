package proyecto;

// @author Danny
import java.util.Date;
import java.util.Objects;

public class Cliente {

    private int ID_Cliente;
    private String Nombre;
    private String Paterno;
    private String Materno;
    private String Telefono;
    private String Email;
    private String opcEmail;
    private Date Nacimiento;
    private String Estado;

    public Cliente() {
    }

    public Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public Cliente(int ID_Cliente, String Nombre, String Paterno, String Materno, String Telefono, String Email, String opcEmail, Date Nacimiento, String Estado) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre = Nombre;
        this.Paterno = Paterno;
        this.Materno = Materno;
        this.Telefono = Telefono;
        this.Email = Email;
        this.opcEmail = opcEmail;
        this.Nacimiento = Nacimiento;
        this.Estado = Estado;
    }

    public String getOpcEmail() {
        return opcEmail;
    }

    public void setOpcEmail(String opcEmail) {
        this.opcEmail = opcEmail;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaterno() {
        return Paterno;
    }

    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    public String getMaterno() {
        return Materno;
    }

    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(Date Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ID_Cliente;
        hash = 17 * hash + Objects.hashCode(this.Nombre);
        hash = 17 * hash + Objects.hashCode(this.Paterno);
        hash = 17 * hash + Objects.hashCode(this.Materno);
        hash = 17 * hash + Objects.hashCode(this.Telefono);
        hash = 17 * hash + Objects.hashCode(this.Email);
        hash = 17 * hash + Objects.hashCode(this.opcEmail);
        hash = 17 * hash + Objects.hashCode(this.Nacimiento);
        hash = 17 * hash + Objects.hashCode(this.Estado);
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
        final Cliente other = (Cliente) obj;
        if (this.ID_Cliente != other.ID_Cliente) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Paterno, other.Paterno)) {
            return false;
        }
        if (!Objects.equals(this.Materno, other.Materno)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.opcEmail, other.opcEmail)) {
            return false;
        }
        if (!Objects.equals(this.Nacimiento, other.Nacimiento)) {
            return false;
        }
        if (!Objects.equals(this.Estado, other.Estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuarios_Cliente{" + "ID_Cliente=" + ID_Cliente
                + ", Nombre=" + Nombre + ", Paterno=" + Paterno
                + ", Materno=" + Materno + ", Telefono=" + Telefono
                + ", Email=" + Email + ", opcEmail=" + opcEmail + ", Nacimiento=" + Nacimiento + '}';
    }

}
