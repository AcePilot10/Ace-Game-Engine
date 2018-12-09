package com.codygordon.game.physics;

import java.awt.Point;

public class Vector2 {

	public float x;
	public float y;
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public static Vector2 pointToVector2(Point point) {
		return new Vector2(point.x, point.y);
	}
}