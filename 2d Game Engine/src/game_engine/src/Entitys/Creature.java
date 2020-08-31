package game_engine.src.Entitys;

import game_engine.src.Main.Game;
import game_engine.src.Tiles.Tile;

// Author: Jacob Angel
// Date: 8/30/2020

public abstract class Creature extends Entity {
	
	// Default varibles for all creatures
	public static final float DEFAULT_SPEED = Tile.TILEWIDTH / 34;
	public static final int DEFAULT_WIDTH = 64,
							DEFAULT_HEIGHT = 64;
	
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	// Move function for player and other creatures
	public void move() {
		x += xMove;
		y += yMove;
	}
	
	// Getters and Setters 
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
}