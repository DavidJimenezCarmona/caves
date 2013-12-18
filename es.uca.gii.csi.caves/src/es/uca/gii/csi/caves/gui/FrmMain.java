package es.uca.gii.csi.caves.gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class FrmMain {

	private JFrame frmMain;
	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public FrmMain() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		initialize();
	}
	
	public JFrame getFrame()
	{
		return this.frmMain;
	}	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{	
		frmMain = new JFrame();
		frmMain.setResizable(false);
		frmMain.setTitle("CAVES :: Inicio");
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Modo pantalla completa
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frmMain.setBounds(0, 0, screenSize.width, screenSize.height);

		
		JMenuBar menuBar = new JMenuBar();
		frmMain.setJMenuBar(menuBar);
		
		JMenu mitBuscar = new JMenu("Buscar");
		menuBar.add(mitBuscar);
		
		JMenuItem mitBuscarUsuario = new JMenuItem("Persona");
		mitBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				IfrPersonas ifrPersonas = new IfrPersonas(getFrame());
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				ifrPersonas.setBounds(0, 0, screenSize.width-5, screenSize.height-50);
				frmMain.getContentPane().add(ifrPersonas, 0); // El segundo parámetro es para que siempre aparezca delante
				ifrPersonas.setVisible(true);
			}
		});
		mitBuscar.add(mitBuscarUsuario);
		
		JMenu mitNuevo = new JMenu("Nuevo");
		menuBar.add(mitNuevo);
		
		JMenuItem mitNuevoUsuario = new JMenuItem("Persona");
		mitNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				IfrPersona ifrPersona = new IfrPersona();
				ifrPersona.setBounds(0, 0, screenSize.width-5, 220);
				frmMain.getContentPane().add(ifrPersona);
				ifrPersona.setVisible(true);
			}
		});
		mitNuevo.add(mitNuevoUsuario);
		frmMain.getContentPane().setLayout(null);
	}

}
