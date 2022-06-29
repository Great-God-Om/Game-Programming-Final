package finalgame.world.Controllers.Enemies.Skeleton;

import finalgame.lib.GraphicsEngine.Animation;
import finalgame.lib.GraphicsEngine.AnimationState;
import finalgame.lib.Resources.ImageResource;
import finalgame.world.Controllers.Enemies.EnemyAnimationController;

class SKELETON_IDLE_STATE extends AnimationState {
	SKELETON_IDLE_STATE(){
		this.animation = new Animation(new ImageResource[]{
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_1.png"),
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_2.png"),
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_3.png"),
			new ImageResource("Enemies/skeleton/idle/skeleton_v2_4.png"),
	}, true);
	this.animation.rate = 15;
	}
}
public class SkeletonAnimationController extends EnemyAnimationController{
	public SkeletonAnimationController(){
		states[0] = new SKELETON_IDLE_STATE();
		currentState = states[0];
	}
}
