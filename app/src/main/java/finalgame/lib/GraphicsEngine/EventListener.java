package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import finalgame.world.World;

public class EventListener implements GLEventListener {

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0, 0, 0, 1);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glTranslatef(-Camera.position.x, -Camera.position.y, 0);
		// gl.glScalef(-0.2f, -0.2f, 0);
		World.render(gl);
		gl.glTranslatef(Camera.position.x, Camera.position.y, 0);
		// gl.glScalef(1.02f, 1.02f, 0);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		float h_units = height / (width / Renderer.w_units);
		gl.glOrtho(-Renderer.w_units, Renderer.w_units, -h_units, h_units, -1, 1);
		// gl.glOrtho(0, width, height, 0, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

}
