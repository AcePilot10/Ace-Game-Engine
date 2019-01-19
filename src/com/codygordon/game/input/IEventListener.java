package com.codygordon.game.input;

import com.codygordon.game.input.events.KeyDownEvent;

public interface IEventListener {
	public void onKeyPressed(KeyDownEvent event);
}