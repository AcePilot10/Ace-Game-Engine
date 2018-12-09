package com.codygordon.game.demos.pong;

import com.codygordon.game.Game;

public class Pong extends Game {
	
	public static void main(String[] args) {
		new Pong();
	}
	
	@Override
	public void initGameView() {
		gameView = new PongView();
	}
	
	@Override
	public void onEnable() {
		registerEventListener(new PongEventListener());
	}
}