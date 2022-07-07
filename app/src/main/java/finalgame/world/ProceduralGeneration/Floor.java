package finalgame.world.ProceduralGeneration;

import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;

public class Floor {
	public ImageResource imageResource;
	public Vector2d position;
	public Floor(ImageResource imageResource, Vector2d position) {
		this.imageResource = imageResource;
		this.position = position;
	}

}
