package finalgame.world.ProceduralGeneration.Generators;

import finalgame.world.ProceduralGeneration.Dungeon;

public abstract class AbstractDungeonGenerator {
	
	/** 
	 * @return Dungeon
	 */
	public Dungeon generateDungeon(){
		return runProceduralGeneration();
	}

	abstract Dungeon runProceduralGeneration();
}
