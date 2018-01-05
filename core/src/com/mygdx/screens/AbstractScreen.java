package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.TutorialClickerGame;

public abstract class AbstractScreen implements Screen{

	protected TutorialClickerGame game; //aby miec dostep do glownej klasy gry

	protected Stage stage; //tak jakby scena
	private OrthographicCamera camera;

	protected SpriteBatch spriteBatch;

	public AbstractScreen(TutorialClickerGame game) {
		this.game = game; //lokanie zapisana gra, z ktorej mozna rozne rzeczy pobierac
		createCamera();
		stage = new Stage(new StretchViewport(TutorialClickerGame.WIDTH, TutorialClickerGame.HEIGHT, camera)); //2 odc 32min
		spriteBatch = new SpriteBatch();Gdx.input.setInputProcessor(stage); //input pobierany ze stage
	}

	private void createCamera() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, TutorialClickerGame.WIDTH, TutorialClickerGame.HEIGHT); //jaies ustawienie kamery
		camera.update(); //malo istotne, update przy tworzeniu kamery
	}

	@Override
	public void render(float delta) {
		clearScreen(); //abysmy zawsze rysowali na czystym obszarze
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void show() { //wywolana, gdy gra sie pojawia

	}

	private void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resume() { //co sie dzieje, jak aplikacja wroci z tla
		game.setPaused(false);
	}

	@Override
	public void pause() { //co sie dzieje jak aplikacja zapausuje sie
		game.setPaused(true);
	}

	@Override
	public void dispose() { //zwalnianie pamieci
		game.dispose();
	}

	@Override //przeniesiono tu, bo nie jest potrzebna ta metoda, dzieki temu nie trzeba tego dodawac w kazdej klasie osobno, ktora ta dziwdziczy
	public void resize(int width, int height) {

	}

	@Override //jak wyzej, ja to zrobilem :)
	public void hide() {

	}

}
