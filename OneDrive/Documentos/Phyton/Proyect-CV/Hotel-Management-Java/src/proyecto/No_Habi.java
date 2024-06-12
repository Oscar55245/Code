
package proyecto;

public class No_Habi {
  private int habitacionNO;
private int costo;  

    public No_Habi(int habitacionNO, int costo) {
        this.habitacionNO = habitacionNO;
        this.costo =  costo ;
    }

    No_Habi() {
        
    }

    public int getHabitacionNO() {
        return habitacionNO;
    }

    public void setHabitacionNO(int habitacionNO) {
        this.habitacionNO = habitacionNO;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.habitacionNO;
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
        final No_Habi other = (No_Habi) obj;
        if (this.habitacionNO != other.habitacionNO) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "No_Habi{" + "habitacionNO=" + habitacionNO + ", costo=" + costo + '}';
    }

    
  
}

