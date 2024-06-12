package pBase;

// @author Danny

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import proyecto.Habitacion;

public class ModelHabitacion extends AbstractTableModel{
    private final  ArrayList<Habitacion> lista;
    private final  String columnas []={"No. Habitación","Tipo","Capacidad","Estatus","Costo","PISO","CUARTOS","CAMAS","BAÑOS","AC","TV"};

    public ModelHabitacion(ArrayList<Habitacion> lista) {
        this.lista = lista;
    }
            
    
    public int getRowCount() {
     return lista.size();
    }

    
    public int getColumnCount() {
    return  columnas.length;      
    }

    public Object getValueAt(int i, int i1) {
       Habitacion e = lista.get(i); // i =  renglon // i1 = Columna
       switch(i1){
               case 0: 
                   return e.getNoH();
               case 1 :
                   return e.getTipo();
               case 2:
                   return e.getCapacidad();
               case 3: 
                   return e.getEstatus();
               case 4: 
                   return e.getCosto();
               case 5: 
                   return e.getPISO();
               case 6: 
                   return e.getCUARTOS();
               case 7: 
                   return e.getCAMAS();
               case 8: 
                   return e.getBAÑOS();
               case 9: 
                   return e.getAC();
               case 10: 
                   return e.getTV();
               
               default:
                   return "";
       }
    }

    public void fireTableDataChanged() {
          super.fireTableDataChanged();
    }

    public String getColumnName(int i) {
        return columnas[i];
    }
}
