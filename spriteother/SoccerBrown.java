package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class SoccerBrown extends SpriteOther{

	public SoccerBrown() {
		super(500, 120, Assets.soccerBrownKick.getWidth(), Assets.soccerBrownKick.getHeight(), 49, 37, 89, 134);
	}
	
	public void soccerBrownIn(ScrollSpeed _scrollSpeed) {
			super.setX(super.getX() - _scrollSpeed.getScrollSpeed());
	}
	
	public void soccerBrownOut(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() + _scrollSpeed.getScrollSpeed());
	}

	public void drawSoccerBrown(Graphics g) {
		g.drawPixmap(Assets.soccerBrownKick, super.getX(), super.getY());
	}

}
