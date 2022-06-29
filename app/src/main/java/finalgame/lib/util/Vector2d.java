package finalgame.lib.util;

import java.util.Objects;

public class Vector2d {
	public final float x;
	public final float y;
	public static final Vector2d UP = new Vector2d(0, 1);
	public static final Vector2d DOWN = new Vector2d(0, -1);
	public static final Vector2d LEFT = new Vector2d(-1, 0);
	public static final Vector2d RIGHT = new Vector2d(1, 0);

	public Vector2d(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @param a
	 * @param b
	 * @return Vector2d
	 */
	public static Vector2d add(Vector2d a, Vector2d b) {
		return new Vector2d(a.x + b.x, a.y + b.y);
	}

	/**
	 * @return String
	 */
	public String toString() {
		return String.format("(%s,%s)", this.x, this.y);
	}

	/**
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y);
	}

	/**
	 * @param oth
	 * @return boolean
	 */
	@Override
	public boolean equals(Object oth) {
		if (oth == this) {
			return true;
		}
		if (!(oth instanceof Vector2d)) {
			return false;
		}
		Vector2d v = (Vector2d) oth;
		return Float.compare(this.x, v.x) == 0 && Float.compare(this.y, v.y) == 0;
	}

	public static float distance(Vector2d pos1, Vector2d pos2) {
		return (float) Math.sqrt(
				Math.pow(pos2.x - pos1.x, 2) + Math.pow(pos2.y - pos1.y, 2));
	}
}