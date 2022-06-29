package finalgame.world.ProceduralGeneration.Generators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

import finalgame.lib.util.Boundsint;
import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.Dungeon;
import finalgame.world.ProceduralGeneration.util.ProceduralGenerationAlgorithms;

public class RoomsFirstDungeonGenerator extends SimpleRandomWalkDungeonGenerator {
	private final int minRoomWidth = 10, minRoomHeight = 10;
	private final int dungeonWidth = 70, dungeonHeight = 70;
	private int offset = 2;
	private boolean randomWalkRooms = true;

	@Override
	public Dungeon runProceduralGeneration() {
		return roomFirstGeneration();
	}

	private Dungeon roomFirstGeneration() {
		var rooms = createRooms();
		return new Dungeon(rooms, WallGenerator.createWalls(rooms));
	}

	private HashSet<Vector2d> createRooms() {
		var roomsList = ProceduralGenerationAlgorithms.binarySpacePartioning(
				new Boundsint(startPosition,
						new Vector2d(dungeonWidth, dungeonHeight)),
				minRoomWidth,
				minRoomHeight);
		HashSet<Vector2d> floor = new HashSet<Vector2d>();
		if (randomWalkRooms) {
			floor = createRoomsRandomly(roomsList);
		} else {
			floor = createSimpleRooms(roomsList);
		}

		ArrayList<Vector2d> roomCenters = new ArrayList<Vector2d>();
		for (var room : roomsList) {
			roomCenters.add(room.center);
		}
		HashSet<Vector2d> corridors = connectRooms(roomCenters);
		floor.addAll(corridors);
		return floor;
	}

	private HashSet<Vector2d> createRoomsRandomly(ArrayList<Boundsint> roomsList) {
		HashSet<Vector2d> floor = new HashSet<Vector2d>();
		for (int i = 0; i < roomsList.size(); i++) {
			var roomBounds = roomsList.get(i);
			var roomCenter = new Vector2d(roomBounds.center.x, roomBounds.center.y);
			var roomFloor = runRandomWalk(iterations, walkLength, roomCenter);
			for (var position : roomFloor) {
				if (position.x >= (roomBounds.min.x + offset) && position.x < (roomBounds.max.x - offset)
						&& position.y >= (roomBounds.min.y - offset) && position.y <= (roomBounds.max.y - offset)) {
					floor.add(position);
				}
			}
		}
		return floor;
	}

	private HashSet<Vector2d> connectRooms(ArrayList<Vector2d> roomCenters) {
		HashSet<Vector2d> corridors = new HashSet<>();
		var currentRoomCenter = roomCenters.stream().collect(Collectors.toList())
				.get(new Random().nextInt(roomCenters.size()));
		roomCenters.remove(currentRoomCenter);
		while (roomCenters.size() > 0) {
			Vector2d closest = findClosestPointTo(currentRoomCenter, roomCenters);
			roomCenters.remove(closest);
			HashSet<Vector2d> newCorridor = createCorridor(currentRoomCenter, closest);
			currentRoomCenter = closest;
			corridors.addAll(newCorridor);
		}
		return corridors;
	}

	private HashSet<Vector2d> createCorridor(Vector2d currentRoomCenter, Vector2d destination) {
		HashSet<Vector2d> corridor = new HashSet<Vector2d>();
		var position = currentRoomCenter;
		corridor.add(position);
		while (position.y != destination.y) {
			if (destination.y > position.y) {
				position = Vector2d.add(position, Vector2d.UP);
			} else {
				position = Vector2d.add(position, Vector2d.DOWN);
			}
			corridor.add(position);
		}
		while (position.x != destination.x) {
			if (destination.x > position.x) {
				position = Vector2d.add(position, Vector2d.RIGHT);
			} else {
				position = Vector2d.add(position, Vector2d.LEFT);
			}
			corridor.add(position);
		}
		return corridor;
	}

	private Vector2d findClosestPointTo(Vector2d currentRoomCenter, ArrayList<Vector2d> roomCenters) {
		return roomCenters.stream().reduce((v1, v2) -> {
			return (Vector2d.distance(currentRoomCenter, v1) < Vector2d.distance(currentRoomCenter, v2)) ? v1 : v2;
		}).get();
	}

	private HashSet<Vector2d> createSimpleRooms(ArrayList<Boundsint> roomList) {
		HashSet<Vector2d> floor = new HashSet<Vector2d>();
		for (var room : roomList) {
			for (int col = offset; col < room.size.x - offset; col++) {
				for (int row = offset; row < room.size.y - offset; row++) {
					Vector2d pos = Vector2d.add(room.min, new Vector2d(col, row));
					floor.add(pos);
				}
			}
		}
		return floor;
	}

}
