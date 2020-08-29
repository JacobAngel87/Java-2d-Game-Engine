package game_engine.src.Tiles;

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
}