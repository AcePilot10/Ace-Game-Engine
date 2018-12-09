package com.codygordon.game.input;

import com.codygordon.game.input.events.KeyDownEvent;

public interface EventListener {
	public void onKeyPressed(KeyDownEvent event);
}