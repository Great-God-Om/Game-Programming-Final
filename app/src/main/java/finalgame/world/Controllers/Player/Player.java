package finalgame.world.Controllers.Player;

import java.util.Random;

import com.jogamp.newt.event.KeyEvent;

import finalgame.lib.Engine.SceneManagement.SceneManager;
import finalgame.lib.GraphicsEngine.Camera;
import finalgame.lib.Input.KeyHandler;
import finalgame.lib.util.Vector2d;
import finalgame.world.Board;
import finalgame.world.GameObject;
import finalgame.world.ProceduralGeneration.util.Direction2D;
import finalgame.world.Scenes.GameOver;
import finalgame.world.Scenes.World;

public class Player extends GameObject {
	private long lastMove = System.currentTimeMillis();
	private boolean attacked = false;
	private long lastGametime = -1;
	private final int MOVE_PLAYER_DELAY = 100;
	public int maxHealth = 20;
	public int health = maxHealth;
	private int damage = 5;
	private final float playerAttackChance = 0.7f;

	public Player() {
		anim = new PlayerAnimationController();
	}

	public void update() {
		if (lastGametime != World.gameTime) {
			if ((KeyHandler.getKey(KeyEvent.VK_W) || KeyHandler.getKey(KeyEvent.VK_A)
					|| KeyHandler.getKey(KeyEvent.VK_S) || KeyHandler.getKey(KeyEvent.VK_D))
					&& System.currentTimeMillis() >= lastMove + MOVE_PLAYER_DELAY) {
				System.out.println("Character Moved");
				move();
				lastMove = System.currentTimeMillis();
				lastGametime = World.gameTime++;
			}
			if (KeyHandler.getKey(KeyEvent.VK_F)) {
				attack();
				attacked = true;
			}
			if(attacked && !KeyHandler.getKey(KeyEvent.VK_F)){
				attacked = false;
				lastGametime = World.gameTime++;
			}
			Camera.moveCameraToPosition(this.position.x, this.position.y);
		}
		System.out.println(this.lastGametime);
	}

	/**
	 * @param amount
	 */
	public void damage(int amount) {
		health -= amount;
		if (health <= 0) {
			System.out.println("Player Died\n You got to level: " + World.level);
			World.removeGameObject(this);
			SceneManager.changeScene(new GameOver());
		}

	}

	private void move() {
		float vertical = this.velocity.y, horizontal = this.velocity.x;
		if (KeyHandler.getKey(KeyEvent.VK_W)) {
			vertical = World.TILE_SIZE;
		} else if (KeyHandler.getKey(KeyEvent.VK_D)) {
			horizontal = World.TILE_SIZE;
		} else if (KeyHandler.getKey(KeyEvent.VK_S)) {
			vertical = -World.TILE_SIZE;
		} else if (KeyHandler.getKey(KeyEvent.VK_A)) {
			horizontal = -World.TILE_SIZE;
		}
		this.velocity = new Vector2d(horizontal, vertical);
		var newPosition = Vector2d.add(position, velocity);
		if (!Board.dungeon.wallPositions.contains(newPosition) && !World.enemyPositions.containsKey(newPosition)) {
			this.position = Vector2d.add(position, velocity);
		}
		this.velocity = new Vector2d(0, 0);
	}

	private void attack() {
		for (var direction : Direction2D.eightDirectionsList) {
			var pos = Vector2d.add(position, direction);
			if (World.enemyPositions.containsKey(pos) && new Random().nextFloat() < playerAttackChance) {
				World.enemyPositions.get(pos).damage(damage);
				System.out.println("Player did Damage");
				break;
			}
		}
	}

	/**
	 * @param amount
	 */
	public void heal(int amount) {
		this.health += amount;
		if (this.health > maxHealth) {
			this.health = maxHealth;
		}
	}
}
