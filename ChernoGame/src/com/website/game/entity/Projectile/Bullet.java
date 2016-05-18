package com.website.game.entity.Projectile;

import com.website.game.entity.Entity;
import com.website.game.graphics.Screen;

public class Bullet extends Projectile {

	public static final int FIRE_RATE = 14;

	public Bullet(int x, int y, double d) {
		super(x, y, d);
		despawnTimer = 5000;
		speed = 20;
		sprite = sprite.bullet;
		nx = Math.cos(angle);
		ny = Math.sin(angle);
	}

	public void tick() {
		move();
		despawnTimer--;
		if (despawnTimer < 0) remove();
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x, (int) y, this);
	}

	protected void move() {
		for (int i = 0; i < speed; i++) {
			if (map.tileCollision((int)x + (int)nx, (int)y + (int)ny, 2)) {
				remove();
			} else {
				Entity e = new Trail((int)x, (int)y, 3, sprite.bullet);
				map.add(e);
				x += nx;
				y += ny;
			}
		}
	}
}
