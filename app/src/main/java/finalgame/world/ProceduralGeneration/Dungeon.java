package finalgame.world.ProceduralGeneration;

import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

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
			new ImageResource("Dungeon/wall/wall_top.png"),
			new ImageResource("Dungeon/wall/wall_side_right.png"),
			new ImageResource("Dungeon/wall/wall_bottom.png"),
			new ImageResource("Dungeon/wall/wall_side_left.png"),
			new ImageResource("Dungeon/wall/wall_full.png"),
			new ImageResource("Dungeon/wall/wall_inner_corner_down_left.png"),
			new ImageResource("Dungeon/wall/wall_inner_corner_down_right.png"),
			new ImageResource("Dungeon/wall/wall_diagonal_corner_down_right.png"),
			new ImageResource("Dungeon/wall/wall_diagonal_corner_down_left.png"),
			new ImageResource("Dungeon/wall/wall_diagonal_corner_up_right.png"),
			new ImageResource("Dungeon/wall/wall_diagonal_corner_up_left.png"),
	};

	public static ImageResource exit = new ImageResource("Dungeon/floor_ladder.png");
	public HashSet<Vector2d> floorTiles;
	public HashSet<Wall> wallTiles;
	public Vector2d exitPosition;

	public Dungeon(HashSet<Vector2d> floorTiles, HashSet<Wall> wallTiles) {
		this.floorTiles = floorTiles;
		this.wallTiles = wallTiles;
		exitPosition = floorTiles.stream().collect(Collectors.toList()).get(new Random().nextInt(floorTiles.size()));
	}

	public void render(GL2 gl) {
		floorTiles.forEach(tile -> {
			Drawing.drawImage(floorTileImages[0], tile.x,
					tile.y,
					new float[] { 1, 1, 1 }, gl);
		});

		wallTiles.forEach(wall -> {
			switch (wall.type) {
				case WallTop:
					Drawing.drawImage(wallTilesImages[0], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallSideRight:
					Drawing.drawImage(wallTilesImages[1], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallBottom:
					Drawing.drawImage(wallTilesImages[2], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallSideLeft:
					Drawing.drawImage(wallTilesImages[3], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallFull:
					Drawing.drawImage(wallTilesImages[4], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallInnerCornerDownLeft:
					Drawing.drawImage(wallTilesImages[5], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallInnerCornerDownRight:
					Drawing.drawImage(wallTilesImages[6], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallDiagonalCornerDownRight:
					Drawing.drawImage(wallTilesImages[7], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallDiagonalCornerDownLeft:
					Drawing.drawImage(wallTilesImages[8], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallDiagonalCornerUpRight:
					Drawing.drawImage(wallTilesImages[9], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;
				case WallDiagonalCornerUpLeft:
					Drawing.drawImage(wallTilesImages[10], wall.position.x,
							wall.position.y,
							new float[] { 1, 1, 1 }, gl);
					break;

			}
		});

		Drawing.drawImage(exit, exitPosition.x, exitPosition.y, new float[] { 1, 1, 1 }, gl);
	}
}
