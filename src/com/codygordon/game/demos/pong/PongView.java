package com.codygordon.game.demos.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.codygordon.game.demos.pong.gameobjects.Ball;
import com.codygordon.game.demos.pong.gameobjects.Paddle;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Collider;
import com.codygordon.game.input.events.KeyDownEvent;
import com.codygordon.game.physics.Vector2;
import com.codygordon.game.settings.Settings;
import com.codygordon.game.ui.GameView;
import com.codygordon.game.util.ScreenBorder;
import com.codygordon.game.util.ScreenBorder.BorderDelegate;
import com.codygordon.game.util.ScreenBorder.ScreenBorderObject;

public class PongView extends GameView {
	 
	public Ball ball;
	public Paddle paddle1, paddle2;
	
	private PongController controller;
	private ScreenBorder border;
	
	private PongEventListener listener;
	
	public static int BALL_SPEED = 2;
	
	@Override
	public void onEnable() {
		setFocusable(true);
		requestFocus();
		controller = new PongController(this);
		listener = new PongEventListener();
		GetKeyListener().registerListener(listener);
	}
	
	@Override
	public void onCreateGameObjects() {
		border = new ScreenBorder(5, new BorderDelegate() {
			@Override
			public void BorderHit(int border, GameObject col) {
				controller.handleBorderHit(border, col);
			}
		}, this);

		int paddleWidth = 25;
		int paddleHeight = 150;
		int frameWidth = Integer.parseInt(Settings.getInstance().getSetting("FRAME_WIDTH"));
		int frameHeight = Integer.parseInt(Settings.getInstance().getSetting("FRAME_HEIGHT"));
		
		ball = (Ball)createGameObject(new Ball());
		paddle1 = (Paddle)createGameObject(new Paddle());
		paddle2 = (Paddle)createGameObject(new Paddle());
		
		ball.size = new Point(50, 50);
		ball.location = new Vector2(frameWidth / 2, frameHeight / 2);
		ball.name = "Ball";
		
		System.out.println("Ball has been created");
		
		paddle1.paddleNumber = 1;
		paddle2.paddleNumber = 2;
		
		paddle1.size = new Point(paddleWidth, paddleHeight);
		paddle2.size = new Point(paddleWidth, paddleHeight);
		
		int p1x = (paddleWidth) - (paddleWidth);
		int p1y = frameHeight / 2 - paddleHeight / 2;
		
		int p2x = frameWidth - paddleWidth - 18;
		int p2y = p1y;
		
		paddle1.location = new Vector2(p1x, p1y);
		paddle2.location = new Vector2(p2x, p2y);
		
		((Collider)ball.getComponent(Collider.class)).autoResize();
		((Collider)paddle1.getComponent(Collider.class)).autoResize();
		((Collider)paddle2.getComponent(Collider.class)).autoResize();
	
		ball.rigidbody.velocity = new Vector2(-BALL_SPEED, 0);
		ball.rigidbody.useGravity = false;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLACK);
		g.fillOval((int)ball.location.x,
				   (int)ball.location.y,
				   (int)ball.size.x,
				   (int)ball.size.y);
		
		g.setColor(Color.BLUE);
		
		g.fillRect((int)paddle1.location.x,
				   (int)paddle1.location.y,
				   (int)paddle1.size.x,
				   (int)paddle1.size.y);
		
		g.fillRect((int)paddle2.location.x,
				   (int)paddle2.location.y,
				   (int)paddle2.size.x,
				   (int)paddle2.size.y);
		
		g.setColor(Color.GRAY);
		
		for(ScreenBorderObject obj : border.getBorders()) {
			g.fillRect((int)obj.location.x,
					   (int)obj.location.y,
					   (int)obj.size.x,
					   obj.size.y);
		}
		
		g.setColor(Color.darkGray);
		g.drawRect((int)paddle1.location.x,
				   (int)paddle1.location.y,
				   15, 15);
	}

	@Override
	public void onKeyPressed(KeyDownEvent e) {
		System.out.println("Detected event!");
	}
	
	public PongController getController() { 
		return this.controller; 
	}

	public PongEventListener getListener() {
		return this.listener;
	}
}