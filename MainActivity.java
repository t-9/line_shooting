package com.example.line_shooting;


import com.example.line_shooting.framewark.Screen;
import com.example.line_shooting.framewark.impl.AndroidGame;

public class MainActivity extends AndroidGame{

	@Override
	public Screen getStartScreen(){
		return new LoadingScreen(this);
	}
}