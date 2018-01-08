package com.mygdx.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.entities.Player;
import com.mygdx.game.TutorialClickerGame;

public class GameplayScreen extends AbstractScreen {

	private Player player;
	private Button playerButton; // to w co sie wciska, zeby player sie poruszal

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
	}

	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
	}

	private void initPlayerButton() {
		playerButton = new Button(new ButtonStyle()); // pusty buttonstyle,
														// czyli przezroczysty
		playerButton.setWidth(460);
		playerButton.setHeight(360);
		playerButton.setX(10);
		playerButton.setY(170);
		playerButton.setDebug(true); //taki zarys

		stage.addActor(playerButton);

		playerButton.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) { //metoda po kliknieciu co ma sie stac
				
				player.reactOnClick();
				
				return super.touchDown(event, x, y, pointer, button);
			}

		});
	}

	private void initPlayer() {
		player = new Player();
		stage.addActor(player); // dodanie aktora do sceny
	}

	public void render(float delta) {
		super.render(delta); // super, czyli wszystko to, co w abstarcyjnym
								// screenie
		update(); // najpoierw update przez rysowaniem

		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act(); // czyli rob update co kzda klatke dla wszystkich aktorow
						// na scenie
	}

}
