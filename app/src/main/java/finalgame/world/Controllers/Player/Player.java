package finalgame.world.Controllers.Player;

import com.jogamp.newt.event.KeyEvent;

import finalgame.lib.GraphicsEngine.Camera;
import finalgame.lib.Input.KeyHandler;
import finalgame.lib.util.Vector2d;
import finalgame.world.Board;
import finalgame.world.GameObject;
import finalgame.world.World;

// TODO: Add ability for player to attack
// TODO: Add Health UI
public class Player extends GameObject {
	public int health = 20;
	public int maxHealth = 20;

	public Player() {
		anim = new PlayerAnimationController();
	}

	public void update() {
		move();
	}
	public void damage(int amount){
		health -= amount;
		if(health <= 0){
			System.out.println("Player Died");
		}
		System.out.println(health/maxHealth);
	}
	// TODO: MAKE IT TO WHERE THE PLAYER CAN'T STAND ON TOP OF ENEMIES
	private void move(){
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
		if ((!KeyHandler.getKey(KeyEvent.VK_W) && !KeyHandler.getKey(KeyEvent.VK_D) && !KeyHandler.getKey(KeyEvent.VK_S)
				&& !KeyHandler.getKey(KeyEvent.VK_A)) && !this.velocity.equals(Vector2d.ZERO)) {
			var newPosition = Vector2d.add(position, velocity);
			if (!Board.dungeon.wallPositions.contains(newPosition)) {
				this.position = Vector2d.add(position, velocity);
				World.gameTime++;
			}
			this.velocity = new Vector2d(0, 0);
		}
		Camera.moveCameraToPosition(this.position.x, this.position.y);
	}

}
