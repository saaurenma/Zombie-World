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

	public SniperRifle() {
		super("Sniper Rifle", 'R');
	}

	@Override
	public Action shoot(Actor actor, Display display, GameMap map) {
		//TODO fix casting by updating interfaces
		if (target != null) {
			//TODO already aiming
		} else {
			HashMap<Action, Actor> targetHolder = new HashMap<Action, Actor>();
			Menu sniperMenu = new Menu();
			Actions aimActions = new Actions();
			for (int xcord : map.getXRange()) {
				for (int ycord : map.getYRange()) {
					Actor potentialTarget = map.getActorAt(new Location(map, xcord, ycord));
					if (potentialTarget != actor && potentialTarget != null) {
						AimSniperAction potentialTargetAction = new AimSniperAction(potentialTarget);
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
	}

}
