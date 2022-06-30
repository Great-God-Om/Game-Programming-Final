package finalgame.world;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;

import finalgame.lib.Engine.SceneManagement.Scene;
import finalgame.lib.Engine.UIManagement.UIController;
import finalgame.world.Controllers.Enemies.Skeleton.Skeleton;
import finalgame.world.Controllers.Player.Player;
import finalgame.world.UIElements.PlayerHealth;

public class World extends Scene {
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public static final float TILE_SIZE = 1f;
	public static final float ENEMY_SPAWN_CHANCE = 0.01f;
	public static long gameTime = 0;
	public static Player player;

	public void init() {
		Board.generateDungeon();
		constructUIElements(); // TODO: PROBABLY MOVE THIS SOMEWHERE ELSE
		placeEnemies();
		placePlayer();
	}

	private void constructUIElements() {
		UIController.uiElementsToRender.add(new PlayerHealth());
	}

	private static void placePlayer() {
		player = new Player();
		player.position = Board.dungeon.floorTiles.stream().findFirst().get();
		gameObjects.add(player);
	}

	public static void update() {
		for (GameObject object : gameObjects) {
			object.update();
		}
	}

	public static void placeEnemies() {
		Random rand = new Random();
		Board.dungeon.floorTiles.forEach(position -> {
			if (rand.nextFloat() <= ENEMY_SPAWN_CHANCE) {
				Skeleton skel = new Skeleton();
				skel.position = position;
				gameObjects.add(skel);
			}
		});
	}

	/**
	 * @param gl
	 */
	public void render(GL2 gl) {
		Board.render(gl);
		for (GameObject gameObject : gameObjects) {
			gameObject.render(gl);
		}
		UIController.render(gl);
	}
}
