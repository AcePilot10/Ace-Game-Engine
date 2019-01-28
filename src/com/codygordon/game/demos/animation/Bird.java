package com.codygordon.game.demos.animation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.codygordon.game.gameobjects.GameObject;
import com.codygordon.game.gameobjects.components.Animator;

public class Bird extends GameObject {

	public static final long INTERVAL = 75;
	
	public BufferedImage sprite;

	@Override
	public void onAddComponents() {
		Animator animator = new Animator(this);
		animator.animation = new BirdFlapAnimation(INTERVAL, this);
		addComponent(animator);
		animator.animation.play();
		super.onAddComponents();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(sprite, (int)location.x, (int)location.y, null);
		super.paint(g);
	}	
}