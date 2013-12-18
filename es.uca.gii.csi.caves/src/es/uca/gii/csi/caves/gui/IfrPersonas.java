package es.uca.gii.csi.caves.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import es.uca.gii.csi.caves.data.Persona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IfrPersonas extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private Container pnlParent;

	/**
	 * Create the frame.
	 */
	public IfrPersonas(Container pnlMain) {
		setClosable(true);
		pnlParent=pnlMain;
		setTitle("Persona :: Busqueda");
		setBounds(0, 0, 700, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblBuscar = new JLabel("Busqueda");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBuscar);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					table.setModel(new PersonaTableModel(Persona.Select(textField.getText())));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnBuscar);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if (arg0.getClickCount() == 2) 
				{ // Se activa cuando se hace doble clic sobre una fila
					int iRow = ((JTable)arg0.getSource()).getSelectedRow();
					Persona persona =((PersonaTableModel)table.getModel()).getData(iRow);
					if (persona != null)
					{
						IfrPersona ifrPersona;
						try {
							ifrPersona = new IfrPersona(persona);
							Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
							ifrPersona.setBounds(0, 0, screenSize.width-5, screenSize.height);
							ifrPersona.setTitle("Persona :: Modificar");						
							pnlParent.add(ifrPersona, 0);							
							ifrPersona.setVisible(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		getContentPane().add(table, BorderLayout.CENTER);

	}

}
