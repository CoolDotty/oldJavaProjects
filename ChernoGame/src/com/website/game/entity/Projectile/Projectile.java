package com.website.game.entity.Projectile;

import com.website.game.entity.Entity;
import com.website.game.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double speed, despawnTimer, damage;
	
	public Projectile(int x, int y, double d) {
		xOrigin = x;
		yOrigin = y;
		angle = d;
		this.x = x;
		this.y = y;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getSpriteSize() {
		return sprite.SIZE;
	}
}
