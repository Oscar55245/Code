package vista;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.TextArea;

import modelo.HiloEstado;
import modelo.Impresor;
import modelo.Proceso;

public class FrameEstado extends FrameProceso implements Impresor{
	private static final long serialVersionUID = 1L;
	private TextArea areaTexto;
	private HiloEstado hilo;
	
	public FrameEstado(String nombreVentana) {
		super(nombreVentana);
		areaTexto = new TextArea();
		areaTexto.setEditable(false);
		areaTexto.setFocusable(false);
		add(BorderLayout.CENTER,areaTexto);
		add(BorderLayout.NORTH, new Label("PID"+Proceso.DELIMITADOR_INSTRUCCIONES+"Imagen"));
	}

	@Override
	public void imprimirln(String s) {
		areaTexto.append(s);
	}
	
	public void verProcesos() {
		imprimirln(hilo.getName());
	}
	
	public void establecerHilo(HiloEstado hilo) {
		this.hilo = hilo;
	}
}
