package finalgame.world.Controllers.Enemies.Skeleton.AnimationStates;

import finalgame.lib.GraphicsEngine.Animation;
import finalgame.lib.GraphicsEngine.AnimationState;
import finalgame.lib.Resources.ImageResource;

// TODO: DON'T HAVE ASSET FOR THIS RIGHT NOW WILL MAKE MAYBE LATER
public class SkeletonAttackingState extends AnimationState {
	public SkeletonAttackingState() {
		this.animation = new Animation(new ImageResource[] {
		}, false);
		this.animation.rate = 15;
	}
}
