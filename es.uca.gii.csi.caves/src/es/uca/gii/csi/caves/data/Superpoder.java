package es.uca.gii.csi.caves.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Superpoder {
	
	private int _iId;
	private String _sNombre;
	private String _sDescripcion;
	
	public Superpoder(int iId) throws Exception 
	{
		Data.LoadDriver();
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
	
	public int getId()
	{
		return _iId;
	}
	
	public String getNombre()
	{
		return _sNombre;
	}
	
	public String getDescripcion()
	{
		return _sDescripcion;
	}
	
	public void setId(int iId)
	{
		_iId = iId;
	}
	
	public void setNombre(String sNombre)
	{
		_sNombre = sNombre;
	}
	
	public void setDescripcion(String sDescripcion)
	{
		_sDescripcion = sDescripcion;
	}

	public static ArrayList<Superpoder> Select() throws Exception
	{
		ArrayList<Superpoder> aListaSuperpoderes = new ArrayList<Superpoder>();
		
		Data.LoadDriver();
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
