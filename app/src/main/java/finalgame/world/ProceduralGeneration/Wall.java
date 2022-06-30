package finalgame.world.ProceduralGeneration;

import finalgame.lib.util.Vector2d;

public class Wall {
	public WallTypes type;
	public Vector2d position;
	public Wall(WallTypes type, Vector2d position){
		this.type = type;
		this.position = position;
	}
}
