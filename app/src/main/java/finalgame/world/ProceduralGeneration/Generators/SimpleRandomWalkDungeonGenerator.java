package finalgame.world.ProceduralGeneration.Generators;

import java.util.HashSet;
import java.util.Random;

import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.Dungeon;
import finalgame.world.ProceduralGeneration.ProceduralGenerationAlgorithms;

public class SimpleRandomWalkDungeonGenerator extends AbstractDungeonGenerator {
	protected static Vector2d startPosition = new Vector2d(0, 0);
	protected static int iterations = 15;

	protected static int walkLength = 20;
	public static boolean startRandomlyEachIteration = true;

	
	/** 
	 * @return Dungeon
	 */
	public Dungeon runProceduralGeneration() {
		HashSet<Vector2d> floorPositions = runRandomWalk(iterations, walkLength, startPosition);
		HashSet<Vector2d> wallPositions = WallGenerator.createWalls(floorPositions);
		return new Dungeon(floorPositions, wallPositions);
	}

	
	/** 
	 * @param iterations
	 * @param walkLength
	 * @param startPosition
	 * @return HashSet<Vector2d>
	 */
	protected HashSet<Vector2d> runRandomWalk(int iterations, int walkLength, Vector2d startPosition) {
		Vector2d currentPosition = startPosition;
		HashSet<Vector2d> floorPositions = new HashSet<Vector2d>();
		for (int i = 0; i < iterations; i++) {
			HashSet<Vector2d> path = ProceduralGenerationAlgorithms.simpleRandomWalk(currentPosition, walkLength);
			floorPositions.addAll(path);
			if(startRandomlyEachIteration){
				currentPosition = (Vector2d) floorPositions.toArray()[new Random().nextInt(floorPositions.size())];
			}
		}
		return floorPositions;
	}
}
