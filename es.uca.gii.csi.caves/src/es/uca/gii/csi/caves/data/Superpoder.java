package es.uca.gii.csi.caves.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Superpoder {
	
	private int _iId;
	private String _sNombre;
	private String _sDescripcion;
	
	/**
	 * Constructor de Superpoder: Crea una nueva instancia a partir del iId
	 * @param iId Identificador (clave primaria) de Superpoder
	 * @throws Exception
	 */
	public Superpoder(int iId) throws Exception 
	{
		Connection connection = null;
		ResultSet resultSet = null;
		
		if(iId > 0)
		{
			try
			{
				connection = Data.Connection();
				resultSet = connection.createStatement().executeQuery(
						"SELECT * FROM Superpoder WHERE id=" + iId + ";");
				
				resultSet.next();
				_iId = resultSet.getInt("id");
				_sNombre = resultSet.getString("nombre");
				_sDescripcion = resultSet.getString("descripcion");
	
			} catch (SQLException ee) {
				throw ee;
			} finally {
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					connection.close();
			}
		}else{
			// Superpoder nulo
			_iId = 0;
			_sNombre = "";
			_sDescripcion = "";
		}
	}
	
	/**
	 * @return devuelve el identificador de la instancia Superpoder
	 */
	public int getId()
	{
		return _iId;
	}
	
	/**
	 * @return devuelve el nombre de la instancia Superpoder
	 */
	public String getNombre()
	{
		return _sNombre;
	}
	
	/**
	 * @return devuelve la descripción de la instancia Superpoder
	 */
	public String getDescripcion()
	{
		return _sDescripcion;
	}
	
	/**
	 * @param sNombre modifica el nombre de la instancia Superpoder
	 */
	public void setNombre(String sNombre)
	{
		_sNombre = sNombre;
	}
	
	/**
	 * @param sDescripcion modifica la descripcion de la instancia Superpoder
	 */
	public void setDescripcion(String sDescripcion)
	{
		_sDescripcion = sDescripcion;
	}

	/**
	 * Seleccionar el conjunto de registros completo de la BD
	 * @return devuelve el conjunto de instancias de Superpoder
	 * @throws Exception
	 */
	public static ArrayList<Superpoder> Select() throws Exception
	{
		ArrayList<Superpoder> aListaSuperpoderes = new ArrayList<Superpoder>();
		
		Connection connection = null;
		ResultSet resultSet = null;
		
		try 
		{			
			connection = Data.Connection();
			
			// Seleccionar todos
			resultSet = connection.createStatement().executeQuery("SELECT * FROM Superpoder");

			while (resultSet.next())
			{
				aListaSuperpoderes.add(new Superpoder(resultSet.getInt("id")));
			}
			return aListaSuperpoderes;
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (resultSet != null) resultSet.close();
			if (connection != null) connection.close();
		}
	}
}
