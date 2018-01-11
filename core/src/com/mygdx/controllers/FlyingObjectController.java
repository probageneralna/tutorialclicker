package com.mygdx.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.entities.FlyingObject;
import com.mygdx.entities.FlyingObject.FlyingObjectType;
import com.mygdx.game.TutorialClickerGame;

public class FlyingObjectController {

	private int spawnTime;

	public FlyingObjectController(TutorialClickerGame game, Stage stage) {
		init(game, stage);
	}

	private void init(final TutorialClickerGame game, Stage stage) {
		randomizeSpawnTime();

		Timer.schedule(new Task() {

			@Override
			public void run() {

				FlyingObject flyingObject = null;

				if(MathUtils.randomBoolean()) {
					flyingObject = new FlyingObject(FlyingObjectType.MONEY, game);
				} else {
					flyingObject = new FlyingObject(FlyingObjectType.PASSIVE, game);
				}

				stage.addActor(flyingObject);
				flyingObject.flyLikeHell();

				randomizeSpawnTime();
			}
		}, spawnTime, spawnTime); //losowany co spawnTime, drugi to zeby pojawialo sie cyklicznie a nie tylko raz
	}

	private void randomizeSpawnTime() {
		spawnTime = MathUtils.random(3,6); //pojawianien sie obiektow co miedzy 5 a 10 sec
	}

}
