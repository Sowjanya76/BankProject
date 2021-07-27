package com.mindtree.bank.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.bank.exception.UtilityException;

public class DbConnector {
	static Connection connection=null;
	private static String dbName="dthdatabase";
	private static final String url="jdbc:mysql://localhost:3306/"+dbName;
	
	static String userName="root";
	static String password="16JN1A0508";
	public static Connection connectionToDatabase() throws UtilityException  
	{
		Connection connection=null;
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection=DriverManager.getConnection(url,userName,password);
				}
				catch(ClassNotFoundException | SQLException e)
				{
						throw new UtilityException("connection not available");
				}
		
		return connection;
		}
	
	public static void connectionClose(Connection connection) {
		if (connection != null) 
		try { 
				connection.close(); 
			} catch (SQLException ignore) {}
	}
	
	public static void statementClose(PreparedStatement statement) {
		if (statement != null)
		try {
			statement.close(); 
		} catch (SQLException ignore) {}
		}
	
	
	public static void resultSetClose(ResultSet resultSet) {
		if (resultSet != null) 
		try { 
				resultSet.close(); 
				} catch (SQLException ignore) {}
	}
	
}