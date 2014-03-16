package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.framewark.Graphics;

public class SoccerBall extends SpriteEnemy{
	
	private int targetX = 0, targetY = 0, speed = 4;
	private boolean targetSeted = false;

	public SoccerBall() {
		super(500, 230, Assets.soccerBall.getWidth(), Assets.soccerBall.getHeight(), 
				0, 0, Assets.soccerBall.getWidth(), Assets.soccerBall.getHeight(), 
				13, 13, 64, 65, 10, 60);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.soccerBall);
	}
	
	public void soccerBallIn(ScrollSpeed _scrollSpeed) {
			super.setX(super.getX() - _scrollSpeed.getScrollSpeed());
	}
	
	public void setTarget(SpriteJiki _spriteJiki) {
		targetX = (_spriteJiki.getX() - super.getX()) << 10;
		targetY = (_spriteJiki.getY() - super.getY()) << 10;
	}
	
	public void shoot(ScrollSpeed _scrollSpeed){
		super.guide(_scrollSpeed, speed, targetX, targetY);
	}
	
	public boolean getTargetSeted() {
		return targetSeted;
	}
	
	public void setTargetSeted(boolean targetSeted) {
		this.targetSeted = targetSeted;
	}

}
