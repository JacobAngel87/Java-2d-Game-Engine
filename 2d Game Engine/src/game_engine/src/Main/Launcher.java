package game_engine.src.Main;

import game_engine.src.Graphics.Display;

public class Launcher 
{
	public static void main(String[] args)
	{
		Game game = new Game("Hello?");
		game.start();
	}
}