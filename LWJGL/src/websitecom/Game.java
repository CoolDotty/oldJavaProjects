package websitecom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;

public class Game {

	public Game() {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("LWJGL");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
            Display.destroy();
            System.exit(1);
		}
		
		// boot up openGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		Texture texture = getTexture("BestTexture");
		
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			glClear(GL_COLOR_BUFFER_BIT);
			
			//render
			glBegin(GL_TRIANGLES);
				texture.bind();
	            glTexCoord2f(1, 0);
	            glVertex2i(450, 10);
	            glTexCoord2f(0, 0);
	            glVertex2i(10, 10);
	            glTexCoord2f(0, 1);
	            glVertex2i(10, 450);
	            glTexCoord2f(0, 1);
	            glVertex2i(10, 450);
	            glTexCoord2f(1, 1);
	            glVertex2i(450, 450);
	            glTexCoord2f(1, 0);
	            glVertex2i(450, 10);
            glEnd();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		System.exit(0);
	}

	private Texture getTexture(String key){
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/" + key + ".png")));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		new Game();
	}

}
