package com.example.line_shooting.formation;

import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.ObstacleProcessing;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.enemy.Brown;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.spriteother.BigScratch;
import com.example.line_shooting.spriteother.MiddleScratch;
import com.example.line_shooting.spriteother.SmallScratch;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class BrownFormation extends Formation {
	private int ss0_initX = 100, ss1_initX = 300, ss_initY = -200;
	
	Brown _brown = new Brown(0, -1000);
	SmallScratch _smallScratch0 = new SmallScratch(ss0_initX, ss_initY);
	SmallScratch _smallScratch1 = new SmallScratch(ss1_initX, ss_initY);
	MiddleScratch _middleScratch0 = new MiddleScratch(0, -300);
	MiddleScratch _middleScratch1 = new MiddleScratch(0, -300);
	BigScratch _bigScratch = new BigScratch(300, -600);
	
	ObstacleProcessing _obstacleProcessing = new ObstacleProcessing();

	private byte progressState = 0;
	private int processCounter = 0;

	public void move(TimerCount _timerCount, PointCount _pointCount,
			ScrollSpeed _scrollSpeed, WeaponFlag _weaponFlag,
			Collision _collision, WeaponBoomerang _weaponBoomerang,
			WeaponReport _weaponReport, SpriteJiki _spriteJiki) {
		if (_brown.getHP() > 0) {
			if (progressState == 0) {
				if (_brown.getY() < 10)
					_brown.down(_scrollSpeed);
				else
					progressState = 1;
			} else if (progressState == 1) {
				if (_brown.getY() > -400)
					_brown.up(_scrollSpeed);
				else
					progressState = 2;
			} else if (progressState == 2) {
				if (processCounter <= 60){
					_smallScratch0.guide(_scrollSpeed, _spriteJiki.getX() - 150, _spriteJiki.getY());
					_smallScratch1.guide(_scrollSpeed, _spriteJiki.getX() + 150, _spriteJiki.getY());
					processCounter++;
				} else {
					progressState = 3;
					processCounter = 0;
				}
			} else if (progressState == 3) {
				if (_smallScratch0.getX() < 480 && _smallScratch1.getX() > 97) {
					_smallScratch0.moveRight(_scrollSpeed);
					_smallScratch1.moveLeft(_scrollSpeed);
				} else {
					progressState = 4;
					smallScratchPosInit();
				}
			} else if (progressState == 4) {
				if (processCounter < 30) {
					_smallScratch0.guide(_scrollSpeed, 480, 800);
					_smallScratch1.guide(_scrollSpeed, -100, 800);
					processCounter++;
				} else {
					progressState = 5;
					processCounter = 0;
					if (_brown.getHP() < (_brown.getMaxHP() >> 2)){
						progressState = 6;
						smallScratchPosInit();
					}
				}
			} else if (progressState == 5) {
				if (processCounter < 60) {
					_smallScratch0.guide(_scrollSpeed, _spriteJiki.getCenterX(), _spriteJiki.getCenterY());
					_smallScratch1.guide(_scrollSpeed, _spriteJiki.getCenterX(), _spriteJiki.getCenterY());
					processCounter++;
				} else {
					progressState = 4;
					processCounter = 0;
					if (_brown.getHP() < (_brown.getMaxHP() >> 2)){
						progressState = 7;
						smallScratchPosInit();
					}
				}
			} else if (progressState == 6) {
				if (processCounter < 60) {
					_middleScratch0.guide(_scrollSpeed, 480, 800);
					_middleScratch1.guide(_scrollSpeed, -300, 800);
					processCounter++;
				} else {
					progressState = 7;
					processCounter = 0;
					/*if (_brown.getHP() < (_brown.getMaxHP() >> 3)){
						progressState = 9;
						middleScratchPosInit();
					}*/
				}
			} else if (progressState == 7) {
				if (processCounter < 60) {
					_middleScratch0.guide(_scrollSpeed, _spriteJiki.getCenterX(), _spriteJiki.getCenterY());
					_middleScratch1.guide(_scrollSpeed, _spriteJiki.getCenterX(), _spriteJiki.getCenterY());
					processCounter++;
				} else {
					progressState = 6;
					processCounter = 0;
					/*if (_brown.getHP() < (_brown.getMaxHP() >> 3)){
						progressState = 9;
						middleScratchPosInit();
					}*/
				}
			}
			_brown.check(_timerCount, _weaponFlag, _collision,
					_weaponReport, _weaponBoomerang, _spriteJiki);
			obstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _spriteJiki);
			
		} else
			super.setDrawEnd(true);
	}

	public void draw(Graphics g) {
		_brown.draw(g);
		_smallScratch0.draw(g);
		_smallScratch1.draw(g);
		_middleScratch0.draw(g);
		_middleScratch1.draw(g);
		_bigScratch.draw(g);
	}
	
	private void obstacleCollisionCheck(TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
			_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _smallScratch0, _sp_jiki);
			_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _smallScratch1, _sp_jiki);
			_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _middleScratch0, _sp_jiki);
			_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _middleScratch1, _sp_jiki);
	}
	
	private void smallScratchPosInit() {
		_smallScratch0.setX(ss0_initX);
		_smallScratch0.setY(ss_initY);
		_smallScratch1.setX(ss1_initX);
		_smallScratch1.setY(ss_initY);
	}

}
