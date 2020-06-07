package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FireSniperAction extends Action {
	private int damageLevel;
	private Actor target;
	private Random rand = new Random();
	private SniperRifle thisGun;

	public FireSniperAction(Actor actor, Actor target, int damageLevel, SniperRifle thisGun) {
		this.damageLevel = damageLevel;
		this.target = target;
		this.thisGun = thisGun;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
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
