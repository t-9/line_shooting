package com.example.line_shooting;

import com.example.line_shooting.spriteother.WeaponReport;

public class ObstacleProcessing {

	public void obstacleCollisionCheck(TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, SpriteOther _sp_other, SpriteJiki _sp_jiki) {
		
		// 自機との当たり判定
		if (_collision.CollisionCheck_Jiki_Other(_sp_jiki, _sp_other)){
			_timerCount.setTimeLimitSubtract(60);
			Assets.hitNormal.play(0.5f);
		}
		
		// _武器との当たり判定
		if(_weaponFlag.WeaponIsReport() && _collision.CollisionCheck_Other_Other(_sp_other, _weaponReport)){
			_weaponReport.ReportPosInit(_sp_jiki); 
			Assets.hitNormal.play(0.5f);
		}
	}
}
