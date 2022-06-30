package finalgame.world.Controllers.Enemies.Skeleton.AnimationStates;

import finalgame.lib.GraphicsEngine.Animation;
import finalgame.lib.GraphicsEngine.AnimationState;
import finalgame.lib.Resources.ImageResource;

public class SkeletonIdleState extends AnimationState {
	public SkeletonIdleState(){
		this.animation = new Animation(new ImageResource[]{
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_1.png"),
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_2.png"),
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_3.png"),
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_4.png"),
	}, true);
	this.animation.rate = 15;
	}
}
