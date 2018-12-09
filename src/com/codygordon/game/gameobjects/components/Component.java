package com.codygordon.game.gameobjects.components;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.interfaces.IUpdateListener;

public class Component implements IUpdateListener {
	
	public GameObject gameObject;
	
	public Component(GameObject obj) {
		gameObject = obj;
		Game.getInstance().registerUpdateListener(this);
	}
	
	@Override
	public void update() { }	
}