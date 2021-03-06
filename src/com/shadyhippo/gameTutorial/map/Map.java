package com.shadyhippo.gameTutorial.map;

import com.shadyhippo.gameTutorial.graphics.Screen;
import com.shadyhippo.gameTutorial.map.Tile;

public class Map {
	
	protected int width, height;
	protected Tile[] terrainMap;
	protected int[] entityMap;
	
	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		generateMap();
	}
	
	public Map(String path) {
		loadMap(path);
		generateMap();
	}
	
	protected void generateMap() {
	}
	
	protected void loadMap(String path) {
	}
	
	public void update() {
	}
	
	public void renderMap(int xScroll, int yScroll, Screen screen, int spriteIndex) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4; // >> 4 is the same as divide by 16
		int y0 = yScroll >> 4; 
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				if (x < 0 || y < 0 || x >= width || y >= height) Tile.voidTile.renderTile(x, y, screen, spriteIndex);
				else terrainMap[x + y * width].renderTile(x, y, screen, spriteIndex);
			}
		}
	}
}