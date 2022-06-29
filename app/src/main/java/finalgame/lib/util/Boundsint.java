package finalgame.lib.util;

public class Boundsint {
	public Vector2d min;
	public Vector2d max;
	public Vector2d size;
	public Vector2d center;

	public Boundsint(Vector2d min, Vector2d size) {
		this.min = min;
		this.max = new Vector2d(min.x + size.x, min.y + size.y);
		this.size = size;
		this.center = new Vector2d(Math.round(this.min.x + size.x / 2), Math.round(this.min.y + size.y / 2));
	}
}
