package pBase;

// @author Danny

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import proyecto.Cliente;

public class ModelCliente extends AbstractTableModel{

private ArrayList<Cliente>lista;
    private String columnas [ ]={"ID_Cliente", "Nombre","Paterno","Materno", "Telefono","Email","Nacimiento"};    
  
    public ModelCliente(ArrayList<Cliente>lista){
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
               Cliente e = lista.get((i)); // i = renglon  // i1 = columnas
        switch(i1){
            case 0:
                return e.getID_Cliente();
            case 1:
                return e.getNombre();
            case 2:
                return e.getPaterno();
            case 3:
                return e.getMaterno();
            case 4:
                return e.getTelefono();
            case 5:
                return e.getEmail();
            case 6:
                return e.getNacimiento();
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
