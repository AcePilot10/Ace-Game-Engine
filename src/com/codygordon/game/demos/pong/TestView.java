package com.codygordon.game.demos.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.codygordon.game.Game;
import com.codygordon.game.ui.GameView;

public class TestView extends GameView {

	@Override
	public void onEnable() {
		JButton btn = new JButton("Play");
		add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().switchScreen(new PongView());
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.drawRect(50, 50, 100, 100);
	}
}