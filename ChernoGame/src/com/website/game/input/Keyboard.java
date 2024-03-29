package com.website.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, space, r, one, two;
	
	public void tick() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		r = keys[KeyEvent.VK_R];
		one = keys[KeyEvent.VK_1];
		two = keys[KeyEvent.VK_2];
		
		/*for(int i = 0; i < keys.length; i++) {
			if (keys[i]) {
				System.out.println("KEY: " + i);
			}
		}*/
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
