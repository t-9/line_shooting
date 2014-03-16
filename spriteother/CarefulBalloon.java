package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class CarefulBalloon extends SpriteOther{
	
	private byte speed = 8;
	
	public CarefulBalloon() {
		super(500, 200, Assets.balloon.getWidth(), Assets.balloon.getHeight(),6, 7, 113, 34);
	}
	
	public void draw(Graphics g) {
		g.drawPixmap(Assets.carefulBalloon, super.getX(), super.getY());
	}
	
	public void carefulBalloonIn(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() - (_scrollSpeed.getScrollSpeed() + speed));
	}
	
	public void carefulBalloonOut(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() + (_scrollSpeed.getScrollSpeed() + speed));
	}

}
