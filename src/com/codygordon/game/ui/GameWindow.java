package com.codygordon.game.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;

import com.codygordon.game.input.EventListener;
import com.codygordon.game.settings.Settings;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;

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
		setLayout(new GridLayout());
		setVisible(true);
	}
	
	public void validateScreen() {
		requestFocus();
	}
}