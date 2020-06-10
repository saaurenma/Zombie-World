package edu.monash.fit2099.interfaces;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {
	
	// returns the number of turns the actor has gone through
	// used to avoid downcasting
	public default int getTurns() {
		return 0;};
}
