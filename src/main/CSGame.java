package main;
import java.util.ArrayList;

import menu.Closing;
import menu.Game;
import menu.MainMenu;
import menu.States;

import org.lwjgl.opengl.Display;

import world.BGround;

import entity.Character;
import entity.buttons.Button;

public class CSGame {
	
	public static BGround currentBackground;
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
