package game_engine.src.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game_engine.src.Graphics.Assets;
import game_engine.src.Main.Handler;

// Author: Jacob Angel
// Date: 8/30/2020

public abstract class Tile {
	
	// Static Tile Initialization
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile waterTile = new WaterTile(3);
	
	// Class variables
	public static final int TILEWIDTH = Handler.DEFAULT_WIDTH, TILEHEIGHT = Handler.DEFAULT_HEIGHT;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	// Ticks every tile in range
	public abstract void tick();
	
	// Renders every tile in range
	public abstract void render(Graphics g, int x, int y);
	
	public boolean isSolid() {
		return false;
	}
	
	public boolean isDanger() {
		return false;
	}
	
	// Getters
	public int getId() {
		return id;
	}
 	
}