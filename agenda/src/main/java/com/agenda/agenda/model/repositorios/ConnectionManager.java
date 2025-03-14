package com.agenda.agenda.model.repositorios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/agenda";
	private static final String USER = "agenda";
	// Abaixo colocar a senha do banco de dados.
	private static final String PASSWORD = "agenda123";

	private static Connection conn = null;

	static Connection getCurrentConnection() throws SQLException {

		if (conn == null)
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			

		return conn;

	}

	static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
