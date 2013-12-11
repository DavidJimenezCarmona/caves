package es.uca.gii.csi.caves.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import es.uca.gii.csi.caves.data.Persona;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class IfrPersona extends JInternalFrame {
	private Persona _persona=null;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtPoblacion;
	private JTextField txtProvincia;
	private JComboBox<String> comboSuperpoder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IfrPersona frame = new IfrPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IfrPersona() {
		setTitle("Usuario");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo persona");
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblNuevoUsuario, "9, 4, 10, 1");
		
		JLabel lblDni = new JLabel("D.N.I. ");
		getContentPane().add(lblDni, "4, 6, right, default");
		
		txtDni = new JTextField();
		getContentPane().add(txtDni, "6, 6, 5, 1, fill, default");
		txtDni.setColumns(10);
		
		JLabel lblPoblacin = new JLabel("Poblaci\u00F3n");
		getContentPane().add(lblPoblacin, "18, 6, right, default");
		
		txtPoblacion = new JTextField();
		getContentPane().add(txtPoblacion, "20, 6, fill, default");
		txtPoblacion.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		getContentPane().add(lblNombre, "4, 8, right, default");
		
		txtNombre = new JTextField();
		getContentPane().add(txtNombre, "6, 8, 5, 1, fill, top");
		txtNombre.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia");
		getContentPane().add(lblProvincia, "18, 8, right, default");
		
		txtProvincia = new JTextField();
		getContentPane().add(txtProvincia, "20, 8, fill, default");
		txtProvincia.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		getContentPane().add(lblApellidos, "4, 10, right, default");
		
		txtApellidos = new JTextField();
		getContentPane().add(txtApellidos, "6, 10, 5, 1, fill, default");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Superpoder");
		getContentPane().add(lblNewLabel, "18, 10, right, default");
		
		comboSuperpoder = new JComboBox<String>();
		getContentPane().add(comboSuperpoder, "20, 10, fill, default");
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		getContentPane().add(lblFechaDeNacimiento, "4, 12, right, default");
		
		JSpinner spinDia = new JSpinner();
		getContentPane().add(spinDia, "6, 12");
		
		JSpinner spinMes = new JSpinner();
		getContentPane().add(spinMes, "8, 12");
		
		JSpinner spinAnno = new JSpinner();
		getContentPane().add(spinAnno, "10, 12");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					_persona = Persona.New(txtDni.getText(), txtDni.getText(), txtDni.getText(), txtDni.getText(), txtDni.getText(), txtDni.getText(), txtDni.getText(), comboSuperpoder.getSelectedIndex());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnGuardar, "20, 12");

	}

}
