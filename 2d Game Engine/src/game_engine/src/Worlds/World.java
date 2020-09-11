package game_engine.src.Worlds;

import java.awt.Graphics;

import game_engine.src.Entitys.Player;
import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Handler;
import game_engine.src.Main.Utils;
import game_engine.src.Tiles.Tile;

// Author: Jacob Angel
// Date: 8/30/2020

public class World {
	
	private int width, height;
	private int spawnX, spawnY;
	private int[][] worldTiles;
	private String overworld = "res/worlds/overworld.lvl";
	private String testTown = "res/worlds/testTown.lvl";
	private Handler handler;
		
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick() {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x,y).tick(); 
			}
		}
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x > width || y > height) {
			return Tile.grassTile;
		}
			
		Tile t = Tile.tiles[worldTiles[x][y]];
		if(t == null) {
			return Tile.dirtTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		worldTiles = new int[width][height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				worldTiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
			}
		}
	}

	// Getters and Setters
	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}