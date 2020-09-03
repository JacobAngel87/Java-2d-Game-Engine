package game_engine.src.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game_engine.src.Graphics.Assets;

public class GrassTile extends Tile {
	
	public GrassTile(int id) {
		super(Assets.grass, id);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stubs
	}
	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}
	@Override 
	public boolean isDanger() {
		return true;
	}
	
}