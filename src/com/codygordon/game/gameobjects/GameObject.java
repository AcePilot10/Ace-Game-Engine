package com.codygordon.game.gameobjects;

import java.awt.Point;
import java.util.ArrayList;

import com.codygordon.game.Game;
import com.codygordon.game.gameobjects.components.Component;
import com.codygordon.game.physics.Vector2;

public class GameObject extends BaseGameObject {

	public Vector2 location;
	public Point size;
	public ArrayList<Component> components;
	public String name;
	
	public GameObject() {
		init();
	}
	
	protected void init() {
		location = new Vector2(0, 0);
		size = new Point();
		components =  new ArrayList<Component>();
		onEnable();
		onAddComponents(); 
	}
	
	public <T extends Component> Component getComponent(Class<T> componentClass) {
		for(Component component : components) {
			if(component.getClass() == componentClass) {
				return componentClass.cast(component);
			}
		}
		return null;
	}
	
	public void addComponent(Component component) {
		components.add(component);
		Game.getInstance().registerUpdateListener(component);
	}
}