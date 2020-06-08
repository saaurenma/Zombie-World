package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;

public class Car extends Item {

	public Car(Location location) {
		super("Car", 'C', false);
		allowableActions.add(new Actions(new MoveActorAction(location, "to the other map")));
	}

}
