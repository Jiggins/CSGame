package menu;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import world.BGround;
import entity.Character;

public class Game {
	public static BGround main = new BGround("MissingTexture");

	public static void loop(){	
		
		CSGame.currentBackground = main;
		while(true){
			
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			CSGame.currentBackground.render();
			//TODO get the character to render on top of background
			Character.player.render();
			Character.player.update();
			Display.update();
			
			if(Display.isCloseRequested()){
				CSGame.state = States.Closing;
				break;
			}
		}	
	}
}