package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.screens.SplashScreen;
import com.mygdx.service.ScoreService;
import com.mygdx.service.SoundService;

public class TutorialClickerGame extends Game {

	public final static String GAME_NAME = "Tutorial Clicker";

	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private SoundService soundService;
	private ScoreService scoreService;

	private boolean paused; // czy gra jest zapausowana, nazwano to flag¹\

	@Override
	public void create() {
		init();
		this.setScreen(new SplashScreen(this)); // splashScreen do ktorej
												// przekazujemy ta klase Game
	}

	private void init() {
		initSoundService();
		initScoreService();
	}

	private void initScoreService() {
		scoreService  = new ScoreService();
	}

	private void initSoundService() {
		soundService = new SoundService();
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public SoundService getSoundService() {
		return soundService;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}
}
