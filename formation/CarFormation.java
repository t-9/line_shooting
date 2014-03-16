package com.example.line_shooting.formation;

import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.enemy.Car;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class CarFormation extends Formation{
	
	Car _car = new Car(200, -500);
	
	private void dash(ScrollSpeed _scrollSpeed) {
		_car.move(_scrollSpeed);
	}
	
	public void move(TimerCount _timerCount,
			PointCount _pointCount, ScrollSpeed _scrollSpeed,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponBoomerang _weaponBoomerang, WeaponReport _weaponReport,
			SpriteJiki _spriteJiki) {
		
		if (_car.getY() <= 800 && _car.getHP() > 0) {
			dash(_scrollSpeed);
			_car.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		} else
			super.setDrawEnd(true);
	}

	public void draw(Graphics g) {
		_car.draw(g);
	}

}
