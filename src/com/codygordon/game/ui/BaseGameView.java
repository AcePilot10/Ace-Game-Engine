package com.codygordon.game.ui;

import javax.swing.JPanel;

import com.codygordon.game.interfaces.IUpdateListener;
import com.codygordon.game.util.ScreenBorder;

public abstract class BaseGameView extends JPanel implements IUpdateListener {
	private static final long serialVersionUID = 2234335970350733145L;
	
	protected ScreenBorder screenBorder;
	
	protected void onCreateGameObjects() { }
	protected void onEnable() { }
	protected void onCreate() { } 
	protected void onDestroy() { }

	public void createGameView() {
		onCreate();
		onCreateGameObjects();
		onEnable();
	}
	
	public void destroyGameView() {
		onDestroy();
	}
}