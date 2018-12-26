package com.shadyhippo.gameTutorial.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public SpriteSheet sheet;
	public int[] pixels;

	//tiles
	public static Sprite grass0 = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite grass1 = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite water0 = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite water1 = new Sprite(16, 1, 2, SpriteSheet.tiles);
	public static Sprite rock0 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock1 = new Sprite(16, 2, 2, SpriteSheet.tiles);
	public static Sprite lava0 = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite lava1 = new Sprite(16, 3, 2, SpriteSheet.tiles);
	public static Sprite voidSpace = new Sprite(16, 0x000000); 

	public static Sprite[] grass = {grass0, grass1};
	public static Sprite[] water = {water0, water1};
	public static Sprite[] rock = {rock0, rock1};
	public static Sprite[] lava = {lava0, lava1};
	public static Sprite[] voidSprite = {voidSpace};
	

	//player
	public static Sprite playerUp0 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerUp1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerUp2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	
	public static Sprite playerRight0 = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite playerRight1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerRight2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	
	public static Sprite playerDown0 = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerDown1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite playerDown2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	
	public static Sprite playerLeft0 = new Sprite(32, 3, 5, SpriteSheet.tiles);
	public static Sprite playerLeft1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
	public static Sprite playerLeft2 = new Sprite(32, 3, 7, SpriteSheet.tiles);

//	public static Sprite playerUp0 = new Sprite(32, 4, 5, SpriteSheet.tiles);
//	public static Sprite playerUp1 = new Sprite(32, 4, 6, SpriteSheet.tiles);
//	public static Sprite playerUp2 = new Sprite(32, 4, 7, SpriteSheet.tiles);
//	
//	public static Sprite playerRight0 = new Sprite(32, 5, 5, SpriteSheet.tiles);
//	public static Sprite playerRight1 = new Sprite(32, 5, 6, SpriteSheet.tiles);
//	public static Sprite playerRight2 = new Sprite(32, 5, 7, SpriteSheet.tiles);
//	
//	public static Sprite playerDown0 = new Sprite(32, 6, 5, SpriteSheet.tiles);
//	public static Sprite playerDown1 = new Sprite(32, 6, 6, SpriteSheet.tiles);
//	public static Sprite playerDown2 = new Sprite(32, 6, 7, SpriteSheet.tiles);
//	
//	public static Sprite playerLeft0 = new Sprite(32, 7, 5, SpriteSheet.tiles);
//	public static Sprite playerLeft1 = new Sprite(32, 7, 6, SpriteSheet.tiles);
//	public static Sprite playerLeft2 = new Sprite(32, 7, 7, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color); 
	}
	
	private void setColor(int color) {
		for(int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
