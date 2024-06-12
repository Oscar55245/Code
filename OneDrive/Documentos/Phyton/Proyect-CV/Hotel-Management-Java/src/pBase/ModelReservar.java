package pBase;

// @author Danny

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import proyecto.Reservacion;
import proyecto.Reservacion;

public class ModelReservar extends AbstractTableModel{
    private  ArrayList<Reservacion> lista;
    private  String columnas []={"ID","Cliente","Nombre","Estado","F.Salida","F.Entrada","Habitacion"};

    public ModelReservar(ArrayList<Reservacion> lista) {
        this.lista = lista;
    }
            
    
    public int getRowCount() {
     return lista.size();
    }

    
    public int getColumnCount() {
    return  columnas.length;      
    }

    public Object getValueAt(int i, int i1) {
       Reservacion e = lista.get(i);// i =  renglon // i1 = Columna
       switch(i1){
               case 0: 
                   return e.getFolio();
               case 1 :
                   return e.getCliente();
               case 2:
                   return e.getNombre();
               case 3: 
                   return e.getEstatus();
               case 4:
                   return e.getFechaE();
               case 5:
                   return e.getFechaS();
               case 6:
                   return e.getHabitacion();
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
