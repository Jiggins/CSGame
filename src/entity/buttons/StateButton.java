package entity.buttons;

import main.CSGame;
import states.States;
import utils.Colour;

public class StateButton extends Button {
	
	private States state;

	public StateButton(int x, int y, States state) {
		super(x, y);
		this.state = state;
	}
	
	public StateButton(int x, int y, Colour colour, States state) {
		super(x, y, colour);
		this.state = state;
	}

	public StateButton(int x, int y, String text, States state) {
		super(x, y, text);
		this.state = state;
	}

	public StateButton(int x, int y, int width, int height, String text, States state) {
		super(x, y, width, height, text);
		this.state = state;
	}
	
	@Override
	public void click() {
		CSGame.state = this.state;
		System.out.println("Current State: " + CSGame.state);
	}
}
