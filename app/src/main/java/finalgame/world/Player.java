package finalgame.world;

import finalgame.lib.GraphicsEngine.PlayerAnimationController;

public class Player extends GameObject {
	public Player() {
		anim = new PlayerAnimationController();
	}

	public void update() {
		// if (KeyHandler.getKey(KeyEvent.VK_W)) {
		// 	this.velocity.y = World.TILE_SIZE;
		// } else if (KeyHandler.getKey(KeyEvent.VK_D)) {
		// 	this.velocity.x = World.TILE_SIZE;
		// } else if (KeyHandler.getKey(KeyEvent.VK_S)) {
		// 	this.velocity.y = -World.TILE_SIZE;
		// } else if (KeyHandler.getKey(KeyEvent.VK_A)) {
		// 	this.velocity.x = -World.TILE_SIZE;
		// }
		// if ((!KeyHandler.getKey(KeyEvent.VK_W) && !KeyHandler.getKey(KeyEvent.VK_D) && !KeyHandler.getKey(KeyEvent.VK_S)
		// 		&& !KeyHandler.getKey(KeyEvent.VK_A))) {
		// 	this.position.x += this.velocity.x;
		// 	this.position.y += this.velocity.y;
		//	this.velocity = new Vector2d(0, 0);
		// 	Camera.moveCameraToPosition(this.position.x, this.position.y);
		// }

	}

}
