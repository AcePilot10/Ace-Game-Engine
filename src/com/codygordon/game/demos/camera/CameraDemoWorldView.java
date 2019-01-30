package com.codygordon.game.demos.camera;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.codygordon.game.assets.AssetLoader;
import com.codygordon.game.input.events.KeyDownEvent;
import com.codygordon.game.physics.Vector2;
import com.codygordon.game.ui.GameWorldView;

public class CameraDemoWorldView extends GameWorldView {

	private float camX, camY;
	private int speed = 5;
	private BufferedImage imgMap;
	
	public CameraDemoWorldView(int width, int height) {
		super(width, height);
		imgMap = AssetLoader.getSprite("map.png");
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgMap, 0, 0, imgMap.getWidth(),
				imgMap.getHeight(), null);
		camera.location = new Vector2(camX, camY);
	}

	@Override
	public void onKeyPressed(KeyDownEvent event) {
		super.onKeyPressed(event);
		int code = event.getKeyEvent().getKeyCode();
		if(code == KeyEvent.VK_UP) {
			camY -= speed;
		} else if(code == KeyEvent.VK_DOWN) {
			camY += speed;
		} else if(code == KeyEvent.VK_LEFT) {
			camX -= speed;
		} else if(code == KeyEvent.VK_RIGHT) {
			camX += speed;
		}
	}	
}