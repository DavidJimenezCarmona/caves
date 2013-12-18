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
	private JLabel _lblNuevoUsuario;
	private JTextField _txtDni;
	private JTextField _txtNombre;
	private JTextField _txtApellidos;
	private JTextField _txtFechaNacimiento;
	private JTextField _txtDireccion;
	private JTextField _txtPoblacion;
	private JTextField _txtProvincia;
	private JComboBox<String> _comboSuperpoder;
	private ArrayList<Superpoder> _aSuperpoderes; // copia
	
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	
	public IfrPersona(Persona persona) throws Exception
	{
		this();
		_persona = persona;
		_txtDni.setText(_persona.getDni());
		_txtNombre.setText(_persona.getNombre());
		_txtApellidos.setText(_persona.getApellidos());
		_txtFechaNacimiento.setText(_persona.getFechaNacimiento());
		_txtDireccion.setText(_persona.getDireccion());
		_txtPoblacion.setText(_persona.getPoblacion());
		_txtProvincia.setText(_persona.getProvincia());
		_lblNuevoUsuario.setText("Modificar persona");
		
	}
	
	public IfrPersona() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				try {
					_aSuperpoderes = Superpoder.Select();
					for(Superpoder superpoder : _aSuperpoderes )
					{
						_comboSuperpoder.addItem(superpoder.getNombre());
					}
					if(_persona != null)
						_comboSuperpoder.setSelectedIndex( Data.getIndex(_aSuperpoderes, _persona.getSuperpoder().getNombre()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setClosable(true);
		setTitle("Persona :: Nueva");
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
		
		_lblNuevoUsuario = new JLabel("Nuevo persona");
		_lblNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(_lblNuevoUsuario, "7, 4, 11, 1, center, default");
		
		JLabel lblDni = new JLabel("D.N.I. ");
		getContentPane().add(lblDni, "4, 6, right, default");
		
		_txtDni = new JTextField();
		getContentPane().add(_txtDni, "6, 6, fill, default");
		_txtDni.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		getContentPane().add(lblDireccin, "18, 6, right, default");
		
		_txtDireccion = new JTextField();
		getContentPane().add(_txtDireccion, "20, 6, fill, default");
		_txtDireccion.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		getContentPane().add(lblNombre, "4, 8, right, default");
		
		_txtNombre = new JTextField();
		getContentPane().add(_txtNombre, "6, 8, fill, top");
		_txtNombre.setColumns(10);
		
		JLabel _lblPoblacion = new JLabel("Poblaci\u00F3n");
		getContentPane().add(_lblPoblacion, "18, 8, right, default");
		
		_txtPoblacion = new JTextField();
		getContentPane().add(_txtPoblacion, "20, 8, fill, default");
		_txtPoblacion.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		getContentPane().add(lblApellidos, "4, 10, right, default");
		
		_txtApellidos = new JTextField();
		getContentPane().add(_txtApellidos, "6, 10, fill, default");
		_txtApellidos.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia");
		getContentPane().add(lblProvincia, "18, 10, right, default");
		
		_txtProvincia = new JTextField();
		getContentPane().add(_txtProvincia, "20, 10, fill, default");
		_txtProvincia.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		getContentPane().add(lblFechaDeNacimiento, "4, 12, right, default");
		
		_txtFechaNacimiento = new JTextField();
		_txtFechaNacimiento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(_txtFechaNacimiento.getText().equals("aaaa-mm-dd"))
					_txtFechaNacimiento.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(_txtFechaNacimiento.getText().equals(""))
					_txtFechaNacimiento.setText("aaaa-mm-dd");
			}
		});
		_txtFechaNacimiento.setText("aaaa-mm-dd");
		getContentPane().add(_txtFechaNacimiento, "6, 12, fill, default");
		_txtFechaNacimiento.setColumns(10);
		
		JLabel lblSuperpoder = new JLabel("Superpoder");
		getContentPane().add(lblSuperpoder, "18, 12, right, default");
		
		_comboSuperpoder = new JComboBox<String>();
		getContentPane().add(_comboSuperpoder, "20, 12, fill, default");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int id_Superpoder = _aSuperpoderes.get(_comboSuperpoder.getSelectedIndex()).getId();
				// Nueva persona
				if(_persona == null)
				{
					try {
						_persona = Persona.New(_txtDni.getText(), _txtNombre.getText(), _txtApellidos.getText(), _txtFechaNacimiento.getText(), _txtDireccion.getText(), _txtPoblacion.getText(), _txtProvincia.getText(), new Superpoder(id_Superpoder));
						setVisible(false);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				// Actualizar datos persona
				}else{
					try {
						_persona.setDni(_txtDni.getText());
						_persona.setNombre(_txtNombre.getText());
						_persona.setApellidos(_txtApellidos.getText());
						_persona.setFechaNacimiento(_txtFechaNacimiento.getText());
						_persona.setDireccion(_txtDireccion.getText());
						_persona.setPoblacion(_txtPoblacion.getText());
						_persona.setProvincia(_txtProvincia.getText());
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
		getContentPane().add(btnGuardar, "8, 14, 9, 1, center, default");
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{_txtDni, _txtNombre, _txtApellidos, _txtFechaNacimiento, _txtDireccion, _txtPoblacion, _txtProvincia, _comboSuperpoder, btnGuardar}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{_txtDni, _txtNombre, _txtApellidos, _txtFechaNacimiento, _txtDireccion, _txtPoblacion, _txtProvincia, _comboSuperpoder, btnGuardar}));

	}

}
