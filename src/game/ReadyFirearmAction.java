package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ReadyFirearmAction extends Action {
	private Firearm firearm;

	public ReadyFirearmAction(Firearm firearm) {
		this.firearm = firearm;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		firearm.shoot();
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return (actor + " readies the " + firearm);
	}

}
