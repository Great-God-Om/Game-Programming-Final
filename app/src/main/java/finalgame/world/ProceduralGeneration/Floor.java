package finalgame.world.ProceduralGeneration;

import com.jogamp.opengl.util.texture.Texture;

import finalgame.lib.util.Vector2d;

public class Floor {
	public Texture imageResource;
	public Vector2d position;
	public Floor(Texture imageResource, Vector2d position) {
		this.imageResource = imageResource;
		this.position = position;
	}

}
