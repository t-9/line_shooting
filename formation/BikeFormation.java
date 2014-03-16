package com.example.line_shooting.formation;

import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.ObstacleProcessing;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.spriteother.BikeBrownL;
import com.example.line_shooting.spriteother.BikeBrownR;
import com.example.line_shooting.spriteother.CarefulBalloon;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class BikeFormation extends Formation{
	
	CarefulBalloon _carefulBalloon = new CarefulBalloon();
	BikeBrownR _bikeBrownR0 = new BikeBrownR();
	BikeBrownR _bikeBrownR1 = new BikeBrownR();
	BikeBrownL _bikeBrownL0 = new BikeBrownL();
	
	ObstacleProcessing _obstacleProcessing = new ObstacleProcessing();
	
	private void bikeFormationObstacleCollisionCheck(TimerCount _timerCount,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
		// 当たり判定
		_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _carefulBalloon, _sp_jiki);
		_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _bikeBrownR0, _sp_jiki);
		_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _bikeBrownL0, _sp_jiki);
		_obstacleProcessing.obstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _bikeBrownR1, _sp_jiki);
	}
	
	public void bikeFormationMove(TimerCount _timerCount,
			PointCount _pointCount, ScrollSpeed _scrollSpeed,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponBoomerang _weaponBoomerang, WeaponReport _weaponReport,
			SpriteJiki _spriteJiki) {

		bikeFormationObstacleCollisionCheck(_timerCount, _weaponFlag,
				_collision, _weaponReport, _spriteJiki);

		// 敵の入場
		if (_carefulBalloon.getX() > 330 && _bikeBrownR1.getTargetY() > _bikeBrownR1.getY()) 
			_carefulBalloon.carefulBalloonIn(_scrollSpeed);
		else if (_bikeBrownR0.getTargetY() > _bikeBrownR0.getY())
			_bikeBrownR0.bikeBrownMove(_scrollSpeed);
		else if (_bikeBrownL0.getTargetY() > _bikeBrownL0.getY())
			_bikeBrownL0.bikeBrownMove(_scrollSpeed);
		else if (_bikeBrownR1.getTargetY() > _bikeBrownR1.getY())
			_bikeBrownR1.bikeBrownMove(_scrollSpeed);
		else if (_carefulBalloon.getX() < 800)
			_carefulBalloon.carefulBalloonOut(_scrollSpeed);
		else
			super.setDrawEnd(true);

	}

	public void bikeFormationDraw(Graphics g) {
		_carefulBalloon.draw(g);
		_bikeBrownR0.bikeBrownRDraw(g);
		_bikeBrownL0.bikeBrownLDraw(g);
		_bikeBrownR1.bikeBrownRDraw(g);
	}

}
