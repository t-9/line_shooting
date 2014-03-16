package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.Collision;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class SpeedDownBoard extends SpriteOther{

	public SpeedDownBoard() {
		super(200, 1000,
				Assets.speedDownBoard.getWidth(), Assets.speedDownBoard.getHeight(), 0, 0,
				Assets.speedDownBoard.getWidth(), Assets.speedDownBoard.getHeight());
	}

	// 仮処理
	public void setSpeedDownBoard(PointCount _pointCount, ScrollSpeed _scrollSpeed) {
		super.setY(
				((_pointCount.getPointCount() + 300) % 600 < _scrollSpeed.getScrollSpeed()
						&& super.getY() > 799)
							? -(super.getH())
							: super.getY() + _scrollSpeed.getScrollSpeed());
	}

	public void jikiOnSpeedDownBoard(Collision _collision, SpriteJiki _sp_jiki, ScrollSpeed _scrollSpeed) {
		if (_collision.CollisionCheck_Jiki_Other(_sp_jiki, this)) {
			Assets.speedDown.play(1);
			super.setY(800);
			_scrollSpeed.setScrollSpeedHalf();
		}
	}

	public void drawSpeedDownBoard(Graphics g) {
		g.drawPixmap(Assets.speedDownBoard, super.getX(), super.getY());
	}

}
