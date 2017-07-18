package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	private static String URL = "jdbc:mysql://localhost:3306/jdbctest?createDatabaseIfNotExist=true";
	private static String USERNAME = "root";
	private static String PASSWORD = "mnp";
	
	private static Connection CONNECTION = null;
	
	public static void initConnection() 
			throws SQLException {
		CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	public static Connection getConnection() {
		return CONNECTION;
	}
	
	public void closeConnection() throws SQLException {
		CONNECTION.close();
	}
	
	

}
