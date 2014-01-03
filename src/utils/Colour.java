package utils;

/**
 * Class containing colours for easier rendering
 * Colours based on the colours of the NUIMaynooth Logo colour scheme
 * provided by Adobe Kuler
 */
public class Colour {
	
	public float red, green, blue;
	
	public static final Colour BLACK		= new Colour(0, 0, 0);
	public static final Colour WHITE 		= new Colour(1, 1, 1);
	public static final Colour BLUE 		= new Colour((float) 11/255, (float) 76/255, (float) 137/255);
	public static final Colour LIGHT_BLUE 	= new Colour((float) 3/255, (float) 131/255, (float) 144/255);
	public static final Colour RED			= new Colour((float) 146/255, (float) 52/255, (float) 48/255);
	public static final Colour YELLOW		= new Colour((float) 240/255, (float) 173/255, (float) 20/255);
	
	public Colour(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
}
