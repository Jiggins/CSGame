package states;

public interface IGameState {
	/** 
	 * Run before render loop
	 * Initialise entities
	 *  Set up display lists
	 *  etc
	 */
	public void startup();
	
	/**
	 * Update Loop
	 * Update things
	 */
	public void loop();
	
	/**
	 * Exit the state
	 * Delete display lists, entities etc.
	 */
	public void stop();
}
