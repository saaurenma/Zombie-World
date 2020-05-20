package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A class that generates a PickUpBehaviorAction if the current actor is standing over
 * a weapon they can pick up.
 * 
 * @author Paul McIntosh
 *
 */
public class PickUpBehaviour implements Behaviour {

	/**
	 * Returns a PickUpAction that picks up any Weapon at the actor's feet, and adds it to their inventory.
	 * 
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		//TODO checker for Zombie Arms status once zombieArms is implemented
		ArrayList<Item> floorItems = new ArrayList<Item>();
		for (Item i: floorItems) {
			if (i.asWeapon() != null) {
				return i.getPickUpAction();
			}
		}
		return null;
	}

}
