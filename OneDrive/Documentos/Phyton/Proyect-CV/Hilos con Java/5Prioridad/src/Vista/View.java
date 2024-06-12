
package Vista;

import Controlador.LeerArchivo;
import Controlador.PlanificadorProcesos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Impresor;

public class View extends javax.swing.JFrame implements Impresor{
    PlanificadorProcesos planificadorProcesos;
    public View() {
        initComponents();
        planificadorProcesos = new PlanificadorProcesos(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ventanaInicio = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInicio = new javax.swing.JTextArea();
        ventanaListo = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtListo = new javax.swing.JTextArea();
        ventanaEjecucion = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtEjecucion = new javax.swing.JTextArea();
        ventanaTerminado = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTerminado = new javax.swing.JTextArea();
        ventanaBloqueado = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtBloqueado = new javax.swing.JTextArea();
        ventanaProcesos = new javax.swing.JPanel();
        Ejecutar = new javax.swing.JButton();
        itemArchivos = new javax.swing.JComboBox<>();
        txtLapsoEjecucion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTiempoEjecucion = new javax.swing.JTextField();
        txtTiempoInicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTiempoBloqueo = new javax.swing.JTextField();
        itmPrioridades = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("5 Estados");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 2, 3));

        ventanaInicio.setBackground(new java.awt.Color(204, 153, 255));
        ventanaInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inicio ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Small", 3, 24), new java.awt.Color(0, 0, 102))); // NOI18N

        txtInicio.setColumns(20);
        txtInicio.setRows(5);
        jScrollPane2.setViewportView(txtInicio);

        javax.swing.GroupLayout ventanaInicioLayout = new javax.swing.GroupLayout(ventanaInicio);
        ventanaInicio.setLayout(ventanaInicioLayout);
        ventanaInicioLayout.setHorizontalGroup(
            ventanaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaInicioLayout.setVerticalGroup(
            ventanaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ventanaInicio);

        ventanaListo.setBackground(new java.awt.Color(204, 153, 255));
        ventanaListo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Small", 3, 24), new java.awt.Color(0, 0, 102))); // NOI18N

        txtListo.setColumns(20);
        txtListo.setRows(5);
        jScrollPane3.setViewportView(txtListo);

        javax.swing.GroupLayout ventanaListoLayout = new javax.swing.GroupLayout(ventanaListo);
        ventanaListo.setLayout(ventanaListoLayout);
        ventanaListoLayout.setHorizontalGroup(
            ventanaListoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaListoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaListoLayout.setVerticalGroup(
            ventanaListoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaListoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ventanaListo);

        ventanaEjecucion.setBackground(new java.awt.Color(204, 153, 255));
        ventanaEjecucion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ejecucion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Small", 3, 24), new java.awt.Color(0, 0, 102))); // NOI18N

        txtEjecucion.setColumns(20);
        txtEjecucion.setRows(5);
        jScrollPane4.setViewportView(txtEjecucion);

        javax.swing.GroupLayout ventanaEjecucionLayout = new javax.swing.GroupLayout(ventanaEjecucion);
        ventanaEjecucion.setLayout(ventanaEjecucionLayout);
        ventanaEjecucionLayout.setHorizontalGroup(
            ventanaEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaEjecucionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaEjecucionLayout.setVerticalGroup(
            ventanaEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaEjecucionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ventanaEjecucion);

        ventanaTerminado.setBackground(new java.awt.Color(204, 153, 255));
        ventanaTerminado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Terminado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Small", 3, 24), new java.awt.Color(0, 0, 102))); // NOI18N

        txtTerminado.setColumns(20);
        txtTerminado.setRows(5);
        jScrollPane6.setViewportView(txtTerminado);

        javax.swing.GroupLayout ventanaTerminadoLayout = new javax.swing.GroupLayout(ventanaTerminado);
        ventanaTerminado.setLayout(ventanaTerminadoLayout);
        ventanaTerminadoLayout.setHorizontalGroup(
            ventanaTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaTerminadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        ventanaTerminadoLayout.setVerticalGroup(
            ventanaTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaTerminadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ventanaTerminado);

        ventanaBloqueado.setBackground(new java.awt.Color(204, 153, 255));
        ventanaBloqueado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bloqueado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Small", 3, 24), new java.awt.Color(0, 0, 102))); // NOI18N

        txtBloqueado.setColumns(20);
        txtBloqueado.setRows(5);
        jScrollPane10.setViewportView(txtBloqueado);

        javax.swing.GroupLayout ventanaBloqueadoLayout = new javax.swing.GroupLayout(ventanaBloqueado);
        ventanaBloqueado.setLayout(ventanaBloqueadoLayout);
        ventanaBloqueadoLayout.setHorizontalGroup(
            ventanaBloqueadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaBloqueadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ventanaBloqueadoLayout.setVerticalGroup(
            ventanaBloqueadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaBloqueadoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ventanaBloqueado);

        ventanaProcesos.setBackground(new java.awt.Color(204, 204, 255));
        ventanaProcesos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ejecutar.setText("Ejecutar");
        Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjecutarActionPerformed(evt);
            }
        });
        ventanaProcesos.add(Ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 170, 30));

        itemArchivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un archivo", "Alfa.txt", "Beta.txt", "Gama.txt" }));
        ventanaProcesos.add(itemArchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, 30));

        txtLapsoEjecucion.setText("1000");
        txtLapsoEjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLapsoEjecucionActionPerformed(evt);
            }
        });
        ventanaProcesos.add(txtLapsoEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 94, -1));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        jLabel1.setText("Lapso de Ejecucion");
        ventanaProcesos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 26, -1, -1));

        jLabel2.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        jLabel2.setText("Tiempo de Ejecucion");
        ventanaProcesos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, -1));

        jLabel3.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        jLabel3.setText("Tiempo de Inicio");
        ventanaProcesos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txtTiempoEjecucion.setText("1000");
        txtTiempoEjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoEjecucionActionPerformed(evt);
            }
        });
        ventanaProcesos.add(txtTiempoEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 94, -1));

        txtTiempoInicio.setText("1000");
        ventanaProcesos.add(txtTiempoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 94, -1));

        jLabel4.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        jLabel4.setText("Tiempo de Bloqueo");
        ventanaProcesos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtTiempoBloqueo.setText("1000");
        ventanaProcesos.add(txtTiempoBloqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 94, -1));

        itmPrioridades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridades", "TIEMPO_REAL", "ALTA", "MEDIA", "BAJA" }));
        ventanaProcesos.add(itmPrioridades, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 160, 30));

        jPanel1.add(ventanaProcesos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjecutarActionPerformed
        LeerArchivo  leer  = new LeerArchivo();
        String archivo=itemArchivos.getSelectedItem().toString();
        try {
            planificadorProcesos.agregarInicio(leer.LeerArchivo(itemArchivos.getSelectedItem().toString()));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EjecutarActionPerformed

    private void txtLapsoEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLapsoEjecucionActionPerformed

    }//GEN-LAST:event_txtLapsoEjecucionActionPerformed

    private void txtTiempoEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoEjecucionActionPerformed

    }//GEN-LAST:event_txtTiempoEjecucionActionPerformed
  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ejecutar;
    private javax.swing.JComboBox<String> itemArchivos;
    public static javax.swing.JComboBox<String> itmPrioridades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea txtBloqueado;
    public static javax.swing.JTextArea txtEjecucion;
    private javax.swing.JTextArea txtInicio;
    public static javax.swing.JTextField txtLapsoEjecucion;
    private javax.swing.JTextArea txtListo;
    private javax.swing.JTextArea txtTerminado;
    public static javax.swing.JTextField txtTiempoBloqueo;
    public static javax.swing.JTextField txtTiempoEjecucion;
    public static javax.swing.JTextField txtTiempoInicio;
    private javax.swing.JPanel ventanaBloqueado;
    private javax.swing.JPanel ventanaEjecucion;
    private javax.swing.JPanel ventanaInicio;
    private javax.swing.JPanel ventanaListo;
    private javax.swing.JPanel ventanaProcesos;
    private javax.swing.JPanel ventanaTerminado;
    // End of variables declaration//GEN-END:variables

    @Override
    public void imprimirContador( String instruccion) {
        txtEjecucion.append(instruccion+"\n");
    }
    @Override
    public void imprimirInicio(String nombre) {
       txtInicio.append(nombre+"\n");
    }
    @Override
    public void imprimirListo(String nombre) {
       txtListo.append(nombre+"\n");
    }
    @Override
    public void imprimirTerminado(String nombre) {
        txtTerminado.append(nombre+"\n");
    }
    @Override
    public void imprimirBloqueado(String nombre) {
     txtBloqueado.append(nombre+"\n");
    }
}
