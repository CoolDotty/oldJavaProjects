package com.website.game.map;

public class TileCoord {

	private int x, y;
	private final int TILE_SIZE = 16;

	public TileCoord(int x, int y) {
		this.x = x * TILE_SIZE + TILE_SIZE / 2;
		this.y = y * TILE_SIZE + TILE_SIZE / 2;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}
}
