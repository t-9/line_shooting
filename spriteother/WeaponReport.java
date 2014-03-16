package com.example.line_shooting.spriteother;

import com.example.line_shooting.Assets;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.SpriteOther;
import com.example.line_shooting.framewark.Graphics;

public class WeaponReport extends SpriteOther{

	static private int reportSpeed = 40, initXPos = 200, initYPos = 600;

	public WeaponReport() {
		super(initXPos, initYPos,
				Assets.report.getWidth(), Assets.report.getHeight(), 0, 0,
				Assets.report.getWidth(), Assets.report.getHeight());
	}

	public void ReportPosInit(SpriteJiki _sp_jiki){
		super.setX(_sp_jiki.getX());
		super.setY(_sp_jiki.getY());
		Assets.reportLaunch.play(1);
	}

	public void ReportMove(SpriteJiki _sp_jiki) {
		if (super.getY() > 0)
			super.setY(super.getY() - reportSpeed);
		else
			ReportPosInit(_sp_jiki);
	}

	public void ReportDraw(Graphics g) {
		g.drawPixmap(Assets.report, super.getX(), super.getY());
	}
	
	public int getY() {
		return super.getY();
	}

}
