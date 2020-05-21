package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Weapon;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}

	@Override
	/**
	 * Perform the Attack Action.
	 * Modified for Zombie unique properties; it includes lower hit chance but heal effect if the attack being made is a Zombie bite,
	 * and a chance for the target to lose limbs if it is a Zombie.
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of what happened that can be displayed to the user.
	 */
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();

		if (weapon.verb() == "bites") {
			if (rand.nextFloat() >= 0.3) {
				return actor + " misses " + target + ".";
			}
			else {
				actor.heal(5);
			}
		}
		else {
			if (rand.nextBoolean()) {
				return actor + " misses " + target + ".";
			}
		}

		int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";

		target.hurt(damage);
		if (!target.isConscious()) {
			Item corpse = new PortableItem("dead " + target, '%');
			map.locationOf(target).addItem(corpse);
			
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		
				drop.execute(target, map);
			map.removeActor(target);	
			
			result += System.lineSeparator() + target + " is killed.";
		}
		
		if (target instanceof Zombie && target.isConscious()) {
			if (rand.nextFloat() >= 0.75) {
				((Zombie) target).limbLoss(map);
			}
		}

		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}
}
