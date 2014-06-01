package entity;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * Entity Object
 */
public abstract class Entity {
	
	public Texture texture;
	public String textureLocation;
	public int x;
	public int y;
	public float height;
	public float width;
	/** List of all active entities that need to be updated. */
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	/** List of all loaded Textures */
	//TODO implement a way to have multiple textures per Entity.
	public ArrayList<String> textures;

	public Entity() {
		this(15, 15, 16, 16, null);
	}

	public Entity(int x, int y){
		this(x, y, 16, 16, null);
	}
	
	public Entity(int x, int y, String textureLocation) {
		this.x = x;
		this.y = y;
		setTextureLocation(textureLocation);
		this.loadTexture();
		this.width = texture.getImageWidth();
		this.height = texture.getImageHeight();
		entities.add(this);
	}
	
	public Entity(int x, int y, int width, int height) {
		this(x, y, height, width, null);
	}
	
	/**
	 * Basic Entity
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param textureLocation
	 */
	public Entity(int x, int y, int width, int height, String textureLocation) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setTextureLocation(textureLocation);
		this.loadTexture();
	}
	
	/**
	 * Called every tick
	 */
	public void update() {
		
	}
	
	/**
	 * False if the player can walk through the Entity.
	 * @return
	 */
	public boolean isSolid() {
		return true;
	}
	
	/**
	 * @return - Texture object.
	 */
	public Texture getCurrentTexture(){
		return this.texture;
	}
	
	public ArrayList<String> getTextures() {
		return textures;
	}
	
	/**
	 * Returns the name of the Texture used
	 * @return
	 */
	public String getTextureLocation() {
		return this.textureLocation;
	}
	
	/**
	 * Sets the location of the texture used in rendering.
	 * If there is no texture location specified, it will use a default.
	 * @param textureLocation - Texture File name, without the .png extension.
	 */
	public void setTextureLocation(String textureLocation) {
		if (textureLocation == null) {
			System.out.println("Missing Texture for " + this.getClass().getName());
			this.textureLocation = "resources/MissingTexture.png";
			return;
		}
		this.textureLocation = "resources/" + textureLocation + ".png";
	}

	/**
	 * Loads the texture
	 */
	public Texture loadTexture(){
		if (this.getTextureLocation() == null) {
			this.setTextureLocation("MissingTexture");
		}
		
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(this.getTextureLocation()));
		}	
		catch(IOException e){
			System.out.println("Not a valid Texture Location: " + getTextureLocation());
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		return texture;
	}

	/**
	 * Returns the current X position of the top left corner
	 * @return x
	 */
	public int getX(){ 
		return this.x;
	}

	/**
	 * Returns the current Y position of the top left corner
	 * @return y
	 */
	public int getY(){
		return this.y;
	}

	/**
	 * Returns the height of the Entity
	 * @return height
	 */
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * Returns the width of the Entity
	 * @return width
	 */
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}
	
	/**
	 * Sets the position of the Entity
	 * (Top left corner)
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
}