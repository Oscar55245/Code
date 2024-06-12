package proyecto;

// @author Danny

import java.util.Objects;

public class Habitacion {
private int NoH;
private String Tipo;
private int Capacidad;
private String Estatus;
private int Costo;
private String PISO;
private String CUARTOS;
private String Foto;
private String CAMAS;
private String BAÑOS;
private String AC;
private String TV;

    public Habitacion() {
        
    }
    public Habitacion(int NoH, String Tipo, int Capacidad, String Estatus, int Costo, String PISO, String CUARTOS, String Foto, String CAMAS, String BAÑOS, String AC, String TV) {
        this.NoH = NoH;
        this.Tipo = Tipo;
        this.Capacidad = Capacidad;
        this.Estatus = Estatus;
        this.Costo = Costo;
        this.PISO = PISO;
        this.CUARTOS = CUARTOS;
        this.Foto = Foto;
        this.CAMAS = CAMAS;
        this.BAÑOS = BAÑOS;
        this.AC = AC;
        this.TV = TV;
    }
    public int getNoH() {
        return NoH;
    }
    public void setNoH(int NoH) {
        this.NoH = NoH;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    public int getCapacidad() {
        return Capacidad;
    }
    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }
    public String getEstatus() {
        return Estatus;
    }
    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }
    public int getCosto() {
        return Costo;
    }
    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    public String getPISO() {
        return PISO;
    }
    public void setPISO(String PISO) {
        this.PISO = PISO;
    }
    public String getCUARTOS() {
        return CUARTOS;
    }
    public void setCUARTOS(String CUARTOS) {
        this.CUARTOS = CUARTOS;
    }
    public String getFoto() {
        return Foto;
    }
    public void setFoto(String Foto) {
        this.Foto = Foto;
    }
    public String getCAMAS() {
        return CAMAS;
    }
    public void setCAMAS(String CAMAS) {
        this.CAMAS = CAMAS;
    }
    public String getBAÑOS() {
        return BAÑOS;
    }
    public void setBAÑOS(String BAÑOS) {
        this.BAÑOS = BAÑOS;
    }
    public String getAC() {
        return AC;
    }
    public void setAC(String AC) {
        this.AC = AC;
    }
    public String getTV() {
        return TV;
    }
    public void setTV(String TV) {
        this.TV = TV;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.NoH;
        hash = 53 * hash + Objects.hashCode(this.Tipo);
        hash = 53 * hash + this.Capacidad;
        hash = 53 * hash + Objects.hashCode(this.Estatus);
        hash = 53 * hash + this.Costo;
        hash = 53 * hash + Objects.hashCode(this.PISO);
        hash = 53 * hash + Objects.hashCode(this.CUARTOS);
        hash = 53 * hash + Objects.hashCode(this.Foto);
        hash = 53 * hash + Objects.hashCode(this.CAMAS);
        hash = 53 * hash + Objects.hashCode(this.BAÑOS);
        hash = 53 * hash + Objects.hashCode(this.AC);
        hash = 53 * hash + Objects.hashCode(this.TV);
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
        final Habitacion other = (Habitacion) obj;
        if (this.NoH != other.NoH) {
            return false;
        }
        if (this.Capacidad != other.Capacidad) {
            return false;
        }
        if (this.Costo != other.Costo) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.Estatus, other.Estatus)) {
            return false;
        }
        if (!Objects.equals(this.PISO, other.PISO)) {
            return false;
        }
        if (!Objects.equals(this.CUARTOS, other.CUARTOS)) {
            return false;
        }
        if (!Objects.equals(this.Foto, other.Foto)) {
            return false;
        }
        if (!Objects.equals(this.CAMAS, other.CAMAS)) {
            return false;
        }
        if (!Objects.equals(this.BAÑOS, other.BAÑOS)) {
            return false;
        }
        if (!Objects.equals(this.AC, other.AC)) {
            return false;
        }
        return Objects.equals(this.TV, other.TV);
    }
    @Override
    public String toString() {
        return "Habitacion{" + "NoH=" + NoH + ", Tipo=" + Tipo + ", Capacidad=" + Capacidad + ", Estatus=" + Estatus + ", Costo=" + Costo + ", PISO=" + PISO + ", CUARTOS=" + CUARTOS + ", Foto=" + Foto + ", CAMAS=" + CAMAS + ", BA\u00d1OS=" + BAÑOS + ", AC=" + AC + ", TV=" + TV + '}';
    }

   


}
