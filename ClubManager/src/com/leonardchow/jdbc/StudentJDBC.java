package com.leonardchow.jdbc;
import com.leonardchow.students.*;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;

public class StudentJDBC {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Conncting to database");
		
		// 1. Driver
		Class.forName("com.mysql.jdbc.Driver");
		// 2. Connection
		String connStr = "jdbc:mysql://localhost:3306/scratchDB";
		Connection connection = DriverManager.getConnection(connStr, "root", "password");
		// 3. Statement
		Statement statement = connection.createStatement();
		// 4. Execute query
		String queryStr = "SELECT * FROM scratchDB.students;";
		ResultSet resultSet = statement.executeQuery(queryStr);
		// 5. Process
		while (resultSet.next()) {
			Student student = new Student();
			student.setId(resultSet.getString("id"));
			student.setFirstName(resultSet.getString("firstName"));
			student.setLastName(resultSet.getString("lastName"));
			student.setFeeTotal(resultSet.getDouble("feeTotal"));
			student.setFeePaid(resultSet.getDouble("feePaid"));
			System.out.println(student.toString());
		}
		// 6. Close
		statement.close();
		connection.close();
	}
}
