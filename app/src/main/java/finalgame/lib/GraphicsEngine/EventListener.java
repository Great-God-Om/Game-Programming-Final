package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import finalgame.lib.Engine.SceneManagement.SceneManager;

public class EventListener implements GLEventListener {

	
	/** 
	 * @param drawable
	 */
	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0.145098039216f, 0.0745098039216f, 0.101960784314f, 1);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}

	
	/** 
	 * @param drawable
	 */
	@Override
	public void dispose(GLAutoDrawable drawable) {

	}

	
	/** 
	 * @param drawable
	 */
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glTranslatef(-Camera.position.x, -Camera.position.y, 0);
		SceneManager.render(gl);
		gl.glTranslatef(Camera.position.x, Camera.position.y, 0);
	}

	
	/** 
	 * @param drawable
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		Renderer.h_units = height / (width / Renderer.w_units);
		gl.glOrtho(-Renderer.w_units, Renderer.w_units, -Renderer.h_units, Renderer.h_units, -1, 1);
		// gl.glOrtho(0, width, height, 0, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

}
