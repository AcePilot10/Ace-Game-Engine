package com.codygordon.game.gameobjects.camera;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.GameObject;

public class Camera extends GameObject {

	public int worldSizeX;
	public int worldSizeY;
	
	public int viewportWidth = Game.getInstance().getWindow().getWidth();
	public int viewportHeight = Game.getInstance().getWindow().getHeight();
	
	private int offsetMinX = 0;
	private int offsetMaxX;
	private int offsetMinY = 0;
	private int offsetMaxY;
	
	public Camera(int viewportWidth, int viewportHeight) {
		this.viewportWidth = viewportWidth;
		this.viewportHeight = viewportHeight;
		validateCamera();
	}
	
	public void validateCamera() {
		offsetMaxX = worldSizeX - viewportWidth;
		offsetMaxY = worldSizeY - viewportHeight;
	}

	@Override
	public void update() {
		super.update();
		location.x = location.x - viewportWidth / 2;
		location.y = location.y - viewportHeight / 2;
		if (location.x > offsetMaxX) {
		    location.x = offsetMaxX;
		}
		else if (location.x < offsetMinX) {
		    location.x = offsetMinX;
		}
		if (location.y > offsetMaxY) {
		    location.y = offsetMaxY;
		}
		else if (location.y < offsetMinY) {
		    location.y = offsetMinY;
		}
	}	
}