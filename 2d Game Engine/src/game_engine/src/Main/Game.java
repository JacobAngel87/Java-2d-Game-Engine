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
	
	public Game(int width, int height, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	public void run()
	{
		init();
		
		running = true;
		
		while(running)
		{
			tick();
			render();
		}
	}
	
	private void init()
	{
		display = new Display(width, height, title);
	}
	
	private void tick()
	{
		System.out.println("Ticking");
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
