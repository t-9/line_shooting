package com.example.line_shooting.rotateTable;

import java.util.HashMap;

import com.example.line_shooting.RotateTable;
import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Pixmap;

import android.graphics.Bitmap;

public class AngrySignRotateTable extends RotateTable{
	
	public AngrySignRotateTable(Bitmap bitmap, float initDegrees, float maxDegrees, float addDegrees, int x, int y) {
		for(float degrees = initDegrees; degrees >= maxDegrees; degrees += addDegrees)
			super.generateRotateBitmap(rotateHashMap, bitmap, degrees, x, y);
	}
	
	static HashMap<Float, Bitmap> rotateHashMap = new HashMap<Float, Bitmap>();

	public void drawRotateBitmap(Graphics g,Bitmap bitmap, int x, int y, float degrees){
		super.drawRotateBitmap(g, rotateHashMap, bitmap, x, y, degrees);
	}
	
	public void drawRotateBitmap(Graphics g,Pixmap pixmap, int x, int y, float degrees){
		super.drawRotateBitmap(g, pixmap, rotateHashMap, x, y, degrees);
	}

	public Bitmap getRotateBitmap(float degrees) {
		return super.getRotateBitmap(rotateHashMap, degrees);
	}

	public void hashMapClear(){
		super.hashMapClear(rotateHashMap);
	}

}
