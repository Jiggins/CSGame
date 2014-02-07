package main;

public class Settings {
	/** The minimal distance from the camera where objects are rendered. */
    public static final float zNear = 0.3f;
    /** The maximal distance from the camera where objects are rendered. */
    public static final float zFar = 35;
    /** Defines the field of view. */
    public static final float fov = 60;
    /** The distance where fog starts appearing. */
    public static final float fogNear = 20;
    /** The distance where the fog stops appearing (fully black here) */
    public static final float fogFar = 32;
}
