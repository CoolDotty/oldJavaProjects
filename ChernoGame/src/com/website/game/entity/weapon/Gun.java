package com.website.game.entity.weapon;

import com.website.game.Game;
import com.website.game.entity.Entity;
import com.website.game.entity.Projectile.Bullet;
import com.website.game.entity.Projectile.Projectile;
import com.website.game.graphics.Screen;

public class Gun extends Entity{
	
	public void tick() {
	}
	
	public void shoot(int x, int y, double d) {
		Projectile p = new Bullet(x, y, d);
		Game.getMap().addProjectile(p);
	}
	
	public void reload() {
	}
	
	public void render(Screen screen) {
	}
}
