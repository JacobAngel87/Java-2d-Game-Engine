package game_engine.src.Graphics;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display 
{
	private int width, height;
	private String title;
	private JFrame frame;
	private Canvas canvas;
	
	
	public Display(int width, int height, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		frame = new JFrame(title);
		canvas = new Canvas();
		createDisplay();
	}
	
	private void createDisplay()
	{
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}