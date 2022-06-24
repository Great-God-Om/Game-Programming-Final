package finalgame.world;

import finalgame.lib.util.Vector2d;

public class Room {
	Vector2d position;
	Vector2d dimensions;

	public Room(
		Vector2d position, Vector2d dimensions){
		this.position = position;
		this.dimensions = dimensions;
	}

}
