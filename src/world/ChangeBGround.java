package world;

import org.newdawn.slick.opengl.Texture;

import entity.Character;

public class ChangeBGround{
	    
	    private int x;
	    private int y;
	    private Texture background;
	    
	    
	    public ChangeBGround(BGround in, BGround to) {
	    	x = to.getDX(1);
	    	y = to.getDY(1);
	    	//TODO have texture associated with background
	    }
	    
	    public void onPlayerArrive(Character player) {
	        player.warpTo(x, y);       
	    }
	    
	    public void setBackground(Texture background){
	    	this.background = background;
	    }
	    
	    
	    
}

