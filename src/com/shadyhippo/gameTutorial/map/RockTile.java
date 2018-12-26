package com.shadyhippo.gameTutorial.map;

import com.shadyhippo.gameTutorial.graphics.Sprite;

public class RockTile extends Tile {
	
	public RockTile(Sprite[] sprite) {
		super(sprite);
	}
	
	public boolean solid() {
		return true;
	}
}
