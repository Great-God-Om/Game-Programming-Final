package finalgame.lib.GraphicsEngine;

import finalgame.lib.util.Vector2d;

public class Camera {
	public static Vector2d position = new Vector2d(0, 0);
	
	/** 
	 * @param x
	 * @param y
	 */
	public static void moveCameraToPosition(float x, float y){
		position = new Vector2d(x, y);
	}
}
