package finalgame.world.Controllers.Enemies;

import finalgame.lib.GraphicsEngine.AnimationController;
import finalgame.lib.GraphicsEngine.AnimationState;

public class EnemyAnimationController extends AnimationController{

	public EnemyAnimationController(){
		states = new AnimationState[1];
	}
	
	/** 
	 * @param state
	 */
	@Override
	public void changeState(AnimationState state) {
		this.currentState = state;
	}
	
}
