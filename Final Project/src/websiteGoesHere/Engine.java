package websiteGoesHere;

import java.awt.event.KeyEvent;

import processing.core.*;
import websiteGoesHere.Game.Room.Room;
import websiteGoesHere.sprite.Sprite;

public class Engine extends PApplet {
	private static final long serialVersionUID = 1L; // for serialization

	public State state = State.DEFAULT;

	public enum State {
		DEFAULT;
	}

	public final int FPSCAP = -1; // per second

	public final int WIDTH = 310;
	public final int HEIGHT = 240;
	public final int SCALE = 2;

	public Room room;

	public void setup() {
		size(WIDTH * SCALE, HEIGHT * SCALE);
		background(0);
		frameRate(FPSCAP);
		smooth(0);
		Sprite.loadSprites(this);
		room = new Room(this, "theLab");
	}

	public void draw() {
		updateKeyboard();
		room.update(this);
		clear();
		room.render(this);
		frame.setTitle("Final Project | fps: " + (int)frameRate);
	}

	public void drawSprite(PImage img, int x, int y, boolean centered) {
		if (centered) {
			imageMode(CENTER);
			image(img, x, y, img.width, img.height);
		} else {
			imageMode(CORNER);
			image(img, x, y, img.width, img.height);
		}
	}

	public void push() {
		pushStyle();
		pushMatrix();
		scale(SCALE);
	}

	public void pop() {
		popStyle();
		popMatrix();
	}

	public PImage loadSprite(String path) {
		return super.requestImage("res/" + path);
	}

	public boolean sketchFullScreen() {
		return false;
	}

	/*
	 * Better Keyboard for games
	 */
	private boolean[] keys = new boolean[120];
	public boolean up_hold, down_hold, left_hold, right_hold, space_hold;

	private void updateKeyboard() {
		up_hold = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down_hold = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left_hold = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right_hold = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space_hold = keys[KeyEvent.VK_SPACE];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		super.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		super.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { Engine.class.getName() });
	}

}
