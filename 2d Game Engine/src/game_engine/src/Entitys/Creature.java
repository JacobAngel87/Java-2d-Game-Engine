package game_engine.src.Entitys;

import java.awt.Graphics;

public abstract class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 1.5f;
	public static final int DEFAULT_WIDTH = 64,
							DEFAULT_HEIGHT = 64;
	
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
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