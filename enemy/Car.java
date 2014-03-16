package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class Car extends SpriteEnemy{
	
	private byte speed = 32;
	
	public Car(int positionX, int positionY) {
		super(positionX, positionY, Assets.car.getWidth(), Assets.car.getHeight(),
				0, 0, Assets.car.getWidth(), Assets.car.getHeight(),
				39, 42, 149, 134, 50, 60);
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.down(_scrollSpeed, speed);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.car);
	}

}
