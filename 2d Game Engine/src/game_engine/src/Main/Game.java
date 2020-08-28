package game_engine.src.Main;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import game_engine.src.Graphics.Assets;
import game_engine.src.Graphics.Display;
import game_engine.src.States.GameState;
import game_engine.src.States.State;

public class Game implements Runnable {
	public int width, height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	
	private Display display;
	private Graphics g;
	private BufferStrategy bs;
	
	public static State overworld;
	
	private KeyManager keyManager;
	
	public Game(String title) {
		this.title = title;
		keyManager = new KeyManager();
	}
	
	public void run() {
		init();
		running = true;
		
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
			 	ticks++;
			 	delta -= timePerTick;
			}
			 
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
			render();
		}
	}
	
	private void init() {
		display = new Display(title);
		width = display.getWidth();
		height = display.getHeight();
		Assets.init();
		display.getFrame().addKeyListener(keyManager);
		overworld = new GameState(this);
		State.setState(overworld);
	}
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		// Start draw graphics;
		if(State.getState() != null) {
			State.getState().render(g);
		}
		// Stop draw graphics
		
		bs.show();
		g.dispose();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
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
}