package game_engine.src.States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game_engine.src.Graphics.ImageLoader;
import game_engine.src.Main.Game;

public class GameState extends State 
{
	
	private Game game;
	private BufferedImage rigbone;
	private int x, y;

	public GameState(Game game)
	{
		this.game = game;
		x = 100;
		y = 100;
		rigbone = ImageLoader.loadImage("/textures/rigby.png");
	}
	
	@Override
	public void tick() 
	{
			if(game.getKeyManager().up)
			{
				y -= 2;
			}
			if(game.getKeyManager().down)
			{
				y += 2;
			}
			if(game.getKeyManager().left)
			{
				x -= 2;
			}
			if(game.getKeyManager().right)
			{
				x += 2;
			}
	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(Color.blue);
		g.fillRect(0, 0, game.width, game.height);
		g.drawImage(rigbone, x, y, 128, 128, null);
	}

}
