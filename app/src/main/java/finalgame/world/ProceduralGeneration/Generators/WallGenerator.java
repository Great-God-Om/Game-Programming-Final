package finalgame.world.ProceduralGeneration.Generators;

import java.util.ArrayList;
import java.util.HashSet;

import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.Wall;
import finalgame.world.ProceduralGeneration.WallTypes;
import finalgame.world.ProceduralGeneration.util.Direction2D;
import finalgame.world.ProceduralGeneration.util.WallTypeHelper;

public class WallGenerator {

	/**
	 * @param floorPositions
	 * @return HashSet<Vector2d>
	 */
	public static HashSet<Wall> createWalls(HashSet<Vector2d> floorPositions) {
		var walls = new HashSet<Wall>();
		var basicWallPositions = findWallsInDirection(floorPositions, Direction2D.cardinalDirectionsList);
		var cornerWallPositions = findWallsInDirection(floorPositions, Direction2D.diagonalDirectionsList);

		createBasicWalls(floorPositions, basicWallPositions, walls);
		createCornerWalls(floorPositions, cornerWallPositions, walls);

		return walls;
	}

	private static void createCornerWalls(HashSet<Vector2d> floorPositions, HashSet<Vector2d> cornerWallPositions,
			HashSet<Wall> walls) {
		for (var position : cornerWallPositions) {
			String neighborsBinaryType = "";
			for (var direction : Direction2D.eightDirectionsList) {
				var neighbourPosition = Vector2d.add(position, direction);
				if (floorPositions.contains(neighbourPosition)) {
					neighborsBinaryType += '1';
				} else {
					neighborsBinaryType += '0';
				}
			}
		}
	}

	private static void createBasicWalls(HashSet<Vector2d> floorPositions, HashSet<Vector2d> basicWallPositions,
			HashSet<Wall> walls) {
		for (var position : basicWallPositions) {
			String neighborsBinaryType = "";
			for (var direction : Direction2D.cardinalDirectionsList) {
				var neighbourPosition = Vector2d.add(position, direction);
				if (floorPositions.contains(neighbourPosition)) {
					neighborsBinaryType += '1';
				} else {
					neighborsBinaryType += '0';
				}
			}
			int type = Integer.parseInt(neighborsBinaryType, 2);
			if (WallTypeHelper.wallTop.contains(type)) {
				walls.add(new Wall(WallTypes.WallTop, position));
			} else if (WallTypeHelper.wallSideRight.contains(type)) {
				walls.add(new Wall(WallTypes.WallSideRight, position));
			} else if (WallTypeHelper.wallSideLeft.contains(type)) {
				walls.add(new Wall(WallTypes.WallSideLeft, position));
			} else if (WallTypeHelper.wallBottom.contains(type)) {
				walls.add(new Wall(WallTypes.WallBottom, position));
			} else if (WallTypeHelper.wallFull.contains(type)) {
				walls.add(new Wall(WallTypes.WallFull, position));
			}
		}
	}

	/**
	 * @param floorPositions
	 * @param directionList
	 * @return HashSet<Vector2d>
	 */
	private static HashSet<Vector2d> findWallsInDirection(HashSet<Vector2d> floorPositions,
			ArrayList<Vector2d> directionList) {
		HashSet<Vector2d> wallPositions = new HashSet<Vector2d>();

		for (var position : floorPositions) {
			for (var direction : directionList) {
				var neighbourPosition = Vector2d.add(position, direction);
				if (floorPositions.contains(neighbourPosition) == false) {
					wallPositions.add(neighbourPosition);
				}
			}
		}
		return wallPositions;
	}
}
