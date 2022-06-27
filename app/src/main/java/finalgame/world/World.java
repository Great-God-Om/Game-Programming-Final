package finalgame.world;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

import finalgame.lib.Resources.ImageResource;

public class World {
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public static final float TILE_SIZE = 3f;
	public static ImageResource image;
	public static void init(){
		image = new ImageResource("1");
		Board.generateDungeon(15);
		gameObjects.add(new Player());
	}
	public static void update() {
		for (GameObject object : gameObjects) {
			object.update();
		}
	}

	public static void render(GL2 gl) {
		// gameObjects.add(new GameObject());
		for (GameObject gameObject : gameObjects) {
			gameObject.render(gl);
		}
		// Board.render(gl);
	}
}
