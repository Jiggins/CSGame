package world;

import java.util.ArrayList;

import entity.Entity;

public abstract class Room {
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
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
	
	/**
	 * Called when Room is Entered
	 * Create Entities,
	 * Create
	 */
	public void init() {
		
	}
	
	/** Called every tick */
	public void update() {
		for (Entity entity : entities) {
			entity.update();
		}
	}
	
	/** Called when Player leaves the room */
	public void close() {
		
	}
	
	/** ArrayList of entities in the room */
	public abstract ArrayList<Entity> getEntities();
	
	public BGround getBGround() {
		return null;
	}
}
