package com.codygordon.game.gameobjects.components;

import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.interfaces.IUpdateListener;
import com.codygordon.game.physics.Vector2;

public class Rigidbody extends Component implements IUpdateListener {

	public Vector2 velocity = new Vector2(0, 0);
	public float mass = 0;
	public float drag = 0;
	public float density = 0;
	public boolean useGravity = true;
	public float gravity = 0.05f;
	
	public Rigidbody(GameObject obj) {
		super(obj);
	}
	
	@Override
	public void update() {
		handleGravity();
		gameObject.location.x += velocity.x;
		gameObject.location.y += velocity.y;
	}
	
	private void handleGravity() {
		if(useGravity) {
			velocity.y += gravity;
		}
	}
}