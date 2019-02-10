package com.shadyhippo.gameTutorial.map;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadedMap extends Map {
	
	//the ol' map color codes for map building. These colors correspond to different tiles
	private static int green = 0xFF519B5D;
	private static int blue = 0xFF3D3AFF;
	private static int brown = 0xFF514F2F;
	private static int orange= 0xFFF84E37;
	
	//for the picture load in
	private int[] mapPixels;
	
	public LoadedMap(String path) {
		super(path);
	}
	
	protected void loadMap(String path) {
		try {
			BufferedImage image = ImageIO.read(LoadedMap.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			terrainMap = new Tile[width * height];
			entityMap = new int[width * height];
			mapPixels = new int[width * height];
			image.getRGB(0, 0, width, height, mapPixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("REEEEEEEEEEEEEEEEEEEEEEEE YOU BROKE LEVEL INTAKE IN SpriteSheet");
		}
	}
 
	/*
	 * green is grass
	 * blue is water
	 * brown is rock
	 * lava is lava
	 */
	protected void generateMap() {
		for(int i = 0; i < mapPixels.length; i++) {
			if (mapPixels[i] == green) terrainMap[i] = Tile.grass;
			if (mapPixels[i] == blue) terrainMap[i] = Tile.water;
			if (mapPixels[i] == brown) terrainMap[i] = Tile.rock;
			if (mapPixels[i] == orange) terrainMap[i] = Tile.lava;
		}
	}
}

