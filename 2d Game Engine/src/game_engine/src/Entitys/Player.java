package game_engine.src.Entitys;

import java.awt.Graphics;

import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Game;
import game_engine.src.Tiles.Tile;

public class Player extends Creature {
	
	public Player(Game game, float x, float y) {
		super(game, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
	}

	@Override
	public void tick() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
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
		g.drawImage(Assets.rigby, (int) (x - game.getGameCamera().getxOffset()), 
				(int) (y - game.getGameCamera().getyOffset()), width, height, null);
	}

}
