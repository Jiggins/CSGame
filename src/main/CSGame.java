package main;
import org.lwjgl.opengl.Display;

import states.Closing;
import states.Game;
import states.Menu;
import states.States;
import states.ThreeDeeTest;
import world.BGround;

public class CSGame {
	
	public static BGround currentBackground;
	
	public static States state = States.Main_Menu;

	public static void main(String [] args) {
		display.CreateDisplay.frame();
				
		while(!Display.isCloseRequested()) {
			
			switch(state){
			
			case Main_Menu: 
				Menu.startup();
				Menu.loop();
				Menu.stop();
				break;
			
			case Game:
				Game.startup();
				Game.loop();
				break;
				
			case ThreeDeeTest:
				ThreeDeeTest.startup();
				ThreeDeeTest.loop();
				//ThreeDeeTest.stop();
				
			case Closing:
				Closing.loop();
			}
		}

		Closing.loop();
	}
}
