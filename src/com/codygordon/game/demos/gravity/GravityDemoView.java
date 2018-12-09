package com.codygordon.game.demos.gravity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.codygordon.game.Game;
import com.codygordon.game.input.EventListener;
import com.codygordon.game.input.events.KeyDownEvent;
import com.codygordon.game.physics.Vector2;
import com.codygordon.game.ui.GameView;

public class GravityDemoView extends GameView {
	
	public static final int BALL_WIDTH = 25, BALL_HEIGHT = 25;
	
	private GravityBall ball;
	
	@Override
	public void onEnable() {
		Game.getInstance().registerEventListener(new EventListener() {
			@Override
			public void onKeyPressed(KeyDownEvent event) {
				int key = event.getKeyEvent().getKeyCode();
				if(key == KeyEvent.VK_SPACE) {
					ball.jump();
				}
			}
		});
	}
	
	@Override
	public void onCreateGameObjects() {
		ball = new GravityBall();
		int midX = Game.getInstance().getWindow().getWidth() / 2;
		ball.location = new Vector2(midX, 0);
		ball.size = new Point(BALL_WIDTH, BALL_HEIGHT);
		createGameObject(ball);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillOval((int)ball.location.x,
				   (int)ball.location.y,
				   (int)ball.size.x,
				   (int)ball.size.y);
	}
}