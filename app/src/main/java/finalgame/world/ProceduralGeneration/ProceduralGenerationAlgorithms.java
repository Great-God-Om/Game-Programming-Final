package finalgame.world.ProceduralGeneration;

import java.util.HashSet;

import finalgame.lib.util.Vector2d;

/**
 * ProceduralGenerationAlgorithms
 */
public class ProceduralGenerationAlgorithms {
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
	
}
