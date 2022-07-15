package finalgame.world.Controllers.Enemies.Slime;

import finalgame.lib.GraphicsEngine.AnimationState;
import finalgame.world.Controllers.Enemies.EnemyAnimationController;
import finalgame.world.Controllers.Enemies.Slime.AnimationStates.SlimeIdleState;

public class SlimeAnimationController extends EnemyAnimationController{

	public SlimeAnimationController(){
		states[0] = new SlimeIdleState();
		currentState = states[0];
	}
	@Override
	public void changeState(AnimationState state) {
		
		
	}
	
}
