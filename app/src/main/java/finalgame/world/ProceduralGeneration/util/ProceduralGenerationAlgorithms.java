package finalgame.world.ProceduralGeneration.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import finalgame.lib.util.Boundsint;
import finalgame.lib.util.Vector2d;

/**
 * ProceduralGenerationAlgorithms
 */
public class ProceduralGenerationAlgorithms {
	
	/** 
	 * @param startingPos
	 * @param walkLength
	 * @return HashSet<Vector2d>
	 */
	public static HashSet<Vector2d> simpleRandomWalk(Vector2d startingPos, int walkLength){
		HashSet<Vector2d> path = new HashSet<Vector2d>();
		path.add(startingPos);
		Vector2d previousPos = startingPos;
		for(int i =0; i < walkLength; i++){
			Vector2d newPos = Vector2d.add(previousPos, Direction2D.getRandomCardinalDirection());
			path.add(newPos);
			previousPos = newPos;
		}
		return path;
	}

	
	/** 
	 * @param startingPos
	 * @param corridorLength
	 * @return ArrayList<Vector2d>
	 */
	public static ArrayList<Vector2d> randomWalkCorridor(Vector2d startingPos, int corridorLength) {
		ArrayList<Vector2d> corridor = new ArrayList<Vector2d>();
		var direction = Direction2D.getRandomCardinalDirection();
		var currentPosition = startingPos;
		corridor.add(currentPosition);
		for (int i = 0; i < corridorLength; i++) {
			var v = Vector2d.add(currentPosition, direction);
			corridor.add(v);
			currentPosition = v;
		}
		return corridor;
	}

	public static ArrayList<Boundsint> binarySpacePartioning(Boundsint spaceToSplit, int minWidth, int minHeight) {
		Random rand = new Random();
		Queue<Boundsint> roomsQueue = new LinkedList<Boundsint>();
		ArrayList<Boundsint> roomsList = new ArrayList<Boundsint>();
		roomsQueue.add(spaceToSplit);
		while(!roomsQueue.isEmpty()){
			var room = roomsQueue.poll();
			if(room.size.y >=minHeight && room.size.x >= minWidth){
				if(rand.nextFloat() < 0.5f){
					if (room.size.y >= minHeight * 2) {
						splitHorizontally(minWidth, minHeight, roomsQueue, room);
					} else if (room.size.x >= minWidth * 2){
						splitVertically(minWidth, minHeight, roomsQueue, room);
						
					} else {
						roomsList.add(room);
					}
				} else {
					if (room.size.y >= minHeight * 2) {
						splitVertically(minWidth, minHeight, roomsQueue, room);
					} else if (room.size.x >= minWidth * 2){
						splitHorizontally(minWidth, minHeight, roomsQueue, room);
					} else {
						roomsList.add(room);
					}
				}
			}
		}
		return roomsList;
	}


	private static void splitVertically(int minWidth, int minHeight, Queue<Boundsint> roomsQueue, Boundsint room) {
	}


	private static void splitHorizontally(int minWidth, int minHeight, Queue<Boundsint> roomsQueue, Boundsint room) {
	}
	
}
