package world;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.nio.FloatBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;

import utils.Colour;
import entity.Entity;

public class Room {
	
	private float fov = 70f;
	
	private float zNear = 25f;
	private float zFar = 35f;
	
	private int wallDisplayList;
	/**List of all NPC in room**/
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	/** List of all non-moving objects - glDisplayLists */
	private ArrayList<Integer> displayLists = new ArrayList<Integer>();
	
	private float width;
	private float depth;
	private float height;
	
	private Colour fogColour;
	private float fogNear;
	private float fogFar;
	
	public Room(int id){
		//load info in from json file
	}
	
	/**
	 * Called when Room is Entered
	 * Initialise,
	 * Set up projection modes and fog
	 */
	public void init() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();

		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glEnable(GL_ALPHA_TEST);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glEnable(GL_FOG);
		
		FloatBuffer fogColours = BufferUtils.createFloatBuffer(4);
		fogColours.put(new float[]{Colour.RED.red, Colour.RED.green, Colour.RED.blue, 1f});
		glClearColor(fogColour.red, fogColour.green, fogColour.blue, 1f);
		fogColours.flip();
		glFog(GL_FOG_COLOR, fogColours);
		glFogi(GL_FOG_MODE, GL_LINEAR);
		glHint(GL_FOG_HINT, GL_NICEST);
		glFogf(GL_FOG_START, fogNear);
		glFogf(GL_FOG_END, fogFar);
		glFogf(GL_FOG_DENSITY, 0.001f);
		
		//Create entities
		setUpDisplayLists();
	}
	
	public void loop() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		glEnable(GL_CULL_FACE);
		glDisable(GL_DEPTH_TEST);

		renderStaticObjects();

		glLoadIdentity();

		Display.update();
		Display.sync(60);
	}
	
	/** Called when Player leaves the room */
	public void close() {
		for (int i : displayLists) {
			glDeleteLists(i, 1);
		}
	}
	
	/** ArrayList of entities in the room */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	//sets up walls
	private void setUpDisplayLists() {
		wallDisplayList = glGenLists(1);
		glNewList(wallDisplayList, GL_COMPILE);

		glBegin(GL_QUADS);

		// Floor
			/* Bottom Left */
			glVertex3f(0, 0, 0);
			/* Bottom Right */
			glVertex3f(width, 0, 0);
			/* Top Left */
			glVertex3f(0, 0, depth);
			/* Top Right */
			glVertex3f(width, 0, depth);

		//TODO find a way to texture walls
		/* Back Wall 
			/* Bottom Left */
			glVertex3f(0, 0, depth);
			/* Bottom Right */
			glVertex3f(width, 0, depth);
			/* Top Left */
			glVertex3f(0, height, depth);
			/* Top Right */
			glVertex3f(width, height, depth);

		/* left Wall 
			/* Bottom Left */
			glVertex3f(0, 0, 0);
			/* Bottom Right */
			glVertex3f(0, 0, depth);
			/* Top Left */
			glVertex3f(0, height, 0);
			/* Top Right */
			glVertex3f(0, height, depth);

		glEnd();
		glEndList();

		displayLists.add(wallDisplayList);
	}

	/**
	 * Renders all non-moving objects
	 * Override to add objects for rendering
	 */
	public void renderStaticObjects() {
		for (int i : displayLists) {
			glCallList(i);
		}
	}
}