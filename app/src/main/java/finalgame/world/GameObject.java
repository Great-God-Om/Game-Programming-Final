package finalgame.world;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.AnimationController;
import finalgame.lib.util.Vector2d;

public abstract class GameObject {
	public Vector2d position = new Vector2d(0, 0);
	public Vector2d velocity = new Vector2d(0, 0);
	public AnimationController anim;
	public void update() {
	}

	
	/** 
	 * @param gl
	 */
	public void render(GL2 gl) {
		anim.render(gl, position);
	}
}
