package world;

import org.newdawn.slick.opengl.Texture;

import entity.Character;

public class ChangeBGround{
	    
	    private static int x;
	    private static int y;
	    private static BGround currentBackground;
	    	    
	    public void setBackground(BGround background) {
	    	currentBackground = background;
	    	currentBackground.render();
	    }

	    public void onPlayerArrive(Character player) {
	        player.warpTo(x, y);       
	    }
	    
	    
	    
	    
	    
	    
}

