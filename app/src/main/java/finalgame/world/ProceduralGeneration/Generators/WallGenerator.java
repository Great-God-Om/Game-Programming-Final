package finalgame.world.ProceduralGeneration.Generators;

import java.util.ArrayList;
import java.util.HashSet;

import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.util.Direction2D;

public class WallGenerator {
	
	/** 
	 * @param floorPositions
	 * @return HashSet<Vector2d>
	 */
	public static HashSet<Vector2d> createWalls(HashSet<Vector2d> floorPositions) {
		var basicWallPositions = findWallsInDirection(floorPositions, Direction2D.cardinalDiretionsList);
		return basicWallPositions;
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
			for(var direction: directionList){
				var neighbourPosition = Vector2d.add(position, direction);
				if(floorPositions.contains(neighbourPosition) == false){
					wallPositions.add(neighbourPosition);
				}
			}
		}
		return wallPositions;
	}
}
