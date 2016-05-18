package websiteGoesHere.sprite;

import processing.core.*;
import websiteGoesHere.Engine;

public class Sprite extends PImage{
	
	public static PImage GRASS;
	public static PImage BRICK;
	
	public static PImage PLAYER;
	
	public static void loadSprites(Engine e) {
		Sprite.GRASS = loadSprite(e, "grass.png");
		Sprite.BRICK = loadSprite(e, "brick.png");
		Sprite.PLAYER = loadSprite(e, "player.png");
	}
	
	private static PImage loadSprite(Engine e, String path) {
		return e.loadSprite("sprite/" + path);
	}
}
