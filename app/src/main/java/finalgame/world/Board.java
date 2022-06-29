package finalgame.world;

import com.jogamp.opengl.GL2;

import finalgame.world.ProceduralGeneration.Dungeon;
import finalgame.world.ProceduralGeneration.Generators.AbstractDungeonGenerator;
import finalgame.world.ProceduralGeneration.Generators.CorridorFirstDungeonGenerator;

public class Board {
	private static AbstractDungeonGenerator dungeonGenerator;
	public static Dungeon dungeon;

	public static void generateDungeon() {
		dungeonGenerator = new CorridorFirstDungeonGenerator();
		dungeon = dungeonGenerator.generateDungeon();
	}

	/**
	 * @param gl
	 */
	public static void render(GL2 gl) {
		if (dungeon == null) {
			return;
		}
		dungeon.render(gl);
	}
}
