package finalgame.world.ProceduralGeneration.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import finalgame.lib.util.Vector2d;

public class Direction2D {
	public static ArrayList<Vector2d> cardinalDirectionsList = new ArrayList<Vector2d>(
			List.of(Vector2d.UP, // UP
					Vector2d.RIGHT, // RIGHT
					Vector2d.DOWN, // DOWN
					Vector2d.LEFT)); // LEFT
	public static ArrayList<Vector2d> diagonalDirectionsList = new ArrayList<Vector2d>(
			List.of(new Vector2d(1, 1), // UP-RIGHT
					new Vector2d(1, -1), // RIGHT-DOWN
					new Vector2d(-1, -1), // DOWN-LEFT
					new Vector2d(-1, 1))); // LEFT-UP
	public static ArrayList<Vector2d> eightDirectionsList = new ArrayList<Vector2d>(
			List.of(
					Vector2d.UP, // UP
					new Vector2d(1, 1), // UP-RIGHT
					Vector2d.RIGHT, // RIGHT
					new Vector2d(1, -1), // RIGHT-DOWN
					Vector2d.DOWN, // DOWN
					new Vector2d(-1, -1), // DOWN-LEFT
					Vector2d.LEFT, // LEFT
					new Vector2d(-1, 1) // LEFT-UP
			));

	/**
	 * @return Vector2d
	 */
	public static Vector2d getRandomCardinalDirection() {
		return cardinalDirectionsList.get(new Random().nextInt(cardinalDirectionsList.size()));
	}
}
