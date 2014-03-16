package com.example.line_shooting;

import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Pixmap;
import com.example.line_shooting.spriteother.WeaponBoomerang;
import com.example.line_shooting.spriteother.WeaponReport;

public class SpriteEnemy {

	private int x;
	private int y;
	private int w;
	private int h;
	private int bigHitX;
	private int bigHitY;
	private int bigHitW;
	private int bigHitH;
	private int smallHitX;
	private int smallHitY;
	private int smallHitW;
	private int smallHitH;
	private int hp;
	private int addtime;
	private boolean screenIn = false;
	private int centerX;
	private int centerY;

	EnemyProcessing _enemyProcessing = new EnemyProcessing();

	public SpriteEnemy(int positionX, int positionY, int width, int height,
			int bigHitXposition, int bigHitYposition, int bigHitWidth,
			int bigHitHeight, int smallHitXposition, int smallHitYposition,
			int smallHitWidth, int smallHitHeight, int hitPoint, int addtime) {
		this.x = positionX;
		this.y = positionY;
		this.w = width;
		this.h = height;
		this.bigHitX = bigHitXposition;
		this.bigHitY = bigHitYposition;
		this.bigHitW = bigHitWidth;
		this.bigHitH = bigHitHeight;
		this.smallHitX = smallHitXposition;
		this.smallHitY = smallHitYposition;
		this.smallHitW = smallHitWidth;
		this.smallHitH = smallHitHeight;
		this.hp = hitPoint;
		this.addtime = addtime;
		this.centerX = this.w / 2;
		this.centerY = this.h / 2;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getBigHitX() {
		return x + bigHitX;
	}

	public void setBigHitX(int bigHitX) {
		this.bigHitX = bigHitX;
	}

	public int getBigHitY() {
		return y + bigHitY;
	}

	public void setBigHitY(int bigHitY) {
		this.bigHitY = bigHitY;
	}

	public int getBigHitW() {
		return bigHitW;
	}

	public void setBigHitW(int bigHitW) {
		this.bigHitW = bigHitW;
	}

	public int getBigHitH() {
		return bigHitH;
	}

	public void setBigHitH(int bigHitH) {
		this.bigHitH = bigHitH;
	}

	public int getSmallHitX() {
		return x + smallHitX;
	}

	public void setSmallHitX(int smallHitX) {
		this.smallHitX = smallHitX;
	}

	public int getSmallHitY() {
		return y + smallHitY;
	}

	public void setSmallHitY(int smallHitY) {
		this.smallHitY = smallHitY;
	}

	public int getSmallHitW() {
		return smallHitW;
	}

	public void setSmallHitW(int smallHitW) {
		this.smallHitW = smallHitW;
	}

	public int getSmallHitH() {
		return smallHitH;
	}

	public void setSmallHitH(int smallHitH) {
		this.smallHitH = smallHitH;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hitPoint) {
		this.hp = hitPoint;
	}

	public void setHPSubtract(TimerCount _timerCount) {
		hp--;
		if(hp <= 0){
			_timerCount.setTimeLimitAdd(addtime);
			screenIn = false;
		}
	}

	public int getAddTime(){
		return addtime;
	}

	public void setAddTime(int addtime){
		this.addtime = addtime;
	}

	public boolean getScreenIn(){
		return screenIn;
	}

	public void setScreenIn(boolean screenIn){
		this.screenIn = screenIn;
	}

	public void check(TimerCount _timerCount, WeaponFlag _weaponFlag, Collision _collision, WeaponReport _weaponReport, WeaponBoomerang _weaponBoomerang, SpriteJiki _sp_jiki) {
		_enemyProcessing.EnemyCheck(_timerCount, _weaponFlag, _collision, _weaponReport, _weaponBoomerang, _sp_jiki, this);
		_weaponBoomerang.setProvisionalTarget(this);
	}

	protected void guide(ScrollSpeed _scrollSpeed, int enemySpeed, int targetX, int targetY) {
		int spinfacespeed = enemySpeed + _scrollSpeed.getScrollSpeed();
		double vectorX = targetX - this.x;
		double vectorY = targetY - this.y;
		double vectorSize = Math.sqrt(vectorX * vectorX + vectorY * vectorY);
		if (vectorSize != 0){
			vectorX /= vectorSize;
			vectorY /= vectorSize;
			vectorX *= spinfacespeed;
			vectorY *= spinfacespeed;
			this.x += (int) vectorX;
			this.y += (int) vectorY;
		}
	}
	
	public int getCenterX() {
		return x + centerX;
	}
	
	public int getCenterY() {
		return y + centerY;
	}
	
	protected void goLeft(ScrollSpeed _scrollSpeed, byte speed) {
		x -= _scrollSpeed.getScrollSpeed() + speed;
	}
	
	protected void up(ScrollSpeed _scrollSpeed, byte speed) {
		y -= _scrollSpeed.getScrollSpeed() + speed;
	}
	
	protected void down(ScrollSpeed _scrollSpeed, byte speed) {
		y += _scrollSpeed.getScrollSpeed() + speed;
	}
	
	public void scroll(ScrollSpeed _scrollSpeed) {
		y += _scrollSpeed.getScrollSpeed();
	}
	
	protected void draw(Graphics g, Pixmap pixmap){
		if (this.getHP() > 0)
			g.drawPixmap(pixmap, this.getX(), this.getY());
	}

}
