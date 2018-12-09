package com.codygordon.game.demos.pipetest;

import com.codygordon.game.Game;

public class PipeTest extends Game {

	public static void main(String[] args) {
		new PipeTest();
	}
	
	@Override
	public void initGameView() {
		gameView = new PipeTestView();
	}
}