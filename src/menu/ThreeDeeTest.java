package menu;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.util.Random;

import main.CSGame;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import utils.Debug;
import utils.Point;

public class ThreeDeeTest {
	private static float speed;
	private static Point [] points;
	public static Random random = new Random();

	public static void startup() {
		glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        // Create a new perspective with 30 degree angle (field of view), 640 / 480 aspect ratio, 0.001f zNear, 100 zFar
        // Note:         +x is to the right
        //                     +y is to the top
        //                        +z is to the camera
        gluPerspective((float) 30, 640f / 480f, 0.001f, 100);
        glMatrixMode(GL_MODELVIEW);

        // To make sure the points closest to the camera are shown in front of the points that are farther away.
        glEnable(GL_DEPTH_TEST);
        
        points = new Point[10000];
        // Iterate of every array index
        for (int i = 0; i < points.length; i++) {
            // Set the point at the array index to 
            // x = random between -50 and +50
            // y = random between -50 and +50
            // z = random between  0  and -200
            points[i] = new Point((random.nextFloat() - 0.5f) * 100f, (random.nextFloat() - 0.5f) * 100f,
                    random.nextInt(200) - 200);
        }
        // The speed in which the "camera" travels
        speed = 0.0f;
	}
	
	public static void loop() {
		
		while (CSGame.state == States.ThreeDeeTest) {
			// Clear the screen of its filthy contents
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            // Push the screen inwards at the amount of speed
            glTranslatef(0, 0, speed);

            // Begin drawing points
            glBegin(GL_POINTS);
            // Iterate of every point
            
            
            for (Point p : points) {
                // Draw the point at its coordinates
            	glColor3f(1.0f, 0f, 1.0f);
                glVertex3f(p.x, p.y, p.z);
                
            }
            // Stop drawing points
            glEnd();

            // If we're pressing the "up" key increase our speed
            if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                speed += 0.01f;
            }
            // If we're pressing the "down" key decrease our speed
            if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                speed -= 0.01f;
            }
            // Iterate over keyboard input events
            while (Keyboard.next()) {
                // If we're pressing the "space-bar" key reset our speed to zero
                if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
                    speed = 0f;
                }
                // If we're pressing the "c" key reset our speed to zero and reset our position
                if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
                    speed = 0;
                    glLoadIdentity();
                }
            }
            
            
            if(Display.isCloseRequested()){
				CSGame.state = States.Closing;
				break;
			}

            Debug.debugLoop();
            // Update the display
            Display.update();
            // Wait until the frame-rate is 60fps
            Display.sync(60);
		}
	}
	
	public static void stop() {
		
	}
}
