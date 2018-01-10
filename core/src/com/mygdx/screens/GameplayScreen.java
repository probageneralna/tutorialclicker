package com.mygdx.screens;

import com.mygdx.entities.Player;
import com.mygdx.game.TutorialClickerGame;
import com.mygdx.ui.IClickCallback;
import com.mygdx.ui.PlayerButton;
import com.mygdx.ui.ResetScoreButton;
import com.mygdx.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen {

	private Player player;
	private PlayerButton playerButton; // to w co sie wciska, zeby player sie										// poruszal
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
	}

	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
	}

	private void initResetScoreButton() {
		resetScoreButton = new ResetScoreButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.resetGameScore();
			}
		});

		stage.addActor(resetScoreButton);
	}

	private void initScoreLabel() {

		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}

	private void initPlayerButton() {
		playerButton = new PlayerButton(new IClickCallback() {

			@Override
			public void onClick() {
				player.reactOnClick();
				game.addPoint(); // po kliknieciu dodanie punktu
			}
		});

		stage.addActor(playerButton);
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
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act(); // czyli rob update co kzda klatke dla wszystkich aktorow
						// na scenie

	}

}
