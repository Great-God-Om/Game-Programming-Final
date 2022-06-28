package finalgame.world.ProceduralGeneration;

import java.util.HashSet;

import finalgame.lib.util.Vector2d;

public class Dungeon {
	public HashSet<Vector2d> floorTiles;
	public Dungeon(HashSet<Vector2d> floorTiles){
		this.floorTiles = floorTiles;
	}
}
