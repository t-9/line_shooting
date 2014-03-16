package com.example.line_shooting;

public class SpriteOther{
	private int x;
	private int y;
	private int w;
	private int h;
	private int hitX;
	private int hitY;
	private int hitW;
	private int hitH;

	protected SpriteOther(int positionX, int positionY, int width, int height,
			int hitXposition, int hitYposition, int hitWidth, int hitHeight) {
		this.x = positionX;
		this.y = positionY;
		this.w = width;
		this.h = height;
		this.hitX = hitXposition;
		this.hitY = hitYposition;
		this.hitW = hitWidth;
		this.hitH = hitHeight;
	}

	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public void setY(int y){
		this.y = y;
	}

	protected int getW(){
		return w;
	}

	protected void setW(int w){
		this.w = w;
	}

	protected int getH(){
		return h;
	}

	protected void setH(int h){
		this.h = h;
	}

	protected int getHitX(){
		return x + hitX;
	}

	protected void setHitX(int hitX){
		this.hitX = hitX;
	}

	protected int getHitY(){
		return y + hitY;
	}

	protected void setHitY(int hitY){
		this.hitY = hitY;
	}

	protected int getHitW(){
		return hitW;
	}

	protected void setHitW(int hitW){
		this.hitW = hitW;
	}

	protected int getHitH(){
		return hitH;
	}

	protected void setHitH(int hitH){
		this.hitH = hitH;
	}
	
	protected void guide(ScrollSpeed _scrollSpeed, int spriteSpeed, int targetX, int targetY) {
		int spinfacespeed = spriteSpeed + _scrollSpeed.getScrollSpeed();
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
	
	/*protected void down(ScrollSpeed _scrollSpeed, byte speed) {
		y += _scrollSpeed.getScrollSpeed() + speed;
	}*/
	
	protected void moveRight(ScrollSpeed _scrollSpeed, byte speed) {
		x += _scrollSpeed.getScrollSpeed() + speed;
	}
	
	protected void moveLeft(ScrollSpeed _scrollSpeed, byte speed) {
		x -= _scrollSpeed.getScrollSpeed() + speed;
	}
	
	public void scroll(ScrollSpeed _scrollSpeed) {
		y += _scrollSpeed.getScrollSpeed();
	}

}
