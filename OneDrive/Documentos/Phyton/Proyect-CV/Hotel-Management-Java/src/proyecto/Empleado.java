package proyecto;

import java.util.Date;
import java.util.Objects;

// @author Danny

public class Empleado {
    private int ID; //Si esta ///////////////////////////////////////////////////////////// BD
    private String nombre; //Si esta ///////////////////////////////////////////////////////////// BD
    private String paterno; //Si esta ///////////////////////////////////////////////////////////// BD
    private String materno; //Si esta ///////////////////////////////////////////////////////////// BD
    private String curp; //Si esta //////////////////////////////////////////////////////////////// BD
    private String direccion; //Si esta ///////////////////////////////////////////////////////////// BD
    private String telefono; //Si esta ///////////////////////////////////////////////////////////// BD
    private String sexo; //Si esta ///////////////////////////////////////////////////////////// BD
    private String nacimiento; //Si esta ///////////////////////////////////////////////////////////// BD
    private String puesto; //Si esta ///////////////////////////////////////////////////////////// BD
    private Date ingreso; //Si esta ///////////////////////////////////////////////////////////// BD
    private String email; //Si esta ///////////////////////////////////////////////////////////// BD
    private String opcEmail; //Si esta ///////////////////////////////////////////////////////////// BD
    private String foto; //Si esta ///////////////////////////////////////////////////////////// BD
    private String status; //Si esta ///////////////////////////////////////////////////////////// BD
    private String pass; //Si esta //////////////////////////////////////////////////////////////// BD
    private String repass; //Si esta //////////////////////////////////////////////////////////////// BD
    private String usuario; //Si esta //////////////////////////////////////////////////////////////// BD
    
    
    public Empleado(){
    }

    public Empleado(int ID, String nombre, String paterno, String materno, String curp, String direccion, String telefono, String sexo, String nacimiento, String puesto, Date ingreso, String email, String opcEmail, String foto, String status, String pass, String repass, String usuario) {
        this.ID = ID;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.curp = curp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.puesto = puesto;
        this.ingreso = ingreso;
        this.email = email;
        this.opcEmail = opcEmail;
        this.foto = foto;
        this.status = status;
        this.pass = pass;
        this.repass = repass;
        this.usuario = usuario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpcEmail() {
        return opcEmail;
    }

    public void setOpcEmail(String opcEmail) {
        this.opcEmail = opcEmail;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.ID;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.paterno);
        hash = 59 * hash + Objects.hashCode(this.materno);
        hash = 59 * hash + Objects.hashCode(this.curp);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.sexo);
        hash = 59 * hash + Objects.hashCode(this.nacimiento);
        hash = 59 * hash + Objects.hashCode(this.puesto);
        hash = 59 * hash + Objects.hashCode(this.ingreso);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.foto);
        hash = 59 * hash + Objects.hashCode(this.pass);
        hash = 59 * hash + Objects.hashCode(this.repass);
        hash = 59 * hash + Objects.hashCode(this.usuario);
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
        final Empleado other = (Empleado) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.paterno, other.paterno)) {
            return false;
        }
        if (!Objects.equals(this.materno, other.materno)) {
            return false;
        }
        if (!Objects.equals(this.curp, other.curp)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.puesto, other.puesto)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.opcEmail, other.opcEmail)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        if (!Objects.equals(this.repass, other.repass)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.nacimiento, other.nacimiento)) {
            return false;
        }
        if (!Objects.equals(this.ingreso, other.ingreso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "ID=" + ID + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", curp=" + curp + ", direccion=" + direccion + ", telefono=" + telefono + ", sexo=" + sexo + ", nacimiento=" + nacimiento + ", puesto=" + puesto + ", ingreso=" + ingreso + ", email=" + email + ", opcEmail=" + opcEmail + ", foto=" + foto + ", status=" + status + ", pass=" + pass + ", repass=" + repass + ", usuario=" + usuario + '}';
    }

}
