package com.website.game.map.tile;

import com.website.game.graphics.Screen;
import com.website.game.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile blackTile = new BlackTile(Sprite.blackSprite);
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile Spawn = new Spawn(Sprite.Spawn);
	public static Tile wall = new Wall(Sprite.wall);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return false;
	}
	
}
