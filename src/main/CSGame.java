package main;
import java.util.ArrayList;

import menu.Button;
import menu.Closing;
import menu.Game;
import menu.MainMenu;
import menu.States;

import org.lwjgl.opengl.Display;

import entity.Character;

public class CSGame {
	private static Character test;
	
	public static ArrayList<Button> buttons = new ArrayList<Button>();
	
	public static States state = States.Main_Menu;

	public static void main(String [] args) {
		display.CreateDisplay.frame();
		
		System.out.println("Hi");
		
//		test = new Character(0, 0, "NUIMaynoothLogo");
//		
//		test.setTextureLocation("NUIMaynoothLogo");

//		world.ChangeBGround.changeBGround(BGround.lab3);
		
		while(!Display.isCloseRequested()) { 
			
			switch(state){
			
			case Main_Menu: 
				MainMenu.startup();
				MainMenu.loop();
				break;
			
			case Game:
				Game.loop();	
				break;
				
			case Closing:
				Closing.loop();
			}
		}
		
		Closing.loop();
	}	
	
		
		
//		currentFrame = controller.frame();
//		x = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getX() + 320;
//		y = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getZ() + 240;
//		x2 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getX() + 320;
//		y2 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getZ() + 240;
//		System.out.println("X: " + x + " Y: " + y + " X1: " +  x2 + " Y2: " + y2);
//		test.render(x, y, x2, y2);
		
}
