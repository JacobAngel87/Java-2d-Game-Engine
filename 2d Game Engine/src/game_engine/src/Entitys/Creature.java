package game_engine.src.Entitys;

import java.util.Random;

import game_engine.src.Main.Handler;
import game_engine.src.States.EncounterState;
import game_engine.src.States.State;
import game_engine.src.Tiles.Tile;

// Author: Jacob Angel
// Date: 8/30/2020

public abstract class Creature extends Entity {
	
	// Default varibles for all creatures
	public static final float DEFAULT_SPEED = Handler.DEFAULT_WIDTH / 60;
	public static final int DEFAULT_WIDTH = Tile.TILEWIDTH,
							DEFAULT_HEIGHT = Tile.TILEHEIGHT;
	
	protected float speed;
	protected float xMove, yMove;
		
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	// Move function for player and other creatures
	public void move() {
		xMove();
		yMove();
	}
	
	public void xMove() {
		if(xMove > 0) { // Right side collision 
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			checkDanger(true, true);
		} else if(xMove < 0) { // Left side collision
			
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			checkDanger(true, false);
		}
	}
	
	public void yMove() {
		if(yMove < 0) { // Top side collision
			
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			checkDanger(false, true);
		}else if(yMove > 0) { // Bottom side collision
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
			checkDanger(false, false);
		}
	}
	
	// My coding skills are complete garbage
	// TODO Get good!
	private void checkDanger(boolean horo, boolean side) {
		if(horo) {
			if(side) {
				int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
				if(collisionWithDangerTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
						collisionWithDangerTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
					checkBattle();
				}
			} else {
				int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
				if(collisionWithDangerTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
						collisionWithDangerTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
					checkBattle();
				}
			}
		} else {
			if(side) {
				int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
				if(collisionWithDangerTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
						collisionWithDangerTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
					checkBattle();
				}
			} else {
				int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
				if(collisionWithDangerTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
						collisionWithDangerTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
					checkBattle();
				}
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	protected boolean collisionWithDangerTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isDanger();
	}
	
	// Random Battles
	
	private void checkBattle() {
		Random r = new Random();
		int num = r.nextInt(800);
		if(num == 799) {
			State encounter = new EncounterState(handler);
			State.setState(encounter);
		}
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