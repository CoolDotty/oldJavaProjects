package com.website.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.website.game.entity.mob.Player;
import com.website.game.graphics.Screen;
import com.website.game.input.Keyboard;
import com.website.game.input.Mouse;
import com.website.game.map.Map;
import com.website.game.map.RandomMap;
import com.website.game.map.TheLab;
import com.website.game.map.TileCoord;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private static int width = 200;
	private static int height =  200;
	private static int scale = 3;
	private static Map map;
	public static String title = "Vidya Gaim";
	
	private Thread thread;
	private JFrame frame;
	private Keyboard kbd;
	private Player player;
	private boolean running = false;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		frame = new JFrame();
		screen = new Screen(width, height);
		kbd = new Keyboard();
		map = new TheLab("/Maps/TheLab.png");
		TileCoord playerSpawn = new TileCoord(7, 8);
		player = new Player(playerSpawn.x(), playerSpawn.y(), kbd);
		player.init(map);
		
		addKeyListener(kbd);
		
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public static int getWindowWidth() {
		return width * scale;
	}
	
	public static int getWindowHeight() {
		return height * scale;
	}
	
	public static Map getMap() {
		return map;
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
			
	public synchronized void stop() {
		running = false;
		try{
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; //ticks per second
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
				while (delta >= 1) {
					tick();
					ticks++;
					delta--;
				}
				render();
				frames++;

			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + frames + " Fps " + ticks + " Tick");
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	public void tick() {
		kbd.tick();
		player.tick();
		map.tick();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		screen.clear();
		
		int xScroll = player.x - screen.width/2 + ((Mouse.getX() - 225) / 8); //screen.width/2;
		int yScroll = player.y - screen.height/2 + ((Mouse.getY() - 225) / 8);//screen.height/2;
		map.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth()/scale, getHeight()/scale, null);
		
		//Testing
		g.setColor(Color.BLUE);
		g.setFont(new Font ("Verdana", 0, 12));
		g.drawString(Mouse.getX() + ", " + Mouse.getY(), Mouse.getX() + 5, Mouse.getY() - 5);
		//g.fillRect(screen.width*3/2 - 5, screen.height*3/2 - 5, 10, 10);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	
}
