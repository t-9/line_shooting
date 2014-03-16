package com.example.line_shooting;

public class Collision {

	private boolean CollisionDetection(int x, int y, int width, int height,
			int x2, int y2, int width2, int height2) {
		return (x < x2 + width2 && x2 < x + width && y < y2 + height2&& y2 < y + height);
	}

	public boolean CollisionCheck_Jiki_Enemy(SpriteJiki _sp_jiki, SpriteEnemy _sp_enemy) {
		return (CollisionDetection( _sp_jiki.getSmallHitX(), _sp_jiki.getSmallHitY(),
				_sp_jiki.getSmallHitW(), _sp_jiki.getSmallHitH(),
				_sp_enemy.getSmallHitX(), _sp_enemy.getSmallHitY(),
				_sp_enemy.getSmallHitW(), _sp_enemy.getSmallHitH()));
	}

	public boolean CollisionCheck_Jiki_Other(SpriteJiki _sp_jiki, SpriteOther _sp_other){
		return (CollisionDetection(_sp_jiki.getBigHitX(),
				_sp_jiki.getBigHitY(), _sp_jiki.getBigHitW(),
				_sp_jiki.getBigHitH(), _sp_other.getHitX(),
				_sp_other.getHitY(), _sp_other.getHitW(),
				_sp_other.getHitH()));
	}

	public boolean CollisionCheck_Enemy_Other(SpriteEnemy _sp_enemy, SpriteOther _sp_other){
		return (CollisionDetection(_sp_enemy.getBigHitX(),
				_sp_enemy.getBigHitY(), _sp_enemy.getBigHitW(),
				_sp_enemy.getBigHitH(), _sp_other.getHitX(),
				_sp_other.getHitY(), _sp_other.getHitW(),
				_sp_other.getHitH()));
	}
	
	public boolean CollisionCheck_Other_Other(SpriteOther _sp_other0, SpriteOther _sp_other1){
		return (CollisionDetection(_sp_other0.getHitX(),
				_sp_other0.getHitY(), _sp_other0.getHitW(),
				_sp_other0.getHitH(), _sp_other1.getHitX(),
				_sp_other1.getHitY(), _sp_other1.getHitW(),
				_sp_other1.getHitH()));
	}

	

	public boolean CollisionCheck_Screen_Enemy(SpriteEnemy _sp_enemy){
		return (CollisionDetection(0,0, 479, 799,
				_sp_enemy.getX(), _sp_enemy.getY(),
				_sp_enemy.getW(), _sp_enemy.getH()));
	}

}
