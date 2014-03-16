package com.example.line_shooting;

public class PointCount {

	private int pointCount = 0;

	public void setPointCount(ScrollSpeed _scrollSpeed) {
		pointCount += _scrollSpeed.getScrollSpeed();
		if (pointCount > 2000000000)
			pointCount = pointCount - 2000000000;
	}

	public int getPointCount() {
		return pointCount;
	}

}
