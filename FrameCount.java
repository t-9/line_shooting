package com.example.line_shooting;

public class FrameCount {

	private int frameCount = 0;

	public void FrameCountIncrement(){
		frameCount++;
		if (frameCount == 2000000000)
			frameCount = 0;
	}

	public int GetFrameCount(){
		return frameCount;
	}

}
