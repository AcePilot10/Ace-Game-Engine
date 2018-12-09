package com.codygordon.game.demos.pipetest.gameobjects;

import java.awt.Color;
import java.awt.Graphics;

import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Rigidbody;

public class Player extends GameObject {
	
	private int jumpPower = 2;
	private Rigidbody rb;

	@Override
	public void onAddComponents() {
		rb = new Rigidbody(this);
		rb.useGravity = true;
		addComponent(rb);
	}
	
	public void jump() {
		rb.velocity.y = -jumpPower;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)location.x,(int)location.y,
				(int)size.x,(int)size.y);
	}
}