package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class ConySquare extends SpriteOther{
	
	//private byte speed = 0;

	public ConySquare(int x, int y) {
		super(x, y, Assets.conySquare.getWidth(), Assets.conySquare.getHeight(), 0, 0,
				Assets.conySquare.getWidth(), Assets.conySquare.getHeight());
	}

	public void drawConySquare(Graphics g) {
		g.drawPixmap(Assets.conySquare, super.getX(), super.getY());
	}
	
	public void moveRight(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() + _scrollSpeed.getScrollSpeed());
	}
	
	public void moveLeft(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() - _scrollSpeed.getScrollSpeed());
	}
	
}
