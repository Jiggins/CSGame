package utils;

public class Point {
	
	public final float x;
	public final float y;
	public float z;
	
	public Point(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
}
