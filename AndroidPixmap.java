package com.example.line_shooting;

import android.graphics.Bitmap;

import com.example.line_shooting.framewark.Graphics.PixmapFormat;
import com.example.line_shooting.framewark.Pixmap;

public class AndroidPixmap implements Pixmap {
	Bitmap bitmap;
	PixmapFormat format;

	public AndroidPixmap(Bitmap bitmap, PixmapFormat format) {
		this.bitmap = bitmap;
		this.format = format;
	}

	@Override
	public int getWidth() {
		return bitmap.getWidth();
	}

	@Override
	public int getHeight() {
		return bitmap.getHeight();
	}

	@Override
	public PixmapFormat getFormat() {
		return format;
	}

	@Override
	public void dispose() {
		bitmap.recycle();
	}

	@Override
	public Bitmap getBitmap(){
		return bitmap;
	}
}
