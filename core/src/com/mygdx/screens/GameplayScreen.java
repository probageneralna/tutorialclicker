package com.mygdx.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.controllers.FlyingObjectController;
import com.mygdx.entities.Player;
import com.mygdx.game.TutorialClickerGame;
import com.mygdx.ui.IClickCallback;
import com.mygdx.ui.PlayerButton;
import com.mygdx.ui.ResetScoreButton;
import com.mygdx.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen {

	private Image bgImg;
	private Player player;
	private PlayerButton playerButton; // to w co sie wciska, zeby player sie //
										// poruszal
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;
	private FlyingObjectController flyinObjectController;

	public GameplayScreen(TutorialClickerGame game) {
		super(game);
	}

	@Override
	protected void init() { // KOLEJNOSC TYCH INITOW JEST WAZNA!!!
		initBg();
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
		initFlyingStuffController();
		startTheMusic();
	}

	private void startTheMusic() {
		game.getSoundService().startPlayingMusic(true);
	}

	private void initFlyingStuffController() {
		flyinObjectController = new FlyingObjectController(game, stage);
	}

	private void initBg() {
		bgImg = new Image(new Texture("bg.png"));
		stage.addActor(bgImg);
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

	private void initScoreLabel() {
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
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
