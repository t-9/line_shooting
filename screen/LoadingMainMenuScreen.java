package com.example.line_shooting.screen;

import com.example.line_shooting.Assets;
import com.example.line_shooting.Settings;
import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.framewark.Graphics.PixmapFormat;

public class LoadingMainMenuScreen extends Screen {

	public LoadingMainMenuScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {

		MainMenuScreenDispose();

		try {
			// 読み込み
			LoadingMainMenuScreenLoad();

		} catch (OutOfMemoryError e) {

			java.lang.System.gc();

			try {

				// 読み込み
				LoadingMainMenuScreenLoad();

			} catch (OutOfMemoryError e2) {
				System.err.println("insufficient memory was available to complete the operation.");
				System.exit(1);
			}

		}
		
		Settings.load(game.getFileIO());

		game.setScreen(new MainMenuScreen(game));
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

	private void LoadingMainMenuScreenLoad() {
		Graphics g = game.getGraphics();

		Assets.boomerang_item_01 = g.newPixmap("boomerang_item_01.png",
				PixmapFormat.RGB565);
		Assets.boomerang_item_02 = g.newPixmap("boomerang_item_02.png",
				PixmapFormat.RGB565);
		Assets.boomerang_item_03 = g.newPixmap("boomerang_item_03.png",
				PixmapFormat.RGB565);
		Assets.boomerang_item_04 = g.newPixmap("boomerang_item_04.png",
				PixmapFormat.RGB565);
		Assets.boomerang_item_05 = g.newPixmap("boomerang_item_05.png",
				PixmapFormat.RGB565);
		Assets.boomerang_item_06 = g.newPixmap("boomerang_item_06.png",
				PixmapFormat.RGB565);
		Assets.boomerang_item_07 = g.newPixmap("boomerang_item_07.png",
				PixmapFormat.RGB565);
		Assets.report_item_01 = g.newPixmap("report_item_01.png",
				PixmapFormat.RGB565);
		Assets.report_item_02 = g.newPixmap("report_item_02.png",
				PixmapFormat.RGB565);
		Assets.report_item_03 = g.newPixmap("report_item_03.png",
				PixmapFormat.RGB565);
		Assets.report_item_04 = g.newPixmap("report_item_04.png",
				PixmapFormat.RGB565);
		Assets.report_item_05 = g.newPixmap("report_item_05.png",
				PixmapFormat.RGB565);
		Assets.report_item_06 = g.newPixmap("report_item_06.png",
				PixmapFormat.RGB565);
		Assets.report_item_07 = g.newPixmap("report_item_07.png",
				PixmapFormat.RGB565);
		Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
		Assets.GameTitle = g.newPixmap("GameTitle.png", PixmapFormat.RGB565);
		Assets.MessageBar = g
				.newPixmap("MessageBar.png", PixmapFormat.RGB565);
		Assets.StatesBar = g.newPixmap("StatesBar.png", PixmapFormat.RGB565);
		Assets.boomerang = g
				.newPixmap("boomerang_2.png", PixmapFormat.RGB565);
		Assets.boomerang45 = g.newPixmap("boomerang45.png",
				PixmapFormat.RGB565);
		Assets.boomerang90 = g.newPixmap("boomerang_2_90.png",
				PixmapFormat.RGB565);
		Assets.boomerang135 = g.newPixmap("boomerang135.png",
				PixmapFormat.RGB565);
		Assets.boomerang180 = g.newPixmap("boomerang_2_180.png",
				PixmapFormat.RGB565);
		Assets.boomerang225 = g.newPixmap("boomerang225.png",
				PixmapFormat.RGB565);
		Assets.boomerang270 = g.newPixmap("boomerang_2_270.png",
				PixmapFormat.RGB565);
		Assets.boomerang315 = g.newPixmap("boomerang315.png",
				PixmapFormat.RGB565);
		Assets.jiki1 = g.newPixmap("jiki1.png", PixmapFormat.RGB565);
		Assets.jiki2 = g.newPixmap("jiki2.png", PixmapFormat.RGB565);
		Assets.pulldownBar = g.newPixmap("pulldownBar.png",
				PixmapFormat.RGB565);
		Assets.report = g.newPixmap("report.png", PixmapFormat.RGB565);
		Assets.barehand = g.newPixmap("barehand.png", PixmapFormat.RGB565);
		Assets.speedUpBoard = g.newPixmap("speedUpBoard.png", PixmapFormat.RGB565);
		Assets.speedDownBoard = g.newPixmap("speedDownBoard.png", PixmapFormat.RGB565);
		Assets.timer_0 = g.newPixmap("timer_0.png", PixmapFormat.RGB565);
		Assets.timer_1 = g.newPixmap("timer_1.png", PixmapFormat.RGB565);
		Assets.timer_2 = g.newPixmap("timer_2.png", PixmapFormat.RGB565);
		Assets.timer_3 = g.newPixmap("timer_3.png", PixmapFormat.RGB565);
		Assets.timer_4 = g.newPixmap("timer_4.png", PixmapFormat.RGB565);
		Assets.timer_5 = g.newPixmap("timer_5.png", PixmapFormat.RGB565);
		Assets.timer_6 = g.newPixmap("timer_6.png", PixmapFormat.RGB565);
		Assets.timer_7 = g.newPixmap("timer_7.png", PixmapFormat.RGB565);
		Assets.timer_8 = g.newPixmap("timer_8.png", PixmapFormat.RGB565);
		Assets.timer_9 = g.newPixmap("timer_9.png", PixmapFormat.RGB565);
		Assets.timer_colon = g.newPixmap("timer_colon.png", PixmapFormat.RGB565);
		Assets.conySquare = g.newPixmap("conySquare.png", PixmapFormat.RGB565);
		Assets.conyName = g.newPixmap("conyName.png", PixmapFormat.RGB565);
		Assets.balloon = g.newPixmap("balloon.png", PixmapFormat.RGB565);
		Assets.spin_face01 =g.newPixmap("spin_face01.png", PixmapFormat.RGB565);
		Assets.spin_face02 =g.newPixmap("spin_face02.png", PixmapFormat.RGB565);
		Assets.spin_face03 =g.newPixmap("spin_face03.png", PixmapFormat.RGB565);
		Assets.spin_face04 =g.newPixmap("spin_face04.png", PixmapFormat.RGB565);
		Assets.spin_face05 =g.newPixmap("spin_face05.png", PixmapFormat.RGB565);
		Assets.spin_face06 =g.newPixmap("spin_face06.png", PixmapFormat.RGB565);
		Assets.spin_face07 =g.newPixmap("spin_face07.png", PixmapFormat.RGB565);
		Assets.spin_face08 =g.newPixmap("spin_face08.png", PixmapFormat.RGB565);
		Assets.angrySign = g.newPixmap("angrySign.png", PixmapFormat.RGB565);
		Assets.soccerBall = g.newPixmap("soccerBall.png", PixmapFormat.RGB565);
		Assets.soccerBrownKick = g.newPixmap("soccerBrownKick.png", PixmapFormat.RGB565);
		Assets.carefulBalloon = g.newPixmap("carefulBalloon.png", PixmapFormat.RGB565);
		Assets.bikeBrownR = g.newPixmap("bikeOnTheBrownGoRight.png", PixmapFormat.RGB565);
		Assets.bikeBrownL = g.newPixmap("bikeOnTheBrownGoLeft.png", PixmapFormat.RGB565);
		Assets.goodbyeExclamation = g.newPixmap("goodbye!_!.png", PixmapFormat.RGB565);
		Assets.goodbyeB = g.newPixmap("goodbye!_b.png", PixmapFormat.RGB565);
		Assets.goodbyeD = g.newPixmap("goodbye!_d.png", PixmapFormat.RGB565);
		Assets.goodbyeE = g.newPixmap("goodbye!_e.png", PixmapFormat.RGB565);
		Assets.goodbyeG = g.newPixmap("goodbye!_g.png", PixmapFormat.RGB565);
		Assets.goodbyeO = g.newPixmap("goodbye!_o.png", PixmapFormat.RGB565);
		Assets.goodbyeY = g.newPixmap("goodbye!_y.png", PixmapFormat.RGB565);
		Assets.beerLeft = g.newPixmap("beer_left.png", PixmapFormat.RGB565);
		Assets.beerRight = g.newPixmap("beer_right.png", PixmapFormat.RGB565);
		Assets.cheers = g.newPixmap("cheers.png", PixmapFormat.RGB565);
		Assets.sideAttackCony = g.newPixmap("sideAttackCony.png", PixmapFormat.RGB565);
		Assets.car = g.newPixmap("car.png", PixmapFormat.RGB565);
		Assets.sally = g.newPixmap("sally.png", PixmapFormat.RGB565);
		Assets.brown = g.newPixmap("brown.png", PixmapFormat.RGB565);
		Assets.smallScratch = g.newPixmap("smallScratch.png", PixmapFormat.RGB565);
		Assets.middleScratch = g.newPixmap("middleScratch.png", PixmapFormat.RGB565);
		Assets.bigScratch = g.newPixmap("bigScratch.png", PixmapFormat.RGB565);

		Assets.timeUp = g.newPixmap("timeUp.png", PixmapFormat.RGB565);
		
		Assets.gameClear = g.newPixmap("clear.png", PixmapFormat.RGB565);
		
		Assets.option = g.newPixmap("option.png", PixmapFormat.RGB565);
		Assets.instruction = g.newPixmap("instruction.png", PixmapFormat.RGB565);
		Assets.optionHeader = g.newPixmap("optionHeader.png", PixmapFormat.RGB565);
		Assets.exit = g.newPixmap("exit.png", PixmapFormat.RGB565);
		Assets.staffroll = g.newPixmap("staffroll.png", PixmapFormat.RGB565);
		
		Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.RGB565);

		Assets.itemGet = game.getAudio().newSound("itemGet.wav");
		Assets.speedUp = game.getAudio().newSound("speedUp.mp3");
		Assets.speedDown = game.getAudio().newSound("speedDown.mp3");
		Assets.reportLaunch = game.getAudio().newSound("reportLaunch.mp3");
		Assets.windNoise = game.getAudio().newSound("windNoise.mp3");
		Assets.hurtIron = game.getAudio().newSound("hurtIron.mp3");
		Assets.hitNormal = game.getAudio().newSound("hitNormal.wav");

		Assets.Opening = game.getAudio().newMusic("Opening.mp3");
		Assets.Opening.setLooping(true);
		Assets.Opening.seekToStart();

		Assets.BGM1st = game.getAudio().newMusic("BGM1st.mp3");
		Assets.BGM1st.setLooping(true);

		Assets.Lose = game.getAudio().newMusic("Lose.mp3");
		Assets.Lose.setLooping(true);
		
		Assets.Boss = game.getAudio().newMusic("boss.mp3");
		Assets.Boss.setLooping(true);
		
		Assets.EndingTheme = game.getAudio().newMusic("endingTheme.mp3");
		Assets.EndingTheme.setLooping(true);
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
