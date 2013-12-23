import org.lwjgl.opengl.Display;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import entity.Character;

public class CSGame {
	private static Character test;
	private static Controller controller = new Controller();
	private static Frame currentFrame = new Frame();
	private static float x, y, x2, y2;
	
	//another text case

	public static void main(String [] args) {
		display.CreateDisplay.frame();
		
		System.out.println("Hi");
		//Hello
		
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
		currentFrame = controller.frame();
		x = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getX() + 320;
		y = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getZ() + 240;
		x2 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getX() + 320;
		y2 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getZ() + 240;
		System.out.println("X: " + x + " Y: " + y + " X1: " +  x2 + " Y2: " + y2);
		test.render(x, y, x2, y2);
		
	}
}
