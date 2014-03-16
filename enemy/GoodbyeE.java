package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class GoodbyeE extends SpriteEnemy{
	
	private byte speed = 8;

	public GoodbyeE(int positionX, int positionY) {
		super(positionX, positionY, Assets.goodbyeE.getWidth(), Assets.goodbyeE.getHeight(),
				0, 0, Assets.goodbyeE.getWidth(), Assets.goodbyeE.getHeight(),
				6, 3, 35, 68, 5, 60);
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, speed, 480, 1200);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.goodbyeE);
	}

}
