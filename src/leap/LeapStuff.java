package leap;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;

import entity.Character;

public class LeapStuff {
	private Character test;
	private Controller controller;
	private Frame currentFrame;
	private float x, y, x1, y1;
	

	public LeapStuff() {
		test = new Character(0, 0, "NUIMaynoothLogo");
		currentFrame = controller.frame();
		x = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getX() + 320;
		y = currentFrame.hands().leftmost().fingers().rightmost().tipPosition().getZ() + 240;
		x1 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getX() + 320;
		y1 = currentFrame.hands().rightmost().fingers().leftmost().tipPosition().getZ() + 240;
		System.out.println("X: " + x + " Y: " + y + " X1: " +  x1 + " Y2: " + y1);
		test.render(x, y, x1, y1);
	}
}
