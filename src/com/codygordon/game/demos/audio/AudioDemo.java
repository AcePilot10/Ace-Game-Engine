package com.codygordon.game.demos.audio;

import com.codygordon.game.Game;

public class AudioDemo extends Game {

	public static void main(String[] args) {
		new AudioDemo();
	}
	
	@Override
	public void initGameView() {
		gameView = new AudioDemoView();
	}
}