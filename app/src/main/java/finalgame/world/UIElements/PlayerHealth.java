package finalgame.world.UIElements;

import com.jogamp.opengl.GL2;

import finalgame.lib.Engine.UIManagement.UIElement;
import finalgame.lib.GraphicsEngine.Camera;
import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.GraphicsEngine.Renderer;
import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;
import finalgame.world.Scenes.World;

public class PlayerHealth extends UIElement {
	private float scaleFactor = 13f;
	private final float container_width = 0.8557692307692307f * scaleFactor,
			container_height = 0.1442307692307692f * scaleFactor;
	private float bar_width = 0.870f * container_width, bar_height = 0.45f * container_height;
	private float padding = 0.2f;
	private Vector2d position;
	ImageResource[] sprites = new ImageResource[] {
			new ImageResource("UI/player_health_base.png"),
			new ImageResource("UI/player_health_bar_health.png"),

	};

	
	/** 
	 * @param gl
	 */
	@Override
	public void render(GL2 gl) {
		position = new Vector2d(-Renderer.w_units + padding, Renderer.h_units - container_height - padding);

		Drawing.drawImage(sprites[1], Camera.position.x + this.position.x + 0.125f * container_width,
				Camera.position.y + this.position.y + 0.41f * container_height,
				bar_width * (float)World.player.health / (float)World.player.maxHealth,
				bar_height, new float[] { 1, 1, 1 }, gl);
		Drawing.drawImage(sprites[0], Camera.position.x + this.position.x, Camera.position.y + this.position.y,
				container_width,
				container_height, new float[] { 1, 1, 1 }, gl);
	}

}
