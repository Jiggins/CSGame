import org.lwjgl.opengl.Display;

public class Main {

	public static void main(String [] args) {
		display.CreateDisplay.frame();
		System.out.println("Hello");
		
		while(!Display.isCloseRequested()) { 
			gameLoop();
		}
		
		System.exit(0);
	}	
	
	public static void gameLoop() {
//		TODO Add stuff here! 
		System.out.println("Hi Niamh!");	
	}
}
