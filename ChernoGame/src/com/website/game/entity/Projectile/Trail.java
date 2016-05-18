package com.website.game.entity.Projectile;

import com.website.game.entity.Entity;
import com.website.game.graphics.Screen;
import com.website.game.graphics.Sprite;

public class Trail extends Entity {
	
	private Sprite sprite;
	private int despawnTimer;
	
	public Trail(int x, int y, int despawnTimer, Sprite sprite) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.despawnTimer = despawnTimer;
	}
	
	public void tick() {
		despawnTimer--;
		if (despawnTimer < 0) remove();
	}
	
	public void render(Screen screen) {
		screen.renderSprite(x, y, sprite);
	}
}
