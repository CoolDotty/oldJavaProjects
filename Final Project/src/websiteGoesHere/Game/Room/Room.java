package websiteGoesHere.Game.Room;

import java.util.ArrayList;

import processing.core.PImage;
import websiteGoesHere.Engine;
import websiteGoesHere.Game.Room.Entity.Entity;
import websiteGoesHere.Game.Room.Entity.Player;
import websiteGoesHere.Game.Room.tile.*;
import websiteGoesHere.sprite.SpriteBuilder;

public class Room {

	private Tile[] tiles;
	public int width, height;
	private Location focus;
	private ArrayList<Entity> entities = new ArrayList<Entity>();

	/**
	 * Generates the room from file.
	 * 
	 * @param path
	 *            Directory of level file.
	 */
	public Room(Engine e, String name) {
		loadRoom(e, name);
	}

	private void loadRoom(Engine e, String name) {
		PImage tileMap = e.loadImage("res/room/" + name + "/tiles.png");
		tiles = new Tile[tileMap.width*tileMap.height];
		width = tileMap.width;
		height = tileMap.height;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Location loc = new Location(x * Tile.WIDTH, y * Tile.HEIGHT);
				tiles[x + (y*width)] = getTile(tileMap.pixels[x + (y * tileMap.width)], loc);
			}
		}
		
		Player p = new Player((tileMap.width*Tile.WIDTH)>>1, (tileMap.height*Tile.HEIGHT)>>1);
		entities.add(p);
		focus = p.getLocation();
	}
	
	private Tile getTile(int hex, Location loc) {
		switch(hex) {
			  case Grass.hexID: 
			    return new Grass(loc);
			  case Brick.hexID: 
				return new Brick(loc);
			  default:
			    System.out.println("Invalid Tile");
			    return null;
			}
	}

	public void update(Engine e) {
		for(Entity entity : entities) {
			entity.update(e, this);
		}
		
		for(Entity entity : entities) {
			if(entity.removed) entities.remove(entity);
		}
	}

	public void render(Engine e) {
		
		SpriteBuilder sb = new SpriteBuilder(e.WIDTH*e.SCALE, e.HEIGHT*e.SCALE);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Tile t = tiles[x + (y*width)];
				int xOffset = (e.WIDTH >> 1) - (focus.x - t.getLocation().x);
				if (xOffset < -Tile.WIDTH || xOffset > e.WIDTH) continue;
				int yOffset = (e.HEIGHT >> 1) - (focus.y - t.getLocation().y);
				if (yOffset < -Tile.HEIGHT || xOffset > e.WIDTH) continue;
				sb = t.render(sb, xOffset, yOffset);
			}
		}
		
		for(Entity entity : entities) {
			int xOffset = (e.WIDTH >> 1) - (focus.x - entity.getLocation().x);
			int yOffset = (e.HEIGHT >> 1) - (focus.y - entity.getLocation().y);
			entity.render(sb, xOffset, yOffset);
		}
		
		e.push();
		e.drawSprite(sb, 0, 0, false);
		e.pop();
	}
	
	public Tile getTile(int x, int y) {
		return tiles[x + (y*width)];
	}
}
