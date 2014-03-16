package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.Collision;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class SpeedUpBoard extends SpriteOther{

	public SpeedUpBoard() {
		super(200, 1000,
				Assets.speedUpBoard.getWidth(), Assets.speedUpBoard.getHeight(), 0, 0,
				Assets.speedUpBoard.getWidth(), Assets.speedUpBoard.getHeight());
	}

	public void setSpeedUpBoard(PointCount _pointCount, ScrollSpeed _scrollSpeed) {
		super.setY(
				(_pointCount.getPointCount() % 600 < _scrollSpeed.getScrollSpeed()
						&& super.getY() > 799)
							? -(super.getH())
							: super.getY() + _scrollSpeed.getScrollSpeed());
	}

	// 仮処理
	public void jikiOnSpeedUpBoard(Collision _collision, SpriteJiki _sp_jiki, ScrollSpeed _scrollSpeed) {
		if (_collision.CollisionCheck_Jiki_Other(_sp_jiki, this)) {
			Assets.speedUp.play(1);
			super.setY(800);
			_scrollSpeed.setScrollSpeedDouble();
		}
	}

	public void drawSpeedUpBoard(Graphics g) {
		g.drawPixmap(Assets.speedUpBoard, super.getX(), super.getY());
	}

}
