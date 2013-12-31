package utils;

import org.lwjgl.input.Keyboard;

import entity.Entity;

/**
 * Simple class for debugging tools.
 */
public class Debug {
	
	/**
	 * Prints debug info on key press
	 * Keys:
	 * 		E: List of entities.
	 */
	public static void debugLoop() {
		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
			System.out.println("Entities:");
			for (Entity entity : Entity.entities) {
				System.out.println("\tEntity: " + entity.getClass().getSimpleName() + " " + "(" + entity.x + "," + entity.y + ")");
			}
			System.out.println();
		}
	}
}
