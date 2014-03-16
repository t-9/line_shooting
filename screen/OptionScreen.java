package com.example.line_shooting.screen;

import java.util.List;

import com.example.line_shooting.Assets;
import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.framewark.Input.TouchEvent;

public class OptionScreen extends Screen {

	private int frameCount = 0, touchBufferY = 0, oldTouchBufferY = 0,
			shiftY = 0, staffRollPos = 128;
	private boolean topArea = true, instructionArea = false, staffArea = false;

	public OptionScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {

		frameCount++;
		if (frameCount == 2000000000)
			frameCount = 0;

		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		int len = touchEvents.size();

		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				// タッチした瞬間の座標を取得する
				touchBufferY = game.getInput().getTouchY(0);
			}
			if (event.type == TouchEvent.TOUCH_UP) {
				if (topArea && inBounds(event, 50, 162, 352, 162)) {
					Assets.pushButton.play(0.5f);
					topArea = false;
					instructionArea = true;
				} else if (topArea && inBounds(event, 61, 363, 341, 146)){
					Assets.pushButton.play(0.5f);
					topArea = false;
					staffArea = true;
				} else if (inBounds(event, 234, 598, 239, 192)) {
					if(topArea) {
						Assets.pushButton.play(0.5f);
						game.setScreen(new MainMenuScreen(game));
						return;
					} else if (instructionArea) {
						Assets.pushButton.play(0.5f);
						instructionArea = false;
						topArea = true;
					} else if (staffArea) {
						Assets.pushButton.play(0.5f);
						staffArea = false;
						topArea = true;
					}
				}
			}
			if (event.type == TouchEvent.TOUCH_DRAGGED) {
				// ドラッグ前の座標を格納する
				oldTouchBufferY = touchBufferY;

				// ドラッグ後の座標を取得する
				touchBufferY = game.getInput().getTouchY(0);

				// 差分を求める
				shiftY = touchBufferY - oldTouchBufferY;

				// 移動後座標を求める
				staffRollPos += shiftY;

				// 範囲外に移動できない
				if (staffRollPos < -2272)
					staffRollPos = -2272;
				else if (staffRollPos > 128)
					staffRollPos = 128;
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		if (topArea)
			g.drawPixmap(Assets.option, 0, 0);
		else if (instructionArea)
			g.drawPixmap(Assets.instruction, 0, 0);
		else if (staffArea) {
			g.drawPixmap(Assets.optionHeader, 0, 0);
			g.drawPixmap(Assets.staffroll, 0, staffRollPos);
			g.drawPixmap(Assets.exit, 234, 598);
		}
		Assets.Opening.play();

	}

	@Override
	public void pause() {
		Assets.Opening.pause();

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	public void OnPause() {
		Assets.Opening.stop();
	}
	
	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

}
