package finalgame.world;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.Resources.ImageResource;

public class World {
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public static final float TILE_SIZE = 1.5f;
	public static ImageResource image;
	public static void init(){
		image = new ImageResource("1");
		Board.generateDungeon(15);

	}
	public static void update() {
		for (GameObject object : gameObjects) {
			object.update();
		}
	}

	public static void render(GL2 gl) {
		// gameObjects.add(new GameObject());
		// for (GameObject gameObject : gameObjects) {
		// 	gameObject.render(gl);
		// }
		// Board.render(gl);
		Drawing.drawImage(image, 0, 0, new float[]{1,1,1}, gl);
	}
}
