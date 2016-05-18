package com.website.game.map.tile;

import com.website.game.graphics.Screen;
import com.website.game.graphics.Sprite;

public class Spawn extends Tile {

	public Spawn(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
