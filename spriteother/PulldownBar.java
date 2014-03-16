package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.Barehand;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.framewark.Graphics;

public class PulldownBar extends SpriteOther{

	public PulldownBar() {
		super(0, -112,
			Assets.pulldownBar.getWidth(), Assets.pulldownBar.getHeight(), 0,
			0, Assets.pulldownBar.getWidth(), Assets.pulldownBar.getHeight());
	}

	private void PulldownBarDown() {
		super.setY((super.getY() + 10 < Assets.StatesBar.getHeight())
								? super.getY() + 10
								: Assets.StatesBar.getHeight()
				);
	}

	private void PulldownBarUp() {
		super.setY((super.getY() - 10 > -
				(Assets.pulldownBar.getHeight() - Assets.StatesBar.getHeight()))
						? super.getY() - 10
						: -(Assets.pulldownBar.getHeight() - Assets.StatesBar.getHeight())
				);
	}

	public void DrawPulldownBar(Graphics g) {
		g.drawPixmap(Assets.pulldownBar, super.getX(),
				super.getY());
	}

	private void Collision_Jiki_PulldownBar(SpriteJiki _sp_jiki, TimerCount _timerCount) {
		if (_sp_jiki.getY() <= super.getY() + super.getHitH()){
			_sp_jiki.setY(super.getY() + super.getHitH());
			if (super.getY() != -112){
				_timerCount.setTimeLimitSubtract(30);
				Assets.hurtIron.play(0.375f);
			}
		}
		
	}
	
	private void Collision_Weapon_PulldownBar(WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
		// _武器との当たり判定
		if (_weaponReport.getY() <= super.getY() + super.getHitH()) {
			_weaponReport.ReportPosInit(_sp_jiki);
			if (super.getY() != -112){
				Assets.hitNormal.play(0.5f);
			}
		}
	}
	
	public void CollisionCheck(TimerCount _timerCount, WeaponReport _weaponReport, SpriteJiki _sp_jiki) {
		Collision_Jiki_PulldownBar(_sp_jiki, _timerCount);
		Collision_Weapon_PulldownBar(_weaponReport, _sp_jiki);
		
	}

	public void JikiInPulldownBarRange(SpriteJiki _sp_jiki, Barehand _barehand) {
		if (_sp_jiki.getY() >= Assets.StatesBar.getHeight() + super.getHitH() - 2) {
			_barehand.barehandUp();
			PulldownBarUp();
		} else {

			if (_barehand.getBarehandX() > 450)
				_barehand.barehandDown();
			else
				PulldownBarDown();
		}
	}

}
