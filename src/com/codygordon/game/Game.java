package com.codygordon.game;

import com.codygordon.game.input.EventListener;
import com.codygordon.game.interfaces.IUpdateListener;
import com.codygordon.game.ui.GameView;
import com.codygordon.game.ui.GameWindow;

public class Game extends BaseGame {

	private static Game instance;
	
	private GameLoop gameLoop;
	private Thread gameLoopThread;
	protected GameWindow gameWindow;
	protected GameView gameView;

	public Game() {
		instance = this;
		createGame();
	}
	
	public void createGame() {
		initWindow();
		initGameLoop();
		initGameView();
		onEnable();
		validate();
	}
	
	public void initWindow() {
		gameWindow = new GameWindow();
		System.out.println("Created game window");
	}
	
	public void initGameLoop() {
		gameLoop = new GameLoop();
		gameLoopThread = new Thread(gameLoop);
		gameLoopThread.setName("Game Loop Thread");
		System.out.println("Started game loop");
	}
	
	public void initGameView() {
		System.out.print("Initializing base view");
		gameView = new GameView();
		gameWindow.add(gameView);
	}

	public void validate() {
		registerUpdateListener(gameView);
		gameWindow.add(gameView);
		gameLoopThread.start();
		gameWindow.setVisible(true);
	}
	
	public void switchScreen(GameView view) {
		gameWindow.getContentPane().removeAll();
		gameWindow.getContentPane().add(view);
		gameWindow.getContentPane().revalidate();
		gameWindow.getContentPane().repaint();
		this.gameView = view;
		initGameLoop();
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
		gameLoop.registerListener(listener);
	}	
	public void registerEventListener(EventListener listener) {
		gameWindow.registerEventListener(listener);
	}
}