package world;

import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import entity.Door;

public class BGround{
	
	private Texture texture;
	private String textureLocation;

	public static final BGround lab3 = new BGround("MissingTexture");
	
	public BGround(String textureLocation){
		setTextureLocation(textureLocation);
		this.loadTexture();
	}
	
	@SuppressWarnings("unused")
	public BGround addDoor(int x, int y){
		Door door  = new Door(x, y);
		return this;
	}

	public String getTextureLocation() {
		return this.textureLocation;
	}
	
	public void setTextureLocation(String textureLocation) {
		if (textureLocation == null) {
			this.textureLocation = "resources/MissingTexture.png";
			return;
		}
		this.textureLocation = "resources/" + textureLocation + ".png";
	}

	public BGround loadTexture(){
		if (this.getTextureLocation() == null) {
			System.out.println("Missing Texture for " + this.getClass());
			this.setTextureLocation("MissingTexture");
		}
		
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(this.getTextureLocation()));
		}	
		catch(IOException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(0);
		}
		return this;
	}

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
