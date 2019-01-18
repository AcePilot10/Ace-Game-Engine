package com.codygordon.game.demos.pipetest;

import java.awt.Point;
import java.awt.event.KeyEvent;

import com.codygordon.game.Game;
import com.codygordon.game.demos.pipetest.gameobjects.Pipe;
import com.codygordon.game.demos.pipetest.gameobjects.Player;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Collider;
import com.codygordon.game.input.EventListener;
import com.codygordon.game.input.events.KeyDownEvent;
import com.codygordon.game.physics.Vector2;
import com.codygordon.game.ui.GameView;
import com.codygordon.game.util.ScreenBorder;
import com.codygordon.game.util.ScreenBorder.BorderDelegate;

public class PipeTestView extends GameView {

	private final int startingPipes = 6;
	private final int pipeXMargin = 250;
	private final int pipeWidth = 45;
	private final int pipeHeight = 380;
	private final int pipeYMargin = 45;
	private final int minMid = -100;
	private final int maxMid = 100;

	private final int PLAYER_WIDTH = 50;
	private final int PLAYER_HEIGHT = 50;
	private final int PLAYER_SPAWN_X = 250;
	private final int PLAYER_SPAWN_Y = 150;
	
	public static final int speed = 2;
	
	private static int spawnX;
	
	private Player player;
	
	@Override
	public void onEnable() {
		screenBorder = new ScreenBorder(5, new BorderDelegate() {			
			@Override
			public void BorderHit(int border, GameObject col) {
				onBorderHit(border, col);
			}
		}, this);
		
//		Game.getInstance().registerEventListener(new EventListener() {
//			@Override
//			public void onKeyPressed(KeyDownEvent event) {
//				int key = event.getKeyEvent().getKeyCode();
//				if(key == KeyEvent.VK_SPACE) {
//					player.jump();
//				}
//			}
//		});
	}

	@Override
	public void onCreateGameObjects() {
		player = new Player();
		player.location = new Vector2(PLAYER_SPAWN_X, PLAYER_SPAWN_Y);
		player.size = new Point(PLAYER_WIDTH, PLAYER_HEIGHT);
		createGameObject(player);
		
		int initialPipeX = pipeXMargin * 2;
		for(int i = 0; i < startingPipes; i++) {
			addNewPipes(initialPipeX);
			initialPipeX += pipeXMargin;
		}
		spawnX = initialPipeX - pipeXMargin * 2;
	}
	
	public void addNewPipes(int x) {		
		Pipe pipeTop = new Pipe();
		Pipe pipeBottom = new Pipe();
		
		pipeTop.size = new Point(pipeWidth, pipeHeight);
		pipeBottom.size = new Point(pipeWidth, pipeHeight);
		
		pipeTop.name = "Pipe Top";
		
		int midY = (int) (Math.random() * (maxMid - minMid)) + minMid;
		int topY = midY - (pipeYMargin + (pipeHeight / 2));
		int bottomY = midY + (pipeYMargin + (pipeHeight / 2));
		
		pipeTop.location = new Vector2(x, topY);
		pipeBottom.location = new Vector2(x, bottomY);
		
		createGameObject(pipeTop);
		createGameObject(pipeBottom);
		
		((Collider)pipeTop.getComponent(Collider.class)).autoResize();
		((Collider)pipeBottom.getComponent(Collider.class)).autoResize();
		
		gameObjects.add(pipeTop);
		gameObjects.add(pipeBottom);
	}
	
	private void onBorderHit(int border, GameObject col) {
		if(border == ScreenBorder.LEFT) {
			if(col instanceof Pipe) {
				if(col.name == "Pipe Top") {
					Pipe pipe = (Pipe)col;
					if(!pipe.offScreen) {
						addNewPipes(spawnX);
						pipe.offScreen = true;
					}
				}
			}
		}
	}
}