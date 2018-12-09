package com.codygordon.game.demos.pong.gameobjects;

import com.codygordon.game.Game;
import com.codygordon.game.demos.pong.PongView;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Collider;
import com.codygordon.game.gameobjects.components.Rigidbody;
import com.codygordon.game.physics.Vector2;

public class ScreenBorder extends GameObject {
	
	@Override
	public void onAddComponents() {
		addComponent(new Collider(this));
	}	
	
	@Override
	public void onCollision(GameObject obj) {
		if(obj.name == "Ball") {
			Ball ball = (Ball)obj;
			Rigidbody rb = (Rigidbody)ball.getComponent(Rigidbody.class);		
			Vector2 newVel = new Vector2(0, 0);
			switch(name) {
			case "Col Top":
				newVel = new Vector2(rb.velocity.x, PongView.BALL_SPEED);
				rb.velocity = newVel;
				break;
			case "Col Bottom":
				newVel = new Vector2(rb.velocity.x, -PongView.BALL_SPEED);
				rb.velocity = newVel;
				break;
			case "Col Left":
				((PongView)Game.getInstance().getGameView()).getController().respawnBall();
				break;
			case "Col Right":
				((PongView)Game.getInstance().getGameView()).getController().respawnBall();
				break;
			}
		}
	}
}