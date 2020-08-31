package game_engine.src.Entitys;

import java.awt.Graphics;

import game_engine.src.Main.Handler;

// Author: Jacob Angel
// Date: 8/30/2020

public abstract class Entity {
	
	// Protected variables for all Sub-classes
	protected float x, y;
	protected int width, height;
	protected Handler handler;
	
	// Entity constructor method
	public Entity(Handler handler , float x, float y, int width, int height) {
		this.handler = handler;
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