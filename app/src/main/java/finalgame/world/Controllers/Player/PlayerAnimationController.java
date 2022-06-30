package finalgame.world.Controllers.Player;

import finalgame.lib.GraphicsEngine.Animation;
import finalgame.lib.GraphicsEngine.AnimationController;
import finalgame.lib.GraphicsEngine.AnimationState;
import finalgame.lib.Resources.ImageResource;

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
	@Override
	public void changeState(AnimationState state) {
		
	}
}
