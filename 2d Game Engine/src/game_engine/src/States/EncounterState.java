package game_engine.src.States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Handler;
import game_engine.src.Tiles.Tile;

public class EncounterState extends State {

	private Tile tile;
	private BufferedImage background;
	private Rectangle encounterWindow;
	
	public EncounterState(Handler handler, Tile tile, BufferedImage background) {
		super(handler);
		this.tile = tile;
		this.background = background;
		encounterWindow = new Rectangle((int)((handler.getWidth() * 10) * (.01)), (int)((handler.getHeight() * 13) * (.01)), 
				(int)((handler.getWidth() * 80) * (.01)),(int)((handler.getHeight() * 75) * (.01)));
	}

	@Override
	public void tick() {
		if(handler.getKeyManager().enter) {
			State.setState(handler.getGame().overworld); // I think I messed something up so I am going to re-commit this to the github master branch
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, handler.getWidth(), handler.getHeight(), null);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(encounterWindow.x, encounterWindow.y, encounterWindow.width, encounterWindow.height);
	}

}
