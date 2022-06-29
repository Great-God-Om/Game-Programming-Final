package finalgame.world.Controllers;

import com.jogamp.newt.event.KeyEvent;

import finalgame.lib.GraphicsEngine.Camera;
import finalgame.lib.Input.KeyHandler;
import finalgame.lib.util.Vector2d;
import finalgame.world.Board;
import finalgame.world.GameObject;
import finalgame.world.World;

public class Player extends GameObject {
	public Player() {
		anim = new PlayerAnimationController();
	}

	public void update() {
		move();

	}

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
				&& !KeyHandler.getKey(KeyEvent.VK_A))) {
			var newPosition = Vector2d.add(position, velocity);
			if (!Board.dungeon.wallTiles.contains(newPosition)) {
				this.position = Vector2d.add(position, velocity);
			}
			this.velocity = new Vector2d(0, 0);
			Camera.moveCameraToPosition(this.position.x, this.position.y);
		}
	}

}
