package game_engine.src.States;

import java.awt.Color;
import java.awt.Graphics;

import game_engine.src.Main.Handler;

public class EncounterState extends State {

	public EncounterState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		if(handler.getKeyManager().enter) {
			State.setState(handler.getGame().overworld);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.setColor(Color.white);
		g.drawString("Encounter Has Started!", handler.getWidth() / 2, handler.getWidth() / 4);
	}

}
