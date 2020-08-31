package game_engine.src.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

// Author: Jacob Angel
// Date: 8/30/2020

public class Tile {
	
	// Static Tile Initialization
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile waterTile = new WaterTile(3);
	
	// Class variables
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT,  null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	// Getters
	public int getId() {
		return id;
	}
 	
}