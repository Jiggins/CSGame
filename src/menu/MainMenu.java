package menu;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import utils.Debug;
import world.BGround;
import entity.Character;
import entity.Entity;
import entity.buttons.StateButton;

public class MainMenu {
	
	public static BGround menu = new BGround("Menu");
	private static StateButton start;
	private static StateButton close;
	private static Character player;
	
	public static void startup(){
		CSGame.currentBackground = menu;
		CSGame.currentBackground.loadTexture();

		start = new StateButton(16, 16, States.Game);
		close = new StateButton(16, 64, States.Closing);
	}

	public static void loop(){
		while(CSGame.state == States.Main_Menu){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			CSGame.currentBackground.render();
			//start.update();
			
			for (Entity entity : Entity.entities) {
				entity.update();
			}
			
			Display.sync(20);
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
