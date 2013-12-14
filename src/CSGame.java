import org.lwjgl.opengl.Display;

public class CSGame {

	public static void main(String [] args) {
		display.CreateDisplay.frame();
		System.out.println("Hello");
		
		while(!Display.isCloseRequested()) { 
			gameLoop();
		}
		
		System.exit(0);
	}	
	
	public static void gameLoop() {
		Display.update();
		System.out.println("Hi Niamh!");	
	}
}
