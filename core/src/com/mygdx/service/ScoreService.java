package com.mygdx.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {

	public final static String GAME_PREFS = "pl.javadevmatt.preclicker.pref";
	public final static String GAME_SCORE = "pl.javadevmatt.preclicker.pref.score";

	private Preferences prefs; // mozna tu zapisac np punkty

	private int points; // zliczanie punktow

	public ScoreService() {
		init();
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE); // aby wczytywac dane po
												// zamknieciu aplikacji
	}

	public void addPoints(int pointsToAdd) {
		points += pointsToAdd; // dodane punkty przekazanen w parametrze
		updateSavedScoreInPrefs();
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

	public void addPassiveIncome() {
		// TODO implement
	}

	public int getPoints() {
		return points;
	}


}
