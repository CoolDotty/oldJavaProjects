package websitecom.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static SpriteSheet tiles = new SpriteSheet("tiles.png");
	
	private String path;
	public int[][] pixels;
	
	public SpriteSheet(String path) {
		this.path = path;
		load();
	}
	
	public int[][] getSprite(int x, int y, int width, int height) {
		int[][] array = new int[width][height];
		
		for(int i = x; i < x + width; i++) {
			for(int j = y; j < y + height; j++) {
				array[i-x][j-y] = pixels[i][j];
			}
		}
		
		return array;
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			pixels = new int[image.getWidth()][image.getHeight()];
			
			for(int x = 0; x < image.getWidth(); x++) {
				for(int y = 0; y < image.getHeight(); y++) {
					pixels[x][y] = image.getRGB(x, y);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
