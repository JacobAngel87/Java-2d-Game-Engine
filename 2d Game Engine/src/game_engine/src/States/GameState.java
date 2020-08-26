package game_engine.src.States;

import java.awt.Color;
import java.awt.Graphics;

import game_engine.src.Main.Game;

public class GameState extends State 
{
	
	private Game game;
	private int x, y;

	public GameState(Game game)
	{
		this.game = game;
		x = 100;
		y = 100;
	}
	
	@Override
	public void tick() 
	{
		if(game.getKeyManager().up == true)
		{
			y-=2;
		}
		if(game.getKeyManager().down == true)
		{
			y+=2;
		}
		if(game.getKeyManager().left == true)
		{
			x-=2;
		}
		if(game.getKeyManager().right == true)
		{
			x+=2;
		}
			
	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect(0, 0, game.width, game.height);
		g.setColor(Color.blue);
		g.fillRect(x, y, 50, 50);
	}

}
