package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.FrameCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.rotateTable.SpinfaceRotateTable;

public class Spinface extends SpriteEnemy{

	static private int smallCollisionX = 7, smallCollisionY = 7, smallCollisionWidth = 47, smallCollisionHeight = 47,
	bigCollisionX = 16, bigCollisionY = 18, bigCollisionWidth = 30, bigCollisionHeight = 26,
	hp = 20, addtime = 60;
	private byte speed = 2;
	private float rotateDegrees = 0, maxRotateDegrees = -360, rotateDegreesAdd = -22.5f;
	
	SpinfaceRotateTable _spinfaceRotateTable = new SpinfaceRotateTable(rotateDegrees, maxRotateDegrees, rotateDegreesAdd, super.getX(), super.getY());

	public Spinface(int xPos, int yPos){
		super(xPos, yPos, Assets.spin_face01.getWidth(), Assets.spin_face01.getHeight(),
				smallCollisionX, smallCollisionY, smallCollisionWidth, smallCollisionHeight,
				bigCollisionX, bigCollisionY, bigCollisionWidth, bigCollisionHeight, hp, addtime);
	}

	public void spinfaceMove(ScrollSpeed _scrollSpeed, SpriteJiki _sp_jiki) {
		if (super.getScreenIn()){
			rotateDegrees = (rotateDegrees <= maxRotateDegrees)	? 0
																: rotateDegrees + rotateDegreesAdd;
			super.guide(_scrollSpeed, speed, _sp_jiki.getX(), _sp_jiki.getY());
		}
	}

	public void spinfaceDraw(Graphics g, FrameCount _frameCount){
		if (super.getHP() > 0 && !super.getScreenIn())
			g.drawPixmap(Assets.spin_face01, super.getX(), super.getY());
		else if (super.getScreenIn())
			_spinfaceRotateTable.drawRotateBitmap(g, Assets.spin_face01, super.getX(), super.getY(), rotateDegrees);
	}

}
