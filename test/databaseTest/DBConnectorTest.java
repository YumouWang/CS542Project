package databaseTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import database.DBConnector;

public class DBConnectorTest {
	
	@Test
	public void testDBConnection() throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		assertNotNull(conn);
	}
}
