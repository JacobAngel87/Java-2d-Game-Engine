package game_engine.src.States;

import java.awt.Graphics;

import game_engine.src.Entitys.Player;
import game_engine.src.Main.Game;
import game_engine.src.Worlds.World;

public class GameState extends State {
	
	private Game game;
	private Player player;
	private World overworld;

	public GameState(Game game) {
		this.game = game;
		overworld = new World("res/worlds/overworld.txt");
		player = new Player(game, overworld.getSpawnX(), overworld.getSpawnY());
	}
	
	@Override
	public void tick() {
		overworld.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		overworld.render(g);
		player.render(g);
	}

}
