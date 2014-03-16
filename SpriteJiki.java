package com.example.line_shooting;

public class SpriteJiki {

	private int x, y, w, h, bigHitX, bigHitY, bigHitW, bigHitH, smallHitX, smallHitY, smallHitW, smallHitH, 
	centerX, centerY;

	public SpriteJiki(int positionX, int positionY, int width, int height,
			int bigHitXposition, int bigHitYposition, int bigHitWidth,
			int bigHitHeight, int smallHitXposition, int smallHitYposition,
			int smallHitWidth, int smallHitHeight) {
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
	
	public int getCenterX() {
		return x + centerX;
	}
	
	public int getCenterY() {
		return y + centerY;
	}

}
