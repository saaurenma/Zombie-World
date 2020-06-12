package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Action subclass representing shouldering a firearm, and preparing to fire it. 
 * Opens a submenu offering firing direction or choice of target, depending on the firearm used.
 * @author Paul McIntosh
 *
 */
public class ReadyFirearmAction extends Action {
	/**
	 * The gun being readied by this action.
	 */
	private Item firearm;
	/**
	 * The display class used to represent the results of this action in the UI.
	 */
	private Display display;

	/**
	 * Constructor class.
	 * @param firearm The gun being readied by this action.
	 * @param display The display class used to represent the results of this action in the UI.
	 */
	public ReadyFirearmAction(Item firearm, Display display) {
		this.firearm = firearm;
		this.display = display;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		return firearm.shoot(actor, display, map).execute(actor, map);
	}

	@Override
	public String menuDescription(Actor actor) {
		return (actor + " readies the " + firearm);
	}

	@Override
	public boolean stoppedAiming() {
		if (this.firearm.hasCapability(FirearmCapabilities.AIMED)) {
			return false;
		} else
			return true;
	}

}
