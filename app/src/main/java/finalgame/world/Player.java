package finalgame.world;

import com.jogamp.newt.event.KeyEvent;

import finalgame.lib.Engine.GameLoop;
import finalgame.lib.GraphicsEngine.PlayerAnimationController;
import finalgame.lib.Input.KeyHandler;

public class Player extends GameObject {
	private int speed = 1;
	public Player() {
		anim = new PlayerAnimationController();
	}

	public void update() {
		if(KeyHandler.getKey(KeyEvent.VK_W)){
			this.velocity.y = 1;
		} else if (KeyHandler.getKey(KeyEvent.VK_D)){
			this.velocity.x = 1;
		}
		else if (KeyHandler.getKey(KeyEvent.VK_S)){
			this.velocity.y = -1;
		}
		else if (KeyHandler.getKey(KeyEvent.VK_A)){
			this.velocity.x = -1;
		}

		this.position.x += this.velocity.x * speed * GameLoop.deltaTime;
		this.position.y += this.velocity.y * speed * GameLoop.deltaTime;
		this.velocity.x = 0;
		this.velocity.y = 0;

	}

}
