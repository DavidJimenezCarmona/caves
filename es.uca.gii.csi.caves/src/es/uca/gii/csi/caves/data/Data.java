package es.uca.gii.csi.caves.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import es.uca.gii.csi.caves.util.Config;

public class Data 
{
	public static String getPropertiesUrl() { return "./db.properties"; }
	
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
	
	public static void LoadDriver()
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException 
	{
			Class.forName(Config.Properties(Data.getPropertiesUrl()
			).getProperty("jdbc.driverClassName")).newInstance();
	}
	
	// Reemplaza la cadena "'" por "''"
	// y (si bAddWildcards es true) añade "'" antes y después
	public static String String2Sql(String s, boolean bAddWildcards)
	{
		s.replace("'", "''");
		if(bAddWildcards)
		{
			s="'"+s+"'";
		}
		return s;
	}
	
	// Convierte true ó false en 1 ó 0, respectivamente
	public static int Boolean2Sql(boolean b)
	{
		if(b)
			return 1;
		else
			return 0;
	}
	
	public static int LastId(Connection con) throws Exception
	{
		Data.LoadDriver();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try 
		{			
			connection = Data.Connection();
			resultSet = connection.createStatement().executeQuery(String.format("%s", Config.Properties(Data.getPropertiesUrl()).getProperty("jdbc.lastIdSentence")));
		}catch(Exception e){ throw e; }
		
		return resultSet.getInt("id");	
	}
}
