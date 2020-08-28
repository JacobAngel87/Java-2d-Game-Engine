package game_engine.src.Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	public static BufferedImage grass, stone, water;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		grass = sheet.crop(0, 0, width, height);
		water = sheet.crop(width, 0, width, height);
		stone = sheet.crop(0, height, width, height);
	}
}