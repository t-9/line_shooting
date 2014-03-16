package com.example.line_shooting.framewark;

import android.graphics.Bitmap;


public interface Graphics {
	public static enum PixmapFormat{
		ARGB8888, ARGB4444, RGB565
	}

	public Pixmap newPixmap(String fileName, PixmapFormat format);

	public void clear(int color);

	public void drawPixel(int x, int y, int color);

	public void drawLine(int x, int y, int x2, int y2, int color);

	public void drawRect(int x, int y, int width, int height, int color);

	public void drawPixmap(Pixmap pixmap, int x, int y, int srxX, int srcY, int srcWidth, int srcHeight);

	public void drawPixmap(Pixmap pixmap, int x, int y);

	public void drawBitmap(Bitmap bitmap, int x, int y);

	public void drawScalePixmap(Pixmap pixmap, int x, int y, float scaleX, float scaleY);

	public void drawRotatePixmap(Pixmap pixmap, int x, int y, float degrees);

	public void drawRotateBitmap(Bitmap bitmap, int x, int y, float degrees);

	public int getWidth();

	public int getHeight();

}
