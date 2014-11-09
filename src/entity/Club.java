package entity;

import java.util.Collection;

public class Club {
	String clubName;
	String homeStadium;
	String coach;
	int ranking;

	Collection<Player> playerList;
	
	public Club(String clubName, String homeStadium, String coach, int ranking) {
		this.clubName = clubName;
		this.homeStadium = homeStadium;
		this.coach = coach;
		this.ranking = ranking;
	}
	
	public String getClubName() {
		return clubName;
	}
	
	public String getHomeStadium() {
		return homeStadium;
	}
	
	public String getCoach() {
		return coach;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	
}
