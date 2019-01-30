package com.codygordon.game.ui;

import java.awt.Graphics;

import com.codygordon.game.gameobjects.camera.Camera;

/**
 * Like a normal GameView but uses a camera to render
 * @author Cody Gordon
 */
public class GameWorldView extends GameView {

	protected Camera camera;
	
	public GameWorldView(int width, int height) {
		camera = new Camera(width, height);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.translate((int)-camera.location.x, (int)-camera.location.y);
	}
}