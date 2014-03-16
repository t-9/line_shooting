package com.example.line_shooting;

import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class EnemyProcessing {

	private void EnemyCollision(TimerCount _timerCount, SpriteEnemy _sp_enemy){
		_sp_enemy.setHPSubtract(_timerCount);
		Assets.hitNormal.play(0.5f);
	}

	private void EnemyCollisionCheck(TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _sp_jiki, SpriteEnemy _sp_enemy){

		// _sp_enemyと武器の当たり判定
		if(_weaponFlag.WeaponIsReport()) {
			if(_collision.CollisionCheck_Enemy_Other(_sp_enemy, _weaponReport)){
				EnemyCollision(_timerCount, _sp_enemy);
				_weaponReport.ReportPosInit(_sp_jiki);
			}
		} else if(_weaponFlag.WeaponIsBoomerang()){
			if(_collision.CollisionCheck_Enemy_Other(_sp_enemy, _weaponBoomerang))
				EnemyCollision(_timerCount, _sp_enemy);
		}

		// _sp_enemyと自機の当たり判定
		if (_collision.CollisionCheck_Jiki_Enemy(_sp_jiki, _sp_enemy)){
			_timerCount.setTimeLimitSubtract(60);
			EnemyCollision(_timerCount, _sp_enemy);
		}
	}

	public void EnemyCheck(TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _sp_jiki, SpriteEnemy _sp_enemy){
		if (!_sp_enemy.getScreenIn() && _collision.CollisionCheck_Screen_Enemy(_sp_enemy) && _sp_enemy.getHP() > 0)
				_sp_enemy.setScreenIn(true);

		// _sp_enemyがいれば
		if (_sp_enemy.getScreenIn()){
			if(!_collision.CollisionCheck_Screen_Enemy(_sp_enemy))
				_sp_enemy.setScreenIn(false);

			EnemyCollisionCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _sp_jiki, _sp_enemy);
		}
	}

}
