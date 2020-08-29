package game_engine.src.Tiles;

import java.awt.image.BufferedImage;

import game_engine.src.Graphics.Assets;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Assets.water, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
