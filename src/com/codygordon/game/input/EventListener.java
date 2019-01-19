package com.codygordon.game.input;

import com.codygordon.game.input.events.KeyDownEvent;

public abstract class EventListener implements IEventListener {
	public abstract void onKeyPressed(KeyDownEvent event);
}