package com.shadyhippo.gameTutorial.entity;

import java.util.Random;

import com.shadyhippo.gameTutorial.graphics.Screen;
import com.shadyhippo.gameTutorial.map.Map;

public abstract class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Map map;
	
	protected final Random random = new Random();
	
	public void update() {
	}
	
	public void render(Screen screen) {	
	}
	
	public void remove() {
		 removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
