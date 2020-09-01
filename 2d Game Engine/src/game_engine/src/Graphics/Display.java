package game_engine.src.Graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

// Author: Jacob Angel
// Date: 8/30/2020

public class Display {
	
	// JFrame and Canvas variables 
	private int width, height;
	private String title;
	private JFrame frame;
	private Canvas canvas;
	private Dimension screenSize;
	
	// Constucor of the display class
	// Gets the computers screen size and makes a JFrame fitted to that size
	public Display(String title) {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		width = screenSize.width;
		height = screenSize.height;
		this.title = title;
		
		frame = new JFrame(title);
		canvas = new Canvas();
		createDisplay();
	}
	
	private void createDisplay() {
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.setPreferredSize(screenSize);
		canvas.setMaximumSize(screenSize);
		canvas.setMinimumSize(screenSize);
		
		frame.add(canvas);
		frame.pack();
	}
	
	// Getters
	public JFrame getFrame() {
		return frame;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}