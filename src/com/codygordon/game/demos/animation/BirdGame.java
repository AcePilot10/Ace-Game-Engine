package com.codygordon.game.demos.animation;

import com.codygordon.game.Game;

public class BirdGame extends Game {

	public static void main(String[] args) {
		new BirdGame();
	}
	
	@Override
	public void initGameView() {
		gameView = new BirdGameView();
	}
}