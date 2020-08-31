package game_engine.src.States;

import java.awt.Graphics;

import game_engine.src.Main.Handler;

// Author: Jacob Angel 
// Date: 8/30/2020

public abstract class State {
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	// State Variables
	private static State currentState = null;
	
	public static State getState() {
		return currentState;
	}
	public static void setState(State state) {
		currentState = state;
	}
	
	// Abstract class methods
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}