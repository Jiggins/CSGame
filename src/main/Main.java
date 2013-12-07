package main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display; 

public class Main {

	public static void main(String [] args) {
		display.CreateDisplay.frame();
		System.out.println("Test");
		
		while(!Display.isCloseRequested()) { 
			gameLoop();
		}
		
		System.exit(0);
	}
	
	public static void gameLoop() {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			System.out.println("Left");
		}
	}

}
