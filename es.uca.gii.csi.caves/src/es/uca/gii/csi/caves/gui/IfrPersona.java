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
	private JTextField txtFechaNacimiento;
	private JTextField txtDireccion;
	private JTextField txtPoblacion;
	private JTextField txtProvincia;
	private JComboBox<String> comboSuperpoder;
	
	

	/**
	 * Create the frame.
	 */
	
	public IfrPersona(Persona persona)
	{
		this();
		_persona = persona;
		txtDni.setText(_persona.getDni());
		txtNombre.setText(_persona.getNombre());
		txtApellidos.setText(_persona.getApellidos());
		txtFechaNacimiento.setText(_persona.getFechaNacimiento());
		txtDireccion.setText(_persona.getDireccion());
		txtPoblacion.setText(_persona.getPoblacion());
		txtProvincia.setText(_persona.getProvincia());
	}
	
	public IfrPersona() {
		setTitle("Usuario");
		setBounds(0, 0, 700, 450);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo persona");
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblNuevoUsuario, "7, 4, 11, 1");
		
		JLabel lblDni = new JLabel("D.N.I. ");
		getContentPane().add(lblDni, "4, 6, right, default");
		
		txtDni = new JTextField();
		getContentPane().add(txtDni, "6, 6, fill, default");
		txtDni.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		getContentPane().add(lblDireccin, "18, 6, right, default");
		
		txtDireccion = new JTextField();
		getContentPane().add(txtDireccion, "20, 6, fill, default");
		txtDireccion.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		getContentPane().add(lblNombre, "4, 8, right, default");
		
		txtNombre = new JTextField();
		getContentPane().add(txtNombre, "6, 8, fill, top");
		txtNombre.setColumns(10);
		
		JLabel lblPoblacin = new JLabel("Poblaci\u00F3n");
		getContentPane().add(lblPoblacin, "18, 8, right, default");
		
		txtPoblacion = new JTextField();
		getContentPane().add(txtPoblacion, "20, 8, fill, default");
		txtPoblacion.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		getContentPane().add(lblApellidos, "4, 10, right, default");
		
		txtApellidos = new JTextField();
		getContentPane().add(txtApellidos, "6, 10, fill, default");
		txtApellidos.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia");
		getContentPane().add(lblProvincia, "18, 10, right, default");
		
		txtProvincia = new JTextField();
		getContentPane().add(txtProvincia, "20, 10, fill, default");
		txtProvincia.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		getContentPane().add(lblFechaDeNacimiento, "4, 12, right, default");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// Nueva persona
				if(_persona == null)
				{
					try {
						_persona = Persona.New(txtDni.getText(), txtNombre.getText(), txtApellidos.getText(), txtFechaNacimiento.getText(), txtDireccion.getText(), txtPoblacion.getText(), txtProvincia.getText(), 0);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				// Actualizar datos persona
				}else{
					try {
						_persona.Update();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		txtFechaNacimiento = new JTextField();
		getContentPane().add(txtFechaNacimiento, "6, 12, fill, default");
		txtFechaNacimiento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Superpoder");
		getContentPane().add(lblNewLabel, "18, 12, right, default");
		
		comboSuperpoder = new JComboBox<String>();
		getContentPane().add(comboSuperpoder, "20, 12, fill, default");
		getContentPane().add(btnGuardar, "20, 14");

	}

}
