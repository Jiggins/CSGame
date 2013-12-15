package entity;

import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public abstract class Entity {
	
	public Texture texture;
	public String textureLocation;
	public int x;
	public int y;
	
	public Entity(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	public Texture getTexture(){
		return this.texture;
	}
	
	public String getTextureLocation() {
		return this.textureLocation;
	}
	
	public void setTextureLocation(String location) {
		this.textureLocation = location;
	}

	public int getX(){ 
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setPosition(int newX, int newY){
		this.x = newX;
		this.y = newY;
	}
	
	
	public void loadTexture(){
		if (this.getTextureLocation() == null) {
			System.out.println("Missing Texture for " + this);
			this.setTextureLocation("images/MissingTexture.png");
		}
		
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(this.getTextureLocation()));
		}	
		catch(IOException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(0);
		}	
	} 
	
public void render(){ 
		
		Color.white.bind();
		texture.bind();
		
		
		//create shape for image to sit on
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x+texture.getTextureWidth(),y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x+texture.getTextureWidth(),y+texture.getTextureHeight());
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x,y+texture.getTextureHeight());
		
		GL11.glEnd();
		
	}
}
