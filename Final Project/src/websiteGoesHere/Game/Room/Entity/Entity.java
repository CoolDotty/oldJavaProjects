package websiteGoesHere.Game.Room.Entity;

import processing.core.PImage;
import websiteGoesHere.Engine;
import websiteGoesHere.Game.Room.Location;
import websiteGoesHere.Game.Room.Room;
import websiteGoesHere.sprite.SpriteBuilder;

public abstract class Entity {
	
	protected Location loc;
	protected PImage sprite;
	public boolean removed = false;
	
	public Entity(Location loc) {
		this.loc = loc;
	}
	
	public void update(Engine e, Room room) {
		
	}
	
	public SpriteBuilder render(SpriteBuilder sb, int x, int y) {
		sb.addSprite(sprite, x, y, true);
		return sb;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public void remove() {
		removed = true;
	}
}
