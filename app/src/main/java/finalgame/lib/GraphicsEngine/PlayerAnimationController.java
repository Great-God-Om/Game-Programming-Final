package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.GL2;

import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;

enum AnimationStates {
	IDLE,
	WALKING,
	ATTACKING
}
public class PlayerAnimationController extends AnimationController{
	private Animation[] animations;
	private AnimationStates currentState = AnimationStates.IDLE;

	public PlayerAnimationController(){
		animations = new Animation[3];
		currentState = AnimationStates.IDLE;
		animations[0] = new Animation(new ImageResource[]{
			new ImageResource("Player/Idle/player_idle_1.png"),
			new ImageResource("Player/Idle/player_idle_2.png"),
			new ImageResource("Player/Idle/player_idle_3.png"),
			new ImageResource("Player/Idle/player_idle_4.png"),
			new ImageResource("Player/Idle/player_idle_5.png"),
			new ImageResource("Player/Idle/player_idle_6.png"),
			new ImageResource("Player/Idle/player_idle_7.png"),
			new ImageResource("Player/Idle/player_idle_8.png"),


		}, true); // Initialize IDLE state animation
		animations[0].rate = 20;
	}

	public void changeState(){

	}

	public void render(GL2 gl, Vector2d pos){
		animations[0].play();
		Drawing.drawImage(animations[0].getImage(), pos.x, pos.y, new float[]{1,1,1}, gl);
	}
}
