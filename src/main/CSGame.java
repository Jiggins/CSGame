package main;
import menu.Closing;
import menu.Game;
import menu.MainMenu;
import menu.States;
import menu.ThreeDeeTest;

import org.lwjgl.opengl.Display;

import world.BGround;

public class CSGame {
	
	public static BGround currentBackground;
	
	public static States state = States.Main_Menu;

	public static void main(String [] args) {
		display.CreateDisplay.frame();
				
		while(!Display.isCloseRequested()) {
			
			switch(state){
			
			case Main_Menu: 
				MainMenu.startup();
				MainMenu.loop();
				MainMenu.stop();
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
