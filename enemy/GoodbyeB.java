package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class GoodbyeB extends SpriteEnemy{
	
	private byte speed = 8;

	public GoodbyeB(int positionX, int positionY) {
		super(positionX, positionY, Assets.goodbyeB.getWidth(), Assets.goodbyeB.getHeight(),
				0, 0, Assets.goodbyeB.getWidth(), Assets.goodbyeB.getHeight(),
				8, 5, 36, 73, 5, 60);
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, speed, 0, 1200);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.goodbyeB);
	}

}
