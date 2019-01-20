package com.codygordon.game.demos.audio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.codygordon.game.audio.AudioPlayer;
import com.codygordon.game.ui.GameView;

public class AudioDemoView extends GameView {

	private AudioPlayer audioPlayer;
	
	@Override
	public void onCreate() {
		audioPlayer = new AudioPlayer();
		audioPlayer.setAudioClip("demo_audio.wav");
		super.onCreate();
	}
	
	@Override
	public void onCreateGameObjects() {
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playAudio();
			}
		});
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stopAudio();
			}
		});
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseAudio();
			}
		});
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restartAudio();
			}
		});
		
		JButton btnSetLoopTrue= new JButton("Enable Looping");
		btnSetLoopTrue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audioPlayer.loop = true;
			}
		});
		
		JButton btnSetLoopFalse = new JButton("Disable Looping");
		btnSetLoopFalse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audioPlayer.loop = false;
			}
		});
		
		add(btnPlay);
		add(btnStop);
		add(btnPause);
		add(btnRestart);
		add(btnSetLoopTrue);
		add(btnSetLoopFalse);
	}
	
	private void playAudio() {
		audioPlayer.play();
	}
	
	private void stopAudio() {
		audioPlayer.stop();
	}
	
	private void pauseAudio() {
		audioPlayer.pause();
	}
	
	private void restartAudio() {
		audioPlayer.restart();
	}
}