package main;

import parser.GameParser;
import entity.Game;

public class GameParserMain {
	public static void main(String[] args) {
		GameParser gameParser = new GameParser();
		
		for(Game game : gameParser.parse()) {
			System.out.println(game.getGameId() + "," + game.getHomeTeam() + "," + game.getAwayTeam() + "," + game.getDate());	
		}
	}
}
