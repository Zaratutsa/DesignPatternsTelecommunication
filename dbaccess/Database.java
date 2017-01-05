package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database 
{
	private static Database instance;
	private static String dbUrl = "jdbc:mysql://127.0.0.1/";
	private static String dbName = "service";
	private static String dbLogin = "root";
	private static String dbPass = "salem";
	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static Connection conn = null;
	

	public static Database getInstance() 
	{
		return (instance == null) ? new Database() : instance;
	}

	public Connection getConn() 
	{
		return conn;
	}

	public void connect() 
	{
		try 
		{
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl + dbName, dbLogin, dbPass);
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.printf("Problem driver: " + e);
		} 
		catch (SQLException e) 
		{
			System.out.printf("Error: " + e.getErrorCode());
		}
	}

	public ResultSet getQuery(String query)
	{
		Statement statement = null;
		ResultSet result = null;

		try 
		{
			statement = conn.createStatement();
			result = statement.executeQuery(query);
		} 
		catch (SQLException e) 
		{
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		return result;
	}

	public void close()
	{
		try 
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			System.out.printf("Problem with close: " + e);
		}
	}
}
