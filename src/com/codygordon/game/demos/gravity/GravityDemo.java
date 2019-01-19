package com.codygordon.game.demos.gravity;

import com.codygordon.game.Game;

public class GravityDemo extends Game {

	public static void main(String[] args) {
		new GravityDemo();
	}
	
	@Override
	public void initGameView() {
		gameView = new TestView();
	}
}