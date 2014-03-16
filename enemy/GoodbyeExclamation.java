package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class GoodbyeExclamation extends SpriteEnemy{
	
	private byte speed = 8;

	public GoodbyeExclamation(int positionX, int positionY) {
		super(positionX, positionY, Assets.goodbyeExclamation.getWidth(), Assets.goodbyeExclamation.getHeight(),
				0, 0, Assets.goodbyeExclamation.getWidth(), Assets.goodbyeExclamation.getHeight(),
				11, 4, 10, 68, 5, 60);
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, speed, 480, 801);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.goodbyeExclamation);
	}

}
