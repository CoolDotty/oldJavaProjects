package com.website;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.website.States.*;

public class Engine extends StateBasedGame {

	public static String title = "Shoot Em Up";
	public static boolean _APPLET;
	
	public Engine() {
		super(title);
		_APPLET = true;
	}
	
	public static void main(String[] args) {
		
		_APPLET = false;
		
		// Set natives folder
		File f = new File("natives");
		if(f.exists()) System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
		
		try {
			AppGameContainer game = new AppGameContainer(new Engine());
			game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
			game.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		gc.setMaximumLogicUpdateInterval(60); // update rate
		gc.setTargetFrameRate(60);
		gc.setAlwaysRender(true);
		gc.setShowFPS(false);
		gc.setVSync(true);
		this.addState(new GameState());
	}

}