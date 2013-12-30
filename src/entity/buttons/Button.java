package entity.buttons;

import main.CSGame;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import entity.Entity;

public class Button extends Entity {

	private String text;

	public Button(int x, int y) {
		this(x, y, 64, 32, "Button");
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
		CSGame.buttons.add(this);
	}
	
	@Override
	public void update() {
		this.render();
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
	
	public void render() {
		
		glBegin(GL_QUADS);
//			GL11.glEnable(GL11.GL_BLEND);
			
			GL11.glColor3f(1, 1, 1);
			GL11.glVertex2f(x, y); // Upper-left
			GL11.glVertex2f(x + width, y); //Upper-right
			GL11.glVertex2f(x + width, y + height); //Bottom-right
			GL11.glVertex2f(x, y + height); //Bottom-left
		
//		GL11.glDisable(GL11.GL_BLEND);
		glEnd();
	}
}
