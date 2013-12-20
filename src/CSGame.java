import org.lwjgl.opengl.Display;

import entity.Character;

public class CSGame {
	private static Character test;

	public static void main(String [] args) {
		display.CreateDisplay.frame();
		System.out.println("Hello");
		
		test = new Character(0, 0);
		
		test.loadTexture();
		
		while(!Display.isCloseRequested()) { 
			gameLoop();
		}
		
		Display.destroy();
		System.exit(0);
	}	
	
	public static void gameLoop() {
		Display.update();
		test.render(64,64);
	}
}
