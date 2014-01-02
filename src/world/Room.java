package world;

import java.util.ArrayList;

import entity.Entity;

public abstract class Room {
	
	/*
	 *  Each type of room extends Room
	 *  
	 *  Need:
	 *  List of entities - arraylist
	 *  Background
	 *  boundaries - maybe
	 *  
	 *  
	 */
	public enum Rooms {
		Callan_Lab_3, Callan_Lab_4, Callan_Corridor;
	}
	
	public Room(){
		
	}
	
	public abstract ArrayList<Entity> getEntities();
	
	public BGround getBGround() {
		return null;
	}
}
