package menu;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Game {

	public static void loop(){	
		
		while(!Display.isCloseRequested()){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
			Display.update();
		
		}
		
		CSGame.state = States.Closing;
		
}

}