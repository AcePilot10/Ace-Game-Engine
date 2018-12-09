package com.codygordon.game.demos.pipetest.gameobjects;

import java.awt.Color;
import java.awt.Graphics;

import com.codygordon.game.Game;
import com.codygordon.game.demos.pipetest.PipeTestView;
import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Collider;

public class Pipe extends GameObject {

	public boolean offScreen = false;
	
	@Override
	public void onAddComponents() {
		addComponent(new Collider(this));
	}
	
	@Override
	public void update() {
		location.x -= PipeTestView.speed;
		if(location.x <= -size.x) {
			Game.getInstance().getGameView().destroyGameObject(this);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)location.x, (int)location.y,
				(int)size.x, (int)size.y);
	}
}