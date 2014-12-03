package main;

import view.LaunchGUI;

public class MainGUI {
	/**
	 * 
	 * Launch the Application GUI
	 */
	public static void main(String[] args) {

		LaunchGUI launchGUI = new LaunchGUI();
		launchGUI.add(LaunchGUI.container);
		launchGUI.setVisible(true);
	}
}