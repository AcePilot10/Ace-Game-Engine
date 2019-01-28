package com.codygordon.game.gameobjects.components;

import com.codygordon.game.animation.Animation;
import com.codygordon.game.gameobjects.GameObject;

public class Animator extends Component {

	public Animation animation;
	
	public Animator(GameObject obj) {
		super(obj);
	}
}