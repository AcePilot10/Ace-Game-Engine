package com.codygordon.game.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.input.EventListener;
import com.codygordon.game.input.events.KeyDownEvent;

public class GameView extends BaseGameView implements EventListener {

	private static final long serialVersionUID = 1L;

	private static GameView instance;
	
	private GameViewKeyListener keyListener;
	
	protected ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	public void init() {
		instance = this;
		revalidate();
		onEnable();
		onCreateGameObjects();
		Game.getInstance().getGameLoop().registerUpdateListener(this);
		setBackground(Color.red);	
		initKeyListener();
	}
	
	private void initKeyListener() {
		keyListener = new GameViewKeyListener();
		keyListener.registerListener(this);
	}

	@Override
	public synchronized void paint(Graphics g) {
		super.paint(g);
		for(GameObject obj : gameObjects) {
			obj.paint(g);
		}
	}
	
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
	
	public GameViewKeyListener GetKeyListener() { return this.keyListener; } 

	@Override
	public void onKeyPressed(KeyDownEvent event) {
		System.out.println("Key press detected");
	}	
}