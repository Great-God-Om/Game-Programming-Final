package finalgame.world;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class World {
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public static final float TILE_SIZE = 1f;
	public static long gameTime = 0;
	public static void init(){
		Board.generateDungeon();
		gameObjects.add(new Player());
	}
	public static void update() {
		for (GameObject object : gameObjects) {
			object.update();
		}
	}
	
	public static void render(GL2 gl) {
		Board.render(gl);
		for (GameObject gameObject : gameObjects) {
			gameObject.render(gl);
		}
	}
}
