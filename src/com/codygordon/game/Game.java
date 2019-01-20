package com.codygordon.game;

import com.codygordon.game.interfaces.IUpdateListener;
import com.codygordon.game.ui.GameView;
import com.codygordon.game.ui.GameWindow;

public class Game extends BaseGame {

	private static Game instance;

	public Game() {
		instance = this;
		startGame();
	}

	@Override
	public void initWindow() {
		gameWindow = new GameWindow();
		System.out.println("Created game window");
	}

	@Override
	public void initGameLoop() {
		gameLoop = new GameLoop();
		gameLoopThread = new Thread(gameLoop);
		gameLoopThread.setName("Game Loop Thread");
		gameLoopThread.start();
		System.out.println("Started game loop");
	}

	@Override
	public void initGameView() {
		System.out.print("Initializing base view");
		gameView = new GameView();
	}

	@Override
	public void validate() {
		gameWindow.revalidate();
		gameWindow.setVisible(true);
		gameWindow.validate();
		gameView.validate();
	}
	
	@Override
	public void show() {
		gameWindow.getContentPane().add(gameView);
		gameView.createGameView();
		validate();
	}

	public void switchScreen(GameView view) {
		System.out.println("Switching to: " + view.getClass().getSimpleName());
		gameLoop.clearUpdateListeners();
		gameView.destroyGameView();
		gameWindow.getContentPane().remove(gameView);
		this.gameView = view;
		gameWindow.getContentPane().add(gameView);
		view.createGameView();
		validate();
	}

	/** Getters **/
	public GameLoop getGameLoop() {
		return this.gameLoop;
	}

	public GameWindow getWindow() {
		return this.gameWindow;
	}

	public GameView getGameView() {
		return this.gameView;
	}

	public static Game getInstance() {
		return instance;
	}

	/** Helpers **/
	public void registerUpdateListener(IUpdateListener listener) {
		gameLoop.registerUpdateListener(listener);
	}
}