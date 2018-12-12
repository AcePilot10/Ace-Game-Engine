package com.codygordon.game.demos.pong;

import com.codygordon.game.Game;
import com.codygordon.game.demos.pong.gameobjects.Ball;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Rigidbody;
import com.codygordon.game.physics.Vector2;
import com.codygordon.game.util.ScreenBorder;

public class PongController {

	private PongView view;
	
	public static final long BALL_RESPAWN_DELAY = 3l;
	
	public PongController(PongView view) {
		this.view = view;
	}
	
	public void respawnBall() {
		try {
			Thread.sleep(BALL_RESPAWN_DELAY * 1000);
			int midX = view.getWidth() / 2 - view.ball.size.x / 2;
			int midY = view.getHeight() / 2 - view.ball.size.y / 2;
			view.ball.location = new Vector2(midX, midY);
			Rigidbody rb = (Rigidbody)view.ball.getComponent(Rigidbody.class);
			rb.velocity = new Vector2(-3, 0);
		}
		catch(Exception e) { }
	}
	
	public void handleBorderHit(int border, GameObject obj) {
		Ball ball = view.ball;
		Rigidbody rb = ball.rigidbody;
		if(obj.name == "Ball") {
			switch(border) {
			case ScreenBorder.TOP:
				System.out.println("Switching screens");
				Game.getInstance().switchScreen(new TestView());
				rb.velocity =  new Vector2(rb.velocity.x, PongView.BALL_SPEED);
				break;
			case ScreenBorder.BOTTOM:
				rb.velocity =  new Vector2(rb.velocity.x, -PongView.BALL_SPEED);
				break;
			case ScreenBorder.LEFT:
				((PongView)Game.getInstance().getGameView()).getController().respawnBall();
				break;
			case ScreenBorder.RIGHT:
				((PongView)Game.getInstance().getGameView()).getController().respawnBall();
				break;
			}
		}
	}
}