package finalgame.world.Controllers.Enemies.Slime;

import finalgame.world.Controllers.Enemies.Enemy;

public class Slime extends Enemy{
	public Slime(){
		this.anim = new SlimeAnimationController();
		this.AttackChance = 0.3f;
	}
}
