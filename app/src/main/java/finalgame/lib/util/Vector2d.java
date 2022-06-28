package finalgame.lib.util;

public class Vector2d {
	public float x;
	public float y;
	public Vector2d(float x, float y){
		this.x = x;
		this.y = y;
	}

	public static Vector2d add(Vector2d a, Vector2d b){
		a.x += b.x;
		a.y += b.y;
		return a;
	}
}