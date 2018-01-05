package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.screens.SplashScreen;

public class TutorialClickerGame extends Game {

	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean paused; //czy gra jest zapausowana, nazwano to flag¹

	@Override
	public void create () {
		this.setScreen(new SplashScreen(this)); //splashScreen do ktorej przekazujemy ta klase Game
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
