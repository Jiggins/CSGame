package menu;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;


import world.BGround;

public class Closing {
	
	private static BGround closing = new BGround(null);
	
	
	public static void loop(){
		
		closing.loadTexture();
		
		while(true /* !start.click() , start button not pressed*/){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			closing.render();
			Display.update();
		}
		
		Display.destroy();
		System.exit(0);
		
		
	}
	
	
	
	
	
	
	
}