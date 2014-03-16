package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;


public class Balloon extends SpriteOther{
	
	//private byte speed = 0;

	public Balloon() {
		super(75, -68, Assets.balloon.getWidth(), Assets.balloon.getHeight(),25, 7, 336, 61);
	}

	public void balloonLeave(ScrollSpeed _scrollSpeed) {
		if( super.getY() >= 0 && super.getY() <= 400)
			super.setX(super.getX() + _scrollSpeed.getScrollSpeed());
		else if( super.getY() > 400 && super.getX() >= 75)
			super.setX(super.getX() - _scrollSpeed.getScrollSpeed());
	}

	public void balloonDraw(Graphics g) {
		g.drawPixmap(Assets.balloon, super.getX(), super.getY());
	}
}
