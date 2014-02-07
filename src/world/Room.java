package world;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.CSGame;
import main.Settings;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector3f;

import states.FirstPerson;
import states.States;
import utils.Colour;
import entity.Entity;

public class Room {
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	private float length;
	private float width;
	private float height;
	private Colour fogColour;
	private int ceilingDisplayList;
	private int floorDisplayList;
	private int wallDisplayList;
	private Vector rotation;
	private Vector position;
	
	/*
	 *  Each type of room extends Room
	 *  
	 *  Need:
	 *  List of entities - arraylist
	 *  Background
	 *  boundaries - maybe
	 *  
	 *  
	 */
	public enum Rooms {
		Callan_Lab_3, Callan_Lab_4, Callan_Corridor;
	}
	
	public Room(float length, float width, float height){
		this.length = length;
		this.width = width;
		this.height = height;
		fogColour = Colour.WHITE;
	}
	
	/**
	 * Called when Room is Entered
	 * Create Entities,
	 * Create
	 */
	// public void init() {
	// 	glMatrixMode(GL_PROJECTION);
 //        glLoadIdentity();
 //        gluPerspective(Settings.fov, (float) Display.getWidth() / (float) Display.getHeight(), Settings.zNear, Settings.zFar);
 //        glMatrixMode(GL_MODELVIEW);
 //        glLoadIdentity();

 //        glEnable(GL_DEPTH_TEST);
 //        glEnable(GL_TEXTURE_2D);
 //        glEnable(GL_BLEND);
 //        glEnable(GL_ALPHA_TEST);
 //        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
 //        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
 //        glEnable(GL_CULL_FACE);
 //        glCullFace(GL_BACK);
 //        glEnable(GL_FOG);
        
 //        {
 //            FloatBuffer fogColours = BufferUtils.createFloatBuffer(4);
 //            fogColours.put(new float[]{Colour.RED.red, Colour.RED.green, Colour.RED.blue, 1f});
 //            glClearColor(fogColour.red, fogColour.green, fogColour.blue, 1f);
 //            fogColours.flip();
 //            glFog(GL_FOG_COLOR, fogColours);
 //            glFogi(GL_FOG_MODE, GL_LINEAR);
 //            glHint(GL_FOG_HINT, GL_NICEST);
 //            glFogf(GL_FOG_START, Settings.fogNear);
 //            glFogf(GL_FOG_END, Settings.fogFar);
 //            glFogf(GL_FOG_DENSITY, 0.001f);
 //        }
        
 //        ceilingDisplayList = glGenLists(1);
 //        glNewList(ceilingDisplayList, GL_COMPILE);
	//         glBegin(GL_QUADS);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(-length, height, -width);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(length, height, -width);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(length, height, width);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(-length, height, width);
	//         glEnd();
 //        glEndList();

 //        floorDisplayList = glGenLists(1);
 //        glNewList(floorDisplayList, GL_COMPILE);
 //        	glBegin(GL_QUADS);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(-length, 0, -width);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(length, 0, -width);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(length, 0, width);
	// 	        glColor4f(Colour.WHITE.red, Colour.WHITE.green, Colour.WHITE.blue, 1);
	// 	        glVertex3f(-length, 0, width);
	//         glEnd();
 //       glEndList();

 //       wallDisplayList = glGenLists(1);
 //        glNewList(wallDisplayList, GL_COMPILE);
        
	//         glBegin(GL_QUADS);

	// 	        // North wall
		
	// 	        glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 1);
	// 	        glVertex3f(-length, 0, -width);
	// 	        glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 1);
	// 	        glVertex3f(length, 0, -width);
	//         	glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 0);
	// 	        glVertex3f(length, height, -height);
	// 	        glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 0);
	// 	        glVertex3f(-length, height, -width);
		
	// 	        // West wall
		
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 1);
	// 	        glVertex3f(-length, 0, -width);
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 0);
	// 	        glVertex3f(-length, height, -width);
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 0);
	// 	        glVertex3f(-length, height, +width);
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 1);
	// 	        glVertex3f(-length, 0, +width);
		
	// 	        // East wall
		
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 1);
	// 	        glVertex3f(+length, 0, -width);
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 1);
	// 	        glVertex3f(+length, 0, +width);
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 0);
	// 	        glVertex3f(+length, height, +width);
	// 	        glColor4f(Colour.LIGHT_BLUE.red, Colour.LIGHT_BLUE.green, Colour.LIGHT_BLUE.blue, 0);
	// 	        glVertex3f(+length, height, -width);
		
	// 	        // South wall
		
	// 	        glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 1);
	// 	        glVertex3f(-length, 0, +width);
	// 	        glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 0);
	// 	        glVertex3f(-length, height, +width);
	// 	        glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 0);
	// 	        glVertex3f(+length, height, +width);
	// 	        glColor4f(Colour.BLUE.red, Colour.BLUE.green, Colour.BLUE.blue, 1);
	// 	        glVertex3f(+length, 0, +width);
		
	//         glEnd();

 //        glEndList();
	// }
	
	// /** Called every tick */
	// public void update() {
	// 	for (Entity entity : entities) {
	// 		entity.update();
	// 	}

	// 	while (CSGame.state == States.FirstPerson) {
	// 		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
	// 		glEnable(GL_CULL_FACE);
	// 		glDisable(GL_DEPTH_TEST);
	// 		glCallList(floorDisplayList);
	// 		glCallList(ceilingDisplayList);
	// 		glCallList(wallDisplayList);
	// 		glEnable(GL_DEPTH_TEST);
	// 		glDisable(GL_CULL_FACE);
	// 		glBindTexture(GL_TEXTURE_2D, 0);
			
	// 		glLoadIdentity();
	// 		glRotatef(rotation.x, 1, 0, 0);
	// 		glRotatef(rotation.y, 0, 1, 0);
	// 		glRotatef(rotation.z, 0, 0, 1);
	// 		glTranslatef(position.x, position.y, position.z);
						
	// 		if (Mouse.isGrabbed()) {
	// 			float mouseDX = Mouse.getDX() * mouseSpeed * 0.16f;
	// 			float mouseDY = Mouse.getDY() * mouseSpeed * 0.16f;
	// 			if (rotation.y + mouseDX >= 360) {
	// 				rotation.y = rotation.y + mouseDX - 360;
	// 			} else if (rotation.y + mouseDX < 0) {
	// 				rotation.y = 360 - rotation.y + mouseDX;
	// 			} else {
	// 				rotation.y += mouseDX;
	// 			}
	// 			if (rotation.x - mouseDY >= maxLookDown && rotation.x - mouseDY <= maxLookUp) {
	// 				rotation.x += -mouseDY;
	// 			} else if (rotation.x - mouseDY < maxLookDown) {
	// 				rotation.x = maxLookDown;
	// 			} else if (rotation.x - mouseDY > maxLookUp) {
	// 				rotation.x = maxLookUp;
	// 			}
	// 		}
						
	// 		// If you're looking for a challenge / something interesting, be sure to have a look at this comment:
	// 		// http://www.youtube.com/watch?v=OO_yNzAuDe4&lc=2e3e-Xz131-fklyBuY6e-xYiWWBv379j7BmQpZRysjc
	// 		boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W);
	// 		boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S);
	// 		boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A);
	// 		boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D);
	// 		boolean flyUp = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
	// 		boolean flyDown = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
	// 		boolean moveFaster = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
	// 		boolean moveSlower = Keyboard.isKeyDown(Keyboard.KEY_TAB);
						
	// 		if (moveFaster && !moveSlower) {
	// 			walkingSpeed *= 4f;
	// 		}
	// 		if (moveSlower && !moveFaster) {
	// 			walkingSpeed /= 10f;
	// 		}
			
	// 		if (keyUp && keyRight && !keyLeft && !keyDown) {
	// 			float angle = rotation.y + 45;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = (walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
	// 		if (keyUp && keyLeft && !keyRight && !keyDown) {
	// 			float angle = rotation.y - 45;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = (walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
	// 		if (keyUp && !keyLeft && !keyRight && !keyDown) {
	// 			float angle = rotation.y;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = (walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
	// 		if (keyDown && keyLeft && !keyRight && !keyUp) {
	// 			float angle = rotation.y - 135;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = (walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
	// 		if (keyDown && keyRight && !keyLeft && !keyUp) {
	// 			float angle = rotation.y + 135;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = (walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
	// 		if (keyDown && !keyUp && !keyLeft && !keyRight) {
	// 			float angle = rotation.y;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = -(walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
	// 		if (keyLeft && !keyRight && !keyUp && !keyDown) {
	// 			float angle = rotation.y - 90;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = (walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
	// 		if (keyRight && !keyLeft && !keyUp && !keyDown) {
	// 			float angle = rotation.y + 90;
	// 			Vector3f newPosition = new Vector3f(position);
	// 			float hypotenuse = (walkingSpeed * 0.0002f) * delta;
	// 			float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
	// 			float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
	// 			newPosition.z += adjacent;
	// 			newPosition.x -= opposite;
	// 			position.z = newPosition.z;
	// 			position.x = newPosition.x;
	// 		}
			
	// 		if (flyUp && !flyDown) {
	// 			double newPositionY = (walkingSpeed * 0.0002) * delta;
	// 			position.y -= newPositionY;
	// 		}
	// 		if (flyDown && !flyUp) {
	// 			double newPositionY = (walkingSpeed * 0.0002) * delta;
	// 			position.y += newPositionY;
	// 		}
	// 		if (moveFaster && !moveSlower) {
	// 			walkingSpeed /= 4f;
	// 		}
	// 		if (moveSlower && !moveFaster) {
	// 			walkingSpeed *= 10f;
	// 		}
	// 		while (Mouse.next()) {
	// 			if (Mouse.isButtonDown(0)) {
	// 				Mouse.setGrabbed(true);
	// 			}
	// 			if (Mouse.isButtonDown(1)) {
	// 				Mouse.setGrabbed(false);
	// 			}
	// 		}
	// 		while (Keyboard.next()) {
	// 			if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
	// 				position = new Vector3f(0, 0, 0);
	// 				rotation = new Vector3f(0, 0, 0);
	// 			}
	// 			if (Keyboard.isKeyDown(Keyboard.KEY_O)) {
	// 				mouseSpeed += 1;
	// 				System.out.println("Mouse speed changed to " + mouseSpeed + ".");
	// 			}
	// 			if (Keyboard.isKeyDown(Keyboard.KEY_L)) {
	// 				if (mouseSpeed - 1 > 0) {
	// 					mouseSpeed -= 1;
	// 					System.out.println("Mouse speed changed to " + mouseSpeed + ".");
	// 				}
	// 			}
	// 			if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
	// 				System.out.println("Walking speed changed to " + walkingSpeed + ".");
	// 				walkingSpeed += 1;
	// 			}
	// 			if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
	// 				System.out.println("Walking speed changed to " + walkingSpeed + ".");
	// 				walkingSpeed -= 1;
	// 			}
	// 			if (Keyboard.isKeyDown(Keyboard.KEY_F11)) {
	// 				try {
	// 					Display.setFullscreen(!Display.isFullscreen());
	// 					if (!Display.isFullscreen()) {
	// 						Display.setResizable(true);
	// 						Display.setDisplayMode(new DisplayMode(800, 600));
	// 						glViewport(0, 0, Display.getWidth(), Display.getHeight());
	// 						glMatrixMode(GL_PROJECTION);
	// 						glLoadIdentity();
	// 						gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
	// 						glMatrixMode(GL_MODELVIEW);
	// 						glLoadIdentity();
	// 					} else {
	// 						glViewport(0, 0, Display.getWidth(), Display.getHeight());
	// 						glMatrixMode(GL_PROJECTION);
	// 						glLoadIdentity();
	// 						gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
	// 						glMatrixMode(GL_MODELVIEW);
	// 						glLoadIdentity();
	// 					}
	// 				} catch (LWJGLException ex) {
	// 					Logger.getLogger(FirstPerson.class.getName()).log(Level.SEVERE, null, ex);
	// 				}
	// 			}
	// 			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
	// 				if (!Mouse.isGrabbed() || Display.isFullscreen()) {
	// 					CSGame.state = States.Closing;
	// 				} else {
	// 					Mouse.setGrabbed(false);
	// 				}
	// 			}
	// 		}
			
	// 		if (Display.wasResized()) {
	// 			glViewport(0, 0, Display.getWidth(), Display.getHeight());
	// 			glMatrixMode(GL_PROJECTION);
	// 			glLoadIdentity();
	// 			gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
	// 			glMatrixMode(GL_MODELVIEW);
	// 			glLoadIdentity();
	// 		}
			
	// 		if (Display.isCloseRequested()) {
	// 			CSGame.state = States.Closing;
	// 			break;
	// 		}
			
	// 		Display.update();
	// 		Display.sync(60);
	// 	}
 //    }
	
	/** Called when Player leaves the room */
	public void close() {
		
	}
	
	/** ArrayList of entities in the room */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public BGround getBGround() {
		return null;
	}
}
