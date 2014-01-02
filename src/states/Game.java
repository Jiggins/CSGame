package states;

import main.CSGame;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import utils.Debug;
import world.BGround;
import world.Room.Rooms;
import entity.Character;



public class Game {
	
	public static BGround main = new BGround("MissingBackground");
	private static Character player;
	public static Rooms room = Rooms.Callan_Corridor;
	
	public static void startup(){
		
		CSGame.currentBackground = main;
		player = new Character(100, 100, "NUIMaynoothLogo");	
	}
	
	/**
	 * Switch between each Room object, 
	 * update the room all the entites and background in that room.
	 * 
	 * @param none
	 */
	public static void loop(){	
		
		while(true){
			
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			switch(room){
			
			case Callan_Lab_4:  break;
			case Callan_Lab_3: break;
			case Callan_Corridor: break;
			
			}
			
			CSGame.currentBackground.render();
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
