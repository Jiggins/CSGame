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
	public static ArrayList<Button> buttons = new ArrayList<Button>();
	
	public static States state = States.Main_Menu;

	public static void main(String [] args) {
		display.CreateDisplay.frame();
				
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
}
