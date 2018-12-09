package com.codygordon.game.ui;

import javax.swing.JPanel;

import com.codygordon.game.interfaces.IUpdateListener;
import com.codygordon.game.util.ScreenBorder;

public abstract class BaseGameView extends JPanel implements IUpdateListener {
	protected ScreenBorder screenBorder;
	protected void onCreateGameObjects() { }
	protected void onEnable() { }
	public void update() { }
}