package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

public class SniperRifle extends Firearm {

	public SniperRifle() {
		super("Sniper Rifle", 'S');
	}

	@Override
	public Action shoot(Actor actor, Display display, GameMap map) {
		//TODO might want to put the below in actor interface, rather than player?
		if (((Player) actor).getAimStatus()) {
			//TODO
		} else {
			Menu sniperMenu = new Menu();
			Actions actions = new Actions();
			
			sniperMenu.showMenu(actor, actions, display);
		}
		return null;
	}

}
