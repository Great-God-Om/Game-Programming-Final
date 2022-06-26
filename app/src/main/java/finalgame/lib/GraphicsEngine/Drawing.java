package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

import finalgame.lib.Resources.ImageResource;
import finalgame.world.World;

public class Drawing {
	public static void drawImage(ImageResource image, float x, float y, float[] tint, GL2 gl) {
		Texture texture = image.getTexture();

		if (texture != null) {
			gl.glBindTexture(GL2.GL_TEXTURE_2D, texture.getTextureObject());
		}
		gl.glColor3fv(tint, 0);
		gl.glBegin(GL2.GL_QUADS);

		gl.glTexCoord2f(0, 1);
		gl.glVertex2f(x, y);

		gl.glTexCoord2f(1, 1);
		gl.glVertex2f(x + World.TILE_SIZE, y);

		gl.glTexCoord2f(1, 0);
		gl.glVertex2f(x + World.TILE_SIZE, y + World.TILE_SIZE);

		gl.glTexCoord2f(0, 0);
		gl.glVertex2f(x, y + World.TILE_SIZE);

		gl.glEnd();
		gl.glFlush();
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
	}

	public static void drawRect(float x, float y, float[] color, GL2 gl) {
		gl.glColor3fv(color, 0);
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex2f(x, y);
			gl.glVertex2f(x + World.TILE_SIZE, y);
			gl.glVertex2f(x + World.TILE_SIZE, y + World.TILE_SIZE);
			gl.glVertex2f(x, y + World.TILE_SIZE);
		gl.glEnd();
		gl.glFlush();
	}
}
