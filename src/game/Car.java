package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;

/**
 * Item subclass, can be placed in world, constructor includes an allowableAction transporting the user to a single given location.
 * @author Paul McIntosh
 *
 */
public class Car extends Item {

	/**
	 * Constructor class.
	 * @param location The location using this car's action will move the user to.
	 */
	public Car(Location location) {
		super("Car", 'C', false);
		allowableActions.add(new Actions(new MoveActorAction(location, "to the other map")));
	}

}
