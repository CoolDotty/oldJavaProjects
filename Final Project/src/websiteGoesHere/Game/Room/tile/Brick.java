package websiteGoesHere.Game.Room.tile;

import websiteGoesHere.Game.Room.Location;
import websiteGoesHere.sprite.Sprite;

public class Brick extends Tile {
	
	protected int thickness = Tile.WALL;
	public static final int hexID = 0xFF4d2122;
	
	public Brick(Location loc) {
		super(loc);
		super.sprite = Sprite.BRICK;
	}
}
