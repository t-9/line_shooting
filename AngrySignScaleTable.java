package com.example.line_shooting;

public class AngrySignScaleTable extends ScaleTable{
	
	public AngrySignScaleTable(float initScale, float maxScale, float addScale) {
		super();
		for(float scale = initScale; scale <= maxScale; scale += addScale)
			generateScalePixmap(Assets.angrySign, scale);
	}

}
