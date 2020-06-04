package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;

public class Car extends Item {

	public Car(Location location) {
		super("Car", 'C', false);
		Actions actions = new Actions(new MoveActorAction(location, "to the other map"));
		//TODO get moveactoractions for each car in a location that is not this map.
		allowableActions.add(actions);
	}

}
