package com.codygordon.game.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.input.IEventListener;
import com.codygordon.game.input.events.KeyDownEvent;

public class GameView extends BaseGameView implements IEventListener {

	private static final long serialVersionUID = 1L;

	private static GameView instance;
	
	private GameViewKeyListener keyListener;
	
	protected ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	private boolean initialized = false;
	
	@Override
	public void onCreate() {
		instance = this;
		setBackground(Color.red);	
		initKeyListener();
		setFocusable(true);
		requestFocus();
	}
	
	@Override
	public void onEnable() {
		Game.getInstance().getGameLoop().registerUpdateListener(this);
		initialized = true;
	}
	
	@Override
	public void onDestroy() {
		GetKeyListener().unRegisterListener(this);
	}
	
	private void initKeyListener() {
		keyListener = new GameViewKeyListener();
		keyListener.registerListener(this);
		addKeyListener(keyListener);
		setFocusable(true);
		requestFocus();
	}

	@Override
	public synchronized void paint(Graphics g) {
		super.paint(g);
		for(GameObject obj : gameObjects) {
			obj.paint(g);
		}
	}
	
	@Override
	public void update() {
		repaint();
	}
	
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	public synchronized GameObject createGameObject(GameObject obj) {
		gameObjects.add(obj);
		Game.getInstance().registerUpdateListener(obj);
		return obj;
	}
	
	public synchronized void destroyGameObject(GameObject obj) {
		if(gameObjects.contains(obj)) {
			gameObjects.remove(obj);
		}
	}
	
	public static GameView getGameView() {
		return instance;
	}
	
	public GameViewKeyListener GetKeyListener() {
		return this.keyListener; 
	} 

	@Override
	public void onKeyPressed(KeyDownEvent event) { }	

	public boolean isRunning() {
		return Game.getInstance().getGameLoop() != null;
	}
	
	public boolean isInitialized() {
		return this.initialized;
	}
}