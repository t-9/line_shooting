package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class BigScratch extends SpriteOther{
	
	public BigScratch(int positionX, int positionY) {
		super(positionX, positionY, Assets.bigScratch.getWidth(), Assets.bigScratch.getHeight(),
				117, 141, 205, 182);
	}
	
	public void draw(Graphics g) {
		g.drawPixmap(Assets.bigScratch, super.getX(), super.getY());
	}

}
