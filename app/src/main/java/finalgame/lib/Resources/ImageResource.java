package finalgame.lib.Resources;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;

import finalgame.lib.GraphicsEngine.Renderer;

public class ImageResource {
	private Texture texture = null;
	private BufferedImage image = null;

	public ImageResource(String path){
		Path p = Paths.get(Paths.get(".").normalize().toAbsolutePath().toString(), "app", "src", "main", "resources", path);
		try {
			image = ImageIO.read(new File(p.toString()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(image != null){
			image.flush();
		}
	}

	public Texture getTexture(){
		if(image == null){
			return null;
		}
		if(texture == null){
			texture = AWTTextureIO.newTexture(Renderer.glp, image, true);
		}
		return texture;
	}
}
