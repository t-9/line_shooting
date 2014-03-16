package com.example.line_shooting.framewark;

import android.graphics.Bitmap;

import com.example.line_shooting.framewark.Graphics.PixmapFormat;


public interface Pixmap {
	public int getWidth();
	public int getHeight();
	public PixmapFormat getFormat();
	public void dispose();
	public Bitmap getBitmap();

}
