package finalgame.world.ProceduralGeneration.Generators;

import java.util.ArrayList;
import java.util.HashSet;

import finalgame.lib.util.Boundsint;
import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.Dungeon;
import finalgame.world.ProceduralGeneration.util.ProceduralGenerationAlgorithms;

public class RoomsFirstDungeonGenerator extends SimpleRandomWalkDungeonGenerator {
	private final int minRoomWidth = 5, minRoomHeight = 5;
	private final int dungeonWidth = 100, dungeonHeight = 100;
	private int offset = 2;
	private boolean randomWalkRooms = false;

	@Override
	public Dungeon runProceduralGeneration() {
		// TODO Auto-generated method stub
		return roomFirstGeneration();
	}

	private Dungeon roomFirstGeneration() {
		return new Dungeon(createRooms(), new HashSet<Vector2d>());
	}

	private HashSet<Vector2d> createRooms() {
		var roomList = ProceduralGenerationAlgorithms.binarySpacePartioning(
				new Boundsint(startPosition,
						new Vector2d(dungeonWidth, dungeonHeight)),
				minRoomWidth,
				minRoomHeight);
		HashSet<Vector2d> floor = new HashSet<Vector2d>();
		floor = CreateSimpleRooms(roomList);
		return floor;
	}

	private HashSet<Vector2d> CreateSimpleRooms(ArrayList<Boundsint> roomList) {
		HashSet<Vector2d> floor = new HashSet<Vector2d>();
		for (var room : roomList) {
			for(int col = offset; col < room.size.x - offset; col++){
				for (int row = offset; row < room.size.y - offset; row++) {
					Vector2d pos = Vector2d.add(room.min, new Vector2d(col, row));
					floor.add(pos);
				}
			}
		}
		return floor;
	}

}
