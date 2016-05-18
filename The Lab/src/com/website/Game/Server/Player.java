package com.website.Game.Server;

public class Player extends Slot{

	private String name;
	private int x, y;
	private boolean exist;
	
	Player() {
		this.exist = true;
		this.name = "Nameless Fool";
	}
	
	Player(String name) {
		this.exist = true;
		this.name = name;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public void remove() {
		exist = false;
	}
}
