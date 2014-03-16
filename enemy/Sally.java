package com.example.line_shooting.enemy;

import com.example.line_shooting.Assets;
import com.example.line_shooting.ScrollSpeed;
import com.example.line_shooting.SpriteEnemy;
import com.example.line_shooting.SpriteJiki;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.rotateTable.SallyRotateTable;

public class Sally extends SpriteEnemy{
			private byte speed = 10;
			private float rotateDegrees = 0, maxRotateDegrees = -360, rotateDegreesAdd = -22.5f;
			
			SallyRotateTable _sallyRotateTable = new SallyRotateTable(rotateDegrees, maxRotateDegrees, rotateDegreesAdd, super.getX(), super.getY());

			public Sally(int xPos, int yPos){
				super(xPos, yPos, Assets.sally.getWidth(), Assets.sally.getHeight(),
						0, 0, Assets.sally.getWidth(), Assets.sally.getHeight(),
						17, 12, 15, 20, 5, 60);
				//18, 10, 25, 20
			}

			public void move(ScrollSpeed _scrollSpeed, SpriteJiki _sp_jiki) {
				//if (super.getScreenIn()){
					rotateDegrees = (rotateDegrees <= maxRotateDegrees)	? 0
																		: rotateDegrees + rotateDegreesAdd;
					super.guide(_scrollSpeed, speed, _sp_jiki.getX(), _sp_jiki.getY());
				//}
			}

			public void draw(Graphics g){
				if (super.getHP() > 0 && !super.getScreenIn())
					g.drawPixmap(Assets.sally, super.getX(), super.getY());
				else if (super.getScreenIn())
					_sallyRotateTable.drawRotateBitmap(g, Assets.sally, super.getX(), super.getY(), rotateDegrees);
			}

}
