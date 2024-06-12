package pBase;

// @author Danny

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import proyecto.Tickets;

public class ModelTickets extends AbstractTableModel{

private ArrayList<Tickets>lista;
    private String columnas [ ]={"No_Folio", "Tipo","Descripcion","Emision", "Habitacion","Empleado","Status","Resolucion"};    
  
    public ModelTickets(ArrayList<Tickets>lista){
        this.lista = lista;
    }        
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
                Tickets e = lista.get((i)); // i = renglon  // i1 = columnas
        switch(i1){
            case 0:
                return e.getNo_Folio();
            case 1:
                return e.getTipo();
            case 2:
                return e.getDescripcion();
            case 3:
                return e.getEmision();
            case 4:
                return e.getHabitacion();
            case 5:
                return e.getEmpleado();
            case 6:
                return e.getStatus();
            case 7:
                return e.getResolucion();
            default:
                return "";
        }
    }
 
@Override
public void fireTableDataChanged(){
    super.fireTableDataChanged();
}

@Override
public String getColumnName(int i){
    return columnas[i];
}

}
