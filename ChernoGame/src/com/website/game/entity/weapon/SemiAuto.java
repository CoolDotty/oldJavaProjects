package com.website.game.entity.weapon;

import com.website.game.entity.mob.Player;
import com.website.game.graphics.Screen;
import com.website.game.graphics.Sprite;

public class SemiAuto extends Gun {

	private final int DAMAGE = 35;
	private final int SPREAD = 3;
	private final int MAGSIZE = 4;
	private final int RESERVESIZE = 12;

	private Sprite sprite;
	private Player player;
	private int mag;
	private int reserve;
	private int stall;

	private boolean reloading;

	public SemiAuto(Player player) {
		this.player = player;
		this.sprite = sprite.semiAuto;
		mag = MAGSIZE;
		reserve = 4;
	}

	public void tick() {
		if (stall > 0) {
			stall--;
		} else {
			reloading = false;
		}
	}

	public void shoot(int x, int y, double d) {
		if (mag > 0 && stall <= 0) {
			super.shoot(x, y, d);
			mag--;
			stall = 25;
		}
	}

	public void reload() {
		if (stall <= 0 && reserve > 0) {
			reserve--;
			mag = MAGSIZE;
			stall = 120;
			reloading = true;
		}
	}

	public void render(Screen screen) {
		if (!reloading) {
		screen.renderSprite(player.x - sprite.SIZE / 2, player.y - sprite.SIZE / 2 - 5, sprite);
		}
	}
}
