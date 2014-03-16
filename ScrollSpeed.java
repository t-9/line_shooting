package com.example.line_shooting;

public class ScrollSpeed {

	private int scrollSpeed = 3;

	public int getScrollSpeed(){
		return scrollSpeed;
	}

	public void setScrollSpeedDouble(){
		scrollSpeed = (scrollSpeed * 2 > 512)	? 512
												: scrollSpeed + 1;
	}

	public void setScrollSpeedHalf(){
		scrollSpeed = (scrollSpeed - 1 <= 0) 	? 1
												: scrollSpeed - 1;
	}

}
