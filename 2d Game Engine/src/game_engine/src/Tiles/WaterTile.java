package game_engine.src.Tiles;

import java.awt.Graphics;

import game_engine.src.Graphics.Animation;
import game_engine.src.Graphics.Assets;

public class WaterTile extends Tile {
	
	private Animation waterAni;
	
	public WaterTile(int id) {
		super(Assets.water, id);
		waterAni = new Animation(300, Assets.waterAni);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
	@Override
	public void tick() {
		waterAni.tick();
	}

	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(waterAni.getCurrentFrame(), x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}

}
