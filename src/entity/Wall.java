package entity;

public class Wall extends Entity{
	
	public Wall(int x , int y){
		super(x,y);
	}
	
	public Wall(Point start, Point end){
		
	}
	
	@Override
	public float getHeight(){
		return 3;
	}
	
}
