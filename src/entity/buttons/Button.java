package entity.buttons;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import utils.Colour;
import entity.Entity;

/**
 * Button
 * Extends Entity
 * Adds an object that can be clicked
 */
public class Button extends Entity {

	private String text;
	private Colour colour;

	public Button(int x, int y) {
		this(x, y, 64, 32, null);
	}
	
	public Button(int x, int y, Colour colour) {
		this(x, y, 64, 32, null, colour);
	}
	
	public Button(int x, int y, String text) {
		this(x, y, 64, 32, text);
	}
	
	public Button(int x, int y, String text, Colour colour) {
		this(x, y, 64, 32, text, colour);
	}
	
	public Button(int x, int y, int width, int height, String text) {
		this(x, y, width, height, text, Colour.BLUE);
	}
	
	/**
	 * Button
	 * Extends Entity
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param text
	 * @param colour
	 */
	public Button(int x, int y, int width, int height, String text, Colour colour) {
		super(x, y, width, height, null);
		this.text = text;
		this.colour = colour;
		Entity.entities.add(this);
	}
	
	@Override
	public void update() {	
		if (inBounds()) {
			render(Colour.BLUE);
			mouseOver();
			if(Mouse.isButtonDown(0)) {
				System.out.println("Clicked");
				this.click();
			}
		}
		else render(colour);
	}

	/**
	 * Called when object is clicked.
	 */
	public void click() {
		System.out.println("Clicked on " + this.text);
	}
	
	/**
	 * Called when mouse is over the Button.
	 */
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

	public void render(Colour colour) {
		glBegin(GL_QUADS);
		glEnable(GL11.GL_BLEND);
		
			glColor4f(colour.red, colour.green, colour.blue, 0);
			glVertex2f(x, y); // Upper-left
			glColor4f(colour.red, colour.green, colour.blue, 0);
			glVertex2f(x + width, y); //Upper-right
			glColor4f(colour.red, colour.green, colour.blue, 1);
			glVertex2f(x + width, y + height); //Bottom-right
			glColor4f(colour.red, colour.green, colour.blue, 1);
			glVertex2f(x, y + height); //Bottom-left
	
		glDisable(GL11.GL_BLEND);
	glEnd();
	}
}
