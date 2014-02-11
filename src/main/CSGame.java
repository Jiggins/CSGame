package main;
import org.lwjgl.opengl.Display;

import render.Model;
import states.Closing;
import states.FirstPerson;
import states.Game;
import states.Menu;
import states.ModelTest;
import states.States;
import states.ThreeDeeTest;
import world.BGround;

public class CSGame {
	
	public static BGround currentBackground;
	
	public static States state = States.FirstPerson;

	public static void main(String [] args) {
		display.CreateDisplay.frame();
//		Model model = new Model("Glass");
//		model.createModel();
				
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
				break;	
			
			case FirstPerson:
				FirstPerson.startup();
				FirstPerson.loop();
				FirstPerson.stop();
				break;
				
			case Closing:
				Closing.loop();
				break;
				
			case ModelTest:
				ModelTest.main();
			}
		}

		Closing.loop();
	}
}
