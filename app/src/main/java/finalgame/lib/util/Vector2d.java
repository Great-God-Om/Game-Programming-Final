package finalgame.lib.util;

public class Vector2d {
	public float x;
	public float y;
	public Vector2d(float x, float y){
		this.x = x;
		this.y = y;
	}

	public static Vector2d add(Vector2d a, Vector2d b){
		return new Vector2d(a.x + b.x, a.y + b.y);
	}

	public String toString(){
		return String.format("(%s,%s)", this.x, this.y);
	}
}