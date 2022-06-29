package finalgame.world.ProceduralGeneration;

import java.util.ArrayList;
import java.util.HashSet;

import finalgame.lib.util.Vector2d;
import finalgame.world.ProceduralGeneration.util.Direction2D;

/**
 * ProceduralGenerationAlgorithms
 */
public class ProceduralGenerationAlgorithms {
	
	/** 
	 * @param startingPos
	 * @param walkLength
	 * @return HashSet<Vector2d>
	 */
	public static HashSet<Vector2d> simpleRandomWalk(Vector2d startingPos, int walkLength){
		HashSet<Vector2d> path = new HashSet<Vector2d>();
		path.add(startingPos);
		Vector2d previousPos = startingPos;
		for(int i =0; i < walkLength; i++){
			Vector2d newPos = Vector2d.add(previousPos, Direction2D.getRandomCardinalDirection());
			path.add(newPos);
			previousPos = newPos;
		}
		return path;
	}

	
	/** 
	 * @param startingPos
	 * @param corridorLength
	 * @return ArrayList<Vector2d>
	 */
	public static ArrayList<Vector2d> randomWalkCorridor(Vector2d startingPos, int corridorLength) {
		ArrayList<Vector2d> corridor = new ArrayList<Vector2d>();
		var direction = Direction2D.getRandomCardinalDirection();
		var currentPosition = startingPos;
		corridor.add(currentPosition);
		for (int i = 0; i < corridorLength; i++) {
			var v = Vector2d.add(currentPosition, direction);
			corridor.add(v);
			currentPosition = v;
		}
		return corridor;
	}
	
}
