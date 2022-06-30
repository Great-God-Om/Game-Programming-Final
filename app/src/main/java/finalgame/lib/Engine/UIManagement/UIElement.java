package finalgame.lib.Engine.UIManagement;

import com.jogamp.opengl.GL2;

import finalgame.lib.util.Vector2d;

public abstract class UIElement {
	public Vector2d position = new Vector2d(0, 0);
	public abstract void render(GL2 gl);
}
