package com.example.line_shooting;

import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.framewark.Graphics.PixmapFormat;
import com.example.line_shooting.screen.LoadingMainMenuScreen;
import com.example.line_shooting.screen.PrologueScreen;

public class LoadingScreen extends Screen {

	public LoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {

		try {
			// 読み込み
			LoadingScreenLoad();

		} catch (OutOfMemoryError e) {

			java.lang.System.gc();

			try {

				// 読み込み
				LoadingScreenLoad();

			} catch (OutOfMemoryError e2) {

				System.err
						.println("insufficient memory was available to complete the operation.");

				// 読み込めなかったらタイトル画面を飛ばす
				MainMenuScreenDispose();
				game.setScreen(new LoadingMainMenuScreen(game));
				return;

			}

		}

		game.setScreen(new PrologueScreen(game));
		return;
	}

	@Override
	public void present(float deltaTime) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void LoadingScreenLoad() {
		Graphics g = game.getGraphics();
		Assets.Prologue_01 = g.newPixmap("prologue_01.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_02 = g.newPixmap("prologue_02.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_03 = g.newPixmap("prologue_03.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_04 = g.newPixmap("prologue_04.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_05 = g.newPixmap("prologue_05.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_06 = g.newPixmap("prologue_06.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_07 = g.newPixmap("prologue_07.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_08 = g.newPixmap("prologue_08.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_09 = g.newPixmap("prologue_09.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_10 = g.newPixmap("prologue_10.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_11 = g.newPixmap("prologue_11.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_12 = g.newPixmap("prologue_12.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_13 = g.newPixmap("prologue_13.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_14 = g.newPixmap("prologue_14.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_15 = g.newPixmap("prologue_15.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_16 = g.newPixmap("prologue_16.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_17 = g.newPixmap("prologue_17.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_18 = g.newPixmap("prologue_18.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_19 = g.newPixmap("prologue_19.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_20 = g.newPixmap("prologue_20.jpg",
				PixmapFormat.RGB565);
		Assets.Prologue_21 = g.newPixmap("prologue_21.jpg",
				PixmapFormat.RGB565);
		Assets.skipButton = g
				.newPixmap("skipButton.png", PixmapFormat.RGB565);

		Assets.pushButton = game.getAudio().newSound("pushButton.wav");
		Assets.onstage = game.getAudio().newSound("Prologue_08_onstage.mp3");
		Assets.jahng = game.getAudio().newSound("Prologue_09_jahng.wav");
		Assets.jahjahng = game.getAudio().newSound("Prologue_10_jahjahng.wav");
		Assets.Vibraslap = game.getAudio()
				.newSound("Prologue_11_Vibraslap.mp3");
		Assets.twinkle = game.getAudio().newSound("Prologue_12_twinkle.mp3");
		Assets.CuckooClock = game.getAudio().newSound(
				"Prologue_13_CuckooClock.mp3");
		Assets.eat = game.getAudio().newSound("Prologue_14_eat.mp3");
		Assets.impact = game.getAudio().newSound("Prologue_18_impact.mp3");
		Assets.gogogogogo = game.getAudio().newSound(
				"Prologue_20_gogogogogo.mp3");
		Assets.shock = game.getAudio().newSound("Prologue_21_shock01.mp3");

		Assets.Prologue_BGM = game.getAudio().newMusic("Prologue_BGM.mp3");
		Assets.Prologue_BGM.setLooping(true);
		Assets.Prologue_BGM.setVolume(0.5f);
		Assets.Prologue_BGM.seekToStart();

		Settings.load(game.getFileIO());
	}

	private void MainMenuScreenDispose() {

		Assets.Prologue_01.dispose();
		Assets.Prologue_02.dispose();
		Assets.Prologue_03.dispose();
		Assets.Prologue_04.dispose();
		Assets.Prologue_05.dispose();
		Assets.Prologue_05.dispose();
		Assets.Prologue_06.dispose();
		Assets.Prologue_07.dispose();
		Assets.Prologue_08.dispose();
		Assets.Prologue_09.dispose();
		Assets.Prologue_10.dispose();
		Assets.Prologue_11.dispose();
		Assets.Prologue_12.dispose();
		Assets.Prologue_13.dispose();
		Assets.Prologue_14.dispose();
		Assets.Prologue_15.dispose();
		Assets.Prologue_16.dispose();
		Assets.Prologue_17.dispose();
		Assets.Prologue_18.dispose();
		Assets.Prologue_19.dispose();
		Assets.Prologue_20.dispose();
		Assets.Prologue_21.dispose();

		Assets.CuckooClock.dispose();
		Assets.eat.dispose();
		Assets.gogogogogo.dispose();
		Assets.impact.dispose();
		Assets.jahjahng.dispose();
		Assets.jahng.dispose();
		Assets.onstage.dispose();
		Assets.shock.dispose();
		Assets.twinkle.dispose();
		Assets.Vibraslap.dispose();
	}

}
