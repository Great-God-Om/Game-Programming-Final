package finalgame.world.ProceduralGeneration.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import finalgame.lib.util.Vector2d;

public class Direction2D {
	public static ArrayList<Vector2d> cardinalDiretionsList = new ArrayList<Vector2d>(
			List.of(Vector2d.UP, // UP
					Vector2d.RIGHT, // RIGHT
					Vector2d.DOWN, // DOWN
					Vector2d.LEFT)); // LEFT

	
	/** 
	 * @return Vector2d
	 */
	public static Vector2d getRandomCardinalDirection() {
		return cardinalDiretionsList.get(new Random().nextInt(cardinalDiretionsList.size()));
	}
}
