package common;

public enum Country {
	Any("Any"), Argentina("Argentina"), Australia("Australia"), Belgium(
			"Belgium"), Brazil("Brazil"), Colombia("Colombia"), Costa_Rica(
			"Costa Rica"), Cote_dIvoire("Cote_dIvoire"), Croatia("Croatia"), England(
			"England"), France("France"), Germany("Germany"), Italy("Italy"), Mexico(
			"Mexico"), Netherlands("Netherlands"), Portugal("Portugal"), Serbia(
			"Serbia"), Slovakia("Slovakia"), Spain("Spain"), Sweden("Sweden"), Uruguay(
			"Uruguay"), Wales("Wales");

	private String country;

	Country(String country) {
		this.country = country;
	}

	public String getCountryName() {
		return country;
	}
}
