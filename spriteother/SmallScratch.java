package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class SmallScratch extends SpriteOther{
	
	private byte speed = 10;

	public SmallScratch(int positionX, int positionY) {
		super(positionX, positionY, Assets.smallScratch.getWidth(), Assets.smallScratch.getHeight(),
				22, 28, 43, 35);
	}
	
	public void guide(ScrollSpeed _scrollSpeed, int targetX, int targetY) {
		super.guide(_scrollSpeed, speed, targetX, targetY);
	}
	
	public void moveRight(ScrollSpeed _scrollSpeed) {
		super.moveRight(_scrollSpeed, speed);
	}
	
	public void moveLeft(ScrollSpeed _scrollSpeed) {
		super.moveLeft(_scrollSpeed, speed);
	}
	
	public void draw(Graphics g) {
		g.drawPixmap(Assets.smallScratch, super.getX(), super.getY());
	}

}
