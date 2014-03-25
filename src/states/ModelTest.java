package states;

import main.CSGame;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector3f;

import render.Model;
import render.OBJLoader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class ModelTest {
	
	 private static final float zNear = 0.3f;
	    /** The maximal distance from the camera where objects are rendered. */
	    private static final float zFar = 35;
	    /** Defines the field of view.  */
	    private static final int fov = 90;


		//GL Display Lists
		private static int objectDisplayList;
		private static int objectDisplayTest;
		private static int floorTexture;
		private static int wallDisplayList;
		private static int ceilingDisplayList;
		
		 private static Vector3f position = new Vector3f(0, 0, 0);
		    /**
		     * The rotation of the axis (where to the player looks). The X component stands for the rotation along the x-axis,
		     * where 0 is dead ahead, 180 is backwards, and 360 is automatically set to 0 (dead ahead). The value must be between
		     * (including) 0 and 360. The Y component stands for the rotation along the y-axis, where 0 is looking straight
		     * ahead, -90 is straight up, and 90 is straight down. The value must be between (including) -90 and 90.
		     */
		    private static Vector3f rotation = new Vector3f(0, 0, 0);
			private static int floorDisplayList;
			private static long lastFrame;
			
			/** Defines the walking speed, where 10 is the standard. */
		    private static int walkingSpeed = 10;
		    /** Defines the mouse speed. */
		    private static int mouseSpeed = 2;
		    /** Defines if the application utilizes vertical synchronization (eliminates screen tearing; caps fps to 60fps) */
		    private static final int maxLookUp = 85;
		    /** Defines the minimum angle at which the player can look down. */
		    private static final int maxLookDown = -85;

    private static int glassDisplayList;


    public static void main() {

        setUpDisplayLists();
            loop();
        cleanUp();
        System.exit(0);
    }

    private static void setUpDisplayLists() {
        glassDisplayList = glGenLists(1);
        glNewList(glassDisplayList, GL_COMPILE);
        {
            Model m = null;
            try {
                m = OBJLoader.loadTexturedModel(new File("bin/resources/models/Glass.obj"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Display.destroy();
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
                Display.destroy();
                System.exit(1);
            }
            glBegin(GL_TRIANGLES);
            for (Model.Face face : m.getFaces()) {
                Vector3f n1 = m.getNormals().get(face.getNormalIndices()[0] - 1);
                glNormal3f(n1.x, n1.y, n1.z);
                Vector3f v1 = m.getVertices().get(face.getVertexIndices()[0] - 1);
                glVertex3f(v1.x, v1.y, v1.z);
                Vector3f n2 = m.getNormals().get(face.getNormalIndices()[1] - 1);
                glNormal3f(n2.x, n2.y, n2.z);
                Vector3f v2 = m.getVertices().get(face.getVertexIndices()[1] - 1);
                glVertex3f(v2.x, v2.y, v2.z);
                Vector3f n3 = m.getNormals().get(face.getNormalIndices()[2] - 1);
                glNormal3f(n3.x, n3.y, n3.z);
                Vector3f v3 = m.getVertices().get(face.getVertexIndices()[2] - 1);
                glVertex3f(v3.x, v3.y, v3.z);
            }
            glEnd();
        }
        glEndList();
    }

    private static void checkInput() {
        if (Mouse.isButtonDown(0)) {
            Mouse.setGrabbed(true);
        } else if (Mouse.isButtonDown(1)) {
            Mouse.setGrabbed(false);
        }
    }

    private static void cleanUp() {
        glDeleteLists(glassDisplayList, 1);
        Display.destroy();
    }

    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glLoadIdentity();
 
        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        glCallList(glassDisplayList);
    }
    
public static void loop() {
		
		while (CSGame.state == States.ModelTest) {
			
			render();
//            checkInput();
            Display.update();
            Display.sync(60);
						
			int delta = getDelta();

			glRotatef(rotation.x, 1, 0, 0);
			glRotatef(rotation.y, 0, 1, 0);
			glRotatef(rotation.z, 0, 0, 1);
			glTranslatef(position.x, position.y, position.z);
						
			if (Mouse.isGrabbed()) {
				float mouseDX = Mouse.getDX() * mouseSpeed * 0.16f;
				float mouseDY = Mouse.getDY() * mouseSpeed * 0.16f;
				if (rotation.y + mouseDX >= 360) {
					rotation.y = rotation.y + mouseDX - 360;
				} else if (rotation.y + mouseDX < 0) {
					rotation.y = 360 - rotation.y + mouseDX;
				} else {
					rotation.y += mouseDX;
				}
				if (rotation.x - mouseDY >= maxLookDown && rotation.x - mouseDY <= maxLookUp) {
					rotation.x += -mouseDY;
				} else if (rotation.x - mouseDY < maxLookDown) {
					rotation.x = maxLookDown;
				} else if (rotation.x - mouseDY > maxLookUp) {
					rotation.x = maxLookUp;
				}
			}
						
			// If you're looking for a challenge / something interesting, be sure to have a look at this comment:
			// http://www.youtube.com/watch?v=OO_yNzAuDe4&lc=2e3e-Xz131-fklyBuY6e-xYiWWBv379j7BmQpZRysjc
			boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W);
			boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S);
			boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A);
			boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D);
			boolean flyUp = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
			boolean flyDown = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
			boolean moveFaster = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
			boolean moveSlower = Keyboard.isKeyDown(Keyboard.KEY_TAB);
						
			if (moveFaster && !moveSlower) {
				walkingSpeed *= 4f;
			}
			if (moveSlower && !moveFaster) {
				walkingSpeed /= 10f;
			}
			
			if (keyUp && keyRight && !keyLeft && !keyDown) {
				float angle = rotation.y + 45;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			if (keyUp && keyLeft && !keyRight && !keyDown) {
				float angle = rotation.y - 45;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			if (keyUp && !keyLeft && !keyRight && !keyDown) {
				float angle = rotation.y;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			if (keyDown && keyLeft && !keyRight && !keyUp) {
				float angle = rotation.y - 135;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			if (keyDown && keyRight && !keyLeft && !keyUp) {
				float angle = rotation.y + 135;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			if (keyDown && !keyUp && !keyLeft && !keyRight) {
				float angle = rotation.y;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = -(walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			if (keyLeft && !keyRight && !keyUp && !keyDown) {
				float angle = rotation.y - 90;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			if (keyRight && !keyLeft && !keyUp && !keyDown) {
				float angle = rotation.y + 90;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position.z = newPosition.z;
				position.x = newPosition.x;
			}
			
			if (flyUp && !flyDown) {
				double newPositionY = (walkingSpeed * 0.0002) * delta;
				position.y -= newPositionY;
			}
			if (flyDown && !flyUp) {
				double newPositionY = (walkingSpeed * 0.0002) * delta;
				position.y += newPositionY;
			}
			if (moveFaster && !moveSlower) {
				walkingSpeed /= 4f;
			}
			if (moveSlower && !moveFaster) {
				walkingSpeed *= 10f;
			}
			while (Mouse.next()) {
				if (Mouse.isButtonDown(0)) {
					Mouse.setGrabbed(true);
				}
				if (Mouse.isButtonDown(1)) {
					Mouse.setGrabbed(false);
				}
			}
			
			while (Keyboard.next()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
					position = new Vector3f(0, 0, 0);
					rotation = new Vector3f(0, 0, 0);
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_O)) {
					mouseSpeed += 1;
					System.out.println("Mouse speed changed to " + mouseSpeed + ".");
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_L)) {
					if (mouseSpeed - 1 > 0) {
						mouseSpeed -= 1;
						System.out.println("Mouse speed changed to " + mouseSpeed + ".");
					}
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
					System.out.println("Walking speed changed to " + walkingSpeed + ".");
					walkingSpeed += 1;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
					System.out.println("Walking speed changed to " + walkingSpeed + ".");
					walkingSpeed -= 1;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_F11)) {
					try {
						Display.setFullscreen(!Display.isFullscreen());
						if (!Display.isFullscreen()) {
							Display.setResizable(true);
							Display.setDisplayMode(new DisplayMode(800, 600));
							glViewport(0, 0, Display.getWidth(), Display.getHeight());
							glMatrixMode(GL_PROJECTION);
							glLoadIdentity();
							gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
							glMatrixMode(GL_MODELVIEW);
							glLoadIdentity();
						} else {
							glViewport(0, 0, Display.getWidth(), Display.getHeight());
							glMatrixMode(GL_PROJECTION);
							glLoadIdentity();
							gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
							glMatrixMode(GL_MODELVIEW);
							glLoadIdentity();
						}
					} catch (LWJGLException ex) {
						Logger.getLogger(FirstPerson.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
					if (!Mouse.isGrabbed() || Display.isFullscreen()) {
						CSGame.state = States.Closing;
					} else {
						Mouse.setGrabbed(false);
					}
				}
			}
			
			if (Display.wasResized()) {
				glViewport(0, 0, Display.getWidth(), Display.getHeight());
				glMatrixMode(GL_PROJECTION);
				glLoadIdentity();
				gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
				glMatrixMode(GL_MODELVIEW);
				glLoadIdentity();
			}
			
			if (Display.isCloseRequested()) {
				CSGame.state = States.Closing;
				break;
			}
			
			Display.update();
			Display.sync(60);
		}
}
		private static int getDelta() {
	        long currentTime = getTime();
	        int delta = (int) (currentTime - lastFrame);
	        lastFrame = getTime();
	        return delta;
	    }
		
		private static long getTime() {
	        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	    }

}

