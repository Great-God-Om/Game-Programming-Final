package finalgame.world;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.Resources.ImageResource;
import finalgame.lib.util.Vector2d;

public class Board {
	private static final int MAX_ROOM_SIZE = 10;
	private static final int MIN_ROOM_SIZE = 5;
	public static ArrayList<Room> dungeon;
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
		new ImageResource("Dungeon/wall/wall_side_mid_left.png"),
		new ImageResource("Dungeon/wall/wall_side_mid_right.png"),
		new ImageResource("Dungeon/wall/wall_corner_bottom_left.png"),
		new ImageResource("Dungeon/wall/wall_corner_bottom_right.png"),
		new ImageResource("Dungeon/wall/wall_top_mid.png"),
	};

	public static void generateDungeon(int rooms) {
		Random rand = new Random();
		ArrayList<Room> dung = new ArrayList<Room>();
		// create first room and mark as entry point
		Room firstRoom = new Room(new Vector2d(0, 0), new Vector2d(Math.max(MIN_ROOM_SIZE, rand.nextInt(MAX_ROOM_SIZE)),
				Math.max(MIN_ROOM_SIZE, rand.nextInt(MAX_ROOM_SIZE))));
		dung.add(firstRoom);
		// pick random direction and create room there
		// repeat till amount of desired rooms is 0
		Room lastRoom = firstRoom;
		for (int i = 1; i < rooms; i++) {
			int direction = rand.nextInt(4);
			Room currentRoom = null;
			Vector2d newDimensions = new Vector2d(Math.max(MIN_ROOM_SIZE, rand.nextInt(MAX_ROOM_SIZE)),
					Math.max(MIN_ROOM_SIZE, rand.nextInt(MAX_ROOM_SIZE)));
			switch (direction) {
				case 0:
					currentRoom = new Room(
							new Vector2d(lastRoom.position.x,
									lastRoom.position.y + lastRoom.dimensions.y * World.TILE_SIZE),
							newDimensions);
					break; // UP
				case 1:
					currentRoom = new Room(
							new Vector2d(lastRoom.position.x - newDimensions.x * World.TILE_SIZE, lastRoom.position.y),
							newDimensions);
					break; // LEFT
				case 2:
					currentRoom = new Room(
							new Vector2d(lastRoom.position.x + lastRoom.dimensions.x * World.TILE_SIZE,
									lastRoom.position.y),
							newDimensions);
					break; // RIGHT
				case 3:
					currentRoom = new Room(
							new Vector2d(lastRoom.position.x, lastRoom.position.y - newDimensions.y * World.TILE_SIZE),
							newDimensions);
					break; // DOWN
			}

			boolean collision = false;
			// Will add checks later
			for (Room room : dung) {
				if (currentRoom.position.x < room.position.x + room.dimensions.x &&
						currentRoom.position.x + currentRoom.dimensions.x > room.position.x &&
						currentRoom.position.y < room.position.y + room.dimensions.y &&
						currentRoom.dimensions.y + currentRoom.position.y > room.position.y) {
					collision = true;
					break;
				}
			}

			if (collision) {
				continue;
			}
			dung.add(currentRoom);
			lastRoom = currentRoom;
		}
		dungeon = dung;

	}

	public static void render(GL2 gl) {
		if (dungeon == null) {
			return;
		}
		// Will want to do random floor tiles later and maybe change things up
		// Will probably move render code into room so that it can be later optimized
		for (Room room : dungeon) {
			for (int i = 0; i < room.dimensions.x; i++) {
				for (int j = 0; j < room.dimensions.y; j++) {
					if(i == 0 && j == 0) {
						//Rendering Bottom Left Corner
						Drawing.drawImage(wallTiles[2], room.position.x + i * World.TILE_SIZE,
								room.position.y + j * World.TILE_SIZE,
								new float[] { 1, 1, 1 }, gl);
					}
					else if (i == 0) {
						// Rendering left wall middle
						Drawing.drawImage(wallTiles[0], room.position.x + i * World.TILE_SIZE,
								room.position.y + j * World.TILE_SIZE,
								new float[] { 1, 1, 1 }, gl);
					} else if (i == room.dimensions.x - 1) {
						// Rendering Right Wall Middle
						Drawing.drawImage(wallTiles[1], room.position.x + i * World.TILE_SIZE,
								room.position.y + j * World.TILE_SIZE,
								new float[] { 1, 1, 1 }, gl);
					} else if (j == 0) {
						// Rendering Bottom Wall
					} else if (j == room.dimensions.y - 1) {
						// Rendering Top Wall
						Drawing.drawImage(wallTiles[4], room.position.x + i * World.TILE_SIZE,
								room.position.y + j * World.TILE_SIZE,
								new float[] { 1, 1, 1 }, gl);
					} else {
						// Drawing floor
						Drawing.drawImage(floorTiles[0], room.position.x + i * World.TILE_SIZE,
								room.position.y + j * World.TILE_SIZE,
								new float[] { 1, 1, 1 }, gl);
					}
				}
			}
		}
	}
}
