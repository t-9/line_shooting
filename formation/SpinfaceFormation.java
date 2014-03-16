package com.example.line_shooting.formation;

import com.example.line_shooting.AngrySignScaleTable;
import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.FrameCount;
import com.example.line_shooting.ObstacleProcessing;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.enemy.AngrySign;
import com.example.line_shooting.enemy.Spinface;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.rotateTable.AngrySignRotateTable;
import com.example.line_shooting.spriteother.Balloon;
import com.example.line_shooting.spriteother.ConyName;
import com.example.line_shooting.spriteother.ConySquare;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class SpinfaceFormation extends Formation{

	private int spinFaceYPos = -60;

	Spinface _sp_spinFace1 = new Spinface(103, spinFaceYPos);
	Spinface _sp_spinFace2 = new Spinface(155, spinFaceYPos);
	Spinface _sp_spinFace3 = new Spinface(207, spinFaceYPos);
	Spinface _sp_spinFace4 = new Spinface(259, spinFaceYPos);
	Spinface _sp_spinFace5 = new Spinface(311, spinFaceYPos);
	AngrySign _sp_angrySign = new AngrySign(377, -50);
	ConySquare _sp_conySquare = new ConySquare(0, -100);
	ConyName _sp_conyName = new ConyName(88, -97);
	Balloon _sp_balloon = new Balloon();

	ObstacleProcessing _obstacleProcessing = new ObstacleProcessing();

	// AngrySignTableインスタンスの生成(必ずScaleTableを先に記述すること)
	AngrySignScaleTable _angrySignScaleTable = new AngrySignScaleTable(_sp_angrySign.getScale(), 
			_sp_angrySign.getMaxScale(), _sp_angrySign.getScaleAdd());
	AngrySignRotateTable _angrySignRotateTable = new AngrySignRotateTable( 
			_angrySignScaleTable.getScaleBitmap(10.0f), _sp_angrySign.getrotateDegrees(), 
			_sp_angrySign.getMaxRotateDegrees(), _sp_angrySign.getRotateDegreesAdd(), 
			_sp_angrySign.getX(), _sp_angrySign.getY());
	

	private void firstObstacleCollisionCheck(TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
		// conySquareとの当たり判定
			_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _sp_conySquare, _sp_jiki);

		// balloonとの当たり判定
			_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _sp_balloon, _sp_jiki);
	}

	private void firstObstacleFormationDown(ScrollSpeed _scrollSpeed) {
		_sp_conySquare.scroll(_scrollSpeed);
		_sp_conyName.scroll(_scrollSpeed);
		_sp_balloon.scroll(_scrollSpeed);
		if (_sp_conySquare.getY() >= 800)
			super.setDrawEnd(true);
	}

	private void firstEnemyFormationDown(ScrollSpeed _scrollSpeed) {
		_sp_spinFace1.scroll(_scrollSpeed);
		_sp_spinFace2.scroll(_scrollSpeed);
		_sp_spinFace3.scroll(_scrollSpeed);
		_sp_spinFace4.scroll(_scrollSpeed);
		_sp_spinFace5.scroll(_scrollSpeed);
		_sp_angrySign.scroll(_scrollSpeed);
	}

	private void firstFormationEnemyCheckBlock(TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision,
			WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _sp_jiki) {
		_sp_spinFace1.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _sp_jiki);
		if (!_sp_spinFace1.getScreenIn()){
			_sp_spinFace2.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _sp_jiki);
			if (!_sp_spinFace2.getScreenIn()){
				_sp_spinFace3.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _sp_jiki);
				if (!_sp_spinFace3.getScreenIn()){
					_sp_spinFace4.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _sp_jiki);
					if(!_sp_spinFace4.getScreenIn()){
						_sp_spinFace5.check(_timerCount, _weaponFlag, _collision, _weaponReport,
								_weaponBoomerang, _sp_jiki);
						if(!_sp_spinFace5.getScreenIn()){
							_sp_angrySign.check(_timerCount, _weaponFlag, _collision, _weaponReport,
									_weaponBoomerang, _sp_jiki);
						}
					}
				}
			}
		}
	}

	private void firstFormationEnemyMoveBlock(ScrollSpeed _scrollSpeed, SpriteJiki _sp_jiki){
		_sp_spinFace1.spinfaceMove(_scrollSpeed, _sp_jiki);
		_sp_spinFace2.spinfaceMove(_scrollSpeed, _sp_jiki);
		_sp_spinFace3.spinfaceMove(_scrollSpeed, _sp_jiki);
		_sp_spinFace4.spinfaceMove(_scrollSpeed, _sp_jiki);
		_sp_spinFace5.spinfaceMove(_scrollSpeed, _sp_jiki);
		_sp_angrySign.angrySignMove(_scrollSpeed);
	}

	private void firstFormationEnemyAct(ScrollSpeed _scrollSpeed, TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _sp_jiki){
		firstFormationEnemyCheckBlock(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _sp_jiki);
		firstFormationEnemyMoveBlock(_scrollSpeed, _sp_jiki);
	}

	private void firstFormationEnemyDrawBlock(Graphics g, FrameCount _frameCount){
		_sp_spinFace1.spinfaceDraw(g, _frameCount);
		_sp_spinFace2.spinfaceDraw(g, _frameCount);
		_sp_spinFace3.spinfaceDraw(g, _frameCount);
		_sp_spinFace4.spinfaceDraw(g, _frameCount);
		_sp_spinFace5.spinfaceDraw(g, _frameCount);
		_sp_angrySign.angrySignDraw(g, _frameCount, _angrySignScaleTable, _angrySignRotateTable);
	}

	private void firstObstacleDraw(Graphics g){
		_sp_conySquare.drawConySquare(g);
		_sp_conyName.drawConyName(g);
		_sp_balloon.balloonDraw(g);
	}

	public void spinfaceFormationDraw(Graphics g, FrameCount _frameCount){
		if(_sp_conySquare.getY() < 800)
			firstObstacleDraw(g);
		firstFormationEnemyDrawBlock(g, _frameCount);
	}

	public void spinfaceFormationMove(TimerCount _timerCount, PointCount _pointCount, ScrollSpeed _scrollSpeed, WeaponFlag _weaponFlag, Collision _collision, WeaponBoomerang _weaponboomerang, WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
		// conySquareがあれば
		if (_sp_conySquare.getY() < 800)
			firstObstacleCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _sp_jiki);

		// 820地点より前か，angrySignがやられたら
		if ( _pointCount.getPointCount() < 820 || _sp_angrySign.getHP() <= 0){
			firstObstacleFormationDown(_scrollSpeed);

			// 820地点より前なら
			if (_pointCount.getPointCount() < 820)
				firstEnemyFormationDown(_scrollSpeed);

			// angrySignが倒されたら
			if ( _sp_angrySign.getHP() <= 0)
				_sp_balloon.balloonLeave(_scrollSpeed);
		}
		if (_pointCount.getPointCount() >= 820 && _sp_angrySign.getHP() > 0 || _sp_angrySign.getScreenIn())
			firstFormationEnemyAct(_scrollSpeed, _timerCount, _weaponFlag, _collision, _weaponReport, _weaponboomerang, _sp_jiki);
	}

}
