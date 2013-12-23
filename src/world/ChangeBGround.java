package world;

import org.newdawn.slick.opengl.Texture;

import entity.Character;

public class ChangeBGround{
	    
	    private int x;
	    private int y;
	    private Texture background;
	    
	    
	    public ChangeBGround(BGround in, BGround to) {
	    	
	    	background = to.getTexture();
	    }

	    public void onPlayerArrive(Character player) {
	        player.warpTo(x, y);       
	    }
	    
	    
	    
	    
	    
	    
}

