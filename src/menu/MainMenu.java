package menu;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import entity.buttons.Button;
import entity.buttons.StateButton;
import world.BGround;

public class MainMenu {
	
	public static BGround menu = new BGround("Menu");
	private static StateButton start;
	
	public static void startup(){
		CSGame.currentBackground = menu;
		CSGame.currentBackground.loadTexture();
		start = new StateButton(15, 15, States.Game);
	}

	public static void loop(){
		while(CSGame.state == States.Main_Menu){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			CSGame.currentBackground.render();
			//start.update();
			for (Button button : CSGame.buttons) {
				button.update();
			}
			
			Display.update();
			
			if(Display.isCloseRequested()){
				CSGame.state = States.Closing;
				break;
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
}
