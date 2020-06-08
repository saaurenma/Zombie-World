package game;

import java.util.HashMap;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;

public class SniperRifle extends Firearm {
	private int damageLevel = 0;
	private Actor target;
	private Menu sniperMenu = new Menu();

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
						AimSniperAction potentialTargetAction = new AimSniperAction(potentialTarget, this);
						aimActions.add(potentialTargetAction);
						targetHolder.put(potentialTargetAction, potentialTarget);
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

	public void clearTarget() {
		target = null;
		damageLevel = 0;
	}

	public void aimUp() {
		damageLevel += 1;
	}

}
