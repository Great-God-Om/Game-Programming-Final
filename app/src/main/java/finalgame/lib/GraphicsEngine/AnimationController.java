package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.GL2;

import finalgame.lib.util.Vector2d;

public abstract class AnimationController {
	private Animation[] animations;
	private AnimationStates currentState;
	public void changeState(){

	}

	
	/** 
	 * @param gl
	 * @param pos
	 */
	public void render(GL2 gl, Vector2d pos){
	}
}
