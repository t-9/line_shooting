package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class GoodbyeY extends SpriteEnemy{
	
	private byte speed = 8;

	public GoodbyeY(int positionX, int positionY) {
		super(positionX, positionY, Assets.goodbyeY.getWidth(), Assets.goodbyeY.getHeight(),
				0, 0, Assets.goodbyeY.getWidth(), Assets.goodbyeY.getHeight(),
				21, 19, 19, 55, 5, 60);
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, speed, 360, 1200);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.goodbyeY);
	}

}
