package menu;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;


public class Closing {
	
	public static void loop(){
		
		int x = 0;
		float y = 0;
		
		while(x < 100 /* !start.click() , start button not pressed*/){
			
			CSGame.currentBackground.render();
			
			GL11.glBegin(GL11.GL_QUADS);
				GL11.glEnable(GL11.GL_BLEND);
				
				GL11.glColor4f(0, 0, 0, y);
				GL11.glVertex2i(0, 0); // Upper-left
				GL11.glVertex2i(Display.getWidth(), 0); //Upper-right
				GL11.glVertex2i(Display.getWidth(), Display.getHeight()); //Bottom-right
				GL11.glVertex2i(0, Display.getHeight()); //Bottom-left
				
				GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnd();
			
			Display.sync(60);
			Display.update();
			x++;
			y = y + .01f;
		}
		
		Display.destroy();
		System.exit(0);
		
		
	}
	
	
	
	
	
	
	
}
