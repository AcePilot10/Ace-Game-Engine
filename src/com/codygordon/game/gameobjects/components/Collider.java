package com.codygordon.game.gameobjects.components;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.ui.GameView;

public class Collider extends Component {

	public Rectangle rect;
	public ArrayList<String> ignoredObjects = new ArrayList<String>();
	
	public Collider(GameObject obj) {
		super(obj);
		rect = new Rectangle(gameObject.size);
	}
	
	@Override
	public void update() {
		updatePosition();
		checkCollision();
	}
	
	private void updatePosition() {
		rect.setLocation(new Point((int)gameObject.location.x, (int)gameObject.location.y));
	}
	
	protected void checkCollision() {
		try {
			GameView view = Game.getInstance().getGameView();
			for(GameObject obj : view.getGameObjects()) {
				if(obj == gameObject) return;
				if(obj.getComponent(Collider.class) != null) {
					Collider col = (Collider) obj.getComponent(Collider.class);
					if(col.gameObject == gameObject) return;
					if(ignoredObjects.contains(col.gameObject.name)) return;
					if(col.rect.intersects(rect)) {
						executeCollisionWithObject(obj, col);
					}
				}
			}
		}
		catch(ConcurrentModificationException e) {
			//e.printStackTrace();
		}
	}
	
	protected void executeCollisionWithObject(GameObject obj, Collider col) {
		gameObject.onCollision(col.gameObject);
		col.gameObject.onCollision(gameObject);
	}

	public void autoResize() {
		rect.setSize(gameObject.size.x, gameObject.size.y);
	}
}