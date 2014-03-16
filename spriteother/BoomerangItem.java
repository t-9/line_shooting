package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.Collision;
import com.example.line_shooting.FrameCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.framewark.Graphics;

public class BoomerangItem extends SpriteOther{

	public BoomerangItem() {
		super(300, 200,
				Assets.boomerang_item_01.getWidth(),
				Assets.boomerang_item_01.getHeight(), 6, 17, 58, 61);
	}

	public void BoomerangItemMove(ScrollSpeed _scrollSpeed) {
		super.setY(
				(super.getY() < 1000) 	? super.getY() + _scrollSpeed.getScrollSpeed()
													: -1000);
	}

	public void GetBoomerangItem(Collision _collision, SpriteJiki _sp_jiki, WeaponBoomerang _weaponBoomerang, WeaponFlag _weaponFlag) {
		if (_collision.CollisionCheck_Jiki_Other(_sp_jiki, this)) {
			_weaponFlag.setWeaponBoomerang();
			_weaponBoomerang.BoomerangPosInit(_sp_jiki);
			Assets.itemGet.play(0.5f);
		}
	}

	public void BoomerangItemDraw(Graphics g, FrameCount _frameCount) {
		g.drawPixmap((_frameCount.GetFrameCount() % 21 < 3) 	? Assets.boomerang_item_01
				: (_frameCount.GetFrameCount() % 21 < 6) 	? Assets.boomerang_item_02
				: (_frameCount.GetFrameCount() % 21 < 9) 	? Assets.boomerang_item_03
				: (_frameCount.GetFrameCount() % 21 < 12)	? Assets.boomerang_item_04
				: (_frameCount.GetFrameCount() % 21 < 15) 	? Assets.boomerang_item_05
				: (_frameCount.GetFrameCount() % 21 < 18) 	? Assets.boomerang_item_06
				: Assets.boomerang_item_07,
					super.getX(), super.getY());
	}

}
