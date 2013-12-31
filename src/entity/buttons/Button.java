package entity.buttons;

import java.util.Random;

import main.CSGame;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import entity.Entity;

/**
 * Button
 * Extends Entity
 * Adds an object that can be clicked
 */
public class Button extends Entity {

	private String text;

	public Button(int x, int y) {
		this(x, y, 64, 32, "MissingTexture");
	}
	
	public Button(int x, int y, String text) {
		this(x, y, 64, 32, text);
	}
	
	/**
	 * Button
	 * Extends Entity
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param text
	 */
	public Button(int x, int y, int width, int height, String text) {
		super(x, y, width, height, null);
		this.text = text;
		Entity.entities.add(this);
	}
	
	@Override
	public void update() {
		render();
		if (inBounds()) {
			mouseOver();
			if(Mouse.isButtonDown(0)) {
				System.out.println("Clicked");
				this.click();
			}
		}
	}

	/**
	 * Called when object is clicked.
	 */
	public void click() {
		System.out.println("Clicked on " + this.text);
	}
	
	public void mouseOver() {
		
	}

	/**
	 * @return true if mouse is over Button
	 */
	private boolean inBounds() {
		if (Mouse.getX() >= this.x &&  Mouse.getX() <= this.x + width &&
				Mouse.getY() <= Display.getHeight() - this.y && Mouse.getY() >= Display.getHeight() - this.y - height) {
			return true;
		}
		return false;
	}
	
	private Random random = new Random();
	
	public void render() {
		
		glBegin(GL_QUADS);
			glEnable(GL11.GL_BLEND);
			
			glColor3f(random.nextFloat(), random.nextFloat(), random.nextFloat());
			glVertex2f(x, y); // Upper-left
			glVertex2f(x + width, y); //Upper-right
			glVertex2f(x + width, y + height); //Bottom-right
			glVertex2f(x, y + height); //Bottom-left
		
			glDisable(GL11.GL_BLEND);
		glEnd();
	}
}
