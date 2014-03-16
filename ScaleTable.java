package com.example.line_shooting;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.example.line_shooting.framewark.Graphics;
import com.example.line_shooting.framewark.Pixmap;
import com.example.line_shooting.framewark.impl.AndroidPixmap;

public class ScaleTable {
	

	HashMap<Float, Bitmap> scaleHashMap = new HashMap<Float, Bitmap>();
	Matrix m = new Matrix();

	public void generateScalePixmap(Pixmap pixmap, float scale){
		if(scale != 0){
			m.postScale(scale, scale);
			Bitmap bitmap = Bitmap.createBitmap(((AndroidPixmap)pixmap).getBitmap(), 0, 0, pixmap.getWidth(), pixmap.getHeight(), m, true);
			scaleHashMap.put(scale, bitmap);
			m.postScale(1 / scale, 1 / scale);
		}
	}

	public int[] getScalePosition(Graphics g,Pixmap pixmap, int x, int y, float scale, float oldScale){
		int position[] = new int[4];
		position[2] = scaleHashMap.get(scale).getWidth();
		position[3] = scaleHashMap.get(scale).getHeight();
		position[0] = (scaleHashMap.get(oldScale).getWidth() - position[2]) / 2;
		position[1] = (scaleHashMap.get(oldScale).getHeight() - position[3]) / 2;
		return position;
	}

	public void drawScalePixmap(Graphics g,Pixmap pixmap, int x, int y, float scale){
			g.drawBitmap(scaleHashMap.get(scale), x, y);
	}

	public Bitmap getScaleBitmap(float scale) {
		return scaleHashMap.get(scale);
	}

	public void hashMapClear(){
		scaleHashMap.clear();
	}


}
