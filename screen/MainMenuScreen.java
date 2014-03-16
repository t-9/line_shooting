package com.example.line_shooting.screen;

import java.util.List;

import com.example.line_shooting.Assets;
import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Input.TouchEvent;
import com.example.line_shooting.framewark.Screen;

public class MainMenuScreen extends Screen {
	public MainMenuScreen(Game game) {
		super(game);
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
				if (inBounds(event, 74, 538, 210, 84)) {
					Assets.pushButton.play(0.5f);
					Assets.Opening.pause();
					Assets.BGM1st.seekToStart();
					Assets.Boss.seekToStart();
					game.setScreen(new GameScreen(game));
					return;
				} else if (inBounds(event, 32, 638, 208, 87)) {
					Assets.pushButton.play(0.5f);
					game.setScreen(new OptionScreen(game));
					return;
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();

		g.drawPixmap(Assets.GameTitle, 0, 0);
		Assets.Opening.play();
	}

	@Override
	public void pause() {
		Assets.Opening.pause();

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
