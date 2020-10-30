package game_engine.src.Tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game_engine.src.Graphics.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	public void tick() {
		
	}
	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}
}