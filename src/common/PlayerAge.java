package common;

public enum PlayerAge {
	Any("Any"), Age1(" < 21"), Age2("21 ~ 25"), Age3("26 ~ 30"), Age4("31 ~ 35"), Age5(
			" > 35");

	private String PlayerAge;

	PlayerAge(String PlayerAge) {
		this.PlayerAge = PlayerAge;
	}

	public String getPlayerAge() {
		return PlayerAge;
	}

}
