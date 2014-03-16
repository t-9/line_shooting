package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;

public class SideAttackCony extends SpriteEnemy{
	
	private byte speed = 10; 

	public SideAttackCony(int positionX, int positionY) {
		super(positionX, positionY, Assets.sideAttackCony.getWidth(), Assets.sideAttackCony.getHeight(),
				0, 0, Assets.sideAttackCony.getWidth(), Assets.sideAttackCony.getHeight(),
				56, 45, 66, 158, 10, 60);
	}
	
	public void move(ScrollSpeed _scrollSpeed) {
		super.goLeft(_scrollSpeed, speed);
	}
	
	public void draw(Graphics g) {
		super.draw(g, Assets.sideAttackCony);
	}

}
