package websiteGoesHere.sprite;

import processing.core.PImage;

public class SpriteBuilder extends PImage {

	public SpriteBuilder(int width, int height) {
		super(width, height);
		for(int i = 0; i < super.pixels.length; i++) {
			super.pixels[i] = 0x00000000; //Transparent
		}
	}

	public void addSprite(PImage image, int xMod, int yMod, boolean centered) {
		if(centered){
			xMod -= image.width>>1;
			yMod -= image.height>>1;
		}
		for(int y = 0; y < image.height; y++) {
			for(int x = 0; x < image.width; x++) {
				int thisPos = (x + xMod) + ((y + yMod)*super.width);
				if(thisPos < 0 || thisPos >= super.pixels.length) break;
				int imgPos = x + (y*image.width);
				if(imgPos < 0 || imgPos >= image.pixels.length) break;
				super.pixels[thisPos] = image.pixels[imgPos];
			}
		}
	}
}
