package game_engine.src.States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game_engine.src.Entitys.Player;
import game_engine.src.Graphics.Assets;
import game_engine.src.Graphics.ImageLoader;
import game_engine.src.Main.Game;

public class GameState extends State {
	
	private Game game;
	private Player player;

	public GameState(Game game) {
		this.game = game;
		player = new Player(game, 100, 100);
		
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, game.width, game.height);
		player.render(g);
	}

}
