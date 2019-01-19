package com.codygordon.game.demos.gravity;

import java.awt.Color;

import com.codygordon.game.Game;
import com.codygordon.game.input.IEventListener;
import com.codygordon.game.input.events.KeyDownEvent;
import com.codygordon.game.ui.GameView;

public class TestView extends GameView implements IEventListener {

	@Override 
	public void onEnable() {
		setBackground(Color.BLUE);
	}

	@Override
	public void onKeyPressed(KeyDownEvent event) {
		Game.getInstance().switchScreen(new GravityDemoView());
	}
}