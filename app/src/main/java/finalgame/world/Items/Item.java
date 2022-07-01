package finalgame.world.Items;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;

public abstract class Item {
	public ImageResource texture;
	public Vector2d position;

	public abstract void performEffect();

	public void render(GL2 gl) {
		Drawing.drawImage(texture, position.x, position.y, new float[] { 1, 1, 1 }, gl);
	}
}
