package com.website.Game;

import com.website.Game.Graphics.Screen;
import com.website.Game.Networking.Network;

public class Game {

	private String playerName;
	private Screen screen;
	private Network net;
	
	public Game(String name, Network net) {
		this.playerName = name;
		this.net = net;
		screen = new Screen(800, 800);
	}
	
}
