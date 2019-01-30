package com.codygordon.game.demos.camera;

import com.codygordon.game.Game;

public class CameraDemo extends Game {

	public static void main(String[] args) {
		new CameraDemo();
	}
	
	@Override
	public void initGameView() {
		gameView = new CameraDemoWorldView(3000, 1500);
	}
}