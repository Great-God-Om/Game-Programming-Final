package finalgame.world.Controllers.Enemies.Slime.AnimationStates;

import finalgame.lib.Engine.SpriteManagement.Spritesheet;
import finalgame.lib.GraphicsEngine.Animation;
import finalgame.lib.GraphicsEngine.AnimationState;

public class SlimeIdleState extends AnimationState{
	public SlimeIdleState(){
		this.animation = new Animation(new Spritesheet("Enemies/slime/idle/idle.png", 6, 14, 13), true);
		this.animation.rate = 15;
	}
}
