package entity.buttons;

import main.CSGame;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import entity.Entity;

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
		super(x, y, width, height, "Button");
		this.text = text;
		CSGame.buttons.add(this);
	}
	
	@Override
	public void update() {
		this.render();
		if (inBounds()) {
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
}
