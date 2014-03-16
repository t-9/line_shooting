package com.example.line_shooting.screen;

import java.util.List;

import com.example.line_shooting.Assets;
import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.framewark.Input.TouchEvent;

public class PrologueScreen extends Screen {

	private byte screenflg = 0, oldScreenflg = 127;

	public PrologueScreen(Game game) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void update(float deltaTime) {
		// Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();

		int len = touchEvents.size();

		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 439, 739, 36, 60)) {
					Assets.Prologue_BGM.stop();
					game.setScreen(new LoadingMainMenuScreen(game));
					Assets.pushButton.play(0.5f);
					return;
				} else {
					screenflg++;

					if (screenflg > 20) {
						Assets.Prologue_BGM.stop();
						game.setScreen(new LoadingMainMenuScreen(game));
						return;
					}
				}
			}
		}

	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();

		if (screenflg != oldScreenflg) {

			switch (screenflg) {
			case 0:
				g.drawPixmap(Assets.Prologue_01, 0, 0);
				break;
			case 1:
				g.drawPixmap(Assets.Prologue_02, 0, 0);
				break;
			case 2:
				g.drawPixmap(Assets.Prologue_03, 0, 0);
				break;
			case 3:
				g.drawPixmap(Assets.Prologue_04, 0, 0);
				break;
			case 4:
				g.drawPixmap(Assets.Prologue_05, 0, 0);
				break;
			case 5:
				g.drawPixmap(Assets.Prologue_06, 0, 0);
				break;
			case 6:
				g.drawPixmap(Assets.Prologue_07, 0, 0);
				break;
			case 7:
				g.drawPixmap(Assets.Prologue_08, 0, 0);
				Assets.onstage.play(1);
				break;
			case 8:
				g.drawPixmap(Assets.Prologue_09, 0, 0);
				Assets.jahng.play(1);
				break;
			case 9:
				g.drawPixmap(Assets.Prologue_10, 0, 0);
				Assets.jahjahng.play(1);
				break;
			case 10:
				g.drawPixmap(Assets.Prologue_11, 0, 0);
				Assets.Vibraslap.play(1);
				break;
			case 11:
				g.drawPixmap(Assets.Prologue_12, 0, 0);
				Assets.twinkle.play(1);
				break;
			case 12:
				g.drawPixmap(Assets.Prologue_13, 0, 0);
				Assets.CuckooClock.play(1);
				break;
			case 13:
				g.drawPixmap(Assets.Prologue_14, 0, 0);
				break;
			case 14:
				g.drawPixmap(Assets.Prologue_15, 0, 0);
				break;
			case 15:
				g.drawPixmap(Assets.Prologue_16, 0, 0);
				break;
			case 16:
				g.drawPixmap(Assets.Prologue_17, 0, 0);
				break;
			case 17:
				g.drawPixmap(Assets.Prologue_18, 0, 0);
				Assets.impact.play(1);
				break;
			case 18:
				g.drawPixmap(Assets.Prologue_19, 0, 0);
				break;
			case 19:
				g.drawPixmap(Assets.Prologue_20, 0, 0);
				Assets.gogogogogo.play(1);
				break;
			case 20:
				g.drawPixmap(Assets.Prologue_21, 0, 0);
				Assets.shock.play(1);
				break;
			}
			g.drawPixmap(Assets.skipButton, 439, 739);
		}

		oldScreenflg = screenflg;
		Assets.Prologue_BGM.play();

	}

	@Override
	public void pause() {
		Assets.Prologue_BGM.pause();

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		//Assets.Prologue_BGM.dispose();

	}

	public void OnPause() {
		Assets.Prologue_BGM.stop();
		//Assets.Prologue_BGM.dispose();
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
