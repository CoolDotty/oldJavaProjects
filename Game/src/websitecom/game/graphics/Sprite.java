package websitecom.game.graphics;


public class Sprite {

	public final int WIDTH;
	public final int HEIGHT;
	
	private int[][] pixels;
	
	public Sprite(SpriteSheet sheet, int x, int y, int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.pixels = new int[WIDTH][HEIGHT];
		
		int[][] array = sheet.getSprite(x, y, width, height);
		
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j] = array[i][j];
			}
		}
	}
	
	public Sprite(int color, int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.pixels = new int[WIDTH][HEIGHT];
		
		for(int i = 0; i < pixels.length; i++) {
			for(int j = 0; j < pixels[0].length; j++) {
				pixels[i][j] = color;
			}
		}
	}
	
	public int[][] getSprite() {
		return pixels;
	}
	
}
