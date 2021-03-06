package finalgame.lib.Resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import finalgame.App;
import finalgame.lib.GraphicsEngine.Renderer;

public class ImageResource {
	private Texture texture = null;
	public BufferedImage image = null;

	public ImageResource(String path) {

		try {
			var url = App.class.getClassLoader().getResource(path);
			image = ImageIO.read(url);
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (image != null) {
			image.flush();
		}
	}
	public ImageResource(BufferedImage image) {

		this.image = image;
		if (image != null) {
			image.flush();
		}
	}

	/**
	 * @return Texture
	 */
	public Texture getTexture() {
		if (image == null) {
			return null;
		}
		if (texture == null) {
			texture = AWTTextureIO.newTexture(Renderer.glp, image, true);
		}
		return texture;
	}
}
