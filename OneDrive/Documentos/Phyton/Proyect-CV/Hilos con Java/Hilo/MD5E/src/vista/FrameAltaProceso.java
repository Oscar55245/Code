package vista;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Proceso;
import sistema.BloqueControlProcesos.ManejadorProcesos;

public class FrameAltaProceso extends FrameProceso {
	private static final long serialVersionUID = 1L;
	private final String TIEMPO_DEFECTO = "1";

	private Choice selectorProcesos;
	private TextField campoTiempoEjecucion;
	private TextField campoLapsoEjecucion;
	private TextField campoTiempoInicio;
	private TextField campoTiempoBloqueo;
	private Button botonIniciarSistema;
	private ManejadorProcesos manejadorProcesos;
	ArrayList<Proceso> listaProcesos;
	

	public FrameAltaProceso(ManejadorProcesos admin) {
		super("Alta de un proceso");
		manejadorProcesos = admin;
		ManejadorAccion accion = new ManejadorAccion();
		setLayout(new FlowLayout());
		selectorProcesos = new Choice();
		selectorProcesos.addItemListener(accion);
		campoTiempoEjecucion = new TextField();
		campoLapsoEjecucion = new TextField();
		campoTiempoInicio = new TextField();
		campoTiempoBloqueo = new TextField();
		botonIniciarSistema = new Button("Iniciar Sistema");
		botonIniciarSistema.addActionListener(accion);
		
		campoTiempoEjecucion.setText(TIEMPO_DEFECTO);
		campoLapsoEjecucion.setText(TIEMPO_DEFECTO);
		campoTiempoInicio.setText(TIEMPO_DEFECTO);
		campoTiempoBloqueo.setText(TIEMPO_DEFECTO);
		
		agregarListaProcesos();
		add(new Label("Proceso"));
		add(selectorProcesos);
		add(new Label("Tiempo de ejecucion:"));
		add(campoTiempoEjecucion);
		add(new Label("Lapso de ejecucion:"));
		add(campoLapsoEjecucion);
		add(new Label("Tiempo en inicio:"));
		add(campoTiempoInicio);
		add(new Label("Tiempo de bloqueo:"));
		add(campoTiempoBloqueo);
		add(botonIniciarSistema);
		
	}
	
	private void agregarListaProcesos() {
		listaProcesos = manejadorProcesos.listarProcesosDisponibles();
		if(listaProcesos.isEmpty()) {
			campoTiempoEjecucion.setEditable(false);
			campoTiempoEjecucion.setEditable(false);
			campoLapsoEjecucion.setEditable(false);
			campoTiempoInicio.setEditable(false);
			campoTiempoBloqueo.setEditable(false);
			botonIniciarSistema.setEnabled(false);
			selectorProcesos.add("Vacio");
		} else {
			for(Proceso p:listaProcesos) {
				selectorProcesos.add(p.obtenerImagen());
			}
		}
	}
	

	class ManejadorAccion implements ActionListener, ItemListener {
		private Proceso p;
		private Iterator<Proceso> it;
		private String procesoSeleccionado;
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(botonIniciarSistema)){
				it = listaProcesos.iterator();
				procesoSeleccionado = selectorProcesos.getSelectedItem();
				while(it.hasNext()) {
					p = it.next();
					if(p.obtenerImagen().equals(procesoSeleccionado)) {
						p = (Proceso) p.clone();
						break;
					}
				}
				
				botonIniciarSistema.setEnabled(false);
				manejadorProcesos.iniciar(p,
						Integer.valueOf(campoTiempoEjecucion.getText()),					
						Integer.valueOf(campoLapsoEjecucion.getText()),
						Integer.valueOf(campoTiempoInicio.getText()),
						Integer.valueOf(campoTiempoBloqueo.getText()));
			}
		}

		public void itemStateChanged(ItemEvent e) {
			if(e.getSource().equals(selectorProcesos)) {
				botonIniciarSistema.setEnabled(true);
			}
			
		}
		
	}
}


