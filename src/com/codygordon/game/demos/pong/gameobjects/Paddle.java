package com.codygordon.game.demos.pong.gameobjects;

import com.codygordon.game.demos.pong.PongView;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Collider;
import com.codygordon.game.gameobjects.components.Rigidbody;
import com.codygordon.game.physics.Vector2;

public class Paddle extends GameObject {

	public int paddleNumber;
	private Collider collider;
	
	public static final float HIT_FACTOR = 7f;
	
	@Override
	public void onAddComponents() {
		collider= new Collider(this);
		addComponent(collider);
	}
	
	@Override
	public void onCollision(GameObject obj) {
		if(obj.name == "Ball") {
			Ball ball = (Ball)obj;
			Rigidbody rb = (Rigidbody) obj.getComponent(Rigidbody.class);
			if(paddleNumber == 1) {
				rb.velocity = new Vector2(PongView.BALL_SPEED, hitFactor(ball));
			} else if(paddleNumber == 2){
				System.out.println("Reversing Ball");
				rb.velocity = new Vector2(-PongView.BALL_SPEED, hitFactor(ball));
				System.out.println(rb.velocity.x);
			}
		}
	}
	
	private int hitFactor(Ball ball) {		
		float ballY = ball.location.y + (ball.size.y);
		float racketY = location.y + (size.y / 2);
		float racketHeight = size.y;
		float y = (ballY - racketY) / racketHeight; 
		return Math.round(y * HIT_FACTOR);
	}
}