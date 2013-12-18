package es.uca.gii.csi.caves.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import es.uca.gii.csi.caves.data.Data;

public class Persona 
{
	private int _iId;
	private String _sDni;
	private String _sNombre;
	private String _sApellidos;
	private String _sFechaNacimiento;
	private String _sDireccion;
	private String _sPoblacion;
	private String _sProvincia;
	private Superpoder _superpoder;

	
	/**
	 * Constructor de Persona: Crea una nueva instancia a partir del id
	 * @param id Identificador (clave primaria) de Persona
	 * @throws Exception
	 */
	public Persona(int iId) throws Exception 
	{
		Connection connection = null;
		ResultSet resultSet = null;
		
		try
		{
			connection = Data.Connection();
			resultSet = connection.createStatement().executeQuery(
					"SELECT * FROM Persona WHERE id=" + iId + ";");
			
			resultSet.next();
			_iId = resultSet.getInt("id");
			_sDni = resultSet.getString("dni");
			_sNombre = resultSet.getString("nombre");
			_sApellidos = resultSet.getString("apellidos");
			_sFechaNacimiento = resultSet.getString("fechaNacimiento");
			_sDireccion = resultSet.getString("direccion");
			_sPoblacion = resultSet.getString("poblacion");
			_sProvincia = resultSet.getString("provincia");
			_superpoder = new Superpoder(resultSet.getInt("id_Superpoder"));

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
	/**
	 * @return devuelve el identificador de la instancia Persona
	 */
	public int getId() {
		return _iId;
	}

	/**
	 * @return devuelve el dni de la instancia Persona
	 */
	public String getDni() {
		return _sDni;
	}

	/**
	 * @return devuelve el nombre de la instancia Persona
	 */
	public String getNombre() {
		return _sNombre;
	}

	/**
	 * @return devuelve los apellidos de la instancia Persona
	 */
	public String getApellidos() {
		return _sApellidos;
	}

	/**
	 * @return devuelve la fecha de nacimiento de la instancia Persona
	 */
	public String getFechaNacimiento() {
		return _sFechaNacimiento;
	}

	/**
	 * @return devuelve la dirección de la instancia Persona
	 */
	public String getDireccion() {
		return _sDireccion;
	}

	/**
	 * @return devuelve la población de la instancia Persona
	 */
	public String getPoblacion() {
		return _sPoblacion;
	}

	/**
	 * @return devuelve la provincia de la instancia Persona
	 */
	public String getProvincia() {
		return _sProvincia;
	}

	/** Método observador
	 * @return devuelve un objeto Superpoder asociado a la instancia Persona.
	 * @throws Exception 
	 */
	public Superpoder getSuperpoder() throws Exception
	{
		return _superpoder;
	}

	// Métodos modificadores
	
	/**
	 * @param sValor modifica el dni de la instancia Persona
	 */
	public void setDni(String sValor) {
		_sDni = sValor;
	}

	/**
	 * @param sValor modifica el nombre de la instancia Persona
	 */
	public void setNombre(String sValor) {
		_sNombre = sValor;
	}

	/**
	 * @param sValor modifica los apellidos de la instancia Persona
	 */
	public void setApellidos(String sValor) {
		_sApellidos = sValor;
	}

	/**
	 * @param sValor modifica la fecha de nacimiento de la instancia Persona
	 */
	public void setFechaNacimiento(String sValor) {
		_sFechaNacimiento = sValor;
	}

	/**
	 * @param sValor modifica la dirección de la instancia Persona
	 */
	public void setDireccion(String sValor) {
		_sDireccion = sValor;
	}

	/**
	 * @param sValor modifica la población de la instancia Persona
	 */
	public void setPoblacion(String sValor) {
		_sPoblacion = sValor;
	}

	/**
	 * @param sValor modifica la provincia de la instancia Persona
	 */
	public void setProvincia(String sValor) {
		_sProvincia = sValor;
	}

	/**
	 * @param valor modifica el superpoder asociado a la instancia Persona
	 */
	public void setSuperpoder(Superpoder superpoder) {
		_superpoder = superpoder;
	}

	
	/**
	 * Actualiza los datos de la instancia Persona en la BD
	 * @throws Exception
	 */
	public void Update() throws Exception
	{
		Connection connection = null;
		
		try 
		{
			
			connection = Data.Connection();
			
			String query=String.format("UPDATE Persona SET "
					+ "dni='%s', "
					+ "nombre='%s', "
					+ "apellidos='%s', "
					+ "fechaNacimiento='%s', "
					+ "direccion='%s', "
					+ "poblacion='%s', "
					+ "provincia='%s', "
					+ "id_Superpoder=%d  "
					+ "WHERE id=%d", 
					_sDni, Data.String2Sql(_sNombre, false), Data.String2Sql(_sApellidos, false), _sFechaNacimiento, Data.String2Sql(_sDireccion, false), Data.String2Sql(_sPoblacion, false), Data.String2Sql(_sProvincia, false), _superpoder.getId(), _iId);		
									
			 connection.createStatement().executeUpdate(query);
			 JOptionPane.showMessageDialog(null,"Registro modificado con éxito");
			 
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (connection != null) connection.close();
		}
	}

	
	/**
	 * Elimina de la BD el registro con el mismo identificador que la instancia Persona
	 * @throws Exception
	 */
	public void Delete() throws Exception
	{
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

	
	/**
	 * Crea una nueva persona en la BD
	 * @param sDni
	 * @param sNombre
	 * @param sApellidos
	 * @param sFechaNacimiento
	 * @param sDireccion
	 * @param sPoblacion
	 * @param sProvincia
	 * @param superpoder
	 * @return devuelve una instancia Persona con esos mismos datos
	 * @throws Exception
	 */
	public static Persona New(String sDni, String sNombre, String sApellidos,
			String sFechaNacimiento, String sDireccion, String sPoblacion,
			String sProvincia, Superpoder superpoder) throws Exception
	{
		Connection connection = null;
		ResultSet resultSet = null;
		
		

		
		try 
		{
			connection = Data.Connection();
			if(superpoder.getId() > 0)
			{
				connection.createStatement().executeUpdate(
						String.format("INSERT INTO Persona(dni, nombre, apellidos, fechaNacimiento, direccion, poblacion, provincia, id_Superpoder) VALUES("
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "%d)",
										sDni, Data.String2Sql(sNombre, false), Data.String2Sql(sApellidos, false), sFechaNacimiento, Data.String2Sql(sDireccion, false), Data.String2Sql(sPoblacion, false), Data.String2Sql(sProvincia, false), superpoder.getId()));
				JOptionPane.showMessageDialog(null, "Nueva persona registrada con éxito");
			}
			else
			{
				connection.createStatement().executeUpdate(
						String.format("INSERT INTO Persona(dni, nombre, apellidos, fechaNacimiento, direccion, poblacion, provincia, id_Superpoder) VALUES("
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "'%s', "
										+ "null)",
										sDni, Data.String2Sql(sNombre, false), Data.String2Sql(sApellidos, false), sFechaNacimiento, Data.String2Sql(sDireccion, false), Data.String2Sql(sPoblacion, false), Data.String2Sql(sProvincia, false)));
				JOptionPane.showMessageDialog(null, "Nueva persona registrada con éxito");
			}
			
			return new Persona(Data.LastId(connection));
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (resultSet != null) resultSet.close();
			if (connection != null) connection.close();
		}
	}
	
	/**
	 * Seleccionar conjunto de registros de la BD según un criterio
	 * @param sCriterio criterio
	 * @return devuelve el conjunto de instancias de Personas que cumplen el criterio
	 * @throws Exception
	 */
	public static ArrayList<Persona> Select(String sCriterio) throws Exception
	{
		ArrayList<Persona> aListaPersonas = new ArrayList<Persona>();
		
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
				sCriterio = Data.String2Sql(sCriterio, false); 
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return super.toString() + String.format("%s:%s:%s", _sDni, _sNombre, _sApellidos);
	}
}
