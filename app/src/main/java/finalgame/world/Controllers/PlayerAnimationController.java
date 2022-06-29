package finalgame.world.Controllers;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Animation;
import finalgame.lib.GraphicsEngine.AnimationController;
import finalgame.lib.GraphicsEngine.AnimationState;
import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;

class IDLESTATE extends AnimationState {
	IDLESTATE() {
		this.animation = new Animation(new ImageResource[] {
				new ImageResource("Player/Idle/player_idle_1.png"),
				new ImageResource("Player/Idle/player_idle_2.png"),
				new ImageResource("Player/Idle/player_idle_3.png"),
				new ImageResource("Player/Idle/player_idle_4.png"),
				new ImageResource("Player/Idle/player_idle_5.png"),
				new ImageResource("Player/Idle/player_idle_6.png"),
				new ImageResource("Player/Idle/player_idle_7.png"),
				new ImageResource("Player/Idle/player_idle_8.png"),
		}, true);
		this.animation.rate = 20;
	}

}

public class PlayerAnimationController extends AnimationController {
	public PlayerAnimationController() {
		states = new AnimationState[1];
		states[0] = new IDLESTATE();
		currentState = states[0];
	}

	public void changeState() {

	}

	/**
	 * @param gl
	 * @param pos
	 */
	public void render(GL2 gl, Vector2d pos) {
		currentState.animation.play();
		Drawing.drawImage(currentState.animation.getImage(), pos.x, pos.y, new float[] { 1, 1, 1 }, gl);
	}
}
