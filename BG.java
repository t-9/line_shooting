package com.example.line_shooting;

import com.example.line_shooting.framewark.Graphics;

public class BG {

	private int bgYPos = -1368;

	public void BGScroll() {
		if (bgYPos > -284)
			bgYPos -= 1085;
		// bgYPos = -1368;
	}

	public void BGDraw(Graphics g, ScrollSpeed _scrollSpeed) {
		g.drawPixmap(Assets.background, 0, bgYPos += _scrollSpeed.getScrollSpeed());
	}

}
