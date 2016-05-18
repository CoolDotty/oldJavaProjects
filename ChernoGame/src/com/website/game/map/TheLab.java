package com.website.game.map;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.website.game.map.tile.Tile;

public class TheLab extends Map {

	public TheLab(String path) {
		super(path);
	}

	protected void generateLevel() {
	}

	protected void loadMap(String path) {
		try {
			BufferedImage image = ImageIO.read(TheLab.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Not Found!");
		}
	}
}
