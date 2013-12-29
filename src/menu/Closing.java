package menu;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import world.BGround;

public class Closing {
	
	private static BGround closing = new BGround(null);
	
	
	public static void loop(){
		
		int x = 0;
		
		while(x < 10000 /* !start.click() , start button not pressed*/){
			
			
			GL11.glBegin(GL11.GL_QUADS);
				
				GL11.glColor4f(0, 0, 0, x/1000);
				GL11.glVertex2i(0, 0); // Upper-left
				GL11.glVertex2i(Display.getWidth(), 0); //Upper-right
				GL11.glVertex2i(Display.getWidth(), Display.getHeight()); //Bottom-right
				GL11.glVertex2i(0, Display.getHeight()); //Bottom-left
			GL11.glEnd();
			
			Display.update();
			x++;
		}
		
		Display.destroy();
		System.exit(0);
		
		
	}
	
	
	
	
	
	
	
}