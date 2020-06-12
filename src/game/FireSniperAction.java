package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Action subclass used to fire a Sniper Rifle. Damage depends on time spent aiming.
 * @author Paul McIntosh
 *
 */
public class FireSniperAction extends Action {
	/**
	 * Represents the current level of aiming on target for the Rifle. Damage applied to the target scales up with this integer.
	 */
	private int damageLevel;
	/**
	 * The target being fired at by the rifle.
	 */
	private Actor target;
	/**
	 * Random number generator.
	 */
	private Random rand = new Random();
	/**
	 * The Sniper Rifle being fired by this action.
	 */
	private SniperRifle thisGun;

	/**
	 * Constructor class.
	 * 
	 * @param actor The actor firing the rifle.
	 * @param target The target being fired at by the rifle.
	 * @param damageLevel Represents the current level of aiming on target for the Rifle. Damage applied to the target scales up with this integer.
	 * @param thisGun The Sniper Rifle being fired by this action.
	 */
	public FireSniperAction(Actor actor, Actor target, int damageLevel, SniperRifle thisGun) {
		this.damageLevel = damageLevel;
		this.target = target;
		this.thisGun = thisGun;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		if (thisGun.checkAmmo(actor)) {
			if (damageLevel == 0) {
				thisGun.clearTarget();
				return damageDealing(actor, map, 40);
			} else if (damageLevel == 1) {
				thisGun.clearTarget();
				return damageDealing(actor, map, 80);
			} else if (damageLevel == 2) {
				thisGun.clearTarget();
				return damageDealing(actor, map, 999);
			}
			return menuDescription(actor);
		} else {
			return "The " + thisGun + " only clicks. It's empty!";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " snipes " + target;
	}

	public String damageDealing(Actor actor, GameMap map, int damage) {
		String result = "";
		result += System.lineSeparator() + actor + " snipes " + target + " for " + damage + " damage.";
		target.hurt(damage);
		if (!target.isConscious()) {
			Corpse corpse = new Corpse("dead " + target, '%');
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

}
