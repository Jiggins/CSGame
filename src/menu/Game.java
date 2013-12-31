package menu;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import utils.Debug;
import world.BGround;
import entity.Character;
import entity.buttons.StateButton;


//FIXME cannot render any entities when in Game state!

public class Game {
	public static BGround main = new BGround("MissingTexture");
	private static Character player;
	
	public static void startup(){
		CSGame.currentBackground = main;
		player = new Character(100, 100, "NUIMaynoothLogo");
	}
	
	public static void loop(){	
		
		while(true){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			CSGame.currentBackground.render();
			//TODO get the character to render
			player.update();
			
			
			Display.update();
			
			if(Display.isCloseRequested()){
				CSGame.state = States.Closing;
				break;
			}
			Debug.debugLoop();
		}
	}
}
