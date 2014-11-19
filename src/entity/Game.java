package entity;

public class Game {
	int gameId;
	String homeTeam;
	String awayTeam;
	String date;
	
	public Game(int gameId, String homeTeam, String awayTeam, String date) {
		this.gameId = gameId;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.date = date;
	}

	public int getGameId() {
		return gameId;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public String getDate() {
		return date;
	}
}
