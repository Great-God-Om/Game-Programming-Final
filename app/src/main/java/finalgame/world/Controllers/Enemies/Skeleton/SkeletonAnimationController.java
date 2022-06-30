package finalgame.world.Controllers.Enemies.Skeleton;

import finalgame.world.Controllers.Enemies.EnemyAnimationController;
import finalgame.world.Controllers.Enemies.Skeleton.AnimationStates.SkeletonIdleState;

public class SkeletonAnimationController extends EnemyAnimationController{
	public SkeletonAnimationController(){
		states[0] = new SkeletonIdleState();
		currentState = states[0];
	}
}
