package game_engine.src.Entitys;

import java.awt.Color;
import java.awt.Graphics;

import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Handler;
import game_engine.src.Tiles.Tile;

// Author: Jacob Angel
// Date: 8/30/2020

public class Player extends Creature {
	
	public Player(Handler handler, float x, float y) {
		super(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
		bounds.x = (width / 3) + (width / 11);
		bounds.y = (height / 5);
		bounds.width = (width / 5);
		bounds.height = (int) (height / 1.3);
	}

	// Reads user input then moves the player based on the input and centers the camera around the player
	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	// Renders the player and camera to the game
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
