package finalgame.world.Controllers.Enemies.Vampire;

import finalgame.world.Controllers.Enemies.Enemy;

public class Vampire extends Enemy{
	public Vampire(){
		this.anim = new VampireAnimationController();
		this.damage = 5;
		this.AttackChance = 0.6f;
	}
}
