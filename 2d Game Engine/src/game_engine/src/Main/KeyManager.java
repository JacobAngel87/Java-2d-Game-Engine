package game_engine.src.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Author: Jacob Angel
// Date: 8/30/2020

public class KeyManager implements KeyListener {
	
	// Class Variables
	private boolean[] keys;
	public boolean up, down, left, right, enter;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	// Creating Key Events for all possible inputs
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		enter = keys[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
