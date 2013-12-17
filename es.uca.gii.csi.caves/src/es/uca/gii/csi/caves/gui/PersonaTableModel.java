package es.uca.gii.csi.caves.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import es.uca.gii.csi.caves.data.Persona;

/**
 * @author usuario
 *
 */
public class PersonaTableModel extends AbstractTableModel
{
	private ArrayList<Persona> _aData;
	
	/**
	 * @param aData
	 */
	public PersonaTableModel(ArrayList<Persona> aData)
	{
		_aData = aData;
	}
	
	/**  Se mostrarán todos los campos de la tabla Persona menos el id
	 * @return número de columnas que se van a mostrar
	 */
	public int getColumnCount() 
	{
		return 8;
	}
	
	/**
	 * @param i
	 * @return
	 */
	public Persona getData(int i)
	{
		return _aData.get(i);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount()
	{
		return _aData.size();
	}
	
	
	public Object getValueAt(int rowIndex, int columIndex)
	{
		switch(columIndex)
		{
			// Primer campo
			default:
			case 0:
				return _aData.get(rowIndex).getDni();
			case 1:
				return _aData.get(rowIndex).getApellidos();
			case 2:
				return _aData.get(rowIndex).getNombre();
			case 3:
				return _aData.get(rowIndex).getFechaNacimiento();
			case 4:
				return _aData.get(rowIndex).getDireccion();
			case 5:
				return _aData.get(rowIndex).getPoblacion();
			case 6:
				return _aData.get(rowIndex).getProvincia();
			case 7:
			try {
				return _aData.get(rowIndex).getSuperpoder().getNombre();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
	}
}
