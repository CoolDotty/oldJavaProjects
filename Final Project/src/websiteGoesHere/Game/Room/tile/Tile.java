package websiteGoesHere.Game.Room.tile;

import processing.core.PImage;
import websiteGoesHere.Engine;
import websiteGoesHere.Game.Room.Location;
import websiteGoesHere.sprite.SpriteBuilder;

public abstract class Tile {
	
	public static final int WALKABLE = 0;
	public static final int COVER = 1;
	public static final int WALLBANGABLE = 2;
	public static final int WALL = 3;
	
	public static final int hexID = -1;
	
	public static final int WIDTH = 16;
	public static final int HEIGHT = 16;
	
	protected int thickness;
	protected Location loc;
	protected PImage sprite;
	
	public Tile(Location loc) {
		this.loc = loc;
	}
	
	public void update(Engine e) {
		
	}
	
	public SpriteBuilder render(SpriteBuilder sb, int x, int y) {
		sb.addSprite(sprite, x, y, false);
		return sb;
	}
	
	public int getThickness() {
		return thickness;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public static int getHexID() {
		return hexID;
	}
}
