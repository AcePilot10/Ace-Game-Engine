package com.codygordon.game.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.codygordon.game.input.EventListener;
import com.codygordon.game.input.events.KeyDownEvent;

public class GameWindowKeyListener extends KeyAdapter {

	public interface EventDelegate {
		public void DoAction(EventListener eventListener);
	}
	
	private ArrayList<EventListener> listeners = new ArrayList<EventListener>();
	
	@Override
	public void keyPressed(KeyEvent e) {
		//super.keyPressed(e);
		System.out.println("Key pressed on windowd");
		executeEvent(x -> x.onKeyPressed(new KeyDownEvent(e)));
	}
	
	private void executeEvent(EventDelegate delegate) {
		//System.out.println("Detected event");
		for(EventListener listener : listeners) {
			delegate.DoAction(listener);
		}
	}
	
	public void registerListener(EventListener listener) {
		listeners.add(listener);
		//System.out.println("Window event listener registered! Typeof " + listener.getClass().getTypeName());
	}
	
	public void unRegisterListener(EventListener listener) {
		if(listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}
}