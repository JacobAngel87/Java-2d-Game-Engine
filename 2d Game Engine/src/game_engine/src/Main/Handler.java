package game_engine.src.Main;

import game_engine.src.Graphics.GameCamera;
import game_engine.src.Worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public static int DEFAULT_WIDTH = 64;
	public static int DEFAULT_HEIGHT = 64;
	
	public Handler(Game game) {
		this.game = game;
		DEFAULT_WIDTH = getWidth() / 10;
		DEFAULT_HEIGHT = getHeight() / 10;
	}
	
	// Getters and Setters
	public int getWidth() {
		return game.getWidth();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}