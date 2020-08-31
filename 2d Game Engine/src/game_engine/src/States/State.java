package game_engine.src.States;

import java.awt.Graphics;

import game_engine.src.Main.Game;

// Author: Jacob Angel 
// Date: 8/30/2020

public abstract class State {
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
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