package com.codygordon.game;

import java.util.ArrayList;
import java.util.List;

import com.codygordon.game.interfaces.IUpdateListener;

public class GameLoop implements Runnable {

	private List<IUpdateListener> listeners = new ArrayList<IUpdateListener>();
	
	public static int fps = 0;
	public static double deltaTime = 0;
	
	private boolean running = false;
	
	public static double MAX_FRAMES = 60.0;
	private static final double UPDATE_CAP = 1.0 / MAX_FRAMES;
	
	@Override
	public void run() {
		running = true;
		
		boolean render = false;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double unprocessedTime = 0;
		double frameTime = 0;
		int frames = 0;
		
		while(running) {
			firstTime = System.nanoTime()  / 1000000000.0;
			deltaTime = firstTime - lastTime;
			lastTime = firstTime;
			render = false;
			
			unprocessedTime += deltaTime;
			frameTime += deltaTime;
			
			while(unprocessedTime >= UPDATE_CAP) {
				unprocessedTime -= UPDATE_CAP;
				render = true;
			
				if(frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
				}
			}
			
			if(render) {
				update();
				frames++;
			}
			else {
				try {
					Thread.sleep(1);
				}
				catch(Exception e) { 
					e.printStackTrace();
				}
			}
		}
	}
	
	private void update() {
		try {
			for(IUpdateListener listener : listeners) {
				listener.update();
			} 
		} catch(Exception e) { }
	}
	
	public synchronized void registerListener(IUpdateListener listener) {
		listeners.add(listener);
	}
	
	public synchronized void unRegisterListener(IUpdateListener listener) {
		if(listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}

	public void stop() {
		listeners.clear();
		running = false;
	}
	
	public boolean isRunning() {
		return this.running;
	}
}