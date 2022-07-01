package finalgame.world.Items;

import finalgame.lib.Resources.ImageResource;
import finalgame.world.Scenes.World;

public class HealthPotion extends Item{
	private int healAmount = 20;
	public HealthPotion(){
		this.texture = new ImageResource("Dungeon/items/health_potion.png");
	}
	@Override
	public void performEffect() {
		World.player.heal(healAmount);		
	}
	
}
