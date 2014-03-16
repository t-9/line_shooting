package com.example.line_shooting.formation;

import com.example.line_shooting.Collision;
import com.example.line_shooting.Formation;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.enemy.GoodbyeB;
import com.example.line_shooting.enemy.GoodbyeD;
import com.example.line_shooting.enemy.GoodbyeE;
import com.example.line_shooting.enemy.GoodbyeExclamation;
import com.example.line_shooting.enemy.GoodbyeG;
import com.example.line_shooting.enemy.GoodbyeO;
import com.example.line_shooting.enemy.GoodbyeY;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class GoodbyeFormation extends Formation{
	
	private int oX = 122, oY = -200;
	private byte span = 0 , moveFlag = 0;
	private double [] boomerangToGoodbye = new double[8];
	
	GoodbyeG _goodbyeG = new GoodbyeG(oX, oY);
	GoodbyeO _goodbyeO0 = new GoodbyeO(oX + 74, oY + 12);
	GoodbyeO _goodbyeO1 = new GoodbyeO(oX + 131, oY + 10);
	GoodbyeD _goodbyeD = new GoodbyeD(oX + 186, oY + 10);
	GoodbyeB _goodbyeB = new GoodbyeB(oX + 21, oY + 91);
	GoodbyeY _goodbyeY = new GoodbyeY(oX + 75, oY + 91);
	GoodbyeE _goodbyeE = new GoodbyeE(oX + 137, oY + 88);
	GoodbyeExclamation _goodbyeExclamation = new GoodbyeExclamation(oX + 186, oY + 89);
	
	public GoodbyeFormation() {
		super();
		for(byte i = 0; i <= 7; i++){
			boomerangToGoodbye[i] = Double.MAX_VALUE;
		}
	}
	
	private void down(ScrollSpeed _scrollSpeed) {
		_goodbyeG.setY(_goodbyeG.getY() + _scrollSpeed.getScrollSpeed());
		_goodbyeO0.setY(_goodbyeO0.getY() + _scrollSpeed.getScrollSpeed());
		_goodbyeO1.setY(_goodbyeO1.getY() + _scrollSpeed.getScrollSpeed());
		_goodbyeD.setY(_goodbyeD.getY() + _scrollSpeed.getScrollSpeed());
		_goodbyeB.setY(_goodbyeB.getY() + _scrollSpeed.getScrollSpeed());
		_goodbyeY.setY(_goodbyeY.getY() + _scrollSpeed.getScrollSpeed());
		_goodbyeE.setY(_goodbyeE.getY() + _scrollSpeed.getScrollSpeed());
		_goodbyeExclamation.setY(_goodbyeExclamation.getY() + _scrollSpeed.getScrollSpeed());
	}
	
	/*private void launch(SpriteEnemy _spriteEnemy, ScrollSpeed _scrollSpeed, TimerCount _timerCount,
			WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, 
			SpriteJiki _spriteJiki) {
		_spriteEnemy.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
		_spriteEnemy.move(_scrollSpeed);
	}*/
	
	public void move(TimerCount _timerCount,
			PointCount _pointCount, ScrollSpeed _scrollSpeed,
			WeaponFlag _weaponFlag, Collision _collision,
			WeaponBoomerang _weaponBoomerang, WeaponReport _weaponReport,
			SpriteJiki _spriteJiki) {
		
		span++;
		
		if (_goodbyeG.getY() < 100 && moveFlag == 0)
			down(_scrollSpeed);
		else if (moveFlag == 0) {
			_goodbyeO0.setTarget(-1, 600);
			_goodbyeO1.setTarget(481, 600);
			_goodbyeG.setTarget();
			moveFlag = 1;
			span = 0;
		} else if (moveFlag < 8 && span >= 30) {
			moveFlag++;
			span = 0;
		} 
		if (moveFlag == 8 && !_goodbyeO1.getScreenIn() && !_goodbyeO0.getScreenIn() && !_goodbyeD.getScreenIn()
				&& !_goodbyeG.getScreenIn() && !_goodbyeE.getScreenIn() && !_goodbyeExclamation.getScreenIn()
				&& !_goodbyeB.getScreenIn() && !_goodbyeY.getScreenIn()){
			moveFlag = 9;
			super.setDrawEnd(true);
		}
		
		switch (moveFlag) {
		case 8:
			_goodbyeO1.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeO1.move(_scrollSpeed);
			if (_goodbyeO1.getScreenIn())
				boomerangToGoodbye[7] = Math.abs(Math.sqrt(_goodbyeO1.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeO1.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[7] = Double.MAX_VALUE;
		case 7:
			_goodbyeO0.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeO0.move(_scrollSpeed);
			if (_goodbyeO0.getScreenIn())
				boomerangToGoodbye[6] = Math.abs(Math.sqrt(_goodbyeO0.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeO0.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[6] = Double.MAX_VALUE;
		case 6:
			_goodbyeD.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeD.move(_scrollSpeed);
			if (_goodbyeD.getScreenIn())
				boomerangToGoodbye[5] = Math.abs(Math.sqrt(_goodbyeD.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeD.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[5] = Double.MAX_VALUE;
		case 5:
			_goodbyeG.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeG.move(_scrollSpeed);
			if (_goodbyeG.getScreenIn())
				boomerangToGoodbye[4] = Math.abs(Math.sqrt(_goodbyeG.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeG.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[4] = Double.MAX_VALUE;
		case 4:
			_goodbyeE.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeE.move(_scrollSpeed);
			if (_goodbyeE.getScreenIn())
				boomerangToGoodbye[3] = Math.abs(Math.sqrt(_goodbyeE.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeE.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[3] = Double.MAX_VALUE;
		case 3:
			_goodbyeExclamation.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeExclamation.move(_scrollSpeed);
			if (_goodbyeExclamation.getScreenIn())
				boomerangToGoodbye[2] = Math.abs(Math.sqrt(_goodbyeExclamation.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeExclamation.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[2] = Double.MAX_VALUE;
		case 2:
			_goodbyeB.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeB.move(_scrollSpeed);
			if (_goodbyeB.getScreenIn())
				boomerangToGoodbye[1] = Math.abs(Math.sqrt(_goodbyeB.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeB.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[1] = Double.MAX_VALUE;
		case 1:
			_goodbyeY.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
			_goodbyeY.move(_scrollSpeed);
			if (_goodbyeY.getScreenIn())
				boomerangToGoodbye[0] = Math.abs(Math.sqrt(_goodbyeY.getCenterX() - _spriteJiki.getCenterX()) + 
						Math.sqrt(_goodbyeY.getCenterY() - _spriteJiki.getCenterY()));
			else
				boomerangToGoodbye[0] = Double.MAX_VALUE;
			
			int index = 0;
			for(int i=1; i < boomerangToGoodbye.length; i++)
			index = (boomerangToGoodbye[index] <= boomerangToGoodbye[i])	? index 
																			: i;
			switch (index) {
			case 0:
				_goodbyeY.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				break;
			case 1:
				_goodbyeB.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				break;
			case 2:
				_goodbyeExclamation.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				break;
			case 3:
				_goodbyeE.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				break;
			case 4:
				_goodbyeG.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				break;
			case 5:
				_goodbyeD.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				break;
			case 6:
				_goodbyeO0.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				break;
			case 7:
				_goodbyeO1.check(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _spriteJiki);
				default:
			}
			default:
		}
		
	}

	public void draw(Graphics g) {
		_goodbyeG.draw(g);
		_goodbyeO0.draw(g);
		_goodbyeO1.draw(g);
		_goodbyeD.draw(g);
		_goodbyeB.draw(g);
		_goodbyeY.draw(g);
		_goodbyeE.draw(g);
		_goodbyeExclamation.draw(g);
		
		/* bugCheck
		if(_goodbyeG.getScreenIn())
			g.drawRect(0, 100, 10, 10, Color.RED);
		if(_goodbyeO0.getScreenIn())
			g.drawRect(10, 100, 10, 10, Color.BLUE);
		if(_goodbyeO1.getScreenIn())
			g.drawRect(20, 100, 10, 10, Color.YELLOW);
		if(_goodbyeD.getScreenIn())
			g.drawRect(30, 100, 10, 10, Color.GREEN);
		if(_goodbyeB.getScreenIn())
			g.drawRect(40, 100, 10, 10, Color.BLACK);
		if(_goodbyeY.getScreenIn())
			g.drawRect(50, 100, 10, 10, Color.CYAN);
		if(_goodbyeE.getScreenIn())
			g.drawRect(60, 100, 10, 10, Color.MAGENTA);
		if(_goodbyeExclamation.getScreenIn())
			g.drawRect(70, 100, 10, 10, Color.WHITE);
			*/
	}

}
