package leap;

import com.leapmotion.leap.*;

public class test {

	public test() {
		
		Controller controller = new Controller();
		
		Frame currentFrame = new Frame();
		
		while(true){
			
			currentFrame = controller.frame();
			
			System.out.println(currentFrame.fingers().leftmost().tipPosition().getX());
			
			for(int i = 0; i<currentFrame.fingers().count();i++){
				
			}
			
		}
		
	}

}
