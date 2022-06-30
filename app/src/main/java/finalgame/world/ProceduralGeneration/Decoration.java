package finalgame.world.ProceduralGeneration;

import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;

public class Decoration {
	public ImageResource texture;
	public Vector2d position;
	public Decoration(ImageResource texture, Vector2d position){
		this.texture = texture;
		this.position = position;
	}
}
