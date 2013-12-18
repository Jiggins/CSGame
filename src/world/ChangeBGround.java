package world;

import org.newdawn.slick.opengl.Texture;

import entity.Character;

public class ChangeBGround{
	    
	    private int x;
	    private int y;
	    private Texture background;
	    
	    
	    public ChangeBGround(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    
	    public void onPlayerArrive(Character player) {
	        player.warpTo(x, y);       
	    }
	    
	    public void setBackground(Texture background){
	    	this.background = background;
	    }
	    
	    
	    
}

