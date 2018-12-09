package com.codygordon.game.input.events;

import java.awt.event.KeyEvent;

import com.codygordon.game.input.Event;

public class KeyDownEvent extends Event {
	
	private KeyEvent keyEvent;
	
	public KeyDownEvent(KeyEvent event) {
		keyEvent = event;
	}
	
	public KeyEvent getKeyEvent() {
		return keyEvent;
	}
}