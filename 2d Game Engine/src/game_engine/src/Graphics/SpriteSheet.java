package game_engine.src.Graphics;

import java.awt.image.BufferedImage;

// Author: Jacob Angel
// Date: 8/30/2020

public class SpriteSheet {
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	// Crops out a segement of an image
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}