package com.example.line_shooting.screen;

import java.util.List;

import com.example.line_shooting.Assets;
import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.framewark.Input.TouchEvent;

public class TimeOverScreen extends Screen {

	private int frameCount = 0;

	public TimeOverScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {

		frameCount++;
		if (frameCount == 2000000000)
			frameCount = 0;

		if (frameCount >= 180) {
			List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
			game.getInput().getKeyEvents();

			int len = touchEvents.size();

			for (int i = 0; i < len; i++) {
				TouchEvent event = touchEvents.get(i);
				if (event.type == TouchEvent.TOUCH_UP) {
					Assets.Lose.pause();
					Assets.Opening.seekToStart();
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.timeUp, 0, 0);
		Assets.Lose.play();

	}

	@Override
	public void pause() {
		Assets.Lose.pause();

	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void OnPause() {
		Assets.Lose.stop();
	}

}
