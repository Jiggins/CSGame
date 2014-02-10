package states;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector3f;


import render.Face;
import render.Model;
import render.OBJLoader;

public class ModelTest {

	    private static int glassDisplayList;

	    private static final String MODEL_LOCATION = "bin/resources/models/Glass.obj";

	    public static void main(String[] args) {
	        setUpDisplay();
	        setUpDisplayLists();
	        while (!Display.isCloseRequested()) {
	            render();
	            Display.update();
	            Display.sync(60);
	        }
	        cleanUp();
	        System.exit(0);
	    }

	    private static void setUpDisplayLists() {
	        glassDisplayList = glGenLists(1);
	        glNewList(glassDisplayList, GL_COMPILE);
	        {
	            Model m = null;
	            try {
	                m = OBJLoader.loadModel(new File(MODEL_LOCATION));
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
	            for (Face face : m.faces) {
	                Vector3f n1 = m.normals.get((int)face.normal.x- 1);
	                glNormal3f(n1.x, n1.y, n1.z);
	                Vector3f v1 = m.vertices.get((int) face.vertex.x - 1);
	                glVertex3f(v1.x, v1.y, v1.z);
	                
	                Vector3f n2 = m.normals.get((int)face.normal.y- 1);
	                glNormal3f(n2.x, n2.y, n2.z);
	                Vector3f v2 = m.vertices.get((int) face.vertex.y - 1);
	                glVertex3f(v2.x, v2.y, v2.z);
	                
	                Vector3f n3 = m.normals.get((int)face.normal.z- 1);
	                glNormal3f(n3.x, n3.y, n3.z);
	                Vector3f v3 = m.vertices.get((int) face.vertex.z - 1);
	                glVertex3f(v3.x, v3.y, v3.z);
	            }
	            glEnd();
	        }
	        glEndList();
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


	    private static void setUpDisplay() {
	        try {
	            Display.setDisplayMode(new DisplayMode(640, 480));
	            Display.setVSyncEnabled(true);
	            Display.create();
	        } catch (LWJGLException e) {
	            System.err.println("The display wasn't initialized correctly. :(");
	            Display.destroy();
	            System.exit(1);
	        }
	    }
	}
