package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	private static DBConnector dbConnector;
//	private static String url = "jdbc:mysql://localhost:3306/cs542project";
//	private static String url = "jdbc:mysql://localhost:3306/cs542project";
//	
//	private static String user = "root";
//	private static String password = "123456";
	
	private static String url = "jdbc:oracle:thin:@oracle.wpi.edu:1521:wpi11grxx";
	private static String user = "yling";
	private static String password = "YLING";
	
	private Connection conn = null;

	private DBConnector() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
