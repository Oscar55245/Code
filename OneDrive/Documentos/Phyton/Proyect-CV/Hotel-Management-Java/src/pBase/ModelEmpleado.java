package pBase;

// @author Danny

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import proyecto.Empleado;


public class ModelEmpleado extends AbstractTableModel {

    private ArrayList<Empleado> lista;
    private String[] columnas = {"ID", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "TELEFONO", "PUESTO"};

    public ModelEmpleado(ArrayList<Empleado> lista) {
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
    public Object getValueAt(int r, int c) { // primerValor Renglon, segundoValor Columna
        Empleado e = lista.get(r);
        switch (c){
            case 0:
                return e.getID();
            case 1:
                return e.getNombre();
            case 2:
                return e.getPaterno();
            case 3:
                return e.getMaterno();
            case 4:
                return e.getTelefono();
            case 5:
                return e.getPuesto();
            case 6:
                return e.getUsuario();
            default: 
                return "";
        }    
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }
}
