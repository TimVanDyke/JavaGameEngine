package com.shadyhippo.gameTutorial.entity.mob;

import com.shadyhippo.gameTutorial.entity.Entity;
import com.shadyhippo.gameTutorial.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite; 
	protected int dir = -1; 
	protected boolean moving = false;
	protected int oldX, oldY= 0;
	
	public void move(int xDir, int yDir) {
		if (xDir == 0 || yDir == 0) {
			if 		(xDir > 0) dir = 1;
			else if (xDir < 0) dir = 3; 
			else if (yDir > 0) dir = 2; 
			else if (yDir < 0) dir = 0;
		} else if (oldX != xDir || oldY != yDir) {
			if (oldX == xDir) {
				if (yDir > 0) dir = 2;
				else if (yDir < 0) dir = 0;
			} else {
				if (xDir > 0) dir = 1;
				else if (xDir < 0) dir = 3;
			}
// this code causes moonwalking lmao
//			if (oldY == yDir) {
//				if (xDir > 0) dir = 1;
//				else if (xDir < 0) dir = 3;
//			} else if (oldX == xDir) {
//				if (yDir > 0) dir = 2;
//				else if (yDir < 0) dir = 0;
//			}
		}
		oldX = xDir;
		oldY = yDir;
		if (!collision()) {
			x += xDir;
			y += yDir;
		}
	}
	
	public void update() {
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {
		
	}
}
