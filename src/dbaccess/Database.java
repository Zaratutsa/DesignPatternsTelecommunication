package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database 
{
	// DB config
		private static Database instance;
		private final String PATH = "external/dbconf.dat";
		private String dbUrl ;
		private String dbName;
		private String dbLogin;
		private String dbPass;
		private String dbDriver;
		private Connection conn = null;
		
		/*
		private static String dbUrl = "jdbc:mysql://127.0.0.1/";
		private static String dbName = "galery";
		private static String dbLogin = "root";
		private static String dbPass = "admin";
		private static String dbDriver = "com.mysql.jdbc.Driver";
		*/

		/// *
		private Database() {
			String str[]=new String[5];
			str=ToolsFile.initDBFromFile(PATH);
			this.dbUrl=str[0];
			this.dbName=str[1];
			this.dbLogin=str[2];
			this.dbPass=str[3];
			this.dbDriver=str[4];
		}

		/// *
		public static Database getInstance() {
			return (instance == null) ? new Database() : instance;
		}

		public Connection getConn() {
			return conn;
		}

		/// *
		public void connect() {

			try {
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl + dbName, dbLogin, dbPass);

			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Problem ze sterownikiem! " + e, "connect", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Vendor error ! " + e, "connect", JOptionPane.ERROR_MESSAGE);
			}

		}

		/// *
		public ResultSet getQuery(String query) {

			Statement statement = null;
			ResultSet result = null;

			try {
				statement = conn.createStatement();

				result = statement.executeQuery(query);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"SQLException: " + e.getMessage(), "getQuery", JOptionPane.ERROR_MESSAGE);
//				System.out.println("SQLException: " + e.getMessage());
//				System.out.println("VendorError: " + e.getErrorCode());
			}

			return result;
		}

		/// *
		public void close() {
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Problem zakoñczenia po³¹czenia! " + e, "close", JOptionPane.ERROR_MESSAGE);
			}

		}
}
