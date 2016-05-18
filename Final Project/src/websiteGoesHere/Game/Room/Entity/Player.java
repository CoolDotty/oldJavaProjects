package websiteGoesHere.Game.Room.Entity;

import websiteGoesHere.Engine;
import websiteGoesHere.Game.Room.Location;
import websiteGoesHere.Game.Room.Room;
import websiteGoesHere.sprite.Sprite;

public class Player extends Entity {

	public Player(int x, int y) {
		super(new Location(x, y, 10, 10));
		super.sprite = Sprite.PLAYER;
	}

	public void update(Engine e, Room room) {
		if (e.up_hold) {
			loc.y -= 2;
		} else if (e.down_hold) {
			loc.y += 2;
		}
		if (e.left_hold) {
			loc.x -= 2;
		} else if (e.right_hold) {
			loc.x += 2;
		}
	}

	public void move(Room room, int x, int y) {
		
	}
}
