package com.website.game.entity.mob;

import com.website.game.Game;
import com.website.game.entity.Projectile.Bullet;
import com.website.game.entity.weapon.Gun;
import com.website.game.entity.weapon.SemiAuto;
import com.website.game.graphics.Screen;
import com.website.game.graphics.Sprite;
import com.website.game.input.Keyboard;
import com.website.game.input.Mouse;

public class Player extends Mob {

	private Keyboard kbd;
	private int anim = 0;
	private boolean moving;
	private int health = 0;
	private int parts = 0;

	private Gun primary = new SemiAuto(this);
	private Gun gun = primary;
	private Gun secondary = new SemiAuto(this);
	
	public Player(Keyboard kbd) {
		this.kbd = kbd;
	}

	public Player(int x, int y, Keyboard kbd) {
		this.x = x;
		this.y = y;
		this.kbd = kbd;
	}

	public void tick() {
		primary.tick();
		secondary.tick();
		
		if (anim < 1000) anim++;
		else anim = 0;

		int xa = 0, ya = 0;
		if (kbd.up) ya--;
		if (kbd.down) ya++;
		if (kbd.left) xa--;
		if (kbd.right) xa++;
		if (xa != 0 || ya != 0) move(xa, ya);
		
		if (Mouse.getB() == 1) {
			double dx = Mouse.getX() - Game.getWindowWidth()/2;
			double dy = Mouse.getY() - Game.getWindowHeight()/2;
			double d = Math.atan2(dy, dx);
			gun.shoot(x, y, d);
		}
		if (kbd.r) gun.reload();
		if (kbd.one) gun = primary;
		if (kbd.two) gun = secondary;
	}

	public void render(Screen screen) {
		sprite = Sprite.player_up;
		if (dir == 0) sprite = Sprite.player_up;
		if (dir == 1) sprite = Sprite.player_right;
		if (dir == 2) sprite = Sprite.player_down;
		if (dir == 3) sprite = Sprite.player_left;

		screen.renderSprite(x - sprite.SIZE / 2, y - sprite.SIZE / 2, sprite);
		gun.render(screen);
	}
}
