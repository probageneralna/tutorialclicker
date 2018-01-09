package com.mygdx.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.entities.Player;
import com.mygdx.game.TutorialClickerGame;

public class GameplayScreen extends AbstractScreen {

	private Player player;
	private Button playerButton; // to w co sie wciska, zeby player sie poruszal
	private Label scoreLabel;

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
	}

	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
		initScoreLabel();
	}

	private void initScoreLabel() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont(); //odmyslny styl
		scoreLabel = new Label("Test 123", labelStyle);
		scoreLabel.setX(20);
		scoreLabel.setY(650);
		stage.addActor(scoreLabel);
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
				game.addPoint(); //po kliknieciu dodanie punktu

				return super.touchDown(event, x, y, pointer, button);
			}

		});
	}

	private void initPlayer() {
		player = new Player();
		stage.addActor(player); // dodanie aktora do sceny
	}

	public void render(float delta) {
		super.render(delta); // super, czyli wszystko to, co w abstarcyjnym	screenie
		update(); // najpoierw update przez rysowaniem

		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act(); // czyli rob update co kzda klatke dla wszystkich aktorow na scenie

	}

}
