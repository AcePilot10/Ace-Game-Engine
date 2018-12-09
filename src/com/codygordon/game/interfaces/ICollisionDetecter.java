package com.codygordon.game.interfaces;

import com.codygordon.game.gameobjects.GameObject;

public interface ICollisionDetecter {
	public void onCollision(GameObject obj);
}