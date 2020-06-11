package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * This action represents the Actor siting a target with their Sniper Rifle.
 * @author Paul McIntosh
 *
 */
public class AimSniperAction extends Action {
	/**
	 * The target being aimed at.
	 */
	private Actor target;
	/**
	 * The Sniper Rifle being used in conjunction with this action.
	 */
	private SniperRifle thisGun;

	/**
	 * Constructor class.
	 * @param target The target being aimed at.
	 * @param thisGun The Sniper Rifle being used in conjunction with this action.
	 */
	public AimSniperAction(Actor target, SniperRifle thisGun) {
		this.target = target;
		this.thisGun = thisGun;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		thisGun.aimUp();
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " aims at " + target;
	}

}
