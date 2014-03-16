package com.example.line_shooting.formation;

import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.ObstacleProcessing;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.enemy.BeerLeft;
import com.example.line_shooting.enemy.BeerRight;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.spriteother.Cheers;
import com.example.line_shooting.spriteother.ConyName;
import com.example.line_shooting.spriteother.ConySquare;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class BeerFormation extends Formation{
	
	private int conyPosX = -250, conyPosY = 350, beerPosX = 580, beerPosY = 150, beerSpaceX = 135, beerSpaceY = 28;
	private byte progressState = 0;
	
	ConySquare _conySquare = new ConySquare(conyPosX, conyPosY);
	ConyName _conyName = new ConyName(conyPosX + 88, conyPosY + 3);
	Cheers _cheers = new Cheers(conyPosX + 74, conyPosY + 31);
	BeerLeft _beerLeft = new BeerLeft(beerPosX, beerPosY);
	BeerRight _beerRight = new BeerRight(beerPosX + beerSpaceX, beerPosY + beerSpaceY);
	
	ObstacleProcessing _obstacleProcessing = new ObstacleProcessing();
	
	private void beerFormationObstacleCollisionCheck(TimerCount _timerCount,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
		// 当たり判定
		_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _conySquare, _sp_jiki);
		_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _cheers, _sp_jiki);
	}
	
	public void move(TimerCount _timerCount,
			PointCount _pointCount, ScrollSpeed _scrollSpeed,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponBoomerang _weaponBoomerang, WeaponReport _weaponReport,
			SpriteJiki _spriteJiki) {

		beerFormationObstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _spriteJiki);

		// 敵の入場
		if (progressState == 0){
			if (_beerLeft.getX() > 200) {
				_beerLeft.moveLeft(_scrollSpeed);
				_beerRight.moveLeft(_scrollSpeed);
			} else if (_conySquare.getX() < 10){
					_conySquare.moveRight(_scrollSpeed);
					_conyName.moveRight(_scrollSpeed);
					_cheers.moveRight(_scrollSpeed);
			} else
				progressState = 1;
		} else if (progressState == 1) {
			if (_beerLeft.getX() < 480) {
				_beerLeft.moveRight(_scrollSpeed);
				_beerRight.moveRight(_scrollSpeed);
			} else if (_conySquare.getX() > conyPosX) {
				_conySquare.moveLeft(_scrollSpeed);
				_conyName.moveLeft(_scrollSpeed);
				_cheers.moveLeft(_scrollSpeed);
			} else
				progressState = 2;
		} else if (progressState == 2) {
			_beerLeft.setX(-200);
			_beerRight.setX(512);
			_beerLeft.setY(_spriteJiki.getY());
			_beerRight.setY(_spriteJiki.getY() + beerSpaceY);
			progressState = 3;
		} else if (progressState == 3) {
			if (_beerLeft.getX() < 150){
				_beerLeft.cheers(_scrollSpeed);
				_beerLeft.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_beerRight.getX() > 150 + beerSpaceX){
				_beerRight.cheers(_scrollSpeed);
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_spriteJiki.getCenterX() < 240)
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			
			if (_beerLeft.getX() >= 150 && _beerRight.getX() <= 150 + beerSpaceX)
				progressState = 4;
		} else if (progressState == 4) {
			if (_beerLeft.getX() > -200) {
				_beerLeft.leave(_scrollSpeed);
				_beerLeft.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_beerRight.getX() < 512) {
				_beerRight.leave(_scrollSpeed);
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_spriteJiki.getCenterX() < 240)
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			
			if (_beerLeft.getX() <= -200 && _beerRight.getX() >= 512){
				progressState = 5;
				_beerLeft.setY(_spriteJiki.getY());
				_beerRight.setY(_spriteJiki.getY() + beerSpaceY);
			}
		} else if (progressState == 5) {
			if (_beerLeft.getX() < 150){
				_beerLeft.cheers(_scrollSpeed);
				_beerLeft.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_beerRight.getX() > 150 + beerSpaceX){
				_beerRight.cheers(_scrollSpeed);
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_spriteJiki.getCenterX() < 240)
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			
			if (_beerLeft.getX() >= 150 && _beerRight.getX() <= 150 + beerSpaceX)
				progressState = 6;
		} else if (progressState == 6) {
			if (_beerLeft.getX() > -200) {
				_beerLeft.leave(_scrollSpeed);
				_beerLeft.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_beerRight.getX() < 512) {
				_beerRight.leave(_scrollSpeed);
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_spriteJiki.getCenterX() < 240)
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			
			if (_beerLeft.getX() <= -200 && _beerRight.getX() >= 512){
				progressState = 7;
				_beerLeft.setY(_spriteJiki.getY());
				_beerRight.setY(_spriteJiki.getY() + beerSpaceY);
			}
		}  else if (progressState == 7) {
			if (_beerLeft.getX() < 150){
				_beerLeft.cheers(_scrollSpeed);
				_beerLeft.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_beerRight.getX() > 150 + beerSpaceX){
				_beerRight.cheers(_scrollSpeed);
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_spriteJiki.getCenterX() < 240)
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			
			if (_beerLeft.getX() >= 150 && _beerRight.getX() <= 150 + beerSpaceX)
				progressState = 8;
		} else if (progressState == 8) {
			if (_beerLeft.getX() > -200) {
				_beerLeft.leave(_scrollSpeed);
				_beerLeft.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_beerRight.getX() < 512) {
				_beerRight.leave(_scrollSpeed);
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			}
			if (_spriteJiki.getCenterX() < 240)
				_beerRight.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			
			if (_beerLeft.getX() <= -200 && _beerRight.getX() >= 512)
				super.setDrawEnd(true);
		}

	}
	
	public void draw(Graphics g) {
		_conySquare.drawConySquare(g);
		_conyName.drawConyName(g);
		_cheers.cheersDraw(g);
		_beerLeft.draw(g);
		_beerRight.draw(g);
	}

}