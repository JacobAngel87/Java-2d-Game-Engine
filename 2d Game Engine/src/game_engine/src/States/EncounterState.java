package game_engine.src.States;

import java.awt.Color;
import java.awt.Graphics;

import game_engine.src.Main.Handler;
import game_engine.src.Tiles.Tile;

public class EncounterState extends State {

	private Tile tile;
	public EncounterState(Handler handler, Tile tile) {
		super(handler);
		this.tile = tile;
	}

	@Override
	public void tick() {
		if(handler.getKeyManager().enter) {
			State.setState(handler.getGame().overworld);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tile.getTexture(), 0, 0, handler.getWidth(), handler.getHeight(), null);
	}

}
