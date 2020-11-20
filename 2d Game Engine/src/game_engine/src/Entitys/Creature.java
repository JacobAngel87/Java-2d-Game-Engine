package game_engine.src.Entitys;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import game_engine.src.Main.Handler;
import game_engine.src.Main.Utils;
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
			int tx = calcTempX(false);
			if(rightSideColliding(tx)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			checkDanger(true, true);
		} else if(xMove < 0) { // Left side collision
			
			int tx = calcTempX(true);
			if(leftSideColliding(tx)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			checkDanger(true, false);
		}
	}
	
	public void yMove() {
		if(yMove < 0) { // Top side collision
			
			int ty = calcTempY(true);
			if(topSideColliding(ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			checkDanger(false, true);
		}else if(yMove > 0) { // Bottom side collision
			int ty = calcTempY(false);
			if(bottomSideColliding(ty)) {
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
		ArrayList<Integer> calcs = new ArrayList<Integer>();
		calcs = getMovementCalcs();
		if(horo) {
			if(side) {
				int tx = calcTempX(false);
				if(collisionWithDangerTile(tx, calcs.get(0)) && collisionWithDangerTile(tx, calcs.get(1))) {
					checkBattle(tx, calcs.get(0));
				}
			} else {
				int tx = calcTempX(true);
				if(collisionWithDangerTile(tx, calcs.get(0)) && collisionWithDangerTile(tx, calcs.get(1))) {
					checkBattle(tx, calcs.get(0));
				}
			}
		} else {
			if(side) {
				int ty = calcTempY(true);
				if(collisionWithDangerTile(calcs.get(2), ty) && collisionWithDangerTile(calcs.get(3), ty)) {
					checkBattle(calcs.get(2), ty);
				}
			} else {
				int ty = calcTempY(false);
				if(collisionWithDangerTile(calcs.get(2), ty) && collisionWithDangerTile(calcs.get(3), ty)) {
					checkBattle(calcs.get(2), ty);
				}
			}
		}
	}
	
	// Protected Collision Methods
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	protected boolean collisionWithDangerTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isDanger();
	}
	
	private ArrayList<Integer> getMovementCalcs() {
		ArrayList<Integer> theMoves = new ArrayList<Integer>();
		theMoves.add((int) (y + bounds.y) / Tile.TILEHEIGHT);
		theMoves.add((int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT);
		theMoves.add((int) (x + bounds.x) / Tile.TILEWIDTH);
		theMoves.add((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH);
		return theMoves; 
	}
	
	// Collision Detection
	private boolean rightSideColliding(int tx) {
		if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean leftSideColliding(int tx) {
		if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
			return true;
		} else {
			return false;
		}
	}
	private boolean topSideColliding(int ty) {
		if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
			return true;
		} else {
			return false;
		}
	}
	private boolean bottomSideColliding(int ty) {
		if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
			return true;
		} else {
			return false;
		}
	}
	private int calcTempX(boolean left) {
		int tx;
		if(left) {
			tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
		} else {
			tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
		}
		return tx;
	}
	private int calcTempY(boolean top) {
		int ty;
		if(top) {
			ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
		} else {
			ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
		}
		return ty;
	}
	
	// Random Battles
	private void checkBattle(int x, int y) {
		Random r = new Random();
		int num = r.nextInt(800);
		BufferedImage capture = null;
		if(num == 799) {
			// Screen Capturing
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			try {
				capture = new Robot().createScreenCapture(screenRect);
				capture = Utils.grayScaleImage(capture);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			Tile currentTile = handler.getWorld().getTile(x, y);
			State encounter = new EncounterState(handler, currentTile, capture);
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