package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.FrameCount;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.rotateTable.BoomerangRotateTable;

public class WeaponBoomerang extends SpriteOther{
	
	BoomerangRotateTable _boomerangRotateTable = new BoomerangRotateTable(rotateDegrees, maxRotateDegrees,
			rotateDegreesAdd, super.getX(), super.getY());

	public WeaponBoomerang() {
		super(initXPos, initYPos,
				Assets.boomerang.getWidth(), Assets.boomerang.getHeight(), 0, 0,
				Assets.boomerang.getWidth(), Assets.boomerang.getHeight());
	}

	private double boomerangBezieRate = 0;
	private int boomerangTargetX = 240, boomerangTargetY = 100, provisionalTargetX = 240, provisionalTargetY = 100,
		boomerangCenter = Assets.boomerang.getWidth() / 2;
	static private int initXPos = 200, initYPos = 600;
	static private float rotateDegrees = 0, maxRotateDegrees = 360.0f, rotateDegreesAdd = 22.5f;

	private void setBoomerangTarget(int x, int y){
		boomerangTargetX = x;
		boomerangTargetY = y;
	}

	private void BoomerangMoving(SpriteJiki _sp_jiki){
		super.setX(BezierCurve(super.getX(), boomerangTargetX,
				_sp_jiki.getX(), boomerangBezieRate));
		super.setY(BezierCurve(super.getY(), boomerangTargetY,
				_sp_jiki.getY(), boomerangBezieRate));
		rotateDegrees = (rotateDegrees >= 360)	? 0
												: rotateDegrees + 22.5f;
	}

	public void BoomerangPosInit(SpriteJiki _sp_jiki) {
		boomerangBezieRate = 0;
		super.setX(_sp_jiki.getX());
		super.setY(_sp_jiki.getY());
	}

	private void BoomerangBezieRateAdd(int x, int y){
		boomerangBezieRate += 0.02;
		if (boomerangBezieRate > 1) {
			setBoomerangTarget(x, y);
			boomerangBezieRate = 0.02;
			Assets.windNoise.play(1);
		}
	}

	/* 2次ベジェ曲線
	private int BezierCurve(int a, int b, int c, double rate){
		double e = 1.0 - rate;
		e = e * e * c + 2.0 * e * rate * b + rate * rate * a;
		return (int) e;
	}*/

	// 3次ベジェ曲線
	private int BezierCurve(int a, int b, int c, double rate) { // 初期位置，中間点1，
																// 目標位置，
																// 精度
		double e = 1.0 - rate;
		double rate3be = 3.0 * e * rate * b;
		e = e * e * e * a + rate3be * e + rate3be * rate + rate * rate * rate * c;
		return (int) e;
	}

	// 3次ベジェ曲線
	/*private int BezierCurve(int a, int b, int c, int d, double rate) { // 初期位置，中間点1，
																		// 中間点2，
																		// 目標位置，
																		// 精度
		double e = 1.0 - rate;
		double e2 = e * e;
		double rate2 = rate * rate;
		e = e2 * e * a + 3.0 * e2 * rate * b + 3.0 * e * rate2 * c + rate2 * rate * d;
		return (int) e;
	}*/

	/*public void BoomerangMove(SpriteEnemy _sp_enemy, SpriteJiki _sp_jiki) {
		BoomerangBezieRateAdd(_sp_enemy);
		BoomerangMoving(_sp_jiki);
	}*/

	public void BoomerangMove(SpriteJiki _sp_jiki) {
		BoomerangBezieRateAdd(provisionalTargetX, provisionalTargetY);
		BoomerangMoving(_sp_jiki);
	}

	public void BoomerangDraw(Graphics g, FrameCount _frameCount) {
		
		_boomerangRotateTable.drawRotateBitmap(g, Assets.boomerang, super.getX(), super.getY(), rotateDegrees);

		/*g.drawPixmap((_frameCount.GetFrameCount() % 16 < 2) 	? Assets.boomerang
				: (_frameCount.GetFrameCount() % 16 < 4)		? Assets.boomerang45
				: (_frameCount.GetFrameCount() % 16 < 6)		? Assets.boomerang90
				: (_frameCount.GetFrameCount() % 16 < 8)		? Assets.boomerang135
				: (_frameCount.GetFrameCount() % 16 < 10)	? Assets.boomerang180
				: (_frameCount.GetFrameCount() % 16 < 12)	? Assets.boomerang225
				: (_frameCount.GetFrameCount() % 16 < 14)	? Assets.boomerang270
				: Assets.boomerang315,
					super.getX(), super.getY());*/
	}

	public void setProvisionalTarget(int x, int y){
		this.provisionalTargetX = x;
		this.provisionalTargetY = y;
	}

	public void setProvisionalTarget(SpriteEnemy _sp_enemy){
		this.provisionalTargetX = _sp_enemy.getX() + _sp_enemy.getW() / 2 - boomerangCenter;
		this.provisionalTargetY = _sp_enemy.getY() + _sp_enemy.getH() / 2 - boomerangCenter;
	}
}
