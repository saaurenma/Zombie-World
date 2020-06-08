package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class AimSniperAction extends Action {
	private Actor target;
	private SniperRifle thisGun;

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
