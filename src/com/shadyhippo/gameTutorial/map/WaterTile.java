package com.shadyhippo.gameTutorial.map;

import com.shadyhippo.gameTutorial.graphics.Screen;
import com.shadyhippo.gameTutorial.graphics.Sprite;

public class WaterTile extends Tile {

	public WaterTile(Sprite[] sprite) {
		super(sprite);
	}
	
	public void renderTile(int x, int y, Screen screen, int spriteIndex) {
		spriteIndex = spriteIndex % sprite.length;
		screen.renderTile(x << 4, y << 4, this, spriteIndex);
	}
	
}
