package com.example.line_shooting;

import com.example.line_shooting.framewark.Graphics;

public class TimerCount {

	private int timeLimit = 10800;
	private byte timeLimitMinutes = 3;
	private byte timeLimitSeconds = 0;
	private short timeLimitDecimal = 0;

	public void setTimeLimitAdd(int timeLimitAdd){
		timeLimit += timeLimitAdd;
		setTimeLimits();
	}

	public void setTimeLimitSubtract(int timeLimitSubtract){
		if (timeLimit - timeLimitSubtract >= 0)
			timeLimit -= timeLimitSubtract;
		else
			timeLimit = 0;
		setTimeLimits();
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public byte getTimeLimitMinutes() {
		return timeLimitMinutes;
	}


	public byte getTimeLimitSeconds() {
		return timeLimitSeconds;
	}

	public short getTimeLimitDecimal() {
		return timeLimitDecimal;
	}

	private void setTimeLimits(){
		timeLimitMinutes = (byte) (timeLimit / 3600);
		timeLimitSeconds = (byte) (timeLimit % 3600 / 60);
		timeLimitDecimal = (short) (timeLimit % 60);
	}

	public void DisplayTimer(Graphics g) {
		g.drawPixmap((getTimeLimitMinutes() == 0)	? Assets.timer_0
				: (getTimeLimitMinutes() == 1)		? Assets.timer_1
				: (getTimeLimitMinutes() == 2)		? Assets.timer_2
				: (getTimeLimitMinutes() == 3)		? Assets.timer_3
				: (getTimeLimitMinutes() == 4)		? Assets.timer_4
				: (getTimeLimitMinutes() == 5)		? Assets.timer_5
				: (getTimeLimitMinutes() == 6)		? Assets.timer_6
				: (getTimeLimitMinutes() == 7)		? Assets.timer_7
				: (getTimeLimitMinutes() == 8)		? Assets.timer_8
				: Assets.timer_9,
					417, 11);

		g.drawPixmap(Assets.timer_colon, 429, 11);

		g.drawPixmap((getTimeLimitSeconds() / 10 == 0)	? Assets.timer_0
				: (getTimeLimitSeconds() / 10 == 1)		? Assets.timer_1
				: (getTimeLimitSeconds() / 10 == 2)		? Assets.timer_2
				: (getTimeLimitSeconds() / 10 == 3)		? Assets.timer_3
				: (getTimeLimitSeconds() / 10 == 4)		? Assets.timer_4
				: Assets.timer_5,
					441, 11);

		g.drawPixmap((getTimeLimitSeconds() % 10 == 0)	? Assets.timer_0
				: (getTimeLimitSeconds() % 10 == 1)		? Assets.timer_1
				: (getTimeLimitSeconds() % 10 == 2)		? Assets.timer_2
				: (getTimeLimitSeconds() % 10 == 3)		? Assets.timer_3
				: (getTimeLimitSeconds() % 10 == 4)		? Assets.timer_4
				: (getTimeLimitSeconds() % 10 == 5)		? Assets.timer_5
				: (getTimeLimitSeconds() % 10 == 6)		? Assets.timer_6
				: (getTimeLimitSeconds() % 10 == 7)		? Assets.timer_7
				: (getTimeLimitSeconds() % 10 == 8)		? Assets.timer_8
				: Assets.timer_9,
					453, 11);

	}

}
