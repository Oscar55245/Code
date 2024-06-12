/*
 * NickName: SeisNueve
 * Actividad 3
 * */


package vista;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class MainFrame extends Frame implements WindowListener{
	public static final long serialVersionUID=1;
	private int ANCHO_VENTANA=800;
	private int ALTO_VENTANA=600;
	private PanelProcesos panelProcesos;

	
	public MainFrame(){
		super("Modelo 5 estados");
		panelProcesos = new PanelProcesos();
		add(BorderLayout.CENTER, panelProcesos);
		setSize(ANCHO_VENTANA,ALTO_VENTANA);
		addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] main) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
}
