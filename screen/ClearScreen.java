package com.example.line_shooting.screen;

import java.util.List;

import com.example.line_shooting.Assets;
import com.example.line_shooting.Settings;
import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.framewark.Input.TouchEvent;

public class ClearScreen extends Screen {

	private int frameCount = 0;
	private byte progressStateFlag = 0;
	String highScoreLines[] = new String[5];

	public ClearScreen(Game game) {
		super(game);
		
		for (int i = 0; i < 5; i++) 
			highScoreLines[i] = "" + (i + 1) + ". " + Settings.highscores[i];
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
					if (progressStateFlag == 0) {
						progressStateFlag = 1;
					} else if (progressStateFlag == 1){
						Assets.EndingTheme.pause();
						Assets.Opening.seekToStart();
						game.setScreen(new MainMenuScreen(game));
						return;
					}
				}
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.gameClear, 0, 0);
		Assets.EndingTheme.play();
		if (progressStateFlag == 1) {
			int y = 100;
			for (int i = 0; i < 5; i++)
				drawText(g, highScoreLines[i], 20, y += 50);
		}
	}

	@Override
	public void pause() {
		Assets.EndingTheme.pause();

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
		Assets.EndingTheme.stop();
	}
	
	private void drawText(Graphics g, String line, int x, int y) {
		int len = line.length();
		for (int i = 0; i < len; i++) {
			char character = line.charAt(i);
			
			if (character == ' ') {
				x += 12;
				continue;
			}
			
			int srcX = 0;
			int srcWidth = 0;
			if (character == '.') {
				srcX = 120;
				srcWidth = 12;
			} else {
				srcX = (character - '0') * 12;
				srcWidth = 12;
			}
			
			g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 16);
			x += srcWidth;
		}
	}

}
