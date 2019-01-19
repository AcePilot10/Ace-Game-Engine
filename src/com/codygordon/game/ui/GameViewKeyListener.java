package com.codygordon.game.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import com.codygordon.game.input.IEventListener;
import com.codygordon.game.input.events.KeyDownEvent;

public class GameViewKeyListener extends KeyAdapter {
	public interface EventDelegate {
		public void DoAction(IEventListener eventListener);
	}

	private ArrayList<IEventListener> listeners = new ArrayList<IEventListener>();

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		executeEvent(x -> x.onKeyPressed(new KeyDownEvent(e)));
	}

	private synchronized void executeEvent(EventDelegate delegate) {
		try {
			for (IEventListener listener : listeners) {
				delegate.DoAction(listener);
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Skipped over event execution");
		}
	}

	public synchronized void registerListener(IEventListener listener) {
		listeners.add(listener);
	}

	public synchronized void unRegisterListener(IEventListener listener) {
		if (listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}
}