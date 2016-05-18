package com.website.game.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.website.game.entity.Entity;
import com.website.game.entity.Projectile.Bullet;
import com.website.game.entity.Projectile.Projectile;
import com.website.game.graphics.Sprite;

//abstract = template for classes
public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0; // direction

	public void move(int nx, int ny) {
		if (nx != 0 && ny != 0) {
			move(nx, 0);
			move(0, ny);
			return;
		}

		if (nx > 0) dir = 1;
		if (nx < 0) dir = 3;
		if (ny > 0) dir = 2;
		if (ny < 0) dir = 0;

		if (!moveCollision(nx, ny)) {
			x += nx;
			y += ny;
		}

	}

	public void tick() {
	}

	private boolean moveCollision(int xa, int ya) {
		boolean solid = false;
		if (map.tileCollision(x + xa, y + ya, 12)) solid = true;
		return solid;
	}
	
	// Ask if I'm all up in your grill space?
	private boolean Collision(int nx, int ny) {
		boolean solid = false;
		if (map.tileCollision(x + nx, y + ny, 12)) solid = true;
		return solid;
	}

	public void render() {
	}
}
