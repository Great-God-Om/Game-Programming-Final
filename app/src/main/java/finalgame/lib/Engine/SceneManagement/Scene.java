package finalgame.lib.Engine.SceneManagement;

import com.jogamp.opengl.GL2;

public abstract class Scene {
	public abstract void render(GL2 gl);

	public abstract void init();

}
