package com.example.line_shooting.formation;

import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.enemy.Sally;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class SallyFormation extends Formation{
	
	Sally _sally0	 = new Sally(500, 0);
	Sally _sally1	 = new Sally(500, 30);
	Sally _sally2	 = new Sally(500, 60);
	Sally _sally3	 = new Sally(500, 90);
	Sally _sally4	 = new Sally(500, 120);
	Sally _sally5	 = new Sally(-200, 0);
	Sally _sally6	 = new Sally(-200, 30);
	Sally _sally7	 = new Sally(-200, 60);
	Sally _sally8	 = new Sally(-200, 90);
	Sally _sally9	 = new Sally(-200, 120);
	Sally _sally10	 = new Sally(200, -200);
	Sally _sally11	 = new Sally(210, -200);
	Sally _sally12	 = new Sally(220, -200);
	Sally _sally13	 = new Sally(190, -200);
	Sally _sally14	 = new Sally(180, -200);
	
	private void SallyRMove(ScrollSpeed _scrollSpeed, TimerCount _timerCount, WeaponFlag _weaponFlag, 
			Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _spriteJiki) {
		_sally0.move(_scrollSpeed, _spriteJiki);
		_sally1.move(_scrollSpeed, _spriteJiki);
		_sally2.move(_scrollSpeed, _spriteJiki);
		_sally3.move(_scrollSpeed, _spriteJiki);
		_sally4.move(_scrollSpeed, _spriteJiki);
		_sally0.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally1.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally2.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally3.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally4.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
	}
	
	private void SallyLMove(ScrollSpeed _scrollSpeed, TimerCount _timerCount, WeaponFlag _weaponFlag, 
			Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _spriteJiki) {
		_sally5.move(_scrollSpeed, _spriteJiki);
		_sally6.move(_scrollSpeed, _spriteJiki);
		_sally7.move(_scrollSpeed, _spriteJiki);
		_sally8.move(_scrollSpeed, _spriteJiki);
		_sally9.move(_scrollSpeed, _spriteJiki);
		_sally5.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally6.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally7.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally8.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally9.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
	}
	
	private void SallyUMove(ScrollSpeed _scrollSpeed, TimerCount _timerCount, WeaponFlag _weaponFlag, 
			Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _spriteJiki) {
		_sally10.move(_scrollSpeed, _spriteJiki);
		_sally11.move(_scrollSpeed, _spriteJiki);
		_sally12.move(_scrollSpeed, _spriteJiki);
		_sally13.move(_scrollSpeed, _spriteJiki);
		_sally14.move(_scrollSpeed, _spriteJiki);
		_sally10.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally11.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally12.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally13.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_sally14.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
	}
	
	public void move(TimerCount _timerCount,
			PointCount _pointCount, ScrollSpeed _scrollSpeed,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponBoomerang _weaponBoomerang, WeaponReport _weaponReport,
			SpriteJiki _spriteJiki) {
		
		if (_sally0.getHP() > 0 || _sally1.getHP() > 0 || _sally2.getHP() > 0 || _sally3.getHP() > 0
				|| _sally4.getHP() > 0)
			SallyRMove(_scrollSpeed, _timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		else if (_sally5.getHP() > 0 || _sally6.getHP() > 0 || _sally7.getHP() > 0 || _sally8.getHP() > 0
				|| _sally9.getHP() > 0)
			SallyLMove(_scrollSpeed, _timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		else if (_sally10.getHP() > 0 || _sally11.getHP() > 0 || _sally12.getHP() > 0 || _sally13.getHP() > 0
				|| _sally14.getHP() > 0)
			SallyUMove(_scrollSpeed, _timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		else
			super.setDrawEnd(true);
	}

	public void draw(Graphics g) {
		_sally0.draw(g);
		_sally1.draw(g);
		_sally2.draw(g);
		_sally3.draw(g);
		_sally4.draw(g);
		_sally5.draw(g);
		_sally6.draw(g);
		_sally7.draw(g);
		_sally8.draw(g);
		_sally9.draw(g);
		_sally10.draw(g);
		_sally11.draw(g);
		_sally12.draw(g);
		_sally13.draw(g);
		_sally14.draw(g);
	}

}
