package databaseTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import database.DBQuerier;
import entity.Player;

public class DBQuerierTest {

	@Test
	public void test() throws SQLException {
		DBQuerier dbQuerier = new DBQuerier();
		List<Player> playerlist = dbQuerier.getPlayerData();
		Player player = playerlist.iterator().next();
		
		assertEquals(player.getName(),"Cristiano Ronaldo");
		assertEquals(player.getHeight(),184);
		assertEquals(player.getAge(),29);
		
		List<Player> playerlist1 = dbQuerier.getPlayerData(null, null, 29, null, null);
		Player player1 = playerlist1.iterator().next();
		
		assertEquals(player1.getName(),"Cristiano Ronaldo");
		assertEquals(player1.getHeight(),184);
		assertEquals(player1.getAge(),29);
		
		List<Player> playerlist2 = dbQuerier.getPlayerData(null, null, 0, "France", null);
		Player player2 = playerlist2.iterator().next();
		
		assertEquals(player2.getName(),"Karim Benzema");
		assertEquals(player2.getHeight(),183);
		assertEquals(player2.getAge(),26);
		
		List<Player> playerlist3 = dbQuerier.getPlayerData("Cristiano Ronaldo", null, 29, null, null);
		Player player3 = playerlist3.iterator().next();
		
		assertEquals(player3.getName(),"Cristiano Ronaldo");
		assertEquals(player3.getHeight(),184);
		assertEquals(player3.getAge(),29);
		
		List<Player> playerlist4 = dbQuerier.getPlayerData(null, null, 29, null, "Real Madrid");
		Player player4 = playerlist4.iterator().next();
		
		assertEquals(player4.getName(),"Cristiano Ronaldo");
		assertEquals(player4.getHeight(),184);
		assertEquals(player4.getAge(),29);
		
		List<Player> playerlist5 = dbQuerier.getPlayerData(null, "Forward", 0, "Portugal", "Real Madrid");
		Player player5 = playerlist5.iterator().next();
		
		assertEquals(player5.getName(),"Cristiano Ronaldo");
		assertEquals(player5.getHeight(),184);
		assertEquals(player5.getAge(),29);
	}
}
