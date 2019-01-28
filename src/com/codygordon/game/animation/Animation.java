package com.codygordon.game.animation;

import java.util.Timer;
import java.util.TimerTask;

import com.codygordon.game.gameobjects.GameObject;

public class Animation extends AnimationBase {
	
	public int frame = 0;
	private Timer timer;
	private long interval;
	private long delay = 0;
	private GameObject gameObject;
	
	public Animation(long interval, GameObject obj) {
		this.interval = interval;
		this.gameObject = obj;
	}
	
	public Animation(long interval, long delay, GameObject obj) {
		this.interval = interval;
		this.delay = delay;
		this.gameObject = obj;
	}
	
	@Override
	public void play() {
		stop();
		startTimer();
	}

	@Override
	public void stop() {
		if(timer != null) 
			timer.cancel();
	}

	@Override
	public void nextFrame() {
		frame++;
	}
	
	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				nextFrame();
			}
		}, delay, interval);
	}
	
	public GameObject getGameObject() {
		return this.gameObject;
	}
}