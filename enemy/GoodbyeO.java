package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class GoodbyeO extends SpriteEnemy{
	
	private byte speed = 8;
	private int targetX, targetY;

	public GoodbyeO(int positionX, int positionY) {
		super(positionX, positionY, Assets.goodbyeO.getWidth(), Assets.goodbyeO.getHeight(),
				0, 0, Assets.goodbyeO.getWidth(), Assets.goodbyeO.getHeight(),
				6, 7, 38, 51, 5, 60);
	}
	
	public void setTarget(int targetX, int targetY) {
		this.targetX = (targetX << 2) - super.getX();
		this.targetY = (targetY << 2) - super.getY();
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, speed, targetX, targetY);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.goodbyeO);
	}

}
