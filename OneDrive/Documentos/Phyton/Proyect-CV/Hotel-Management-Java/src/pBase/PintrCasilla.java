/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pBase;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author CesarJ
 */
public class PintrCasilla extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        JLabel labelResultado = (JLabel) super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); 
        if(o instanceof String){
            String Dato= (String)o;
            if(Dato.equals("ACTIVO")){
                labelResultado.setBackground(Color.blue);
                labelResultado.setForeground(Color.black);
            }else
            if(Dato.equals("PENDIENTE")){
                labelResultado.setBackground(Color.red);
                labelResultado.setForeground(Color.black);
            }else
                if(Dato.equals("COMPLETADO")){
                    labelResultado.setBackground(Color.green);
                labelResultado.setForeground(Color.black);
                
            }else
                if(Dato.equals("EN CURSO")){
                    labelResultado.setBackground(Color.ORANGE);
                labelResultado.setForeground(Color.black);
                }
            
        }
        return labelResultado;
        
    }
    
    
    
}
    