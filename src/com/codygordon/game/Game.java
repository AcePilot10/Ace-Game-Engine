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
		gameLoopThread.start();
		System.out.println("Started game loop");
	}
	
	public void initGameView() {
		System.out.print("Initializing base view");
		gameView = new GameView();
	}

	public void validate() {
		gameWindow.getContentPane().add(gameView);
		registerUpdateListener(gameView);
		gameWindow.revalidate();
		gameWindow.setVisible(true);
		gameView.init();

	}
	
	public void switchScreen(GameView view) {
		System.out.println("Switching to: " + view.getClass().getSimpleName());
		gameView.onDisable();
		gameLoop.unRegisterListener(gameView);
		gameWindow.getContentPane().remove(gameView);
		this.gameView = view;		
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
	
	public void unRegisterEventListener(EventListener listener) {
		gameWindow.unRegisterEventListener(listener);
	}
}