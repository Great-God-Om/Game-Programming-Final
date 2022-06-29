package finalgame.world.ProceduralGeneration.Generators;

import java.util.HashSet;

import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.Dungeon;
import finalgame.world.ProceduralGeneration.ProceduralGenerationAlgorithms;

public class CorridorFirstDungeonGenerator extends SimpleRandomWalkDungeonGenerator {
	private int corridorLength = 14, corridorCount = 5;
	private float roomPercent = 0.8f;

	@Override
	public Dungeon runProceduralGeneration() {
		// TODO Auto-generated method stub
		return corridorFirstGeneration();
	}

	private Dungeon corridorFirstGeneration() {
		HashSet<Vector2d> floorTiles = new HashSet<Vector2d>();
		HashSet<Vector2d> potentialRoomPositions = new HashSet<Vector2d>();
		HashSet<Vector2d> wallTiles = new HashSet<Vector2d>();
		floorTiles = createCorridiors(floorTiles, potentialRoomPositions);
		wallTiles = WallGenerator.createWalls(floorTiles);
		return new Dungeon(floorTiles, wallTiles);
	}

	private HashSet<Vector2d> createCorridiors(HashSet<Vector2d> floorPostions,
			HashSet<Vector2d> potentialRoomPositions) {
		var currentPosition = startPosition;
		potentialRoomPositions.add(currentPosition);
		for (int i = 0; i < corridorCount; i++) {
			var corridor = ProceduralGenerationAlgorithms.randomWalkCorridor(currentPosition, corridorLength);
			currentPosition = corridor.get(corridor.size() - 1);
			potentialRoomPositions.add(currentPosition);
			floorPostions.addAll(corridor);
		}
		return floorPostions;
	}

}
