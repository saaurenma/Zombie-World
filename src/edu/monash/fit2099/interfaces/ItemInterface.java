package edu.monash.fit2099.interfaces;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

/**
 * This interface provides the ability to add methods to Item, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ItemInterface {
	
	public default Action shoot(Actor actor, Display display, GameMap map) {
		return new DoNothingAction();
	};
	
	public default void clearTarget() {};
	
	public default void fertilize() {};

}
 