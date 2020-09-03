package game_engine.src.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game_engine.src.Graphics.Assets;

public class DirtTile extends Tile {

	public DirtTile(int id) {
		super(Assets.dirt, id);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}

}