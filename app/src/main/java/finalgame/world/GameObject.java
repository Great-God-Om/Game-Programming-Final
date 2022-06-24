package finalgame.world;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.util.Vector2d;

public class GameObject {
	public Vector2d position;
	public Vector2d velocity;

	public void update() {
	}

	public void render(GL2 gl) {
		Drawing.drawRect(0, 0, new float[] {0, 1, 1},gl);
	}
}
