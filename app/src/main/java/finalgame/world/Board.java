package finalgame.world;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.Resources.ImageResource;
import finalgame.world.ProceduralGeneration.Dungeon;
import finalgame.world.ProceduralGeneration.Generators.AbstractDungeonGenerator;
import finalgame.world.ProceduralGeneration.Generators.CorridorFirstDungeonGenerator;

public class Board {
	private static final int MAX_ROOM_SIZE = 10;
	private static final int MIN_ROOM_SIZE = 5;
	private static AbstractDungeonGenerator dungeonGenerator;
	public static Dungeon dungeon;
	public static ImageResource[] floorTiles = new ImageResource[] {
			new ImageResource("Dungeon/floor/floor_1.png"),
			new ImageResource("Dungeon/floor/floor_1.png"),
			new ImageResource("Dungeon/floor/floor_2.png"),
			new ImageResource("Dungeon/floor/floor_3.png"),
			new ImageResource("Dungeon/floor/floor_4.png"),
			new ImageResource("Dungeon/floor/floor_5.png"),
			new ImageResource("Dungeon/floor/floor_6.png"),
			new ImageResource("Dungeon/floor/floor_7.png")
	};

	public static ImageResource[] wallTiles = new ImageResource[] {
			new ImageResource("Dungeon/wall/wall_top.png"),
			new ImageResource("Dungeon/wall/wall_side_mid_right.png"),
			new ImageResource("Dungeon/wall/wall_corner_bottom_left.png"),
			new ImageResource("Dungeon/wall/wall_corner_bottom_right.png"),
			new ImageResource("Dungeon/wall/wall_top_mid.png"),
	};
	public static void generateDungeon() {
		dungeonGenerator = new CorridorFirstDungeonGenerator();
		// dungeon = new SimpleRandomWalkDungeonGenerator().runProceduralGeneration();
		dungeon = dungeonGenerator.generateDungeon();
	}

	public static void render(GL2 gl) {
		if (dungeon == null) {
			return;
		}
		dungeon.floorTiles.forEach(tile -> {
			Drawing.drawImage(floorTiles[0], tile.x,
					tile.y,
					new float[] { 1, 1, 1 }, gl);
		});

		dungeon.wallTiles.forEach(tile -> {
			Drawing.drawImage(wallTiles[0], tile.x,
					tile.y,
					new float[] { 1, 1, 1 }, gl);
		});
	}
}
