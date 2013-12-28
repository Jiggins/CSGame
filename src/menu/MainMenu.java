package menu;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import world.BGround;

public class MainMenu {
	
	private static BGround menu = new BGround(null);
	
	public static void startup(){
		menu.loadTexture();
	}
	
	
	public static void loop(){
		while(!Display.isCloseRequested() /* and button not pressed*/){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			BGround.lab3.render();
			menu.render();
			Display.update();
			
			if(Display.isCloseRequested()){
				CSGame.state = Closing;
			}
		}
		
		
	}
	
	
	
	
	
	
	
}
