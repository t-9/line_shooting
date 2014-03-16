package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class ConyName extends SpriteOther{
	
	//private byte speed = 0;

	public ConyName(int x, int y) {
		super(x, y, Assets.conyName.getWidth(), Assets.conyName.getHeight(),
				0, 0, 0, 0);
	}

	public void drawConyName(Graphics g) {
		g.drawPixmap(Assets.conyName, super.getX(), super.getY());
	}
	
	public void moveRight(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() + _scrollSpeed.getScrollSpeed());
	}
	
	public void moveLeft(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() - _scrollSpeed.getScrollSpeed());
	}
	
}
