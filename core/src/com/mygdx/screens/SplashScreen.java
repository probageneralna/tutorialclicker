package com.mygdx.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.TutorialClickerGame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg;

	public SplashScreen(final TutorialClickerGame game) { //finalne, bo jezeli przekazujemy cos do taksa to musi miec pewnosc, ze to sie nie zmieni
		super(game);

		Timer.schedule(new Task() {

			@Override
			public void run() {
				game.setScreen(new GameplayScreen(game)); //przejscie na nowy screen
			}
		}, 1); //task wykona sie po 1 sekundzie
	}

	@Override
	protected void init() {
		splashImg = new Texture("badlogic.jpg");
	}

	public void render(float delta) {
		super.render(delta); //super czyli wykonujemy wszystko to, co w klasie nadrzednej

		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		spriteBatch.end();
	}




}
