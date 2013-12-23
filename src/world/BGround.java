package world;

import org.newdawn.slick.opengl.Texture;


public class BGround {
	
	private int d1X, d1Y;
	private int d2X, d2Y;
	private Texture t;
	
	
	//one door
	public BGround(int d1X, int d1Y,Texture t){
		this.d1X = d1X;
		this.d1Y = d1Y;
		this.t = t;
	}
	
	//two doors
	public BGround(int d1X, int d1Y, int d2X, int d2Y, Texture t){
		this.d1X = d1X;
		this.d1Y = d1Y;
		this.d2X = d2X;
		this.d2Y = d2Y;
		this.t = t;
	}
	
	
	public int getDX(int num){
		
		switch(num){
		case 1: return d1X;
		case 2: return d2X; 
		}
		return 0;
	}
	
	public int getDY(int num){
		
		switch(num){
		case 1: return d1Y;
		case 2: return d2Y; 
		}
		return 0;
	}
	
	public Texture getTexture(){
		return t;
	}
}
