package world;

import org.newdawn.slick.opengl.Texture;


public class BGround{
	
	private Texture t;
	
	public BGround(Texture t){
		this.t = t;
	}
	
	public void addDoor(int x, int y){
		Door door  = new door(x , y);
	}
}
