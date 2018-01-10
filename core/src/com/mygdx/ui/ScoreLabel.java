package com.mygdx.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreLabel extends Label {

	public ScoreLabel() {
		super("", prepareLabelStyle());
		init();
	}

	public void init() {
		this.setX(70);
		this.setY(650);
	}

	private static LabelStyle prepareLabelStyle() { // odc 8 dlaczego statyczna
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		return labelStyle;
	}

}
