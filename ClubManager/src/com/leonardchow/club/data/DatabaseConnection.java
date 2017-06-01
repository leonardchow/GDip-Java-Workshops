package com.leonardchow.club.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.security.action.GetBooleanAction;

public class DatabaseConnection implements AutoCloseable{

	private Connection connection;
	private Statement statement;
	
	public DatabaseConnection() {
		connection = null;
		statement = null;
		// 1. Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find JDBC driver.");
			e.printStackTrace();
		}
	}
	
	public Connection openConnection() {
		System.out.println("Connecting to database");
		try {
			connection = DriverManager.getConnection(DatabaseSettings.CONN_STR, DatabaseSettings.USER, DatabaseSettings.PASSWORD);
		} catch (SQLException e) {
			System.out.println("Could not connect to database with credentials. Is the database running?");
			e.printStackTrace();
		}
		return connection;
	}
	
	public ResultSet dbQuery(String queryStr) {	
		openConnection();
		// 2. Connection
		ResultSet resultSet = null;
		try {
			// 3. Statement
			statement = connection.createStatement();
			// 4. Execute query
			resultSet = statement.executeQuery(queryStr);
			// 5. Process
			// Left to caller	
		} catch (SQLException e) {
			System.out.println("Could not execute statement.");
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	public ResultSet dbQueryUpdatable(String queryStr) {	
		openConnection();
		// 2. Connection
		ResultSet resultSet = null;
		try {
			// 3. Statement
			statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			// 4. Execute query
			resultSet = statement.executeQuery(queryStr);
			// 5. Process
			// Left to caller	
		} catch (SQLException e) {
			System.out.println("Could not execute statement.");
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	public int dbUpdate(String updateStr) {		
		openConnection();
		// 2. Connection
		int result = 0;
		try {
			// 3. Statement
			statement = connection.createStatement();
			// 4. Execute query
			result = statement.executeUpdate(updateStr);
			// 5. Process
			// Left to caller	
		} catch (SQLException e) {
			System.out.println("Could not execute statement.");
			e.printStackTrace();
		}
		
		return result;
	}
	
	//public ResultSet dbQueryWithPrepared(String )

	@Override
	public void close() {	
		try {
			// 6. Close
			if (statement != null) statement.close();
			connection.close();			
		} catch (SQLException e) {
			System.out.println("Could not close connection.");
			e.printStackTrace();
		}
	}
}
