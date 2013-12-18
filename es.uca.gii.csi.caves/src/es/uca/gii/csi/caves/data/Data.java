package es.uca.gii.csi.caves.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import es.uca.gii.csi.caves.util.Config;

public class Data 
{
	public static String getPropertiesUrl() { return "./db.properties"; }
	
	/**
	 * Establece una conexión con la BD
	 * @return una referencia de tipo conexión
	 * @throws Exception
	 */
	public static Connection Connection() throws Exception 
	{
		try {
		Properties properties = Config.Properties(getPropertiesUrl());
		return DriverManager.getConnection(
				properties.getProperty("jdbc.url"),
				properties.getProperty("jdbc.username"),
				properties.getProperty("jdbc.password"));
		}
		catch (Exception ee) { throw ee; }
	}
	
	/**
	 * Carga el driver especificado en el fichero de configuración
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void LoadDriver()
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException 
	{
			Class.forName(Config.Properties(Data.getPropertiesUrl()
			).getProperty("jdbc.driverClassName")).newInstance();
	}
	
	
	/**
	 * Reemplaza la cadena "'" por "''"
	 * @param s cadena de caracteres a tratar
	 * @param bAddWildcards si bAddWildcards es true añade "'" antes y después y si es false nada
	 * @return cadena de caracteres resultante
	 */
	public static String String2Sql(String s, boolean bAddWildcards)
	{
		s = s.replace("'", "''");
		if(bAddWildcards)
		{
			s="'"+s+"'";
		}
		return s;
	}
	
	/** Convierte true ó false en 1 ó 0, respectivamente
	 * @param b booleano 
	 * @return devuelve 1 para true y 0 para false
	 */
	public static int Boolean2Sql(boolean b)
	{
		if(b)
			return 1;
		else
			return 0;
	}
	
	/**
	 * @param con referencia a conexión
	 * @return devuelve la id del último registro insertado en la BD
	 * @throws Exception
	 */
	public static int LastId(Connection con) throws Exception
	{
		ResultSet resultSet = null;
		
		try 
		{
			resultSet = con.createStatement().executeQuery(Config.Properties(Data.getPropertiesUrl()).getProperty("jdbc.lastIdSentence"));
			resultSet.next();
			return resultSet.getInt(1);
		}
		catch (SQLException ee) { throw ee; }
		finally {
			if (resultSet != null) resultSet.close();
		}
	}
	
	/** Busca en array si existe un superpoder cuyo nombre sea igual a string
	 *	Devuelve indice del array si existe, y -1 si no lo encuentra 
	 * @param array ArrayList del tipo Superpoder
	 * @param string cadena de caracteres a buscar en al array
	 * @return devuelve el índice de la primera ocurrencia de la cadena de caracteres string en array 
	 */
	public static int getIndex(ArrayList<Superpoder> array, String string)
	{
		for(int i=0; i<array.size(); i++)
		{
			if(string.equals(array.get(i).getNombre())) return i;
		}
		return -1;
	}
}
