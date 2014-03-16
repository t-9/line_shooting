package com.example.line_shooting.formation;

import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.ObstacleProcessing;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.enemy.SoccerBall;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.spriteother.SoccerBrown;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class SoccerFormation extends Formation{

	SoccerBrown _soccerBrown = new SoccerBrown();
	SoccerBall _soccerBall0 = new SoccerBall();
	SoccerBall _soccerBall1 = new SoccerBall();
	SoccerBall _soccerBall2 = new SoccerBall();

	ObstacleProcessing _obstacleProcessing = new ObstacleProcessing();

	private void soccerFormationObstacleCollisionCheck(TimerCount _timerCount,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
		// soccerBrownとの当たり判定
		_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _soccerBrown, _sp_jiki);
	}

	private void aimSoccerBall(SoccerBall _soccerBall, SpriteJiki _spriteJiki) {
		_soccerBall.setTarget(_spriteJiki);
		_soccerBall.setTargetSeted(true);
		_soccerBall.setScreenIn(true);
	}

	private void shootSoccerBall(ScrollSpeed _scrollSpeed,
			TimerCount _timerCount, WeaponFlag _weaponFlag,
			Collision _collision, WeaponReport _weaponReport,
			WeaponBoomerang _weaponBoomerang, SpriteJiki _spriteJiki,
			SoccerBall _soccerBall) {
		_soccerBall.check(_timerCount, _weaponFlag, _collision, _weaponReport,
				_weaponBoomerang, _spriteJiki);
		_soccerBall.shoot(_scrollSpeed);
	}

	public void soccerFormationMove(TimerCount _timerCount,
			PointCount _pointCount, ScrollSpeed _scrollSpeed,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponBoomerang _weaponBoomerang, WeaponReport _weaponReport,
			SpriteJiki _spriteJiki) {

		soccerFormationObstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _spriteJiki);

		// 敵の入場
		if (_soccerBrown.getX() > 280 && !_soccerBall0.getTargetSeted()) {
			_soccerBrown.soccerBrownIn(_scrollSpeed);
			_soccerBall0.soccerBallIn(_scrollSpeed);
		} else {

			// 狙いを定める
			if (!_soccerBall0.getTargetSeted())
				aimSoccerBall(_soccerBall0, _spriteJiki);

			// シュート
			if (_soccerBall0.getScreenIn()) {
				shootSoccerBall(_scrollSpeed, _timerCount, _weaponFlag,
						_collision, _weaponReport, _weaponBoomerang,
						_spriteJiki, _soccerBall0);
			} else {
				if (_soccerBall1.getX() > 280)
					_soccerBall1.soccerBallIn(_scrollSpeed);
				else {
					if (!_soccerBall1.getTargetSeted())
						aimSoccerBall(_soccerBall1, _spriteJiki);
					if (_soccerBall1.getScreenIn()) {
						shootSoccerBall(_scrollSpeed, _timerCount, _weaponFlag,
								_collision, _weaponReport, _weaponBoomerang,
								_spriteJiki, _soccerBall1);
					} else {
						if (_soccerBall2.getX() > 280)
							_soccerBall2.soccerBallIn(_scrollSpeed);
						else {
							if (!_soccerBall2.getTargetSeted())
								aimSoccerBall(_soccerBall2, _spriteJiki);
							if (_soccerBall2.getScreenIn()) {
								shootSoccerBall(_scrollSpeed, _timerCount,
										_weaponFlag, _collision, _weaponReport,
										_weaponBoomerang, _spriteJiki,
										_soccerBall2);
							} else {
								// ブラウン退場
								if (_soccerBrown.getX() < 480)
									_soccerBrown.soccerBrownOut(_scrollSpeed);
								// 描画終了
								else
									super.setDrawEnd(true);
							}
						}
					}
				}
			}
		}
	}

	public void draw(Graphics g) {
		_soccerBrown.drawSoccerBrown(g);
		if (_soccerBall0.getHP() > 0)
			_soccerBall0.draw(g);
		if (_soccerBall1.getHP() > 0)
			_soccerBall1.draw(g);
		if (_soccerBall2.getHP() > 0)
			_soccerBall2.draw(g);
	}

}
