package websitecom.game.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import websitecom.game.input.Keyboard;
import websitecom.game.input.Mouse;

/**
 * Screen v1.0
 * 
 * Creates a window that renders an editable array of pixels.
 * 
 */
public class Screen extends Canvas {

	private final int WIDTH;
	private final int HEIGHT;
	private final int SCALE;
	private final int TRANSPARENT = 0xFFFF00FF;
	
	
	private JFrame frame = new JFrame();

	private int[][] pixels;

	public static Keyboard kbd;
	public static Mouse mouse;

	public Screen(int width, int height, int scale)
	/**
	 * Creates a JFrame with given width, height, and pixels size scale.
	 */
	{
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
		pixels = new int[width][height];

		kbd = new Keyboard();
		mouse = new Mouse();

		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		requestFocus();
	}

	public void setTitle(String title)
	/**
	 * Sets JFrame title
	 */
	{
		frame.setTitle(title);
	}

	public void clear() {
		pixels = new int[WIDTH][HEIGHT];
	}

	public void renderSprite(Sprite sprite, int locx, int locy, int orientation)
	/**
	 * Adds a sprite object to the array of pixels
	 */
	{
		for (int y = 0; y < sprite.HEIGHT; y++) {
			for (int x = 0; x < sprite.WIDTH; x++) {
				try {
					if (sprite.getSprite()[x][y] != TRANSPARENT) {
						pixels[x + locx][y + locy] = sprite.getSprite()[x][y];
					}
				} catch (Exception e) {}
			}
		}
	}

	public void render()
	/**
	 * Updates the image
	 */
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				image.setRGB(x, y, pixels[x][y]);
			}
		}

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.dispose();
		bs.show();
	}
	
	public void update() {
		kbd.update();
	}
}
