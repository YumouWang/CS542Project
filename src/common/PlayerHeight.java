package common;

public enum PlayerHeight {
	Any("Any"), Height1(" < 170"), Height2("170 ~ 175"), Height3(
			"176 ~ 180"), Height4("181 ~ 185"), Height5("186 ~ 190"), Height6(
			" > 190");

	private String playerHeight;

	PlayerHeight(String playerHeight) {
		this.playerHeight = playerHeight;
	}

	public String getPlayerHeight() {
		return playerHeight;
	}
}
