package game_engine.src.Graphics;

import java.awt.image.BufferedImage;

// Author: Jacob Angel
// Date: 8/30/2020

public class Assets {
	
	// Static Assets
	private static final int width = 32, height = 32;
	public static BufferedImage grass, stone, water, dirt, player, town;
	
	// Initializing static assets
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet_v5.2.png"));
		grass = sheet.crop(0, 0, width, height);
		water = sheet.crop(width, 0, width, height);
		stone = sheet.crop(0, height, width, height);
		dirt = sheet.crop(width, height, width, height);
		town = sheet.crop(width * 2, 0, width, height);
		player = sheet.crop(width * 2, height, width, height);
	}
}