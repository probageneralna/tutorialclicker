package com.mygdx.screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.TutorialClickerGame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg;

	public SplashScreen(TutorialClickerGame game) {
		super(game);
		init();
	}

	private void init() {
		//TODO implements better assets loading when game grows
		splashImg = new Texture("badlogic.jpg");
	}

	public void render(float delta) {
		super.render(delta); //super czyli wykonujemy wszystko to, co w klasie nadrzednej

		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		spriteBatch.end();
	}

}
