package render;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

public class Model {
	public List<Vector3f> vertices = new ArrayList<Vector3f>();
	public List<Vector3f> normals = new ArrayList<Vector3f>();
	public List<Face> faces = new ArrayList<Face>();
	private File file;
	
	public Model() {
		
	}
	
	//This doesn't work!  Delete it if you like
	public Model(String modelName){
		file = new File("bin/resources/models/" + modelName + ".obj");
		try {
			OBJLoader.loadModel(file);
			System.out.println(this.vertices.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Again, doesn't work
	public Model createModel() {
		System.out.println(file.exists());
		try {
			Model model = OBJLoader.loadModel(file);
			System.out.println(model.vertices.size());
			return model;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}