package com.shadyhippo.gameTutorial.map;

import com.shadyhippo.gameTutorial.graphics.Screen;
import com.shadyhippo.gameTutorial.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite[] sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile water = new WaterTile(Sprite.water);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile lava = new LavaTile(Sprite.lava);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite[] sprite) {
		this.sprite = sprite;
	}
	
	public void renderTile(int x, int y, Screen screen, int spriteIndex) {
		spriteIndex = 0;
		screen.renderTile(x << 4, y << 4, this, spriteIndex);
	}
	
	public boolean solid() {
		return false;
	}
}
