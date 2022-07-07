package finalgame.lib.GraphicsEngine;

import com.jogamp.opengl.util.texture.Texture;

import finalgame.lib.Resources.SpriteManagement.Spritesheet;

public class Animation {
	private Spritesheet animation;
	private int currentFrame = 0;
	public int rate = 8;
	private long lastFrameTime;
	private boolean loop = true;

	public Animation(Spritesheet spriteSheet, boolean loop) {
		this.animation = spriteSheet;
		this.loop = loop;
	}

	public void play() {
		long currentTime = System.nanoTime();
		if (currentTime > (lastFrameTime + (1000000000 / rate))) {
			currentFrame++;
			if (currentFrame >= animation.frames.length) {
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
	public Texture getImage() {
		return animation.frames[currentFrame];
	}
}
