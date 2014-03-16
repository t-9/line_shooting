package com.example.line_shooting;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Pixmap;

public class RotateTable {
	
	//HashMap<Float, Bitmap> rotateHashMap = new HashMap<Float, Bitmap>();
	Matrix m = new Matrix();

	public void generateRotateBitmap(HashMap<Float, Bitmap> hashmap, Bitmap bitmap, float degrees, int x, int y){
		m.postRotate(degrees, x / 2, y / 2);
		Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
		hashmap.put(degrees, bitmap2);
		m.postRotate(-degrees, x / 2, y / 2);
	}

	public void drawRotateBitmap(Graphics g, HashMap<Float, Bitmap> hashmap, Bitmap bitmap, int x, int y, float degrees){
		if(hashmap.get(degrees) != null){
			int xPosDifference = (bitmap.getWidth() - hashmap.get(degrees).getWidth()) / 2;
			int yPosDifference = (bitmap.getHeight() - hashmap.get(degrees).getHeight()) / 2;
			g.drawBitmap(hashmap.get(degrees), x + xPosDifference, y + yPosDifference);
		} else
			g.drawBitmap(bitmap, x, y);
	}
	
	public void drawRotateBitmap(Graphics g,Pixmap pixmap, HashMap<Float, Bitmap> hashmap, int x, int y, float degrees){
		if(hashmap.get(degrees) != null){
			int xPosDifference = (pixmap.getWidth() - hashmap.get(degrees).getWidth()) / 2;
			int yPosDifference = (pixmap.getHeight() - hashmap.get(degrees).getHeight()) / 2;
			g.drawBitmap(hashmap.get(degrees), x + xPosDifference, y + yPosDifference);
		} else
			g.drawPixmap(pixmap, x, y);
	}

	public Bitmap getRotateBitmap(HashMap<Float, Bitmap> hashmap, float degrees) {
		return hashmap.get(degrees);
	}

	public void hashMapClear(HashMap<Float, Bitmap> hashmap) {
		hashmap.clear();
	}

}
