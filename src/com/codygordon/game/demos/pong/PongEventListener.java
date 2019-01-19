package com.codygordon.game.demos.pong;

import java.awt.event.KeyEvent;

import com.codygordon.game.Game;
import com.codygordon.game.input.EventListener;
import com.codygordon.game.input.events.KeyDownEvent;

public class PongEventListener extends EventListener {

	public static final int PADDLE_MOVE_STRENGTH = 5;
	
	@Override
	public void onKeyPressed(KeyDownEvent event) {
		PongView view = (PongView)Game.getInstance().getGameView();
		int key = event.getKeyEvent().getKeyCode();
		if(key == KeyEvent.VK_W) {
			view.paddle1.location.y -= PADDLE_MOVE_STRENGTH;
		}
		else if(key == KeyEvent.VK_S) {
			view.paddle1.location.y += PADDLE_MOVE_STRENGTH;
		}
		else if(key == KeyEvent.VK_UP) {
			view.paddle2.location.y -= PADDLE_MOVE_STRENGTH;
		}
		else if(key == KeyEvent.VK_DOWN) {
			view.paddle2.location.y += PADDLE_MOVE_STRENGTH;
		}
	}
}