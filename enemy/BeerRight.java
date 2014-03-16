package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class BeerRight extends SpriteEnemy{
	
	private byte speed = 10;
	
	public BeerRight(int positionX, int positionY) {
		super(positionX, positionY, Assets.beerRight.getWidth(), Assets.beerRight.getHeight(),
				0, 0, Assets.beerRight.getWidth(), Assets.beerRight.getHeight(),
				29, 53, 79, 125, 10, 60);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.beerRight);
	}
	
	public void moveLeft(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() - _scrollSpeed.getScrollSpeed());
	}
	
	public void moveRight(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() + _scrollSpeed.getScrollSpeed());
	}
	
	public void cheers(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() - _scrollSpeed.getScrollSpeed() - speed);
	}
	
	public void leave(ScrollSpeed _scrollSpeed) {
		super.setX(super.getX() + _scrollSpeed.getScrollSpeed() + speed);
	}

}
