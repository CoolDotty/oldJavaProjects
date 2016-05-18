package com.website.Game.Graphics;

public class Screen {

	public int width, height;
	public int xOffset, yOffset;
	public int[][] pixels;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width][height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			for (int z = 0; z < pixels[0].length; z++) {
				pixels[i][z] = 0;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}