package finalgame.world;

import com.jogamp.opengl.GL2;

import finalgame.lib.util.Vector2d;

public abstract class GameObject {
	public Vector2d position;
	public Vector2d velocity;

	public void update() {
	}

	public void render(GL2 gl) {
	}
}
