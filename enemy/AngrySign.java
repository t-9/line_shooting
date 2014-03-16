package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.AngrySignScaleTable;
import com.example.line_shooting.FrameCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.rotateTable.AngrySignRotateTable;

public class AngrySign extends SpriteEnemy{

	static private int smallCollisionX = 5, smallCollisionY = 6, smallCollisionWidth = 32, smallCollisionHeight = 30,
	hp = 200, addtime = 180;
	//12, 12, 19, 18
	private float rotateDegrees = 0, rotateDegreesAdd = -22.5f, maxRotateDegrees = -360.f, scale = 1.0f, scaleAdd = 1.0f,
			maxScale = 10.0f, oldScale = 1.0f;
	private boolean rotateCollision = false;

	public AngrySign(int positionX, int positionY) {
		super(positionX, positionY, Assets.angrySign.getWidth(), Assets.angrySign.getHeight(), 0, 0,
				Assets.angrySign.getWidth(), Assets.angrySign.getHeight(), smallCollisionX, smallCollisionY,
				smallCollisionWidth, smallCollisionHeight, hp, addtime);
	}

	public float getScale() {
		return scale;
	}

	public float getScaleAdd() {
		return scaleAdd;
	}

	public float getMaxScale() {
		return maxScale;
	}
	
	public float getrotateDegrees() {
		return rotateDegrees;
	}
	
	public float getRotateDegreesAdd() {
		return rotateDegreesAdd;
	}
	
	public float getMaxRotateDegrees() {
		return maxRotateDegrees;
	}

	public void angrySignMove(ScrollSpeed _scrollSpeed){
		if (super.getScreenIn()){
			if(super.getX() > 219 && super.getY() < 379)
				super.guide(_scrollSpeed, 2, 219, 379);
			else if(scale < maxScale){
				oldScale = scale;
				scale += scaleAdd;
			} else if (scale == maxScale)
				rotateDegrees = (rotateDegrees <= maxRotateDegrees)	? rotateDegrees - maxRotateDegrees
																	: rotateDegrees + rotateDegreesAdd;
		}
	}

	public void angrySignDraw(Graphics g, FrameCount _frameCount, AngrySignScaleTable _angrySignScaleTable, 
			AngrySignRotateTable _angrySignRotateTable){
		if (super.getHP() > 0 && !super.getScreenIn())
			g.drawPixmap(Assets.angrySign, super.getX(), super.getY());
		else if (super.getScreenIn()){
			if(super.getX() > 219 && super.getY() < 379)
				g.drawPixmap(Assets.angrySign, super.getX(), super.getY());
			else if (scale < maxScale){
				int position[] = new int[4];
				position = _angrySignScaleTable.getScalePosition(g, Assets.angrySign, super.getX(),
						super.getY(), scale, oldScale);
				super.setX(super.getX() + position[0]);
				super.setY(super.getY() + position[1]);
				super.setW(position[2]);
				super.setH(position[3]);
				super.setBigHitW(position[2]);
				super.setBigHitH(position[3]);
				super.setSmallHitX((int)(smallCollisionX * scale));
				super.setSmallHitY((int)(smallCollisionY * scale));
				super.setSmallHitW((int)(smallCollisionWidth * scale));
				super.setSmallHitH((int)(smallCollisionHeight * scale));
				_angrySignScaleTable.drawScalePixmap(g, Assets.angrySign, super.getX(), super.getY(), scale);
			}
			else if (scale == maxScale){
				if (rotateCollision == false){
					super.setBigHitW((int)(super.getBigHitW() * 1.1));
					super.setBigHitH((int)(super.getBigHitH() * 1.1));
					super.setSmallHitW((int)(super.getSmallHitW() * 1.1));
					super.setSmallHitH((int)(super.getSmallHitH() * 1.1));
					rotateCollision = true;
				}
				_angrySignRotateTable.drawRotateBitmap(g, _angrySignScaleTable.getScaleBitmap(scale),
						super.getX(), super.getY(), rotateDegrees);			
			}
		} else {
			_angrySignScaleTable.hashMapClear();
			_angrySignRotateTable.hashMapClear();
		}
	}




}
