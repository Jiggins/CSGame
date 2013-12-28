package menu;

import org.lwjgl.input.Mouse;

import entity.Entity;

public class Button extends Entity {

	public Button(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Called when object is clicked.
	 */
	public void click() {
		System.out.println("Clicked on " + this.toString());
	}

	@Override
	public void update() {
		if (inBounds()) {
			this.click();
		}
	}
	
	public boolean inBounds() {
		if (Mouse.getEventX() >= this.x &&  Mouse.getEventX() <= this.x + width &&
				Mouse.getEventY() >= this.y && Mouse.getEventY() <= this.y + height) {
			return true;
			
		}
		return false;
	}
}
