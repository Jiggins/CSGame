package main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display; 

import com.leapmotion.leap.Leap;

public class Main {
	public static Leap leap;

	public static void main(String [] args) {
		leap = new Leap();
		display.CreateDisplay.frame();
		System.out.println("Test");
		
		while(!Display.isCloseRequested()) { 
			gameLoop();
		}
		
		System.exit(0);
	}
	
	
	public static void gameLoop() {
//		leap.
		
	}

}
