package com.website.game.map;

import java.util.ArrayList;
import java.util.List;

import com.website.game.entity.Entity;
import com.website.game.entity.Projectile.Projectile;
import com.website.game.graphics.Screen;
import com.website.game.map.tile.Tile;

public class Map {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Map(String path) {
		loadMap(path);
		generateLevel();
	}

	protected void loadMap(String path) {
	}

	protected void generateLevel() {
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			if (e.isRemoved()) entities.remove(i);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).tick();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			if (p.isRemoved()) projectiles.remove(i);
		}
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		// Converts from Pixel Precision to Tile Precision
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				if (x + y * 16 < 0 || x + y * 16 >= 256) {
					Tile.blackTile.render(x, y, screen);
					continue;
				}
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
	}

	public boolean tileCollision(int x, int y, int size) {
		boolean solid = false;
		for (int i = 0; i < 4; i++) {
			int xt = ((size / 2 - 1) * ((i % 2 * 2) - 1) + x) / 16;// Int rounding
			int yt = ((size / 2 - 1) * ((i / 2 * 2) - 1) + y) / 16;// (0,0)(0,1)(1,0)(1,1)
			if (getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.blackTile;
		if (tiles[x + y * width] == 0xff00ff00) return Tile.grass;
		if (tiles[x + y * width] == 0xffda0205) return Tile.Spawn;
		if (tiles[x + y * width] == 0xff000000) return Tile.wall;
		return Tile.voidTile;
	}
}
