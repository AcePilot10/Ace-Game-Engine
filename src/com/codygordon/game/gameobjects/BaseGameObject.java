package com.codygordon.game.gameobjects;

import java.awt.Graphics;

import com.codygordon.game.interfaces.ICollisionDetecter;
import com.codygordon.game.interfaces.IDrawable;
import com.codygordon.game.interfaces.IUpdateListener;

public class BaseGameObject implements ICollisionDetecter, IUpdateListener, IDrawable {
	protected void onEnable() { }
	public void onAddComponents() { }
	public void update() { }
	public void onCollision(GameObject obj) { }
	public void paint(Graphics g) { }	
}