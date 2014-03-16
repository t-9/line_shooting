package com.example.line_shooting;

import com.example.line_shooting.framewark.Graphics;

public class Barehand {

	private int barehandX = 550, barehandY = -40;

	public void setBarehandX(int barehandX) {
		this.barehandX = barehandX;
	}

	public int getBarehandX() {
		return barehandX;
	}

	public void setBarehandY(int barehandY) {
		this.barehandY = barehandY;
	}

	public int getBarehandY() {
		return barehandY;
	}

	public void barehandDown() {
		barehandX--;
		barehandY++;
	}

	public void barehandUp() {
		if (barehandX < 550) {
			barehandX++;
			barehandY--;
		} else {
			barehandX = 550;
			barehandY = -40;
		}
	}

	public void drawBarehand(Graphics g) {
		g.drawPixmap(Assets.barehand, getBarehandX(), getBarehandY());
	}

}
