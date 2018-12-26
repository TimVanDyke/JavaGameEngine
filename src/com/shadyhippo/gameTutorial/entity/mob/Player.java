package com.shadyhippo.gameTutorial.entity.mob;

import com.shadyhippo.gameTutorial.graphics.Screen;
import com.shadyhippo.gameTutorial.graphics.Sprite;
import com.shadyhippo.gameTutorial.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		
		sprite = Sprite.playerDown0;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		anim++;
		if (anim > 7500) anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) { 
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}
	
	public void render(Screen screen) {
		if (!walking) {
			if (dir == 0) sprite = Sprite.playerUp0;
			if (dir == 1) sprite = Sprite.playerRight0;
			if (dir == 2) sprite = Sprite.playerDown0;
			if (dir == 3) sprite = Sprite.playerLeft0;
		} else { // speed up the walking animation by halving the % ## and halving the other attached ###
			if (anim % 40 > 10 && anim % 40 <= 20) {
				if (dir == 0) sprite = Sprite.playerUp1;
				if (dir == 1) sprite = Sprite.playerRight1;
				if (dir == 2) sprite = Sprite.playerDown1;
				if (dir == 3) sprite = Sprite.playerLeft1;
			} else if (anim % 40 > 30 && anim % 40 <= 40){
				if (dir == 0) sprite = Sprite.playerUp2;
				if (dir == 1) sprite = Sprite.playerRight2;
				if (dir == 2) sprite = Sprite.playerDown2;
				if (dir == 3) sprite = Sprite.playerLeft2;
			} else {
				if (dir == 0) sprite = Sprite.playerUp0;
				if (dir == 1) sprite = Sprite.playerRight0;
				if (dir == 2) sprite = Sprite.playerDown0;
				if (dir == 3) sprite = Sprite.playerLeft0;
			}
		}
		screen.renderPlayer(x - sprite.SIZE / 2,  y - sprite.SIZE / 2,  sprite);
	}
}
