package finalgame.lib.util;

import java.util.Objects;

public class Vector2d {
	public final float x;
	public final float y;

	public Vector2d(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public static Vector2d add(Vector2d a, Vector2d b) {
		return new Vector2d(a.x + b.x, a.y + b.y);
	}

	public String toString() {
		return String.format("(%s,%s)", this.x, this.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y);
	}

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
}