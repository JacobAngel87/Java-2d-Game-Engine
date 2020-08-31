package game_engine.src.Main;

import game_engine.src.Graphics.Display;

// Author: Jacob Angel
// Date: 8/30/2020

// Launcher class that creates a new instance of the game and starts it. 
public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Hello?");
		game.start();
	}
}