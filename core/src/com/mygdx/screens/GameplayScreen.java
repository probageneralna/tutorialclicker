package com.mygdx.screens;

import com.mygdx.entities.Player;
import com.mygdx.game.TutorialClickerGame;

public class GameplayScreen extends AbstractScreen{

	private Player player;

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
		init();
	}

	private void init() {
		initPlayer();
	}

	private void initPlayer() {
		player = new Player();
		stage.addActor(player); //dodanie aktora do sceny
	}

	public void render(float delta) {
		super.render(delta); //super, czyli wszystko to, co w abstarcyjnym screenie
		update(); //najpoierw update przez rysowaniem

		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act(); //czyli rob update co kzda klatke dla wszystkich aktorow na scenie
	}

}
