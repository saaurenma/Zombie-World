package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A class that generates a PickUpBehaviorAction if the current actor is
 * standing over a weapon they can pick up.
 * 
 * @author Paul McIntosh
 *
 */
public class PickUpBehaviour implements Behaviour {

	/**
	 * Returns a PickUpAction that picks up any Weapon at the actor's feet, and adds
	 * it to their inventory. Returns null if the actor is a Zombie with no arms.
	 * 
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		if (actor instanceof Zombie) {
			if (((Zombie) actor).getZombieArms() == 0) {
				return null;
			}
		}

		for (Item i : map.locationOf(actor).getItems()) {
			if (i.asWeapon() != null) {
				return i.getPickUpAction();
			}
		}
		return null;
	}

}
