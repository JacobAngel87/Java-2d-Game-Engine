package game_engine.src.States;

import java.awt.Graphics;

public abstract class State 
{
	public State()
	{
		
	}
	
	// State Variables
	private static State currentState = null;
	
	public static State getState() 
	{
		return currentState;
	}
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	// Abstract class methods
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
