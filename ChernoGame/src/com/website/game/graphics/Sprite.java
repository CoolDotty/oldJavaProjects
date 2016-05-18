package com.website.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	// Tiles Sprites
	public static Sprite voidSprite = new Sprite(16, 15, 15, SpriteSheet.testSheet);
	public static Sprite blackSprite = new Sprite(16, 0);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.testSheet);
	public static Sprite Spawn = new Sprite(16, 0xffda0205);
	public static Sprite wall = new Sprite(16, 1, 0, SpriteSheet.testSheet);

	// Player Sprites
	public static Sprite player_up = new Sprite(16, 0, 5, SpriteSheet.testSheet);
	public static Sprite player_down = new Sprite(16, 1, 5, SpriteSheet.testSheet);
	public static Sprite player_left = new Sprite(16, 2, 5, SpriteSheet.testSheet);
	public static Sprite player_right = new Sprite(16, 3, 5, SpriteSheet.testSheet);

	// Weapon Sprites
	public static Sprite semiAuto = new Sprite(16, 0, 7, SpriteSheet.testSheet);
	
	// Projectile Sprites
	public static Sprite bullet = new Sprite(1, 0xFFFDD14D);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
	}
}
