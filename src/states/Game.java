package states;

import org.lwjgl.opengl.Display;

import main.CSGame;
import world.rooms.CallanLab3;
import world.rooms.Room;
import world.BGround;
import world.rooms.Room.Rooms;

public class Game {
	
//	public static BGround main = new BGround("MissingBackground");
//	private static Character player;
	public static Rooms room = Rooms.Callan_Corridor;
	public static Room currentRoom;
	
	public static void startup(){
		loadRoom();
		currentRoom.init();
//		CSGame.currentBackground = main;
//		player = new Character(100, 100, "NUIMaynoothLogo");	
	}
	
	/**
	 * Switch between each Room object, 
	 * update the room all the entites and background in that room.
	 * 
	 * @param none
	 */
	public static void loop(){
		while (CSGame.state == States.Game) {
			currentRoom.loop();
		}

		if (Display.isCloseRequested()) {
			CSGame.state = States.Closing;
		}
	}

	public static void stop() {
		currentRoom.close();
	}
	
	public static void loadRoom() {
		switch (room) {
		case Callan_Lab_3:
			currentRoom = new CallanLab3();
			break;
			
		case Callan_Corridor:
			currentRoom = new Room(100, 100, 100);
			break;
			
		case Callan_Lab_4:
			currentRoom = new Room(100, 100, 100);
			break;
			
		default:
			break;
		}
	}
}
