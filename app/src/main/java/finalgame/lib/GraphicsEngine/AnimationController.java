package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.GL2;

import finalgame.lib.util.Vector2d;

public abstract class AnimationController {
	protected AnimationState[] states;
	protected AnimationState currentState;

	public abstract void changeState();

	/**
	 * @param gl
	 * @param pos
	 */
	public void render(GL2 gl, Vector2d pos) {
		currentState.animation.play();
		Drawing.drawImage(currentState.animation.getImage(), pos.x, pos.y, new float[] { 1, 1, 1 }, gl);
	}
}
