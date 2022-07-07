package finalgame.lib.Resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import finalgame.App;
import finalgame.lib.GraphicsEngine.Renderer;

public class ImageResourceLoader {
	public static BufferedImage loadImage(String path) {
		BufferedImage image = null;

		try {
			var url = App.class.getClassLoader().getResource(path);
			image = ImageIO.read(url);
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (image != null) {
			image.flush();
		}
		return image;
	}

	/**
	 * @return Texture
	 */
	public static Texture getTextureFromImage(BufferedImage image) {

		return AWTTextureIO.newTexture(Renderer.glp, image, true);
	}
}
