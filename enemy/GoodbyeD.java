package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class GoodbyeD extends SpriteEnemy{
	
	private byte speed = 8;

	public GoodbyeD(int positionX, int positionY) {
		super(positionX, positionY, Assets.goodbyeD.getWidth(), Assets.goodbyeD.getHeight(),
				0, 0, Assets.goodbyeD.getWidth(), Assets.goodbyeD.getHeight(),
				3, 6, 31, 61, 5, 60);
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, speed, 720, 600);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.goodbyeD);
	}

}
