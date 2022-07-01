package finalgame.world.Scenes;

import com.jogamp.opengl.GL2;

import finalgame.lib.Engine.SceneManagement.Scene;
import finalgame.lib.GraphicsEngine.Camera;
import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.GraphicsEngine.Renderer;
import finalgame.lib.Resources.ImageResource;

public class GameOver extends Scene{

	@Override
	public void render(GL2 gl) {
		Drawing.drawImage(new ImageResource("game_over.jpg"), -Renderer.w_units + Camera.position.x, -Renderer.h_units + Camera.position.y, Renderer.w_units * 2, Renderer.h_units * 2, new float[]{1,1,1}, gl);
	}

	@Override
	public void init() {
		
	}
	
}
