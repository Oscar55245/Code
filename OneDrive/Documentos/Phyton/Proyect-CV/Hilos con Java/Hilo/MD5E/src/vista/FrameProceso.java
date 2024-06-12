package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public abstract class FrameProceso extends JPanel  {
	private static final long serialVersionUID = 1L;
	
	public FrameProceso(String nombreVentana) {
		Border borde = new TitledBorder(new EtchedBorder(), nombreVentana);
		setBorder(borde);
		setLayout(new BorderLayout());
	}
	
}
