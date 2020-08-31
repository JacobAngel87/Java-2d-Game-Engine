package game_engine.src.Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	public static BufferedImage grass, stone, water, dirt, rigby, townOnDirt, townOnGrass;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet_v4.png"));
		grass = sheet.crop(0, 0, width, height);
		water = sheet.crop(width, 0, width, height);
		stone = sheet.crop(0, height, width, height);
		dirt = sheet.crop(width, height, width, height);
		townOnDirt = sheet.crop(width * 2, 0, width, height);
		townOnGrass = sheet.crop(width * 2, height, width, height);
		
		rigby = ImageLoader.loadImage("/textures/rigby.png");
	}
}