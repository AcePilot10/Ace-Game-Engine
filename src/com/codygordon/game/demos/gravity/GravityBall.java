package com.codygordon.game.demos.gravity;

import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Rigidbody;

public class GravityBall extends GameObject {

	public Rigidbody rb;
	public int power = 2;
	
	@Override
	public void onAddComponents() {
		rb = new Rigidbody(this);
		rb.useGravity = true;
		addComponent(rb);
	}
	
	public void jump() {
		rb.velocity.y = -power;
	}
}