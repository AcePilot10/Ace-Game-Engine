package com.codygordon.game.demos.animation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.codygordon.game.Game;
import com.codygordon.game.assets.AssetLoader;
import com.codygordon.game.physics.Vector2;
import com.codygordon.game.ui.GameView;

public class BirdGameView extends GameView {

	public static final int BACKGROUND_WIDTH = 1500;
	public static final int BACKGROUND_HEIGHT = 415;
	
	private BufferedImage backgroundImage;
	private Bird bird;
	
	@Override
	public void onEnable() {
		backgroundImage = AssetLoader.getSprite("background.png", 
				BACKGROUND_WIDTH,
				BACKGROUND_HEIGHT);
		super.onEnable();
	}

	@Override
	public void onCreateGameObjects() {
		super.onCreateGameObjects();
		bird = new Bird();
		int padding = 30;
		float midX = Game.getInstance().getWindow().getWidth() / 2;
		float midY = Game.getInstance().getWindow().getHeight() / 2;
		bird.location = new Vector2(midX - padding,
									midY - padding);
		createGameObject(bird);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
		bird.paint(g);
	}
}