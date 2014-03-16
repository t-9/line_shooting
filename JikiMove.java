package com.example.line_shooting;

import java.util.List;

import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Input.TouchEvent;

public class JikiMove {

	private int touchBufferX = 0, touchBufferY = 0, oldTouchBufferX, oldTouchBufferY,
	shiftX, shiftY;
	
	private void setTouchBuffer(Game game) {
		touchBufferX = game.getInput().getTouchX(0);
		touchBufferY = game.getInput().getTouchY(0);
	}

	public void TouchProcessing(Game game, SpriteJiki _sp_jiki){
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		int len = touchEvents.size();

		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);

			if (event.type == TouchEvent.TOUCH_DOWN) {
				// タッチした瞬間の座標を取得する
				setTouchBuffer(game);
			}
			if (event.type == TouchEvent.TOUCH_DRAGGED) {
				// ドラッグ前の座標を格納する
				oldTouchBufferX = touchBufferX;
				oldTouchBufferY = touchBufferY;

				// ドラッグ後の座標を取得する
				setTouchBuffer(game);

				// 差分を求める
				shiftX = touchBufferX - oldTouchBufferX;
				shiftY = touchBufferY - oldTouchBufferY;

				// 自機の移動後座標を求める
				_sp_jiki.setX(_sp_jiki.getX() + shiftX);
				_sp_jiki.setY(_sp_jiki.getY() + shiftY);

				// 自機は範囲外に移動できない
				if (_sp_jiki.getX() < 0)
					_sp_jiki.setX(0);
				else if (_sp_jiki.getX() >= 480 - 60)
					_sp_jiki.setX(479 - 60);

				if (_sp_jiki.getY() < 102)
					_sp_jiki.setY(102);
				else if (_sp_jiki.getY() >= 800 - 82 - 70)
					_sp_jiki.setY(799 - 82 - 70);

			}
		}
	}

}
