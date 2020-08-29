package game_engine.src.Entitys;

import java.awt.Graphics;

public abstract class Entity {
	
	// Protected variables for all Sub-classes
	protected float x, y;
	protected int width, height;
	
	// Entity constructor method
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	// Abstract methods for sub-classes
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	// Getters and setters for the Entity Super-Class
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}