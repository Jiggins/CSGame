package menu;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import main.CSGame;
import menu.States;

import world.BGround;

public class MainMenu {
	
	private static BGround menu = new BGround("Menu");
	
	public static void startup(){
		menu.loadTexture();
	}
	
	
	public static void loop(){
		while(true /* !start.click() , start button not pressed*/){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			menu.render();
			Display.update();
			
			if(Display.isCloseRequested()){
				CSGame.state = States.Closing;
				break;
			}
			
			if(true/* start button is clicked*/){
				CSGame.state = States.Game;
				break;
			}
		}
		
		
	}
	
	
	
	
	
	
	
}
