package finalgame.lib.util;

public class Boundsint {
	public Vector2d min;
	public Vector2d max;
	public Vector2d size = new Vector2d(max.x - min.x, max.y - min.y);
}
