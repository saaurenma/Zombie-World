package game;

import java.util.HashMap;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;

/**
 * Firearm subclass, represents the Sniper Rifle. Deals high damage to a single target, damage increases based on time spent aiming..
 * @author Paul McIntosh
 *
 */
public class SniperRifle extends Firearm {
	/**
	 * Represents the current level of aiming on target for the Rifle. Damage applied to the target scales up with this integer.
	 */
	private int damageLevel = 0;
	/**
	 * The target being fired at by the rifle.
	 */
	private Actor target;
	/**
	 * Instantiation of the Menu class, used to select a target to aim at.
	 */
	private Menu sniperMenu = new Menu();

	/**
	 * Constructor class.
	 */
	public SniperRifle() {
		super("Sniper Rifle", 'R', 'r');
		this.addCapability(FirearmCapabilities.AIMED);
	}

	@Override
	public Action shoot(Actor actor, Display display, GameMap map) {
		if (target != null) {
			if (damageLevel == 1) {
				Actions shootOrWait = new Actions(new AimSniperAction(target, this));
				shootOrWait.add(new FireSniperAction(actor, target, damageLevel, this));
				return sniperMenu.showMenu(actor, shootOrWait, display);
			}
			if (damageLevel == 2) {
				return new FireSniperAction(actor, target, damageLevel, this);
			}
		} else {
			HashMap<Action, Actor> targetHolder = new HashMap<Action, Actor>();
			Actions aimActions = new Actions();
			for (int xcord : map.getXRange()) {
				for (int ycord : map.getYRange()) {
					Actor potentialTarget = map.getActorAt(new Location(map, xcord, ycord));
					if (potentialTarget != actor && potentialTarget != null) {
						if (potentialTarget.hasCapability(ZombieCapability.UNDEAD)) {
							AimSniperAction potentialTargetAction = new AimSniperAction(potentialTarget, this);
							aimActions.add(potentialTargetAction);
							targetHolder.put(potentialTargetAction, potentialTarget);
						}
					}
				}
			}
			Action chosenTargetAction = sniperMenu.showMenu(actor, aimActions, display);
			target = targetHolder.get(chosenTargetAction);
			Actions shootOrWait = new Actions(chosenTargetAction);
			shootOrWait.add(new FireSniperAction(actor, target, damageLevel, this));
			return sniperMenu.showMenu(actor, shootOrWait, display);
		}
		return null;
	}

	/**
	 * Clears the Sniper Rifle's current target, and resests the damage level.
	 */
	public void clearTarget() {
		target = null;
		damageLevel = 0;
	}

	/**
	 * Increases the current damage level by one.
	 */
	public void aimUp() {
		damageLevel += 1;
	}

}
