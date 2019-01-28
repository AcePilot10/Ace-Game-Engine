package com.codygordon.game.demos.animation;

import java.awt.image.BufferedImage;

import com.codygordon.game.animation.Animation;
import com.codygordon.game.assets.AssetLoader;
import com.codygordon.game.gameobjects.GameObject;

public class BirdFlapAnimation extends Animation {

	private BufferedImage spriteUp;
	private BufferedImage spriteMid;
	private BufferedImage spriteDown;
	
	private Bird bird;
	
	public BirdFlapAnimation(long interval, GameObject obj) {
		super(interval, obj);
		loadSprites();
		bird = (Bird)getGameObject();
	}
	
	private void loadSprites() {
		spriteUp = AssetLoader.getSprite("yellowbird-upflap.png");
		spriteDown = AssetLoader.getSprite("yellowbird-downflap.png");
		spriteMid = AssetLoader.getSprite("yellowbird-midflap.png");
	}

	@Override
	public void nextFrame() {
		if(frame == 3) {
			frame = 1;
		} else {
			frame++;
		}
		updateSprite();
	}	
	
	private void updateSprite() {
		switch(frame) {
		case 1:
			bird.sprite = spriteUp;
			break;
		case 2:
			bird.sprite = spriteMid;
			break;
		case 3:
			bird.sprite = spriteDown;
			break;
		}
	}
}