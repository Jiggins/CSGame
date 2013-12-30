package entity;

import org.lwjgl.input.Keyboard;

public class Character extends Entity{
	
	
		
		public Character(int x, int y) {
		super(x, y);	
		setTextureLocation(null);
		}
		
		public Character(int x, int y, String textureLocation) {
			super(x, y, textureLocation);
		}
		
		
		
		@Override
		public void update() {
			
			this.render();
		
			if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
				this.moveToLeft();
				System.out.println("MovedLeft");
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
			
			
			// TODO Do something on Update - Movement Code
		}

		public void moveToLeft(){
			if(x > 0){
				setPosition(this.x - 10, this.y);
			}
		}
		
		public void moveToRight(){
			if(x < 640 - this.getTexture().getImageWidth()){
				setPosition(this.x + 10, this.y);
			}
		}
		
		public void moveUp(){
			if(y > 0){
				setPosition(this.x, this.y - 10);
			}
		}
		
		public void moveDown(){
			if(y < 480 - this.getTexture().getImageHeight()){
				setPosition(this.x, this.y + 10);
			}
		}
		
	    public void warpTo(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
		

	}
