package finalgame.world.ProceduralGeneration;

import java.util.HashSet;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;

public class Dungeon {
	public static ImageResource[] floorTileImages = new ImageResource[] {
			new ImageResource("Dungeon/floor/floor_1.png"),
			new ImageResource("Dungeon/floor/floor_1.png"),
			new ImageResource("Dungeon/floor/floor_2.png"),
			new ImageResource("Dungeon/floor/floor_3.png"),
			new ImageResource("Dungeon/floor/floor_4.png"),
			new ImageResource("Dungeon/floor/floor_5.png"),
			new ImageResource("Dungeon/floor/floor_6.png"),
			new ImageResource("Dungeon/floor/floor_7.png")
	};

	public static ImageResource[] wallTilesImages = new ImageResource[] {
			new ImageResource("Dungeon/wall/wall_top.png")
	};
	public HashSet<Vector2d> floorTiles;
	public HashSet<Vector2d> wallTiles;

	public Dungeon(HashSet<Vector2d> floorTiles, HashSet<Vector2d> wallTiles) {
		this.floorTiles = floorTiles;
		this.wallTiles = wallTiles;
	}

	public void render(GL2 gl){
		floorTiles.forEach(tile -> {
			Drawing.drawImage(floorTileImages[0], tile.x,
					tile.y,
					new float[] { 1, 1, 1 }, gl);
		});

		wallTiles.forEach(tile -> {
			Drawing.drawImage(wallTilesImages[0], tile.x,
					tile.y,
					new float[] { 1, 1, 1 }, gl);
		});
	}
}
