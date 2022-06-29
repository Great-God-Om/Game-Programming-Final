package finalgame.world.ProceduralGeneration.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import finalgame.lib.util.Vector2d;

public class Direction2D {
	public static ArrayList<Vector2d> cardinalDiretionsList = new ArrayList<Vector2d>(
			List.of(new Vector2d(0, 1),
					new Vector2d(1, 0),
					new Vector2d(0, -1),
					new Vector2d(-1, 0)));

	public static Vector2d getRandomCardinalDirection() {
		return cardinalDiretionsList.get(new Random().nextInt(cardinalDiretionsList.size()));
	}
}
