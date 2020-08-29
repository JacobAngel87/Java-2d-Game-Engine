package game_engine.src.Entitys;

import java.awt.Graphics;

import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Game;
import game_engine.src.Tiles.Tile;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up) {
			yMove = -speed;
		}
		if(game.getKeyManager().down) {
			yMove = speed;
		}
		if(game.getKeyManager().left) {
			xMove = -speed;
		}
		if(game.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rigby, (int) x, (int) y, width, height, null);
	}

}
