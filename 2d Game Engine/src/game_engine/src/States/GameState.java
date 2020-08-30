package game_engine.src.States;

import java.awt.Graphics;

import game_engine.src.Entitys.Player;
import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Game;
import game_engine.src.Worlds.World;

public class GameState extends State {
	
	private Game game;
	private Player player;
	private World world;

	public GameState(Game game) {
		this.game = game;
		world = new World("res/worlds/overworld.lvl");
		player = new Player(game, world.getSpawnX(), world.getSpawnY());
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
}