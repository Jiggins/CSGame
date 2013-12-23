package world;

import org.newdawn.slick.opengl.Texture;


public class BGround{
	
	private Texture t;

	public static final BGround lab3 = new BGround() 
	
	public BGround(Texture t){
		this.t = t;
	}
	
	public void addDoor(int x, int y){
		Door door  = new door(x , y);
	}

	public String getTextureLocation() {
		return this.textureLocation;
	}
	
	public void setTextureLocation(String location) {
		this.textureLocation = location;
	}

	public void loadTexture(){
		if (this.getTextureLocation() == null) {
			System.out.println("Missing Texture for " + this.getClass());
			this.setTextureLocation("resources/MissingTexture.png");
		}
		
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(this.getTextureLocation()));
		}	
		catch(IOException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(0);
		}	
	}

	public void render(){ 
		
		Color.white.bind();
		texture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x+texture.getTextureWidth(),y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x+texture.getTextureWidth(),y+texture.getTextureHeight());
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x,y+texture.getTextureHeight());
		
		GL11.glEnd();
	}
}
