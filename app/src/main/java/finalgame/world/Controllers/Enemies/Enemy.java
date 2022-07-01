package finalgame.world.Controllers.Enemies;

import java.util.Random;

import finalgame.lib.util.Vector2d;
import finalgame.world.Board;
import finalgame.world.GameObject;
import finalgame.world.Scenes.World;

public class Enemy extends GameObject {
	// TODO: ADD MORE ENEMY TYPES TO THE WORLD
	protected final int maxHealth = 2;
	protected int health = maxHealth;
	protected final int sightDistance = 6;
	protected long lastGameTime = World.gameTime;
	protected int damage = 1;
	protected float AttackChance = 1f; // TODO: Maybe calculate based on Stats
	@Override
	public void update() {
		if (World.gameTime > lastGameTime) { // Can only take action on next game round
			float distanceToPlayer = Vector2d.distance(World.player.position, this.position);
			if (distanceToPlayer < sightDistance && distanceToPlayer > 1) {
				this.position = moveToPlayer();
				lastGameTime = World.gameTime;
			}
			if (distanceToPlayer == 1) {
				attackPlayer();
				lastGameTime = World.gameTime;
			}
		}
	}

	private void attackPlayer() {
		// TODO: WILL UNCOMMENT WHEN ASSET EXISTS
		// this.anim.changeState(new SkeletonAttackingState());
		if(new Random().nextFloat() < AttackChance){
			World.player.damage(damage);
			System.out.println("Did damage to Player");
		}
	}
	
	/** 
	 * @param amount
	 */
	public void damage(int amount){
		health -= amount;
		if(health <= 0){
			World.removeGameObject(this);
		}
	}
	
	/** 
	 * @return Vector2d
	 */
	private Vector2d moveToPlayer() {
		Vector2d newPosition = this.position;
		if (this.position.x != World.player.position.x) {
			if (this.position.x < World.player.position.x) {
				newPosition = Vector2d.add(this.position, Vector2d.RIGHT);
			} else {
				newPosition = Vector2d.add(this.position, Vector2d.LEFT);
			}
		} else if (this.position.y != World.player.position.y) {
			if (this.position.y < World.player.position.y) {
				newPosition = Vector2d.add(this.position, Vector2d.UP);
			} else {
				newPosition = Vector2d.add(this.position, Vector2d.DOWN);
			}
		}
		if(World.enemyPositions.containsKey(newPosition) || Board.dungeon.wallPositions.contains(newPosition)){
			newPosition = this.position;
		}
		return newPosition;
	}
}
