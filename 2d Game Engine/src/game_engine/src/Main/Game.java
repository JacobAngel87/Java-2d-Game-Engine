package game_engine.src.Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game_engine.src.Graphics.Assets;
import game_engine.src.Graphics.Display;
import game_engine.src.Graphics.GameCamera;
import game_engine.src.States.GameState;
import game_engine.src.States.State;

// Author: Jacob Angel
// Date: 8/30/2020

public class Game implements Runnable {
	
	// JFrame variables
	private int width, height;
	public String title;
	
	// Threading and game loop variables
	private Thread thread;
	private boolean running = false;
	
	// Graphics variables
	private Display display;
	private Graphics g;
	private BufferStrategy bs;
	
	// State variables
	public static State overworld;
	
	// Input varibles
	private KeyManager keyManager;
	
	// Camera Variables
	private GameCamera gameCamera;
	
	// Game class constructor
	public Game(String title) {
		this.title = title;
		keyManager = new KeyManager();
	}
	
	public void run() {
		init();
		running = true;
		
		// V-Sync
		int fps = 144;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += now - lastTime;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= timePerTick) {
				tick();
				render();
			 	ticks++;
			 	delta -= timePerTick;
			}
			/* 	Prints out the Ticks and frames of the game loop.
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			} */
		}
	}
	
	private void init() {
		display = new Display(title);
		width = display.getWidth();
		height = display.getHeight();
		Assets.init();
		gameCamera = new GameCamera(this, 0, 0);
		display.getFrame().addKeyListener(keyManager);
		overworld = new GameState(this);
		State.setState(overworld);
	}
	
	// Gets the current state of the game and ticks it
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	// Gets the current state of the game and renders it
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		// Start draw graphics
		if(State.getState() != null) {
			State.getState().render(g);
		}
		// Stop draw graphics
		
		bs.show();
		g.dispose();
		
	}
	
	// Start and stop thread methods
	public synchronized void start() {
		if(running)
			return;
		thread = new Thread(this);
		thread.run();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Getters and Setters
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}