package websiteGoesHere.Game.Room.tile;


import websiteGoesHere.Game.Room.Location;
import websiteGoesHere.sprite.Sprite;

public class Grass extends Tile {
	
	protected int thickness = Tile.WALKABLE;
	public static final int hexID = 0xFF016D1B;
	
	public Grass(Location loc) {
		super(loc);
		super.sprite = Sprite.GRASS;
	}
}
