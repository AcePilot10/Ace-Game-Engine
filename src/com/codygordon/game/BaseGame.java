package com.codygordon.game;

import com.codygordon.game.ui.GameView;
import com.codygordon.game.ui.GameWindow;

public abstract class BaseGame implements IGame {
	
	protected GameLoop gameLoop;
	protected Thread gameLoopThread;
	protected GameWindow gameWindow;
	protected GameView gameView;
	
	public abstract void initWindow();
	public abstract void initGameLoop();
	public abstract void initGameView();
	public abstract void validate();
	
	public void startGame() {
		initWindow();
		initGameLoop();
		initGameView();
		validate();
	}
	
	public void displayScreen() {
		validate();
	}
}