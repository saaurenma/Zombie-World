package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class ReadyFirearmAction extends Action {
	private Item firearm;
	private Display display;

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
