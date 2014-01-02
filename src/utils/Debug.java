package utils;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import display.CreateDisplay;
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
		while (Keyboard.next()) {
			if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
				System.out.println("Entities:");
				for (Entity entity : Entity.entities) {
					System.out.println("\tEntity: " + entity.getClass().getSimpleName() + " " + "(" + entity.x + "," + entity.y + ")");
				}
				System.out.println();
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
				System.out.println("Resetting OpenGl frame");
				CreateDisplay.initGL();
			}
		}
		
		while (Mouse.next()) {
			if (Mouse.isButtonDown(1)) {
				System.out.println("Mouse: X: " + Mouse.getX() + "Y: " + Mouse.getY());
			}
		}
	}
}
