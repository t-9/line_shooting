package com.example.line_shooting.screen;

import android.view.KeyEvent;

import com.example.line_shooting.Assets;
import com.example.line_shooting.BG;
import com.example.line_shooting.Barehand;
import com.example.line_shooting.Collision;
import com.example.line_shooting.FrameCount;
import com.example.line_shooting.JikiMove;
import com.example.line_shooting.PointCount;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.Settings;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.TimerCount;
import com.example.line_shooting.WeaponFlag;
import com.example.line_shooting.formation.BeerFormation;
import com.example.line_shooting.formation.BikeFormation;
import com.example.line_shooting.formation.BrownFormation;
import com.example.line_shooting.formation.CarFormation;
import com.example.line_shooting.formation.GoodbyeFormation;
import com.example.line_shooting.formation.SallyFormation;
import com.example.line_shooting.formation.SideAttackConyFormation;
import com.example.line_shooting.formation.SoccerFormation;
import com.example.line_shooting.formation.SpinfaceFormation;
import com.example.line_shooting.framewark.Game;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.spriteother.BoomerangItem;
import com.example.line_shooting.spriteother.PulldownBar;
import com.example.line_shooting.spriteother.ReportItem;
import com.example.line_shooting.spriteother.SpeedDownBoard;
import com.example.line_shooting.spriteother.SpeedUpBoard;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class GameScreen extends Screen {

	// 背景インスタンスの生成
	BG _bg = new BG();

	// 武器フラグインスタンスの生成
	WeaponFlag _weaponFlag = new WeaponFlag();

	// FrameCountインスタンスの生成
	FrameCount _frameCount = new FrameCount();

	// PointCountインスタンスの生成
	PointCount _pointCount = new PointCount();

	// 衝突判定インスタンスの設定
	Collision _collision = new Collision();

	// 制限時間インスタンスの生成
	TimerCount _timerCount = new TimerCount();

	// Barehandインスタンスの生成
	Barehand _barehand = new Barehand();

	// スクロール速度インスタンスの生成
	ScrollSpeed _scrollSpeed = new ScrollSpeed();

	// プルダウンバーインスタンスの生成
	PulldownBar _pulldownBar = new PulldownBar();

	// ブーメランインスタンスの生成
	WeaponBoomerang _weaponBoomerang = new WeaponBoomerang();

	// 書類インスタンスの生成
	WeaponReport _weaponReport = new WeaponReport();

	// 自機インスタンスの生成
	SpriteJiki _sp_jiki = new SpriteJiki(200, 600, Assets.jiki1.getWidth(),
			Assets.jiki2.getHeight(), 1, 3, 56, 71, 19, 7, 20, 40);

	// 自機移動インスタンスの生成
	JikiMove _jikiMove = new JikiMove();

	// ブーメランアイテムインスタンスの生成
	BoomerangItem _boomerangItem = new BoomerangItem();

	// 書類アイテムインスタンスの生成
	ReportItem _reportItem = new ReportItem();

	// 速度上昇板インスタンスの生成
	SpeedUpBoard _speedUpBoard = new SpeedUpBoard();

	// 速度下降板インスタンスの生成
	SpeedDownBoard _speedDownBoard = new SpeedDownBoard();

	// 空中物インスタンスと敵インスタンスの設定
	SpinfaceFormation _spinfaceFormation = new SpinfaceFormation();
	SoccerFormation _soccerFormation = new SoccerFormation();
	BikeFormation _bikeFormation = new BikeFormation();
	GoodbyeFormation _goodbyeFormation = new GoodbyeFormation();
	BeerFormation _beerFormation = new BeerFormation();
	SideAttackConyFormation _sideAttackConyFormation = new SideAttackConyFormation();
	CarFormation _carFormation = new CarFormation();
	SallyFormation _sallyFormation = new SallyFormation();
	BrownFormation _brownFormation = new BrownFormation();

	public GameScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {

		_frameCount.FrameCountIncrement();

		_pointCount.setPointCount(_scrollSpeed);

		_timerCount.setTimeLimitSubtract(1);

		// 背景の繰り返し表示
		_bg.BGScroll();

		if (_weaponFlag.WeaponIsReport())
			_weaponReport.ReportMove(_sp_jiki);
		else if (_weaponFlag.WeaponIsBoomerang()){
			_weaponBoomerang.BoomerangMove(_sp_jiki);
			_weaponBoomerang.setProvisionalTarget(240, 100);
		}
			//_weaponBoomerang.BoomerangMove(_sp_spin_face_1, _sp_jiki);

		// アイテムを動かす
		_boomerangItem.BoomerangItemMove(_scrollSpeed);

		_reportItem.ReportItemMove(_scrollSpeed);

		_speedUpBoard.setSpeedUpBoard(_pointCount, _scrollSpeed);

		_speedDownBoard.setSpeedDownBoard(_pointCount, _scrollSpeed);

		_jikiMove.TouchProcessing(game, _sp_jiki);

		if (_weaponFlag.WeaponIsNotReport()) {
			// 書類アイテムを取ったら
			_reportItem.GetReportItem(_collision, _sp_jiki, _weaponFlag, _weaponReport);
		} else if (_weaponFlag.WeaponIsNotBoomearng()) {
			// ブーメランアイテムを取ったら
			_boomerangItem.GetBoomerangItem(_collision, _sp_jiki, _weaponBoomerang, _weaponFlag);
		}

		// 敵
		if (_pointCount.getPointCount() >= 600 && !_spinfaceFormation.getDrawEnd())
			_spinfaceFormation.spinfaceFormationMove(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_spinfaceFormation.getDrawEnd() && !_soccerFormation.getDrawEnd())
			_soccerFormation.soccerFormationMove(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_soccerFormation.getDrawEnd() && !_bikeFormation.getDrawEnd())
			_bikeFormation.bikeFormationMove(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_bikeFormation.getDrawEnd() && !_goodbyeFormation.getDrawEnd())
			_goodbyeFormation.move(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_goodbyeFormation.getDrawEnd() && !_beerFormation.getDrawEnd())
			_beerFormation.move(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_beerFormation.getDrawEnd() && !_sideAttackConyFormation.getDrawEnd())
			_sideAttackConyFormation.move(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_sideAttackConyFormation.getDrawEnd() && !_carFormation.getDrawEnd())
			_carFormation.move(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_carFormation.getDrawEnd() && !_sallyFormation.getDrawEnd())
			_sallyFormation.move(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_sallyFormation.getDrawEnd() && !_brownFormation.getDrawEnd())
			_brownFormation.move(_timerCount, _pointCount, _scrollSpeed, _weaponFlag, _collision, _weaponBoomerang, _weaponReport, _sp_jiki);
		if (_brownFormation.getDrawEnd()){
			GameClear();
		}


		// 自機とプルダウンバーが衝突したら
		_pulldownBar.CollisionCheck(_timerCount, _weaponReport, _sp_jiki);

		// 自機がプルダウンバーの射程内なら
		_pulldownBar.JikiInPulldownBarRange(_sp_jiki, _barehand);


		// 速度上昇板に乗ったら
		_speedUpBoard.jikiOnSpeedUpBoard(_collision, _sp_jiki, _scrollSpeed);

		// 速度下降板に乗ったら
		_speedDownBoard.jikiOnSpeedDownBoard(_collision, _sp_jiki, _scrollSpeed);

		if (_timerCount.getTimeLimit() == 0)
			TimeOver();

	}

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();

		// 背景の描画
		_bg.BGDraw(g, _scrollSpeed);

		// 速度上昇板，下降板の描画
		_speedUpBoard.drawSpeedUpBoard(g);
		_speedDownBoard.drawSpeedDownBoard(g);

		// アイテムの描画
		if (_weaponFlag.WeaponIsNotReport())
			_reportItem.ReportItemDraw(g, _frameCount);
		else if (_weaponFlag.WeaponIsNotBoomearng())
			_boomerangItem.BoomerangItemDraw(g, _frameCount);

		// 武器の描画
		if (_weaponFlag.WeaponIsReport())
			_weaponReport.ReportDraw(g);
		else if (_weaponFlag.WeaponIsBoomerang())
			_weaponBoomerang.BoomerangDraw(g, _frameCount);

		// 自機の描画
		if (_scrollSpeed.getScrollSpeed() <= 20)
			g.drawPixmap((_pointCount.getPointCount() % 40 <= 20) 	? Assets.jiki1
																	: Assets.jiki2,
																	_sp_jiki.getX(), _sp_jiki.getY());
		else
			g.drawPixmap((_frameCount.GetFrameCount() % 2 == 0) 	? Assets.jiki1
																	: Assets.jiki2,
																	_sp_jiki.getX(), _sp_jiki.getY());

		// 空中物と敵の描画
		if (_pointCount.getPointCount() >= 600 && !_spinfaceFormation.getDrawEnd())
			_spinfaceFormation.spinfaceFormationDraw(g, _frameCount);
		if (_spinfaceFormation.getDrawEnd() && !_soccerFormation.getDrawEnd())
			_soccerFormation.draw(g);
		if (_soccerFormation.getDrawEnd() && !_bikeFormation.getDrawEnd())
			_bikeFormation.bikeFormationDraw(g);
		if (_bikeFormation.getDrawEnd() && !_goodbyeFormation.getDrawEnd())
			_goodbyeFormation.draw(g);
		if (_goodbyeFormation.getDrawEnd() && !_beerFormation.getDrawEnd())
			_beerFormation.draw(g);
		if (_beerFormation.getDrawEnd() && !_sideAttackConyFormation.getDrawEnd())
			_sideAttackConyFormation.draw(g);
		if (_sideAttackConyFormation.getDrawEnd() && !_carFormation.getDrawEnd())
			_carFormation.draw(g);
		if (_carFormation.getDrawEnd() && !_sallyFormation.getDrawEnd())
			_sallyFormation.draw(g);
		if (_sallyFormation.getDrawEnd() && !_brownFormation.getDrawEnd()){
			Assets.BGM1st.pause();
			_brownFormation.draw(g);
			Assets.Boss.play();
		}

		_pulldownBar.DrawPulldownBar(g);

		g.drawPixmap(Assets.StatesBar, 0, 0);

		// 制限時間の表示
		_timerCount.DisplayTimer(g);

		g.drawPixmap(Assets.MessageBar, 0, 718);

		_barehand.drawBarehand(g);

		if (!_sallyFormation.getDrawEnd())
			Assets.BGM1st.play();
	}

	@Override
	public void pause() {
		Assets.BGM1st.pause();
		Assets.Boss.pause();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		//Assets.BGM1st.dispose();
	}

	public void OnPause() {
		Assets.BGM1st.stop();
		Assets.Boss.stop();
		//Assets.BGM1st.dispose();
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			Assets.Lose.pause();
			Assets.Opening.seekToStart();
			game.setScreen(new MainMenuScreen(game));
		}
		return false;
	}

	private void TimeOver() {
		Assets.BGM1st.pause();
		Assets.Boss.pause();
		Assets.Lose.seekToStart();
		game.setScreen(new TimeOverScreen(game));
		return;

	}
	
	private void GameClear() {
		Assets.BGM1st.pause();
		Assets.Boss.pause();
		Assets.EndingTheme.seekToStart();
		Settings.addScore(_timerCount.getTimeLimit());
		Settings.save(game.getFileIO());
		game.setScreen(new ClearScreen(game));
		return;
	}

}
