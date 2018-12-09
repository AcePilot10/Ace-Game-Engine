package com.codygordon.game.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.GameObject;

public class GameView extends BaseGameView {

	private static final long serialVersionUID = 1L;

	private static GameView instance;
	
	protected ArrayList<GameObject> gameObjects;
	
	public GameView() {
		instance = this;
		init();
		onEnable();
		validate();
		onCreateGameObjects();
	}
	
	protected void init() {
		setBackground(Color.red);
		gameObjects = new ArrayList<GameObject>();
		System.out.println("Game view is initialized");
	}
	
	@Override
	public synchronized void paint(Graphics g) {
		super.paint(g);
		for(GameObject obj : gameObjects) {
			obj.paint(g);
		}
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
	
	public void update() {
		repaint();
	}
}