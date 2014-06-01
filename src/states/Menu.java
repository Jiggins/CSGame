package states;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import utils.Colour;
import utils.Debug;
import world.BGround;
import entity.Entity;
import entity.buttons.StateButton;

public class Menu {
	
	public static BGround menu = new BGround("Menu");
	
	public static void startup(){
		CSGame.currentBackground = menu;
		CSGame.currentBackground.loadTexture();

		new StateButton(490, 64, States.Closing);
		new StateButton(490, 112, Colour.BLUE, States.ThreeDeeTest);
		new StateButton(490, 160, Colour.BLUE, States.FirstPerson);
		
	}

	public static void loop(){
		while(CSGame.state == States.Main_Menu){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			CSGame.currentBackground.render();
			
			for (Entity entity : Entity.entities) {
				entity.update();
			}
	
			Display.sync(60);
			Display.update();
			
			if(Display.isCloseRequested()){
				CSGame.state = States.Closing;
				break;
			}
			Debug.debugLoop();
		}
	}
	
	/**
	 * Called after gameLoop closes
	 */
	public static void stop() {
		Entity.entities.clear();
	}
}
