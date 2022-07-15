package finalgame.lib.Engine.SpriteManagement;

import finalgame.lib.Resources.ImageResource;

public class Spritesheet {
	int SPRITESHEET_SPRITE_WIDTH = 16, SPRITESHEET_SPRITE_HEIGHT = 16;
	ImageResource spriteSheet;
	public ImageResource[] frames;

	public Spritesheet(String path, int frameCount, int SPRITESHEET_SPRITE_WIDTH, int SPRITESHEET_SPRITE_HEIGHT) {
		this.spriteSheet = new ImageResource(path);
		frames = new ImageResource[frameCount];
		for (int i = 0; i < frameCount; i++)
			frames[i] = new ImageResource(
					spriteSheet.image.getSubimage(i * SPRITESHEET_SPRITE_WIDTH, 0, SPRITESHEET_SPRITE_WIDTH,
							SPRITESHEET_SPRITE_HEIGHT));
	}
}
