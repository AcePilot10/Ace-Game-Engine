package com.codygordon.game.demos.pong.gameobjects;

import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Collider;
import com.codygordon.game.gameobjects.components.Rigidbody;

public class Ball extends GameObject {
	
	public Rigidbody rigidbody;
	
	@Override
	public void onAddComponents() {
		Collider col = new Collider(this);
		rigidbody = new Rigidbody(this);	
		addComponent(col);
		addComponent(rigidbody);
	}
	
	@Override
	public void update() {
//		System.out.println((rigidbody.velocity.x * GameLoop.deltaTime));
//		System.out.println(rigidbody.velocity.y);
	}
}