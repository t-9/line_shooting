package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class MiddleScratch extends SpriteOther{
	
	private int speed = 15;
	
	public MiddleScratch(int positionX, int positionY) {
		super(positionX, positionY, Assets.middleScratch.getWidth(), Assets.middleScratch.getHeight(),
				59, 70, 102, 90);
	}
	
	public void draw(Graphics g) {
		g.drawPixmap(Assets.middleScratch, super.getX(), super.getY());
	}
	
	public void guide(ScrollSpeed _scrollSpeed, int targetX, int targetY) {
		super.guide(_scrollSpeed, speed, targetX, targetY);
	}

}
