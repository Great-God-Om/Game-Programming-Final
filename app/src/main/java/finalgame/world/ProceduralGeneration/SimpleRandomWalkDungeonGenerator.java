package finalgame.world.ProceduralGeneration;

import java.util.HashSet;
import java.util.Random;

import finalgame.lib.util.Vector2d;

public class SimpleRandomWalkDungeonGenerator extends AbstractDungeonGenerator {
	protected static Vector2d startPosition = new Vector2d(0, 0);
	private static int iterations = 20;

	public static int walkLength = 100;
	public static boolean startRandomlyEachIteration = true;

	public Dungeon runProceduralGeneration() {
		HashSet<Vector2d> floorPositions = runRandomWalk();
		System.out.println(floorPositions.size());
		floorPositions.forEach( x -> System.out.println(x));
		return new Dungeon(floorPositions);
	}

	protected HashSet<Vector2d> runRandomWalk() {
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
