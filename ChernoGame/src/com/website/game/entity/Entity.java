package com.website.game.entity;

import java.util.Random;

import com.website.game.graphics.Screen;
import com.website.game.map.Map;

public class Entity {

	public int x, y;
	private boolean removed = false;
	protected Map map;
	protected final Random random = new Random();
	
	public void tick() {
	}
	
	protected void shoot(int x, int y, double d) {
	}
	
	public void render(Screen screen) {
	}
	
	public void remove() {
		//Remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Map map) {
		this.map = map;
	}
}
