package websiteGoesHere.Game;

import websiteGoesHere.Engine;
import websiteGoesHere.Game.Room.Room;

public class Game {

	public Room currentRoom;
	
	public Game(Engine e, String path) {
		currentRoom = new Room(e, path);
	}
	
	public void update(Engine e) {
		currentRoom.update(e);
	}
	
	public void render(Engine e) {
		currentRoom.render(e);
	}
	
}
