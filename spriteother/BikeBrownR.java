package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class BikeBrownR extends SpriteOther {
	
	private int targetX = 0, targetY = 800;
	private byte spriteSpeed = 32;

	public BikeBrownR() {
		super(500, -33, Assets.bikeBrownR.getWidth(), Assets.bikeBrownR.getHeight(),61, 54, 65, 70);
	}
	
	public void bikeBrownRDraw(Graphics g) {
		g.drawPixmap(Assets.bikeBrownR, super.getX(), super.getY());
	}
	
	public void bikeBrownMove(ScrollSpeed _scrollSpeed) {
		super.guide(_scrollSpeed, spriteSpeed, targetX, targetY);
	}
	
	public int getTargetX() {
		return targetX;
	}
	
	public int getTargetY() {
		return targetY;
	}

}
