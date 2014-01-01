package world;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import entity.Door;
import entity.Entity;

public class BGround extends Entity {

	public static final BGround lab3 = new BGround("MissingTexture");
	
	public BGround(String textureLocation){
		setTextureLocation(textureLocation);
		loadTexture();
	}
	
	@SuppressWarnings("unused")
	public BGround addDoor(int x, int y){
		Door door  = new Door(x, y);
		return this;
	}
	
	@Override
	public void render(){ 
		
		Color.white.bind();
		texture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(0,0);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(Display.getWidth(),0);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(Display.getWidth(), Display.getHeight());
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(0, Display.getHeight());
		
		GL11.glEnd();
	}
}
