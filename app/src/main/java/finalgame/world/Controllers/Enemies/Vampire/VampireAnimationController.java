package finalgame.world.Controllers.Enemies.Vampire;

import finalgame.world.Controllers.Enemies.EnemyAnimationController;
import finalgame.world.Controllers.Enemies.Vampire.AnimationStates.VampireIdleState;

public class VampireAnimationController extends EnemyAnimationController{
	public VampireAnimationController(){
		states[0] = new VampireIdleState();
		currentState = states[0];
	}
}
