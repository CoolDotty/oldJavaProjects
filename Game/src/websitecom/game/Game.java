package websitecom.game;

import websitecom.game.graphics.Screen;
import websitecom.game.graphics.Sprite;
import websitecom.game.graphics.SpriteSheet;
import websitecom.game.input.Keyboard;
import websitecom.game.input.Mouse;
import websitecom.game.world.Map;

public class Game implements Runnable {

	public static int width = 200;
	public static int height = 200;
	public static int scale = 3;
	
	public static Screen screen;
	public static Map map;

	private Thread thread;

	private static boolean running = false;

	public Game()
	/**
	 * Creates game objects
	 */
	{
		screen = new Screen(width, height, scale);
	}

	public synchronized void start()
	/**
	 * Starts thread
	 */
	{
		running = true;
		thread = new Thread(this, "Game");
		thread.run();
	}

	public void run()
	/**
	 * Main Thread
	 */
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; // ticks per second
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				screen.update();
				
				ticks++;
				delta--;
			}
			screen.clear();
			
			//Call all objects to render on screen back to front
			Sprite sprite = new Sprite(SpriteSheet.tiles, 0, 0, 16, 16);
			screen.renderSprite(sprite, 50, 50, 1);
			
			screen.render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				screen.setTitle(frames + " Fps " + ticks + " Tick");
				frames = 0;
				ticks = 0;
			}
		}
		quit();
	}

	public synchronized void quit()
	/**
	 * Stops the game loop
	 */
	{
		running = false;
		try{
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
