package entity;

import utils.Point;

public class Wall extends Entity{
	
	private Point start;
	private Point end;
	
	public Wall(int x , int y){
		super(x,y);
	}
	
	@Override
	public void update() {}

	public Wall(Point start, Point end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public float getHeight(){
		return 3;
	}
	
	
	
	
	
	
}
