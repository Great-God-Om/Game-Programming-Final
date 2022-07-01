package finalgame.world.Scenes;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

import com.jogamp.opengl.GL2;

import finalgame.lib.Engine.SceneManagement.Scene;
import finalgame.lib.Engine.UIManagement.UIController;
import finalgame.lib.util.Vector2d;
import finalgame.world.Board;
import finalgame.world.GameObject;
import finalgame.world.Controllers.Enemies.Enemy;
import finalgame.world.Controllers.Enemies.Skeleton.Skeleton;
import finalgame.world.Controllers.Enemies.Vampire.Vampire;
import finalgame.world.Controllers.Player.Player;
import finalgame.world.Items.HealthPotion;
import finalgame.world.Items.Item;
import finalgame.world.UIElements.PlayerHealth;

public class World extends Scene {
	private static CopyOnWriteArraySet<GameObject> gameObjects = new CopyOnWriteArraySet<GameObject>();
	public static final float TILE_SIZE = 1f;
	public static final float ENEMY_SPAWN_CHANCE = 0.03f;
	public static final float ITEM_SPAWN_CHANCE = 0.007f;
	public static long gameTime = 0;
	public static long level = 1;
	public static Player player;
	public static HashMap<Vector2d, Enemy> enemyPositions = new HashMap<Vector2d, Enemy>(); /*
																							 * TODO: Might be a better
																							 * Way TO DO THIS
																							 */
	public static HashMap<Vector2d, Item> items = new HashMap<Vector2d, Item>();

	public void init() {
		// TODO: ADD MORE ITEMS TO THE WORLD
		constructUIElements(); // TODO: PROBABLY MOVE THIS SOMEWHERE ELSE
		makeNewLevel();
	}

	private void constructUIElements() {
		UIController.uiElementsToRender.add(new PlayerHealth());
	}

	private static void placePlayer() {
		player = new Player();
		player.position = Board.dungeon.floors.stream().findFirst().get().position;
		gameObjects.add(player);
	}

	public static void update() {
		for (GameObject object : gameObjects) {
			if (object instanceof Enemy) {
				enemyPositions.remove(object.position);
				object.update();
				enemyPositions.put(object.position, (Enemy) object);
			} else {
				object.update();
			}
		}
		if (player.position.equals(Board.dungeon.exitPosition)) {
			makeNewLevel();
		}
		if (items.containsKey(player.position)) {
			items.get(player.position).performEffect();
			items.remove(player.position);
		}
	}

	private static void makeNewLevel() {
		gameObjects.clear();
		enemyPositions.clear();
		items.clear();
		Board.generateDungeon();
		placeEnemies();
		placePlayer();
		placeItems();
		level++;
	}

	private static void placeItems() {
		Random rand = new Random();
		Board.dungeon.floors.forEach(floor -> {
			if (rand.nextFloat() < ITEM_SPAWN_CHANCE) {
				Item item = new HealthPotion(); // TODO: WILL CHANGE WHEN MORE ITEMS EXISTS
				item.position = floor.position;
				items.put(floor.position, item);
			}
		});
	}

	public static void placeEnemies() {
		Random rand = new Random();
		Board.dungeon.floors.forEach(floor -> {
			if (rand.nextFloat() <= ENEMY_SPAWN_CHANCE) {
				Enemy enemy;
				if (rand.nextFloat() < 0.5f) { // TODO: WILL IMPLEMENT ENEMY SPAWN CHANCE WHEN MORE ENEMIES EXIST
					enemy = new Skeleton();
				} else {
					enemy = new Vampire();
				}
				enemy.position = floor.position;
				gameObjects.add(enemy);
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
		for (Item item : items.values()) {
			item.render(gl);
		}
		UIController.render(gl);
	}

	
	/** 
	 * @param go
	 */
	public static void removeGameObject(GameObject go) {
		if (go instanceof Enemy) {
			enemyPositions.remove(go.position);
		}
		gameObjects.remove(go);
	}
}
