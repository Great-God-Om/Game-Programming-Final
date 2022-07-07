package finalgame.lib.Resources.SpriteManagement;

import java.awt.image.BufferedImage;

import com.jogamp.opengl.util.texture.Texture;

import finalgame.lib.Resources.ImageResourceLoader;

public class Spritesheet {
	final int SPRITESHEET_WIDTH = 16, SPRITESHEET_HEIGHT = 16;
	BufferedImage spriteSheet;
	public Texture[] frames;

	public Spritesheet(String fileName, int frameCount) {
		this.spriteSheet = ImageResourceLoader.loadImage(fileName);
		this.frames = new Texture[frameCount];
		for (int i = 0; i < frameCount; i++) {
			frames[i] = ImageResourceLoader.getTextureFromImage(
					this.spriteSheet.getSubimage(i * SPRITESHEET_WIDTH, 0, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT));
		}
	}
}
