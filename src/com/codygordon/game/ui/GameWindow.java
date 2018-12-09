package com.codygordon.game.ui;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.codygordon.game.input.EventListener;
import com.codygordon.game.input.events.KeyDownEvent;
import com.codygordon.game.settings.Settings;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private GameWindowKeyListener listener;
	
	public GameWindow() {
		init();
	}
	
	protected void init() {
		int width = Integer.parseInt(Settings.getInstance().getSetting("FRAME_WIDTH"));
		int height = Integer.parseInt(Settings.getInstance().getSetting("FRAME_HEIGHT"));
		
		String title = Settings.getInstance().getSetting("FRAME_TITLE");
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		listener = new GameWindowKeyListener();
		addKeyListener(listener);

		setLayout(new GridLayout());
		
		setVisible(true);
	}
	
	/** Key Events **/
	public void registerEventListener(EventListener listener) {
		this.listener.registerListener(listener);
	}
	
	public interface EventDelegate {
		public void DoAction(EventListener eventListener);
	}

	public class GameWindowKeyListener extends KeyAdapter {

		private ArrayList<EventListener> listeners = new ArrayList<EventListener>();
		
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			executeEvent(x -> x.onKeyPressed(new KeyDownEvent(e)));
		}
		
		private void executeEvent(EventDelegate delegate) {
			for(EventListener listener : listeners) {
				delegate.DoAction(listener);
			}
		}
		
		public void registerListener(EventListener listener) {
			listeners.add(listener);
		}
	}
}