package br.com.dev.marcos.coffee.repositories.db;

import java.sql.Connection;

public class H2Connection {

	private static Connection connection;
	
	public H2Connection() {
		getConnection();
	}
	
	public static Connection getConnection() {
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection() {
		try {
			if(!connection.isClosed()) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
