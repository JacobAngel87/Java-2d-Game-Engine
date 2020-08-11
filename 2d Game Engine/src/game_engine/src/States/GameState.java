package game_engine.src.States;

import java.awt.Color;
import java.awt.Graphics;

import game_engine.src.Main.Game;

public class GameState extends State 
{
	
	private Game game;

	public GameState(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void tick() 
	{
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(Color.blue);
		g.fillRect(0, 0, game.width, game.height);
	}

}
