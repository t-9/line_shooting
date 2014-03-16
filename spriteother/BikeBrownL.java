package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class BikeBrownL extends SpriteOther {
	
	private int targetX = 480, targetY = 800;
	private byte spriteSpeed = 32;

	public BikeBrownL() {
		super(-200, -330, Assets.bikeBrownR.getWidth(), Assets.bikeBrownR.getHeight(),81, 53, 61, 74);
	}
	
	public void bikeBrownLDraw(Graphics g) {
		g.drawPixmap(Assets.bikeBrownL, super.getX(), super.getY());
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
