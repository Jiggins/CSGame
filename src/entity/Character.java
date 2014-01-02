package entity;

import org.lwjgl.input.Keyboard;

import utils.Colour;

public class Character extends Entity{
	
	
		
		public Character(int x, int y) {
		super(x, y);	
		setTextureLocation(null);
		}
		
		public Character(int x, int y, String textureLocation) {
			super(x, y, textureLocation);
		}
		
		public Character(int x, int y, int width, int height, String textureLocation) {
			super(x, y, width, height, textureLocation);
		}
		
		
		@Override
		public void update() {
			
			this.render();
		
			if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
				this.moveToLeft();
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
				this.moveToRight();
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				this.moveUp();
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
				this.moveDown();
			}
		}

		public void moveToLeft(){
			if(x > 0){
				setPosition(this.x - 4, this.y);
			}
		}
		
		public void moveToRight(){
			if(x < 640 - this.getCurrentTexture().getImageWidth()){
				setPosition(this.x + 4, this.y);
			}
		}
		
		public void moveUp(){
			if(y > 0){
				setPosition(this.x, this.y - 4);
			}
		}
		
		public void moveDown(){
			if(y < 480 - this.getCurrentTexture().getImageHeight()){
				setPosition(this.x, this.y + 4);
			}
		}
		
		/**
		 * Move the character to this position on screen
		 * @param (x position , y position)
		 * 
		 */
		
	    public void warpTo(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
		

	}
