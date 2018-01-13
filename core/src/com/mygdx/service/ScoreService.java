package com.mygdx.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {

	public final static String GAME_PREFS = "pl.javadevmatt.preclicker.pref";
	public final static String GAME_SCORE = "pl.javadevmatt.preclicker.pref.score";
	public final static String GAME_PASSIVE_INCOME = "pl.javadevmatt.preclicker.pref.passive";

	private Preferences prefs; // mozna tu zapisac np punkty

	private int points; // zliczanie punktow
	private int passiveIncome;

	public ScoreService() {
		init();
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		loadPassiveIncome();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE); // aby wczytywac dane po
												// zamknieciu aplikacji
	}

	private void loadPassiveIncome() {
		passiveIncome = prefs.getInteger(GAME_PASSIVE_INCOME);
	}

	public void addPoints(int pointsToAdd) {
		points += pointsToAdd; // dodane punkty przekazanen w parametrze
		updateSavedScoreAndPassiveIncomeInPrefs();
	}

	public void addPoint() {
		points++;
		updateSavedScoreAndPassiveIncomeInPrefs();
	}

	public void resetGameScore() {
		points = 0;
		updateSavedScoreAndPassiveIncomeInPrefs();
	}

	private void updateSavedScoreAndPassiveIncomeInPrefs() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
		prefs.flush();// musi byc, zeby zapisac w pamieci
	}

	public void addPassiveIncome() {
		passiveIncome++;
		updateSavedScoreAndPassiveIncomeInPrefs();
	}

	public int getPoints() {
		return points;
	}

	public int getPassiveIncome() {
		return passiveIncome;
	}
}
