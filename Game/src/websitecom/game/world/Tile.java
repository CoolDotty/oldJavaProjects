package websitecom.game.world;

import websitecom.game.Game;
import websitecom.game.graphics.Sprite;

public class Tile {

	private Sprite sprite;
	private boolean tall = false;
	private boolean walkable = true;
	
	public Tile() {
		sprite = new Sprite(0, 32, 32);
	}
	
	public void render() {
		Game.screen.renderSprite(sprite, 0, 0, 0);
	}
	
	public boolean getTall() {
		return tall;
	}
	
	public boolean getWalkable() {
		return walkable;
	}
}
