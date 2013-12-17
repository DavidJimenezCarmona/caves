package es.uca.gii.csi.caves.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import es.uca.gii.csi.caves.data.Data;
import es.uca.gii.csi.caves.data.Persona;
import es.uca.gii.csi.caves.data.Superpoder;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

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
	private ArrayList<Superpoder> _aSuperpoderes; // copia
	
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	
	public IfrPersona(Persona persona) throws Exception
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
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				try {
					_aSuperpoderes = Superpoder.Select();
					for(Superpoder superpoder : _aSuperpoderes )
					{
						comboSuperpoder.addItem(superpoder.getNombre());
					}
					if(_persona != null)
						comboSuperpoder.setSelectedIndex( Data.getIndex(_aSuperpoderes, _persona.getSuperpoder().getNombre()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setClosable(true);
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
				int id_Superpoder = _aSuperpoderes.get(comboSuperpoder.getSelectedIndex()).getId();
				// Nueva persona
				if(_persona == null)
				{
					try {
						_persona = Persona.New(txtDni.getText(), txtNombre.getText(), txtApellidos.getText(), txtFechaNacimiento.getText(), txtDireccion.getText(), txtPoblacion.getText(), txtProvincia.getText(), new Superpoder(id_Superpoder));
						setVisible(false);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				// Actualizar datos persona
				}else{
					try {
						_persona.setDni(txtDni.getText());
						_persona.setNombre(txtNombre.getText());
						_persona.setApellidos(txtApellidos.getText());
						_persona.setFechaNacimiento(txtFechaNacimiento.getText());
						_persona.setDireccion(txtDireccion.getText());
						_persona.setPoblacion(txtPoblacion.getText());
						_persona.setProvincia(txtProvincia.getText());
						_persona.setSuperpoder(new Superpoder(id_Superpoder));
						_persona.Update();
						setVisible(false);
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtFechaNacimiento.getText().equals("aaaa-mm-dd"))
					txtFechaNacimiento.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtFechaNacimiento.getText().equals(""))
					txtFechaNacimiento.setText("aaaa-mm-dd");
			}
		});
		txtFechaNacimiento.setText("aaaa-mm-dd");
		getContentPane().add(txtFechaNacimiento, "6, 12, fill, default");
		txtFechaNacimiento.setColumns(10);
		
		JLabel lblSuperpoder = new JLabel("Superpoder");
		getContentPane().add(lblSuperpoder, "18, 12, right, default");
		
		comboSuperpoder = new JComboBox<String>();
		getContentPane().add(comboSuperpoder, "20, 12, fill, default");
		getContentPane().add(btnGuardar, "20, 14");
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtDni, txtNombre, txtApellidos, txtFechaNacimiento, txtDireccion, txtPoblacion, txtProvincia, comboSuperpoder, btnGuardar}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtDni, txtNombre, txtApellidos, txtFechaNacimiento, txtDireccion, txtPoblacion, txtProvincia, comboSuperpoder, btnGuardar}));

	}

}
