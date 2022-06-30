package finalgame.world.Controllers.Enemies;

import java.util.Random;

import finalgame.lib.util.Vector2d;
import finalgame.world.GameObject;
import finalgame.world.World;

public class Enemy extends GameObject {
	public final int sightDistance = 4;
	private long lastGameTime = World.gameTime;
	private final int damage = 1;
	private final float AttackChance = 1f; // TODO: Maybe calculate based on Stats
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
		return newPosition;
	}
}
