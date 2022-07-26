package finalgame.lib.GraphicsEngine;

import finalgame.lib.Engine.SpriteManagement.Spritesheet;
import finalgame.lib.Resources.ImageResource;

public class Animation {
	private Spritesheet spritesheet;
	private int currentFrame = 0;
	public int rate = 8;
	private long lastFrameTime;
	private boolean loop = true;

	public Animation(Spritesheet frames, boolean loop) {
		this.spritesheet = frames;
		this.loop = loop;
	}

	public void play() {
		long currentTime = System.nanoTime();
		if (currentTime > (lastFrameTime + (1000000000 / rate))) {
			currentFrame++;
			if (currentFrame >= spritesheet.frames.length) {
				if (loop) {
					currentFrame = 0;
				} else {
					currentFrame--;
				}
			}
			lastFrameTime = currentTime;
		}
	}

	/**
	 * @return ImageResource
	 */
	public ImageResource getImage() {
		return spritesheet.frames[currentFrame];
	}
}
