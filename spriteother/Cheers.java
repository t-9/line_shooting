package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class Cheers extends SpriteOther {

	public Cheers(int x, int y) {
		super(x, y, Assets.cheers.getWidth(), Assets.cheers.getHeight(),19, 13, 114, 115);
	}
	
	public void cheersDraw(Graphics g) {
		g.drawPixmap(Assets.cheers, super.getX(), super.getY());
	}
	
	public void moveRight(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() + _scrollSpeed.getScrollSpeed());
	}
	
	public void moveLeft(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() - _scrollSpeed.getScrollSpeed());
	}

}
