package finalgame.world.ProceduralGeneration;

import java.util.HashSet;

import finalgame.lib.util.Vector2d;

public class Dungeon {
	public HashSet<Vector2d> floorTiles;
	public HashSet<Vector2d> wallTiles;
	public Dungeon(HashSet<Vector2d> floorTiles, HashSet<Vector2d> wallTiles){
		this.floorTiles = floorTiles;
		this.wallTiles = wallTiles;
	}
}
