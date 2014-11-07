package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	private static DBConnector dbConnector;
	private static String url = "jdbc:mysql://2012-20130817HC:3306/cs542project";
	private static String user = "root";
	private static String password = "123456";
	private Connection conn = null;

	private DBConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBConnector getInstance() {
		if (dbConnector == null) {
			dbConnector = new DBConnector();
		}
		return dbConnector;
	}

	/*
	 * getters and setters
	 */
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
