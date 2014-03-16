package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.Collision;
import com.example.line_shooting.FrameCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.framewark.Graphics;

public class ReportItem extends SpriteOther{

	static private int initXPos = 100, initYPos = 200;

	public ReportItem() {
		super(initXPos, initYPos,
				Assets.report_item_01.getWidth(),
				Assets.report_item_01.getHeight(), 0, 0,
				Assets.report_item_01.getWidth(), Assets.report_item_01.getHeight());
	}

	public void ReportItemMove(ScrollSpeed _scrollSpeed) {
		super.setY(
				(super.getY() < 1000) 	? super.getY() + _scrollSpeed.getScrollSpeed()
													: - 1000);
	}

	public void GetReportItem(Collision _collision, SpriteJiki _sp_jiki, WeaponFlag _weaponFlag, WeaponReport _weaponReport) {
		if (_collision.CollisionCheck_Jiki_Other(_sp_jiki, this)) {
			_weaponFlag.setWeaponReport();
			_weaponReport.ReportPosInit(_sp_jiki);
			Assets.itemGet.play(0.5f);
		}
	}

	public void ReportItemDraw(Graphics g, FrameCount _frameCount) {
		g.drawPixmap((_frameCount.GetFrameCount() % 21 < 3) 	? Assets.report_item_01
				: (_frameCount.GetFrameCount() % 21 < 6) 	? Assets.report_item_02
				: (_frameCount.GetFrameCount() % 21 < 9) 	? Assets.report_item_03
				: (_frameCount.GetFrameCount() % 21 < 12) 	? Assets.report_item_04
				: (_frameCount.GetFrameCount() % 21 < 15) 	? Assets.report_item_05
				: (_frameCount.GetFrameCount() % 21 < 18) 	? Assets.report_item_06
				: Assets.report_item_07,
					super.getX(), super.getY());
	}

}
