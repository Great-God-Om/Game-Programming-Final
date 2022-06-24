package finalgame.world;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;

import finalgame.lib.GraphicsEngine.Drawing;
import finalgame.lib.util.Vector2d;

public class Board {
	private static final int MAX_ROOM_SIZE = 10;
	private static final int MIN_ROOM_SIZE = 5;
	public static ArrayList<Room> dungeon;

	public static void generateDungeon(int rooms) {
		Random rand = new Random();
		ArrayList<Room> dung = new ArrayList<Room>();
		// create first room and mark as entry point
		Room firstRoom = new Room(new Vector2d(5, 1), new Vector2d(4, 4));
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
							new Vector2d(lastRoom.position.x, lastRoom.position.y + lastRoom.dimensions.y),
							newDimensions);
					break; // UP
				case 1:
					currentRoom = new Room(
							new Vector2d(lastRoom.position.x - newDimensions.x, lastRoom.position.y),
							newDimensions);
					break; // LEFT
				case 2:
					currentRoom = new Room(
							new Vector2d(lastRoom.position.x + lastRoom.dimensions.x, lastRoom.position.y),
							newDimensions);
					break; // RIGHT
				case 3:
					currentRoom = new Room(
							new Vector2d(lastRoom.position.x, lastRoom.position.y - newDimensions.y),
							newDimensions);
					break; // DOWN
			}

			boolean collision = false;
			// Will add checks later
			for (Room room : dung) {
				if(currentRoom.position.x < room.position.x + room.dimensions.x &&
        		currentRoom.position.x + currentRoom.dimensions.x > room.position.x &&
        		currentRoom.position.y < room.position.y + room.dimensions.y &&
        		currentRoom.dimensions.y + currentRoom.position.y > room.position.y){
					System.out.println("continued");
					collision = true;
					break;
				}
			}



			if(collision){
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
		for (Room room : dungeon) {
			for (int i = 0; i < room.dimensions.x; i++) {
				for (int j = 0; j < room.dimensions.y; j++) {
					if (i == 0 || i == room.dimensions.x - 1 || j == 0 || j == room.dimensions.y - 1) {
						Drawing.drawRect(room.position.x + i, room.position.y + j, new float[] { 0, 1, 1 }, gl);
					} else {
						Drawing.drawRect(room.position.x + i, room.position.y + j, new float[] { 1, 0, 1 }, gl);
					}
				}
			}
		}
	}
}
