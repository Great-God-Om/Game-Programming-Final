package finalgame.world.ProceduralGeneration.Generators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.Dungeon;
import finalgame.world.ProceduralGeneration.Wall;
import finalgame.world.ProceduralGeneration.util.Direction2D;
import finalgame.world.ProceduralGeneration.util.ProceduralGenerationAlgorithms;

public class CorridorFirstDungeonGenerator extends SimpleRandomWalkDungeonGenerator {
	private int corridorLength = 15, corridorCount = 10;
	private float roomPercent = 0.5f;

	/**
	 * @return Dungeon
	 */
	@Override
	public Dungeon runProceduralGeneration() {
		return corridorFirstGeneration();
	}

	/**
	 * @return Dungeon
	 */
	private Dungeon corridorFirstGeneration() {
		// Create Empty HashSets for FloorTiles, Where we want to put the rooms, and
		// WallTiles
		HashSet<Vector2d> floorTiles = new HashSet<Vector2d>();
		HashSet<Vector2d> potentialRoomPositions = new HashSet<Vector2d>();
		HashSet<Wall> wallTiles = new HashSet<Wall>();

		// Create Corridors and assign them to FloorTiles
		floorTiles = createCorridiors(floorTiles, potentialRoomPositions);
		// Create Rooms and add them to FloorTiles
		HashSet<Vector2d> roomPositions = createRooms(potentialRoomPositions);
		// Find Dead ends with no rooms generated and create rooms at those position
		ArrayList<Vector2d> deadEnds = findAllDeadEnds(floorTiles);
		createRoomsAtDeadEnd(deadEnds, roomPositions);
		// Add all rooms to floor positions
		floorTiles.addAll(roomPositions);
		// Find and Add the Walls
		wallTiles = WallGenerator.createWalls(floorTiles);
		return new Dungeon(floorTiles, wallTiles);
	}

	
	/** 
	 * @param deadEnds
	 * @param roomFloors
	 */
	private void createRoomsAtDeadEnd(ArrayList<Vector2d> deadEnds, HashSet<Vector2d> roomFloors) {
		for (Vector2d position : deadEnds) {
			if(roomFloors.contains(position) == false){
				var room = runRandomWalk(iterations, walkLength, position);
				roomFloors.addAll(room);
			}
		}
	}

	
	/** 
	 * @param floorPositions
	 * @return ArrayList<Vector2d>
	 */
	private ArrayList<Vector2d> findAllDeadEnds(HashSet<Vector2d> floorPositions) {
		ArrayList<Vector2d> deadEnds = new ArrayList<Vector2d>();
		for (Vector2d position : floorPositions) {
			int neighborCount = 0;
			for (Vector2d direction : Direction2D.cardinalDirectionsList) {
				if(floorPositions.contains(Vector2d.add(position, direction))){
					neighborCount++;
				}
			}
			if(neighborCount == 1){
				deadEnds.add(position);
			}
		}
		return deadEnds;
	}

	/**
	 * Creates Rooms at the Potential Room Positions taking into account the Room
	 * Percentage
	 * 
	 * @param potentialRoomPositions
	 * @return HashSet<Vector2d>
	 */
	private HashSet<Vector2d> createRooms(HashSet<Vector2d> potentialRoomPositions) {
		// Create Return HashSet
		HashSet<Vector2d> roomPositions = new HashSet<Vector2d>();
		// Determine the amount of rooms to create
		int roomsToCreateCount = Math.round(potentialRoomPositions.size() * roomPercent);
		// Sort rooms by hashcode to create illusion of random order then only take the amount specified by rooms to create
		var rooms = potentialRoomPositions.stream().sorted((v1, v2) -> Integer.compare(v1.hashCode(), v2.hashCode()))
				.limit(roomsToCreateCount)
				.collect(Collectors.toList());
		// Run Random walk algorithm for each room to generate it and then add them to rooms
		for (Vector2d roomPosition : rooms) {
			var roomFloor = runRandomWalk(iterations, walkLength, roomPosition);
			roomPositions.addAll(roomFloor);
		}
		return roomPositions;
	}

	/**
	 * @param floorPostions
	 * @param potentialRoomPositions
	 * @return HashSet<Vector2d>
	 */
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
