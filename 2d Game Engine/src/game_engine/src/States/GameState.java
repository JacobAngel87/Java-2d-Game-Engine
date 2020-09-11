package game_engine.src.States;

import java.awt.Graphics;

import game_engine.src.Entitys.Player;
import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Handler;
import game_engine.src.Worlds.World;

// Author: Jacob Angel
// Date: 8/30/2020

public class GameState extends State {
	
	// Things that are in this state of the game
	private World world;
	private Player player;
	
	// Initialize the gamestate objects
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/overworld.lvl");
		handler.setWorld(world);
		player = new Player(handler, world.getSpawnX(), world.getSpawnY());
	}
	
	// Tick them all
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	// Render them all
	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
}