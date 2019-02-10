package com.shadyhippo.gameTutorial.map;

import java.util.Random;

public class RandomMap extends  Map {
	
	private static final Random random = new Random();

	public RandomMap(int width, int height) {
		super(width, height);
	}
	
	protected void generateMap() {
		
		for(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int num = random.nextInt(4);
				if (num == 0) {
					terrainMap[x + y * height] = Tile.grass;
				}else if (num == 1) {
					terrainMap[x + y * height] = Tile.water;
				}else if (num == 2) {
					terrainMap[x + y * height] = Tile.rock;
				}else if (num == 3) {
					terrainMap[x + y * height] = Tile.lava;
				} 
			}
		}
	}
}
