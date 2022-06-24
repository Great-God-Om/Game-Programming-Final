package finalgame.world;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class World {
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public static final int TILE_SIZE = 1;
	public static void init(){
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
		Board.render(gl);
	}
}
