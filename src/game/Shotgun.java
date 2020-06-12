package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Menu;

/**
 * Firearm subclass, represents the Shotgun. Deals area of affect damage over three tiles in a chosen area.
 * @author Paul McIntosh
 *
 */
public class Shotgun extends Firearm {
	
	/**
	 * Custom container used to store Action subclasses.
	 */
	private Actions actions = new Actions();

	/**
	 * Constructor class.
	 */
	public Shotgun() {
		super("Shotgun", 'S', 's');
		actions.add(new FireShotgunAction("South-West", "1", this));
		actions.add(new FireShotgunAction("South", "2", this));
		actions.add(new FireShotgunAction("South-East", "3", this));
		actions.add(new FireShotgunAction("West", "4", this));
		actions.add(new FireShotgunAction("East", "6", this));
		actions.add(new FireShotgunAction("North-West", "7", this));
		actions.add(new FireShotgunAction("North", "8", this));
		actions.add(new FireShotgunAction("North-East", "9", this));
	}
	
	@Override
	public Action shoot(Actor actor, Display display, GameMap map) {
		Menu shotgunMenu = new Menu();
		return shotgunMenu.showMenu(actor, actions, display);
	}

}
