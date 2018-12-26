package com.shadyhippo.gameTutorial.graphics;

import com.shadyhippo.gameTutorial.map.Tile;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	private final int mapSize = 64;
	public int xOffset, yOffset;
	public int[] tiles = new int[mapSize * mapSize];
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile, int spriteIndex) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite[spriteIndex].SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite[spriteIndex].SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite[spriteIndex].SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite[spriteIndex].pixels[x + y * tile.sprite[spriteIndex].SIZE];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
}