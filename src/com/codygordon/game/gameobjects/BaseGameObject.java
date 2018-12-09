package com.codygordon.game.gameobjects;

import java.awt.Graphics;

import com.codygordon.game.interfaces.ICollisionDetecter;
import com.codygordon.game.interfaces.IDrawable;
import com.codygordon.game.interfaces.IUpdateListener;

public class BaseGameObject implements ICollisionDetecter, IUpdateListener, IDrawable {
	
	protected void onEnable() { }
	
	public void onAddComponents() { }

	@Override
	public void update() { }

	@Override
	public void onCollision(GameObject obj) { }

	@Override
	public void paint(Graphics g) { }	
	
}