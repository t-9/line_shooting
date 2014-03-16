package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class GoodbyeG extends SpriteEnemy{
	
	private byte speed = 8;
	private int targetX, targetY;

	public GoodbyeG(int positionX, int positionY) {
		super(positionX, positionY, Assets.goodbyeG.getWidth(), Assets.goodbyeG.getHeight(),
				0, 0, Assets.goodbyeG.getWidth(), Assets.goodbyeG.getHeight(),
				15, 11, 47, 60, 5, 60);
	}
	
	public void setTarget() {
		targetX = -super.getX();
		targetY = 800 - super.getY();
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, speed, targetX, targetY);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.goodbyeG);
	}

}
