package finalgame.world.ProceduralGeneration;

import java.util.ArrayList;
import java.util.Random;

import finalgame.lib.util.Vector2d;

public class Direction2D {
	public static ArrayList<Vector2d> cardinalDiretionsList = new ArrayList<Vector2d>() {
		new Vector2d(0,1), // UP
		new Vector2d(1, 0), // RIGHT
		new Vector2d(0, -1), // DOWN
		new Vector2d(-1, 0) // LEFT
	};

	public static Vector2d getRandomCardinalDirection() {
		return cardinalDiretionsList.get(new Random().nextInt(cardinalDiretionsList.size()));
	}
}
