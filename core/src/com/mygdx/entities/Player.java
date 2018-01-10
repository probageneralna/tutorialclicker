package com.mygdx.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image{

	private final static int WIDTH = 150;
	private final static int HEIGHT = 180;

	private final static int STARTING_X = 200;
	private final static int STARTING_Y = 300;

	public Player() {
		super(new Texture("player.png"));

		this.setOrigin(WIDTH/2, HEIGHT/2); //miejsce, skad jest poruszane
		this.setSize(WIDTH, HEIGHT); //rozmiar

		//starting positon
		this.setPosition(STARTING_X, STARTING_Y);
	}

	public void reactOnClick() {
		//akcje, czyli jakies dzialanie na aktorze

		int xMoveAmmount = MathUtils.random(-130, 130);
		int yMoveAmmount = 10;
		float moveActionTime = 0.30f;
		Action moveAction = Actions.sequence( //poruszanie sie w losowe kierunki od -130 do 130
				Actions.moveBy(xMoveAmmount, yMoveAmmount, moveActionTime, Interpolation.circleOut),
				Actions.moveBy(-xMoveAmmount, -yMoveAmmount, moveActionTime, Interpolation.circle)
				); //sequence, czyli rozne sposoby poruszania sie

		int xGrowAmmount = MathUtils.random(-30, 100);
		int yGrowAmmount = 20;
		float growActionTime = 0.2f; //ile czasu to trwa
		Action growAction =  Actions.sequence( //wzrasta
				Actions.sizeBy(xGrowAmmount, yGrowAmmount, growActionTime, Interpolation.circleOut),
				Actions.sizeBy(-xGrowAmmount, -yGrowAmmount, growActionTime, Interpolation.circle)
				);

		this.addAction(moveAction);
		this.addAction(growAction);

		if(this.getHeight() > 170){ //jak bedzie wysokosc wieksza niz 170 to
			this.addAction(Actions.rotateBy(MathUtils.randomSign() * 360, 0.4f)); //losowa rotacja o 360 stopni, 0.4 sec
}
	}
}
