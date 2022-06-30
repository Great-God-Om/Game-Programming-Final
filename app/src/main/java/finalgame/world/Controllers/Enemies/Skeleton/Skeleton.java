package finalgame.world.Controllers.Enemies.Skeleton;

import finalgame.world.Controllers.Enemies.Enemy;

public class Skeleton extends Enemy{
	public Skeleton(){
		this.anim = new SkeletonAnimationController();
		this.AttackChance = 0.5f;
	}
}
