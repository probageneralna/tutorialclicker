package com.mygdx.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.TutorialClickerGame;

public class FlyingObject extends Image {

	public enum FlyingObjectType {
		MONEY, PASSIVE
	}

	public final static String MONEY = "money.png";
	public final static String BOOKS = "books.png";

	private final static int WIDHT = 150;
	private final static int HEIGHT = 150;

	private final static int STARTING_X = 0;
	private final static int STARTING_Y = -100; // startuje poza ekranem

	private TutorialClickerGame game;
	private FlyingObjectType type;

	public FlyingObject(FlyingObjectType type, TutorialClickerGame game) {
		super(new Texture(getTextureString(type)));

		this.type = type;
		this.game = game;

		this.setOrigin(WIDHT / 2, HEIGHT / 2); // miejsce, skad jest poruszane
		this.setSize(WIDHT, HEIGHT); // rozmiar

		this.setPosition(STARTING_X, STARTING_Y); // starting position

		this.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				reactOnClick();

				return super.touchDown(event, x, y, pointer, button);
			}

		});
	}

	private void reactOnClick() {
		if (FlyingObjectType.MONEY.equals(type)) {
			game.addPoints(50);
		} else if(FlyingObjectType.PASSIVE.equals(type)) {
			game.addPassiveIncome();
		}

		FlyingObject.this.remove(); // po kliknieciu na obiekt ma byc
									// usuniety
	}

	private static String getTextureString(FlyingObjectType type) {
		if (FlyingObjectType.MONEY.equals(type)) {
			return MONEY;
		} else if(FlyingObjectType.PASSIVE.equals(type)) {
			return BOOKS;
		}
		return "";
	}

	public void flyLikeHell() {
		// 3 akcje polaczone w jedna sekwencje
		Action a = Actions.parallel // 300 w prawo, 200 w gore, obracac przez 5
									// sekund
		(Actions.moveBy(300, 200, 5), Actions.rotateBy(360, 5));

		Action b = Actions.parallel(Actions.moveBy(-500, 900, 3), Actions.rotateBy(360, 3));

		Action c = Actions.run(new Runnable() { // jezeli a i b sie wykonaja to
			// usuwamy obiekt ze sceny

			@Override
			public void run() {
				FlyingObject.this.remove();
			}
		});

		this.addAction(Actions.sequence(a, b, c));
	}

}
