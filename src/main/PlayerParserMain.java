package main;

import parser.PlayerParser;
import entity.Player;

public class PlayerParserMain {

	public static void main(String[] args) {
		PlayerParser excelParser = new PlayerParser();
		System.out.println("Output:");
		for (Player player : excelParser.parse()) {
			if (player.getName().length() > 14) {
				System.out.println(player.getName() + ",\t"
						+ player.getPosition() + ",\t" + player.getAge()
						+ ",\t" + player.getCountry() + ",\t"
						+ player.getSquad_number() + ",\t" + player.getClub()
						+ ",\t" + player.getHeight());
			} else if (player.getName().length() < 7) {
				System.out.println(player.getName() + ",\t\t\t"
						+ player.getPosition() + ",\t" + player.getAge()
						+ ",\t" + player.getCountry() + ",\t"
						+ player.getSquad_number() + ",\t" + player.getClub()
						+ ",\t" + player.getHeight());
			} else {
				System.out.println(player.getName() + ",\t\t"
						+ player.getPosition() + ",\t" + player.getAge()
						+ ",\t" + player.getCountry() + ",\t"
						+ player.getSquad_number() + ",\t" + player.getClub()
						+ ",\t" + player.getHeight());

			}

		}
	}
}
