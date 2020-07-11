package game_engine.src.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game_engine.src.Graphics.Display;

public class Game implements Runnable
{
	public int width, height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	
	private Display display;
	private Graphics g;
	private BufferStrategy bs;
	
	//Tmp variables to work on frame-rate independence
	private float playerX;
	private float playerY;
	private float speed;
	
	public Game(int width, int height, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		playerX = 0.0f;
		playerY = 0.0f;
		speed = 3.0f;
	}
	
	public void run()
	{
		init();
		running = true;
		
		int fps = 144;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running)
		{
			now = System.nanoTime();
			delta += now - lastTime;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= timePerTick) 
			{
				tick();
			 	ticks++;
			 	delta -= timePerTick;
			}
			 
			if(timer >= 1000000000) 
			{
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
			render();
		}
	}
	
	private void init()
	{
		display = new Display(width, height, title);
	}
	
	private void tick()
	{
		//TODO Kill V-Sync and implement delta time. 
		playerX += speed;
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		// Start draw graphics
		g.setColor(new Color(0, 0, 140, 140));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.red);
		g.fillRect((int) playerX, (int) playerY, 50, 50);
		
		// Stop draw graphics
		
		bs.show();
		g.dispose();
		
	}
	
	public synchronized void start()
	{
		if(running)
			return;
		thread = new Thread(this);
		thread.run();
	}
	
	public synchronized void stop()
	{
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}