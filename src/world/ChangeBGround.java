package world;

import entity.Character;

public class ChangeBGround{
	    
	    private int x;
	    private int y;
		private static BGround currentBackground;

		public static void changeBGround(BGround background) {
			currentBackground = background;
			currentBackground.render();
	    }

		public void onPlayerArrive(Character player) {
			player.warpTo(x, y);    
		}    
}

