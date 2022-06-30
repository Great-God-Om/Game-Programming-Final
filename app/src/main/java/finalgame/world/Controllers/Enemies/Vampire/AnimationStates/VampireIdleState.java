package finalgame.world.Controllers.Enemies.Vampire.AnimationStates;

import finalgame.lib.GraphicsEngine.Animation;
import finalgame.lib.GraphicsEngine.AnimationState;
import finalgame.lib.Resources.ImageResource;

public class VampireIdleState extends AnimationState {
	public VampireIdleState() {
		this.animation = new Animation(new ImageResource[] {
				new ImageResource("Enemies/vampire/idle/vampire_idle_1.png"),
				new ImageResource("Enemies/vampire/idle/vampire_idle_2.png"),
				new ImageResource("Enemies/vampire/idle/vampire_idle_3.png"),
				new ImageResource("Enemies/vampire/idle/vampire_idle_4.png"),
		}, true);
		this.animation.rate = 15;

	}
}
