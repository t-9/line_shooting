package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class Brown extends SpriteEnemy{
	
	private byte speed = 10;
	private static int maxHP = 1800;
	
	public Brown(int positionX, int positionY) {
		super(positionX, positionY, Assets.brown.getWidth(), Assets.brown.getHeight(),
				0, 0, Assets.brown.getWidth(), 579,
				0, 0, Assets.brown.getWidth(), 549, maxHP, 600);
	}
	
	public int getMaxHP() {
		return maxHP;
	}
	
	public void down(ScrollSpeed _scrollSpeed) {
		super.down(_scrollSpeed, speed);
	}
	
	public void up(ScrollSpeed _scrollSpeed) {
		super.up(_scrollSpeed, speed);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.brown);
	}

}
