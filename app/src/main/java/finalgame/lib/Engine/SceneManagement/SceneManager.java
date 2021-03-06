package finalgame.lib.Engine.SceneManagement;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Camera;
import finalgame.world.Scenes.World;

/**
 * SceneManageger
 */
public class SceneManager {
	private static final Scene startScene = new World();
	public static Scene currentScene;
	
	public static void init(){
		currentScene = startScene;
		currentScene.init();
	}
	
	/** 
	 * @param scene
	 */
	public static void changeScene(Scene scene){
		currentScene = scene;
		Camera.moveCameraToPosition(0, 0);
	}
	
	/** 
	 * @param gl
	 */
	public static void render(GL2 gl) {
		currentScene.render(gl);
	}
}