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
	public float height;
	public float width;

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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}
	
	public void setPosition(int newX, int newY){
		this.x = newX;
		this.y = newY;
	}
	
	public void loadTexture(){
		if (this.getTextureLocation() == null) {
			System.out.println("Missing Texture for " + this.getClass());
			this.setTextureLocation("resources/MissingTexture.png");
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
	
	/**
	 * Renders the Entity on screen to the given size.
	 * @param width, height 
	 */
	public void render(int width, int height) {
		GL11.glClearColor(0f, 0f, 0f, 0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		Color.white.bind();
		texture.bind();

		//create shape for image to sit on
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x+width,y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x+width,y+height);
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x,y+height);

		GL11.glEnd();	
	}
	
	public void render(float width, float height) {
		GL11.glClearColor(0f, 0f, 0f, 0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		Color.white.bind();
		texture.bind();

		//create shape for image to sit on
		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x+width,y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x+width,y+height);
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x,y+height);

		GL11.glEnd();	
	}
	
	/**
	 * Zoom to new size
	 * FIXME This is very broken
	 * @param x
	 * @param y
	 */
	public void zoomTo(float x, float y) {
		GL11.glClearColor(0f, 0f, 0f, 0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		if (getWidth() == x && getWidth() == y) {
			render();
			return;
		}
		
		float widthRatio;
		float heightRatio;	
		
		Color.white.bind();
		texture.bind();
		
		for (int i = 100000; i >= 1; i--) {
			widthRatio	= Math.abs(getWidth()	- x)/i;
			heightRatio	= Math.abs(getHeight()	- y)/i;
			
			
			this.width	= x + widthRatio;
			this.height	= y + heightRatio;
			
			render(this.width, this.height);			
		}
		GL11.glEnd();
	}
}
