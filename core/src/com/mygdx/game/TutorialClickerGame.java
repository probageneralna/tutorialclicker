package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.screens.SplashScreen;

public class TutorialClickerGame extends Game {

	public final static String GAME_PREFS = "pl.javadevmatt.preclicker.pref";
	public final static String GAME_SCORE = "pl.javadevmatt.preclicker.pref.score";

	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean paused; // czy gra jest zapausowana, nazwano to flag¹\

	private Preferences prefs; // mozna tu zapisac np punkty

	private int points; // zliczanie punktow

	@Override
	public void create() {
		init();
		this.setScreen(new SplashScreen(this)); // splashScreen do ktorej
												// przekazujemy ta klase Game
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE); // aby wczytywac dane po
												// zamknieciu aplikacji
	}

	public void addPoint() {
		points++;
		updateSavedScoreInPrefs();
	}

	public void resetGameScore() {
		points = 0;
		updateSavedScoreInPrefs();
	}

	private void updateSavedScoreInPrefs() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();// musi byc, zeby zapisac w pamieci
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int pointsToAdd) {
		points += pointsToAdd; //dodane punkty przekazanen w parametrze
		updateSavedScoreInPrefs();
	}

	public void addPassiveIncome() {
		//TODO implement
	}

}
