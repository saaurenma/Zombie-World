package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class ReadyFirearmAction extends Action {
	private Firearm firearm;
	private Display display;

	public ReadyFirearmAction(Firearm firearm, Display display) {
		this.firearm = firearm;
		this.display = display;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		firearm.shoot(actor, display);
		return menuDescription(actor);
	}

	@Override
	public String menuDescription(Actor actor) {
		return (actor + " readies the " + firearm);
	}

}
