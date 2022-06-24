package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.GL2;

import finalgame.world.World;

public class Drawing {
	public static void drawRect(float x, float y, float[] color, GL2 gl) {
		gl.glColor3fv(color, 0);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(x, y);
		gl.glVertex2f(x + World.TILE_SIZE, y);
		gl.glVertex2f(x + World.TILE_SIZE, y + World.TILE_SIZE);
		gl.glVertex2f(x, y + World.TILE_SIZE);
		gl.glEnd();
	}
}
