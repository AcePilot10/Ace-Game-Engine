package com.codygordon.game.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

	private Long currentFrame;
	private Clip clip;
	
	private AudioStatus status = AudioStatus.NOT_PLAYING;
	
	private AudioInputStream audioInputStream;
	private String filePath;
	
	public boolean loop = false;

	public AudioPlayer() { }
	
	public AudioPlayer(String fileName) {
		try {
			this.filePath = "assets/" + fileName;
			File file = new File(filePath);
			System.out.println("Checking path: " + filePath);
			audioInputStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			System.out.println("There was an error initializing audio player: " + e.getMessage());
		}
	}

	public void setAudioClip(String fileName) {
		try {
			this.filePath = "assets/" + fileName;
			File file = new File(filePath);
			System.out.println("Checking path: " + filePath);
			audioInputStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (Exception e) {
			System.out.println("There was an error setting the audio clip: " + e.getMessage());
		}
	}
	
	public void play() {
		if(loop) {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} else {
			clip.start();
		}
		status = AudioStatus.PLAYING;
	}

	public void pause() {
		if (status == AudioStatus.PAUSED) {
			System.out.println("audio is already paused");
			return;
		}
		this.currentFrame = this.clip.getMicrosecondPosition();
		clip.stop();
		status = AudioStatus.PAUSED;
	}

	public void resumeAudio() {
		if (status == AudioStatus.PLAYING) {
			System.out.println("Audio is already " + "being played");
			return;
		}
		try {
			clip.close();
			resetAudioStream();
			clip.setMicrosecondPosition(currentFrame);
			play();
		} catch (Exception e) {
			System.out.println("There was an error resuming audio clip: " + e.getMessage());
		}
	}

	public void restart() {
		try {
			clip.stop();
			clip.close();
			resetAudioStream();
			currentFrame = 0L;
			clip.setMicrosecondPosition(0);
			play();
		} catch (Exception e) {
			System.out.println("There was an error restarting the audio clip: " + e.getMessage());
		}
	}

	public void stop() {
		currentFrame = 0L;
		clip.stop();
		clip.close();
		status = AudioStatus.NOT_PLAYING;
	}

	public void jump(long c) {
		try {
			if (c > 0 && c < clip.getMicrosecondLength()) {
				clip.stop();
				clip.close();
				resetAudioStream();
				currentFrame = c;
				clip.setMicrosecondPosition(c);
				this.play();
			}
		} catch (Exception e) {
			System.out.println("Error jumping into audio clip: " + e.getMessage());
		}
	}

	public void resetAudioStream() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
			clip.open(audioInputStream);
		} catch (Exception e) {
			System.out.println("Error resetting audio stream: " + e.getMessage());
		}
	}
	
	public Clip getAudioClip() {
		return this.clip;
	}
}