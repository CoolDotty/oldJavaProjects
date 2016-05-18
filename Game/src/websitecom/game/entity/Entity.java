package websitecom.game.entity;

import websitecom.game.Game;
import websitecom.game.graphics.Sprite;

public class Entity {

	private int x, y;
	private int direction;
	private Sprite sprite;
	
	public void render() {
		Game.screen.renderSprite(sprite, x, y, direction);
	}
	
	public void tick() {
		
	}
}
