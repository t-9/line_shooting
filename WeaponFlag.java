package com.example.line_shooting;

public class WeaponFlag {

	// 武器のフラグ 0:書類 1:ブーメラン
	private byte weaponflag = 0;

	public boolean WeaponIsReport() {
		return (weaponflag == 0);
	}

	public boolean WeaponIsNotReport() {
		return (weaponflag != 0);
	}

	public boolean WeaponIsBoomerang() {
		return (weaponflag == 1);
	}

	public boolean WeaponIsNotBoomearng() {
		return (weaponflag != 1);
	}

	public void setWeaponReport() {
		weaponflag = 0;
	}

	public void setWeaponBoomerang() {
		weaponflag = 1;
	}
}
