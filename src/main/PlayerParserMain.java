package main;

import parser.PlayerParser;
import entity.Player;

public class PlayerParserMain {
	
	public static void main(String[] args) {
		PlayerParser excelParser = new PlayerParser();
		
		for(Player player : excelParser.parse()) {
			System.out.println(player.getName() + "," + player.getAge());	
		}	
	}
}
