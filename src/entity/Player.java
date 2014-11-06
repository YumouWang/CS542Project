package entity;

public class Player {
	private String name;
	private String position;
	private int age;
	private String country;
	private int squad_number;
	private String club;
	private int height;
	private int marketValue;

	public Player(String name, String position, int age, String country,
			int squad_number, String club, int height) {
		this.name = name;
		this.position = position;
		this.age = age;
		this.country = country;
		this.squad_number = squad_number;
		this.club = club;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getCountry() {
		return country;
	}

	public int getSquad_number() {
		return squad_number;
	}

	public String getClub() {
		return club;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}
}
