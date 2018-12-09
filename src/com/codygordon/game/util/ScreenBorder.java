package com.codygordon.game.util;

import java.awt.Point;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Collider;
import com.codygordon.game.physics.Vector2;
import com.codygordon.game.ui.GameView;

public class ScreenBorder {

	public static final int TOP = 1;
	public static final int BOTTOM = 2;
	public static final int RIGHT = 3;
	public static final int LEFT = 4;

	private ScreenBorderObject borderTop, borderBottom,
					   borderLeft, borderRight;
	private int sizePadding;
	private BorderDelegate delegate;
	private GameView view;
	
	public ScreenBorder(int size, BorderDelegate delegate, GameView view) {
		this.sizePadding = size;
		this.delegate = delegate;
		this.view = view;
		initBorder();
	}
	
	private void initBorder() {
		borderTop = new ScreenBorderObject(this);
		borderBottom = new ScreenBorderObject(this);
		borderLeft = new ScreenBorderObject(this);
		borderRight = new ScreenBorderObject(this);
		
		int frameWidth = Game.getInstance().getWindow().getWidth();
		int frameHeight = Game.getInstance().getWindow().getHeight();
		
		int framePadding = 44;
		
		int midX = frameWidth / 2;
		int midY = frameHeight / 2;
		
		borderTop.size = new Point(frameWidth, sizePadding);
		borderTop.location = new Vector2(midX - (frameWidth / 2), 0);
		borderTop.name = "Col Top";
		
		borderBottom.size = new Point(frameWidth, sizePadding);
		borderBottom.location = new Vector2(midX - (frameWidth / 2), frameHeight - framePadding);
		borderBottom.name = "Col Bottom";

		borderLeft.size = new Point(sizePadding, frameHeight);
		borderLeft.location = new Vector2(0, midY - (frameHeight / 2));
		borderLeft.name = "Col Left";
		
		borderRight.size = new Point(sizePadding, frameHeight);
		borderRight.location = new Vector2(frameWidth - framePadding + 25, midY - (frameHeight / 2));
		borderRight.name = "Col Right";
		
		((Collider)borderTop.getComponent(Collider.class)).autoResize();
		((Collider)borderBottom.getComponent(Collider.class)).autoResize();
		((Collider)borderLeft.getComponent(Collider.class)).autoResize();
		((Collider)borderRight.getComponent(Collider.class)).autoResize();
		
		GameObject[] objs = new GameObject[] { borderTop, borderBottom, borderLeft, borderRight };
		for(GameObject obj : objs) {
			view.createGameObject(obj);
		}
	}
	
	public interface BorderDelegate {
		public void BorderHit(int border, GameObject col);
	}
	
	public void onBorderHit(int border, GameObject col) {
		delegate.BorderHit(border, col);
	}
	
	public ScreenBorderObject[] getBorders() {
		return new ScreenBorderObject[] { borderTop, borderBottom, borderLeft, borderRight };
	}
	
	public class ScreenBorderObject extends GameObject {
		
		private ScreenBorder border;
		
		public ScreenBorderObject(ScreenBorder border) {
			super();
			this.border = border;
		}
		
		@Override
		public void onAddComponents() {
			addComponent(new Collider(this));
		}	
		
		@Override
		public void onCollision(GameObject obj) {
			if(obj instanceof ScreenBorderObject) return;
			switch(name) {
			case "Col Top":
				border.onBorderHit(ScreenBorder.TOP, obj);
				break;
			case "Col Bottom":
				border.onBorderHit(ScreenBorder.BOTTOM, obj);
				break;
			case "Col Left":
				border.onBorderHit(ScreenBorder.LEFT, obj);
				break;
			case "Col Right":
				border.onBorderHit(ScreenBorder.RIGHT, obj);
				break;
			}
		}
	}
}