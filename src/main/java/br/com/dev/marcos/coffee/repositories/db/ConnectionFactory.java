package br.com.dev.marcos.coffee.repositories.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static volatile ConnectionFactory instance;
	
	private String url;
	private String user;
	private String pass;
	private String driver;
	
	private volatile Connection connection;

	public ConnectionFactory(String url, String user, String pass, String driver) {
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.driver = driver;
	}
	
	public static ConnectionFactory getInstance() {
		
		ConnectionFactory conn = instance;
		
		if(conn != null) {
			return conn; 
		}
		
		Properties prop = new Properties();
		try(FileInputStream file = new FileInputStream("./src/main/resource/application.properties")) {
			String url = prop.getProperty("datasource.url");
			String user = prop.getProperty("datasource.username");
			String pass = prop.getProperty("datasource.password");
			String driver = prop.getProperty("datasource.driver-class-name");
			
			synchronized (ConnectionFactory.class) {
				if(instance == null) {
					instance = new ConnectionFactory(url, user, pass, driver);
				}
				return instance;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Connection getConnection() {
		synchronized (Connection.class) {
			try {
				
				if(this.connection != null && !this.connection.isClosed()) return this.connection;
				
				if(this.getDriver() == null || this.getDriver().isEmpty()) throw new RuntimeException("Nenhum driver de conexão informado!");
				if(this.getUrl() == null || this.getUrl().isEmpty()) throw new RuntimeException("Nenhuma url de conexão informada!");
				if(this.getUser() == null || this.getUser().isEmpty()) throw new RuntimeException("Nenhum usuário de conexão informado!");
				
				Class.forName(this.getDriver());
				
				this.connection = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
				
				return this.connection;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public static void setInstance(ConnectionFactory instance) {
		ConnectionFactory.instance = instance;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
