package es.uca.gii.csi.caves.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import es.uca.gii.csi.caves.data.Data;

public class Persona {
	private int _iId;
	private String _sDni;
	private String _sNombre;
	private String _sApellidos;
	private Date _tFechaNacimiento;
	private String _sDireccion;
	private String _sPoblacion;
	private String _sProvincia;
	private int _iSuperpoder;

	public Persona(int id) throws Exception {
		
		Data.LoadDriver();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try
		{
			connection = Data.Connection();
			resultSet = connection.createStatement().executeQuery(
					"SELECT * FROM Persona WHERE id=" + id + ";");
			
			_sDni = resultSet.getString("dni");
			_sNombre = resultSet.getString("nombre");
			_sApellidos = resultSet.getString("apellidos");
			_tFechaNacimiento = resultSet.getDate("fechaNacimiento");
			_sDireccion = resultSet.getString("direccion");
			_sPoblacion = resultSet.getString("poblacion");
			_sProvincia = resultSet.getString("provincia");
			_iSuperpoder = resultSet.getInt("superpoder");

		} catch (SQLException ee) {
			throw ee;
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (connection != null)
				connection.close();
		}
	}

	// Métodos observadores
	public int getId() {
		return _iId;
	}

	public String getDni() {
		return _sDni;
	}

	public String getNombre() {
		return _sNombre;
	}

	public String getApellidos() {
		return _sApellidos;
	}

	public Date getFechaNacimiento() {
		return _tFechaNacimiento;
	}

	public String getDireccion() {
		return _sDireccion;
	}

	public String getPoblacion() {
		return _sPoblacion;
	}

	public String getProvincia() {
		return _sProvincia;
	}

	public int getSuperpoder() {
		return _iSuperpoder;
	}

	// Métodos modificadores
	public void setDni(String sValor) {
		_sDni = sValor;
	}

	public void setNombre(String sValor) {
		_sNombre = sValor;
	}

	public void setApellidos(String sValor) {
		_sApellidos = sValor;
	}

	public void setFechaNacimiento(Date sValor) {
		_tFechaNacimiento = sValor;
	}

	public void setDireccion(String sValor) {
		_sDireccion = sValor;
	}

	public void setPoblacion(String sValor) {
		_sPoblacion = sValor;
	}

	public void setProvincia(String sValor) {
		_sProvincia = sValor;
	}

	public void setSuperpoder(int sValor) {
		_iSuperpoder = sValor;
	}

	// Método Update
	public void Update() throws Exception
	{
		Data.LoadDriver();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try 
		{
			
			connection = Data.Connection();
			resultSet = connection.createStatement().executeQuery(
					String.format("UPDATE Persona SET "
									+ "dni='%s', "
									+ "nombre='%s', "
									+ "apellidos='%s', "
									+ "fechaNacimiento='%s', "
									+ "direccion='%s', "
									+ "poblacion='%s', "
									+ "provincia='%s', "
									+ "superpoder=%i  "
									+ "WHERE id=%i", 
									_sDni, _sNombre, _sApellidos, _tFechaNacimiento, _sDireccion, _sPoblacion, _sProvincia, _iSuperpoder));
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (resultSet != null) resultSet.close();
			if (connection != null) connection.close();
		}
	}

	// Método Delete
	public void Delete() throws Exception
	{
		Data.LoadDriver();
		Connection connection = null;
		
		try 
		{
			connection = Data.Connection();
			connection.createStatement().executeUpdate(
					String.format("DELETE FROM Persona WHERE id = %i", _iId));
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (connection != null) connection.close();
		}
	}

	// Método NuevaPersona
	public static Persona New(String sDni, String sNombre, String sApellidos,
			String sFechaNacimiento, String sDireccion, String sPoblacion,
			String sProvincia, int iSuperpoder) throws Exception
	{
		Data.LoadDriver();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try 
		{
			connection = Data.Connection();
			connection.createStatement().executeUpdate(
					String.format("INSERT INTO Persona VALUES(null, "
									+ "'%s', "
									+ "'%s', "
									+ "'%s', "
									+ "'%s', "
									+ "'%s', "
									+ "'%s', "
									+ "'%s', "
									+ "%d)",
									sDni, sNombre, sApellidos, sFechaNacimiento, sDireccion, sPoblacion, sProvincia, iSuperpoder));
			return new Persona(Data.LastId(connection));
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (resultSet != null) resultSet.close();
			if (connection != null) connection.close();
		}
	}
	
	public static ArrayList<Persona> Select(String sCriterio) throws Exception
	{
		ArrayList<Persona> aListaPersonas = new ArrayList<Persona>();
		
		Data.LoadDriver();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try 
		{			
			connection = Data.Connection();
			
			// Seleccionar todos
			if(sCriterio == null)
			{
				resultSet = connection.createStatement().executeQuery("SELECT id FROM Persona");
			}
			// Selección personalizada
			else{
				resultSet = connection.createStatement().executeQuery(
						String.format("SELECT id FROM Persona "
								    + "WHERE dni like '%s' "
								    + "OR nombre like '%s' "
								    + "OR apellidos like '%s' "
								    + "OR poblacion like '%s'",
								    "%"+sCriterio+"%", "%"+sCriterio+"%", "%"+sCriterio+"%", "%"+sCriterio+"%"));
			}
			while (resultSet.next())
			{
				aListaPersonas.add(new Persona(resultSet.getInt("id")));
			}
			return aListaPersonas;
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (resultSet != null) resultSet.close();
			if (connection != null) connection.close();
		}
	}
	
	
	public String toString()
	{
		return super.toString() + String.format("%s:%s:%s", _sDni, _sNombre, _sApellidos);
	}
}
