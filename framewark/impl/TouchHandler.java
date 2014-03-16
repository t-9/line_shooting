package com.example.line_shooting.framewark.impl;

import java.util.List;

import android.view.View.OnTouchListener;

import com.example.line_shooting.framewark.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {
	public boolean isTouchDown(int pointer);

	public int getTouchX(int pointer);

	public int getTouchY(int pointer);

	public List<TouchEvent> getTouchEvents();

}
