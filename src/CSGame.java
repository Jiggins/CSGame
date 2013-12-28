import menu.States;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import world.BGround;
import entity.Character;
import menu.MainMenu;

public class CSGame {
	private static Character test;
//	private static Controller controller = new Controller();
//	private static Frame currentFrame = new Frame();
	private static float x, y, x2, y2;
	public static States state = States.Main_Menu;

	public static void main(String [] args) {
		display.CreateDisplay.frame();
		
		System.out.println("Hi");
		
		test = new Character(0, 0);
		
		test.setTextureLocation("resources/NUIMaynoothLogo.png");
		test.loadTexture();

		world.ChangeBGround.changeBGround(BGround.lab3);
		
		while(!Display.isCloseRequested()) { 
			
			switch(state){
			
			case Main_Menu: 
				MainMenu.startup();
				MainMenu.loop();
				break;
			
			case Game:
				gameLoop();		
			}
			
		}
		
		Display.destroy();
		System.exit(0);
	}	
	
	public static void gameLoop() {
		
		GL11.glClearColor(0f, 0f, 0f, 0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		BGround.lab3.render();
		test.render();
		Display.update();
		
		
//		currentFrame = controller.frame();
//		x = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getX() + 320;
//		y = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getZ() + 240;
//		x2 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getX() + 320;
//		y2 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getZ() + 240;
//		System.out.println("X: " + x + " Y: " + y + " X1: " +  x2 + " Y2: " + y2);
//		test.render(x, y, x2, y2);
		
	}
}
