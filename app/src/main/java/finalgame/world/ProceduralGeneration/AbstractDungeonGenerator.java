package finalgame.world.ProceduralGeneration;

public abstract class AbstractDungeonGenerator {
	public Dungeon generateDungeon(){
		return runProceduralGeneration();
	}

	abstract Dungeon runProceduralGeneration();
}
